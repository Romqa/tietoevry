package com.tietoevry.homework.services.thingsPlanner.things.food;

import com.tietoevry.homework.services.thingsPlanner.Context;
import com.tietoevry.homework.utils.NumericUtils;
import org.springframework.stereotype.Component;

import java.time.Period;
import java.util.Optional;

@Component
public class LunchProvider implements FoodProvider {

    private final int lunchesPerDay = 1;

    @Override
    public Optional<Food> apply(Context context) {
        return Optional.of(context)
                .map(Context::getPeriod)
                .map(Period::getDays)
                .map(tripDuration -> tripDuration * lunchesPerDay)
                .filter(NumericUtils::isPositive)
                .map(Lunch::new);
    }

}
