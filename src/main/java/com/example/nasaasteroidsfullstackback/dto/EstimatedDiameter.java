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
