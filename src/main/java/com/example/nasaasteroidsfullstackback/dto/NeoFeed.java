package com.example.nasaasteroidsfullstackback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Builder
@Getter
@Setter
@ToString
public class NeoFeed {
    @JsonProperty("links")
    private Map<String, String> links;
    @JsonProperty("element_count")
    private Long elementCount;
    @JsonProperty("near_earth_objects")
    private Map<String, List<NearEarthObject>> nearEarthObjects;

    public void addElementCount(Long newElementCount) {
        elementCount += newElementCount;
    }
}
