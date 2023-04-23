package com.example.nasaasteroidsfullstackback.util;

import com.example.nasaasteroidsfullstackback.dto.NeoFeed;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public final class NeoFeedMapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static NeoFeed JsonToNeoFeed(String json) {
        try {
            return mapper.readValue(json, NeoFeed.class);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

}
