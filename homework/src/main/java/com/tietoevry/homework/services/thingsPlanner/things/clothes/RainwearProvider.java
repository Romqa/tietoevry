package com.tietoevry.homework.services.thingsPlanner.things.clothes;

import com.tietoevry.homework.services.thingsPlanner.Context;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RainwearProvider implements ClothesProvider {

    @Override
    public List<Clothes> apply(Context context) {
        List<Clothes> wears = new ArrayList<>();

        if (context.getWeatherForecastsReport().hasRainyDay()) {
            wears.add(new Rainwear());
        }

        return wears;
    }

}
