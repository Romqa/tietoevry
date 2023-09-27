package com.tietoevry.homework.services.thingsPlanner.things.food;

import com.tietoevry.homework.services.thingsPlanner.Context;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WaterProvider implements FoodProvider {

    @Override
    public Optional<Food> apply(Context context) {

        // todo: calculate waters amount in depends on location(desert/forest),
        // weather forecast (hot/cold) and etc. (drinking water sources)

        return Optional.of(new Water(2.0));
    }

}
