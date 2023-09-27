package com.tietoevry.homework.services;

import org.springframework.stereotype.Service;

import java.time.Period;

@Service
public class TripDurationCalculator {

    private final int distancePerDay = 30;

    public Period calculateDuration(int distanceInKm) { // todo: create and use calculator's context
        return Period.ofDays((distanceInKm / distancePerDay) + 1);
    }

}
