package com.example.nasaasteroidsfullstackback.property;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "nasa")
public class NasaProperties {

    private final String apiKey;

}
