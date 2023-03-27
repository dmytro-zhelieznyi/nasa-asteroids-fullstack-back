package com.example.nasaasteroidsfullstackback.service;

import com.example.nasaasteroidsfullstackback.dto.NearEarthObject;
import com.example.nasaasteroidsfullstackback.dto.NeoFeed;
import com.example.nasaasteroidsfullstackback.property.NasaProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AsteroidService {

    private final NasaProperties nasaProperties;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public NeoFeed getAllAsteroids(String startDate, String endDate) {
        var URI = "https://api.nasa.gov/neo/rest/v1/feed?" +
                "start_date=" + startDate +
                "&end_date=" + endDate +
                "&api_key=" + nasaProperties.getApiKey();

        ResponseEntity<String> response = restTemplate.exchange(
                URI, HttpMethod.GET, null, String.class);

        if (response.getBody() == null) return null;

        NeoFeed neoFeed = objectMapper.readValue(response.getBody(), NeoFeed.class);

        return neoFeed;
    }

    @SneakyThrows
    public NearEarthObject getAsteroid(String id) {
        var URI = "https://api.nasa.gov/neo/rest/v1/neo/" +
                id + "?" +
                "api_key=" + nasaProperties.getApiKey();

        ResponseEntity<String> response = restTemplate.exchange(
                URI, HttpMethod.GET, null, String.class);

        NearEarthObject nearEarthObject = objectMapper.readValue(response.getBody(), NearEarthObject.class);

        return nearEarthObject;
    }

}
