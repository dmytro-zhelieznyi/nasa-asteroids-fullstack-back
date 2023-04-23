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
public class EstimatedDiameterUnit {
    @JsonProperty("estimated_diameter_min")
    private Double estimatedDiameterMin;
    @JsonProperty("estimated_diameter_max")
    private Double estimatedDiameterMax;
}
