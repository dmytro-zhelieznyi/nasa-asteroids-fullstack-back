package com.example.nasaasteroidsfullstackback.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class NeoFeed {
    @JsonProperty("links")
    private Map<String, String> links;
    @JsonProperty("element_count")
    private Long elementCount;
    @JsonProperty("near_earth_objects")
    private Map<String, List<NearEarthObject>> nearEarthObjects;

    public NeoFeed reduceOne(NeoFeed neoFeed) {
        this.elementCount += neoFeed.getElementCount();
        this.nearEarthObjects.putAll(neoFeed.getNearEarthObjects());
        return this;
    }
}
