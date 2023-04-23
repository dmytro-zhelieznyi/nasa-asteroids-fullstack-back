package com.example.nasaasteroidsfullstackback.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class NeoLookUp {
    @JsonProperty("near_earth_object")
    private NearEarthObject nearEarthObject;
}
