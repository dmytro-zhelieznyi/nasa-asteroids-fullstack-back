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
public class MissDistance {
    @JsonProperty("astronomical")
    private String astronomical;
    @JsonProperty("lunar")
    private String lunar;
    @JsonProperty("kilometers")
    private String kilometers;
    @JsonProperty("miles")
    private String miles;
}
