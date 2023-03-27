package com.example.nasaasteroidsfullstackback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class NeoFeed {
    @JsonProperty("links")
    private Map<String, String> links;
    @JsonProperty("element_count")
    private String elementCount;
    @JsonProperty("near_earth_objects")
    private Map<String, List<NearEarthObject>> nearEarthObjects;
}
