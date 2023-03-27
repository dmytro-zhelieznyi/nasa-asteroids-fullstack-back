package com.example.nasaasteroidsfullstackback.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Asteroid {
    private String id;
    private String name;
    private String nasaJplUrl;
    private Double absoluteMagnitudeH;
    private EstimatedDiameter estimatedDiameter;
    private Boolean isPotentiallyHazardousAsteroid;
    private List<CloseApproachData> closeApproachData;
    private Boolean isSentryObject;
}
