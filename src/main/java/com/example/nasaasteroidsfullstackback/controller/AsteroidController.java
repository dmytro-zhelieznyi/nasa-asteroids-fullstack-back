package com.example.nasaasteroidsfullstackback.controller;

import com.example.nasaasteroidsfullstackback.dto.NearEarthObject;
import com.example.nasaasteroidsfullstackback.dto.NeoFeed;
import com.example.nasaasteroidsfullstackback.service.AsteroidService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asteroids")
@RequiredArgsConstructor
public class AsteroidController {

    private final AsteroidService asteroidService;

    @GetMapping
    public NeoFeed getAllAsteroids(
            @RequestParam("start_date") String startDate,
            @RequestParam("end_date") String endDate
    ) {
        return asteroidService.getAllAsteroids(startDate, endDate);
    }

    @GetMapping("/{id}")
    public NearEarthObject getAsteroid(
            @PathVariable("id") String id
    ) {
        return asteroidService.getAsteroid(id);
    }

}
