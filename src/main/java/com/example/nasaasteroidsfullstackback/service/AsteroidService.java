package com.example.nasaasteroidsfullstackback.service;

import com.example.nasaasteroidsfullstackback.dto.DatePair;
import com.example.nasaasteroidsfullstackback.dto.NearEarthObject;
import com.example.nasaasteroidsfullstackback.dto.NeoFeed;
import com.example.nasaasteroidsfullstackback.dto.NeoLookUp;
import com.example.nasaasteroidsfullstackback.property.NasaProperties;
import com.example.nasaasteroidsfullstackback.util.DatePairGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class AsteroidService {

    private final NasaProperties nasaProperties;
    private final ObjectMapper objectMapper;
    private final WebClient webClient;

    public Mono<NeoFeed> getAllAsteroids(String startDate, String endDate) {
        List<DatePair> datePairs = DatePairGenerator.generateDatePairs(startDate, endDate);
        NeoFeed neoFeed = NeoFeed.builder()
                .elementCount(0L)
                .nearEarthObjects(new ConcurrentHashMap<>())
                .build();

        Flux<DatePair> datePairFlux = Flux.fromIterable(datePairs);

        return datePairFlux.flatMap(datePair -> {
            log.info("===> Asteroids data pulling for date pair [startDate: {}, endDate: {}]",
                    datePair.getStartDate(), datePair.getEndDate());
            return webClient.get()
                    .uri(nasaProperties.neoFeedURL(datePair.getStartDate(), datePair.getEndDate()))
                    .retrieve()
                    .bodyToMono(String.class)
                    .map(body -> {
                        try {
                            NeoFeed newNeoFeed = objectMapper.readValue(body, NeoFeed.class);
                            neoFeed.getNearEarthObjects().putAll(newNeoFeed.getNearEarthObjects());
                            neoFeed.addElementCount(newNeoFeed.getElementCount());
                            // TODO cache new data
                        } catch (JsonProcessingException e) {
                            log.error(e.getMessage(), e);
                        }
                        log.info("<=== Asteroids data pulling for date pair [startDate: {}, endDate: {}]",
                                datePair.getStartDate(), datePair.getEndDate());
                        return neoFeed;
                    });
        }).reduce((a, b) -> a).switchIfEmpty(Mono.just(neoFeed));
    }

    public Mono<NeoLookUp> getAsteroid(String id) {
        log.info("===> Asteroid data pulling for id [{}]", id);
        NeoLookUp neoLookUp = NeoLookUp.builder().build();
        return webClient.get()
                .uri(nasaProperties.neoLookUpURL(id))
                .retrieve()
                .bodyToMono(String.class)
                .map(body -> {
                    try {
                        NearEarthObject nearEarthObject = objectMapper.readValue(body, NearEarthObject.class);
                        neoLookUp.setNearEarthObject(nearEarthObject);
                    } catch (JsonProcessingException e) {
                        log.error(e.getMessage(), e);
                    }
                    log.info("<=== Asteroid data pulling for id [{}]", id);
                    return neoLookUp;
                }).switchIfEmpty(Mono.just(neoLookUp));
    }

}
