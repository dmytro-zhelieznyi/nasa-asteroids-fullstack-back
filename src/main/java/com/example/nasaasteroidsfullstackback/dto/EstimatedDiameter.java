package com.example.nasaasteroidsfullstackback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EstimatedDiameter {
    @JsonProperty("kilometers")
    private EstimatedDiameterUnit kilometers;
    @JsonProperty("meters")
    private EstimatedDiameterUnit meters;
    @JsonProperty("miles")
    private EstimatedDiameterUnit miles;
    @JsonProperty("feet")
    private EstimatedDiameterUnit feet;
}
