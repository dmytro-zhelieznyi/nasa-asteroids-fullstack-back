package com.example.nasaasteroidsfullstackback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EstimatedDiameterUnit {
    @JsonProperty("estimated_diameter_min")
    private Double estimatedDiameterMin;
    @JsonProperty("estimated_diameter_max")
    private Double estimatedDiameterMax;
}
