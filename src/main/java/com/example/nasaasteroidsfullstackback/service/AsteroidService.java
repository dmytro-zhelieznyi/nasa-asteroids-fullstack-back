package com.example.nasaasteroidsfullstackback.service;

import com.example.nasaasteroidsfullstackback.dto.DatePair;
import com.example.nasaasteroidsfullstackback.dto.NearEarthObject;
import com.example.nasaasteroidsfullstackback.dto.NeoFeed;
import com.example.nasaasteroidsfullstackback.dto.NeoLookUp;
import com.example.nasaasteroidsfullstackback.property.NasaProperties;
import com.example.nasaasteroidsfullstackback.util.DatePairGenerator;
import com.example.nasaasteroidsfullstackback.util.NearEarthObjectMapper;
import com.example.nasaasteroidsfullstackback.util.NeoFeedMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AsteroidService {

    private final NasaProperties nasaProperties;
    private final WebClient webClient;

    public Mono<NeoFeed> getAllAsteroids(String startDate, String endDate) {
        List<DatePair> datePairs = DatePairGenerator.generateDatePairs(startDate, endDate);
        Flux<DatePair> datePairFlux = Flux.fromIterable(datePairs);

        LocalDateTime start = LocalDateTime.now();
        Mono<NeoFeed> neoFeedMono = datePairFlux.flatMap(datePair -> {
                    log.info("===> Asteroids [startDate: {}, endDate: {}]",
                            datePair.getStartDate(), datePair.getEndDate());
                    return webClient.get()
                            .uri(nasaProperties.neoFeedURL(datePair.getStartDate(), datePair.getEndDate()))
                            .retrieve()
                            .bodyToMono(String.class)
                            .map(body -> {
                                log.info("<=== Asteroids [startDate: {}, endDate: {}]",
                                        datePair.getStartDate(), datePair.getEndDate());
                                log.info("Time: {}", Duration.between(start, LocalDateTime.now()).toSeconds());
                                return NeoFeedMapper.JsonToNeoFeed(body);
                            })
                            .timeout(Duration.ofSeconds(60));
                })
                .reduce(NeoFeed::reduceOne)
                .switchIfEmpty(Mono.just(NeoFeed.builder().build()))
                .timeout(Duration.ofSeconds(60));

        return neoFeedMono;
    }

    public Mono<NeoLookUp> getAsteroid(String id) {
        log.info("===> Asteroid for id [{}]", id);
        return webClient.get()
                .uri(nasaProperties.neoLookUpURL(id))
                .retrieve()
                .bodyToMono(String.class)
                .map(body -> {
                    log.info("<=== Asteroid for id [{}]", id);
                    NearEarthObject nearEarthObject = NearEarthObjectMapper.JsonToNeoLookUp(body);
                    return NeoLookUp.builder().nearEarthObject(nearEarthObject).build();
                })
                .switchIfEmpty(Mono.just(NeoLookUp.builder().build()));
    }

}
