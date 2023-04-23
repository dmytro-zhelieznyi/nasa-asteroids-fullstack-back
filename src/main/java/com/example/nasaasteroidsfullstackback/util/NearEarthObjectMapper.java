package com.example.nasaasteroidsfullstackback.util;

import com.example.nasaasteroidsfullstackback.dto.NearEarthObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public final class NearEarthObjectMapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static NearEarthObject JsonToNeoLookUp(String json) {
        try {
            return mapper.readValue(json, NearEarthObject.class);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

}
