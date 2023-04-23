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
public class OrbitalClass {
    @JsonProperty("orbit_class_type")
    private String orbitClassType;
    @JsonProperty("orbit_class_description")
    private String orbitClassDescription;
    @JsonProperty("orbit_class_range")
    private String orbitClassRange;
}
