package com.example.nasaasteroidsfullstackback.property;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.util.UriComponentsBuilder;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "nasa")
public class NasaProperties {

    private final String apiKey;
    private final String neoFeedUrl;
    private final String neoLookUpUrl;

    public String neoFeedURL(String startDate, String endDate) {
        String URL = UriComponentsBuilder.fromHttpUrl(neoFeedUrl)
                .queryParam("start_date", startDate)
                .queryParam("end_date", endDate)
                .queryParam("api_key", apiKey)
                .toUriString();
        return URL;
    }

    public String neoLookUpURL(String id) {
        String URL = UriComponentsBuilder.fromHttpUrl(neoLookUpUrl)
                .path("/" + id)
                .queryParam("api_key", apiKey)
                .toUriString();
        return URL;
    }
}
