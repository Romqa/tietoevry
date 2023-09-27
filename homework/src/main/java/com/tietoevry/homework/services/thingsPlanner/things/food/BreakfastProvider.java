package com.tietoevry.homework.services.thingsPlanner.things.food;

import com.tietoevry.homework.services.thingsPlanner.Context;
import com.tietoevry.homework.utils.NumericUtils;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
public class BreakfastProvider implements FoodProvider {

    @Override
    public Optional<Food> apply(Context context) {
        return Optional.of(context)
                .map(Context::getPeriod)
                .map(Period::getDays)
                .map(tripDuration -> tripDuration - 1)
                .filter(NumericUtils::isPositive)
                .map(Breakfast::new);
    }

}
