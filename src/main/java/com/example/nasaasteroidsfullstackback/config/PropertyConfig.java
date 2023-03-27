package com.example.nasaasteroidsfullstackback.config;

import com.example.nasaasteroidsfullstackback.property.NasaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        NasaProperties.class
})
public class PropertyConfig {
}
