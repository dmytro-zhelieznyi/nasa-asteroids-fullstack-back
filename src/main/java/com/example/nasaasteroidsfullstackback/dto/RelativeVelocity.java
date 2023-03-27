package com.example.nasaasteroidsfullstackback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RelativeVelocity {
    @JsonProperty("kilometers_per_second")
    private String kilometersPerSecond;
    @JsonProperty("kilometers_per_hour")
    private String kilometersPerHour;
    @JsonProperty("miles_per_hour")
    private String milesPerHour;
}
