package com.example.nasaasteroidsfullstack.service;

import com.example.nasaasteroidsfullstackback.NasaAsteroidsFullstackApplication;
import com.example.nasaasteroidsfullstackback.dto.NeoFeed;
import com.example.nasaasteroidsfullstackback.dto.NeoLookUp;
import com.example.nasaasteroidsfullstackback.service.AsteroidService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        classes = {
                NasaAsteroidsFullstackApplication.class,
        })
public class AsteroidServiceTest {

    @Autowired
    private AsteroidService asteroidService;

    @Test
    public void getAsteroidWithValidAsteroidId() {
        var asteroidId = "3726710";
        NeoLookUp neoLookUp = asteroidService.getAsteroid("3726710")
                .block();
        assert neoLookUp != null;
        Assertions.assertEquals(asteroidId, neoLookUp.getNearEarthObject().getId());
    }

    @Test
    public void getAllAsteroidsWithWithLessThan7Days() {
        String start = "2022-01-01";
        String end = "2022-01-03";
        NeoFeed neoFeed = asteroidService.getAllAsteroids(start, end)
                .block();
        assert neoFeed != null;
        Assertions.assertEquals(neoFeed.getNearEarthObjects().get("2022-01-01").size(), 22);
        Assertions.assertEquals(neoFeed.getNearEarthObjects().get("2022-01-02").size(), 13);
        Assertions.assertEquals(neoFeed.getNearEarthObjects().get("2022-01-03").size(), 14);
    }

    @Test
    public void getAllAsteroidsWithWithMoreThan7Days() {
        String start = "2022-01-01";
        String end = "2022-01-15";
        NeoFeed neoFeed = asteroidService.getAllAsteroids(start, end)
                .block();
        assert neoFeed != null;
        Assertions.assertEquals(neoFeed.getElementCount(), 249);
        Assertions.assertEquals(neoFeed.getNearEarthObjects().size(), 15);
    }

}
