package com.tietoevry.homework.services.thingsPlanner.things.food;

import com.tietoevry.homework.services.thingsPlanner.Context;
import com.tietoevry.homework.utils.NumericUtils;
import org.springframework.stereotype.Component;

import java.time.Period;
import java.util.Optional;

@Component
public class SnacksProvider implements FoodProvider {

    private final int snacksPerDay = 2;

    @Override
    public Optional<Food> apply(Context context) {
        return Optional.of(context)
                .map(Context::getPeriod)
                .map(Period::getDays)
                .map(tripDuration -> tripDuration * snacksPerDay)
                .filter(NumericUtils::isPositive)
                .map(Snacks::new);
    }

}
