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
public class OrbitalData {
    @JsonProperty("orbit_id")
    private String orbitId;
    @JsonProperty("orbit_determination_date")
    private String orbitDeterminationDate;
    @JsonProperty("first_observation_date")
    private String firstObservationDate;
    @JsonProperty("last_observation_date")
    private String lastObservationDate;
    @JsonProperty("data_arc_in_days")
    private Integer dataArcInDays;
    @JsonProperty("observations_used")
    private Integer observationsUsed;
    @JsonProperty("orbit_uncertainty")
    private String orbitUncertainty;
    @JsonProperty("minimum_orbit_intersection")
    private String minimumOrbitIntersection;
    @JsonProperty("jupiter_tisserand_invariant")
    private String jupiterTisserandInvariant;
    @JsonProperty("epoch_osculation")
    private String epochOsculation;
    @JsonProperty("eccentricity")
    private String eccentricity;
    @JsonProperty("semi_major_axis")
    private String semiMajorAxis;
    @JsonProperty("inclination")
    private String inclination;
    @JsonProperty("ascending_node_longitude")
    private String ascendingNodeLongitude;
    @JsonProperty("orbital_period")
    private String orbitalPeriod;
    @JsonProperty("perihelion_distance")
    private String perihelionDistance;
    @JsonProperty("perihelion_argument")
    private String perihelionArgument;
    @JsonProperty("aphelion_distance")
    private String aphelionDistance;
    @JsonProperty("perihelion_time")
    private String perihelionTime;
    @JsonProperty("mean_anomaly")
    private String meanAnomaly;
    @JsonProperty("mean_motion")
    private String meanMotion;
    @JsonProperty("equinox")
    private String equinox;
    @JsonProperty("orbit_class")
    private OrbitalClass orbitalClass;
}
