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
public class CloseApproachData {
    @JsonProperty("close_approach_date")
    private String closeApproachDate;
    @JsonProperty("close_approach_date_full")
    private String closeApproachDateFull;
    @JsonProperty("epoch_date_close_approach")
    private Long epochDateCloseApproach;
    @JsonProperty("relative_velocity")
    private RelativeVelocity relativeVelocity;
    @JsonProperty("miss_distance")
    private MissDistance missDistance;
    @JsonProperty("orbiting_body")
    private String orbitingBody;
}
