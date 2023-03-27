package com.example.nasaasteroidsfullstackback.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class NeoLookUp {
    private NearEarthObject nearEarthObject;
}
