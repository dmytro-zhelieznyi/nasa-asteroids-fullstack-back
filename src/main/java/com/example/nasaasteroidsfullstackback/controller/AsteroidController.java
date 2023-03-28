package com.example.nasaasteroidsfullstackback.controller;

import com.example.nasaasteroidsfullstackback.dto.NeoFeed;
import com.example.nasaasteroidsfullstackback.dto.NeoLookUp;
import com.example.nasaasteroidsfullstackback.exception.model.ExceptionDto;
import com.example.nasaasteroidsfullstackback.service.AsteroidService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/asteroids")
@RequiredArgsConstructor
public class AsteroidController {

    private final AsteroidService asteroidService;

    @Operation(summary = "asteroids", description = "Provide list of asteroids for certain period")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "OK",
                    content = @Content(
                            schema = @Schema(implementation = NeoFeed.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500", description = "Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ExceptionDto.class)
                    )
            ),
    })
    @GetMapping
    public Mono<NeoFeed> getAllAsteroids(
            @RequestParam("start_date") String startDate,
            @RequestParam("end_date") String endDate
    ) {
        return asteroidService.getAllAsteroids(startDate, endDate);
    }

    @Operation(summary = "/asteroids/{id}", description = "Provide asteroid by id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "OK",
                    content = @Content(
                            schema = @Schema(implementation = NeoLookUp.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ExceptionDto.class)
                    )
            ),
    })
    @GetMapping("/{id}")
    public Mono<NeoLookUp> getAsteroid(
            @PathVariable("id") String id
    ) {
        return asteroidService.getAsteroid(id);
    }

}
