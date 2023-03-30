package com.example.nasaasteroidsfullstackback.util;

import com.example.nasaasteroidsfullstackback.dto.DatePair;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UtilityClass
public class DatePairGenerator {

    public static List<DatePair> generateDatePairs(String start, String end) {
        if (start.isBlank() || end.isBlank()) {
            return Collections.singletonList(new DatePair(start, end));
        }

        //TODO rewrite dates generating using already cached data to avoid pulling huge count of data

        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);

        int daysBetween = startDate.until(endDate).getDays();
        List<DatePair> datePairs = new ArrayList<>();

        if (daysBetween <= 7) {
            datePairs.add(new DatePair(start, end));
        } else {
            LocalDate nextStartDate = startDate;

            while (nextStartDate.isBefore(endDate) || nextStartDate.isEqual(endDate)) {
                LocalDate nextEndDate = nextStartDate.plusDays(6);
                if (nextEndDate.isAfter(endDate)) {
                    nextEndDate = endDate;
                }
                datePairs.add(new DatePair(nextStartDate.toString(), nextEndDate.toString()));
                nextStartDate = nextEndDate.plusDays(1);
            }
        }

        return datePairs;
    }

}
