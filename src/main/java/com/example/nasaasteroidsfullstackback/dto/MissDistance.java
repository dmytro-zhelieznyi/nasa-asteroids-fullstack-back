package com.example.nasaasteroidsfullstackback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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
