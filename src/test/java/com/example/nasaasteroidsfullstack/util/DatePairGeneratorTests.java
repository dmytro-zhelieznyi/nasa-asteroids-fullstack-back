package com.example.nasaasteroidsfullstack.util;

import com.example.nasaasteroidsfullstackback.dto.DatePair;
import com.example.nasaasteroidsfullstackback.util.DatePairGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatePairGeneratorTests {

    @Test
    public void generateDatePairsWithEmptyDates() {
        String start = "";
        String end = "";

        List<DatePair> result = DatePairGenerator.generateDatePairs(start, end);

        assertEquals(1, result.size());
        assertEquals("", result.get(0).getStartDate());
        assertEquals("", result.get(0).getEndDate());
    }

    @Test
    public void generateDatePairsWithLessThan7Days() {
        String start = "2022-01-01";
        String end = "2022-01-03";

        List<DatePair> result = DatePairGenerator.generateDatePairs(start, end);

        assertEquals(1, result.size());
        assertEquals(start, result.get(0).getStartDate());
        assertEquals(end, result.get(0).getEndDate());
    }

    @Test
    public void generateDatePairsWithMoreThan7Days() {
        String start = "2022-01-01";
        String end = "2022-01-15";

        List<DatePair> result = DatePairGenerator.generateDatePairs(start, end);

        assertEquals(3, result.size());
        assertEquals("2022-01-01", result.get(0).getStartDate());
        assertEquals("2022-01-07", result.get(0).getEndDate());
        assertEquals("2022-01-08", result.get(1).getStartDate());
        assertEquals("2022-01-14", result.get(1).getEndDate());
        assertEquals("2022-01-15", result.get(2).getStartDate());
        assertEquals("2022-01-15", result.get(2).getEndDate());
    }
}

