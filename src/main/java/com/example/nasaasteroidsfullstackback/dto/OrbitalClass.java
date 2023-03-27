package com.example.nasaasteroidsfullstackback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrbitalClass {
    @JsonProperty("orbit_class_type")
    private String orbitClassType;
    @JsonProperty("orbit_class_description")
    private String orbitClassDescription;
    @JsonProperty("orbit_class_range")
    private String orbitClassRange;
}
