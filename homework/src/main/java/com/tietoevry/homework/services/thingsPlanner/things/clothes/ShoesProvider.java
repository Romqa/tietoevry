package com.tietoevry.homework.services.thingsPlanner.things.clothes;

import com.tietoevry.homework.services.thingsPlanner.Context;
import com.tietoevry.homework.services.thingsPlanner.things.clothes.Shoes.Type;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.tietoevry.homework.services.thingsPlanner.TripType.HIKING;
import static com.tietoevry.homework.services.thingsPlanner.TripType.TREKKING;
import static com.tietoevry.homework.services.thingsPlanner.things.clothes.Shoes.Type.*;

@Component
public class ShoesProvider implements ClothesProvider {

    private final static Map<Type, Predicate<Context>> shoesConditions = new LinkedHashMap<>(Map.of(
            WET_HIGH, context ->
                    context.getWeatherForecastsReport().hasRainyDay() && HIKING.equals(context.getTripType()),
            WET_LIGHT, context ->
                    context.getWeatherForecastsReport().hasRainyDay() && TREKKING.equals(context.getTripType()),
            DRY_HIGH, context ->
                    context.getWeatherForecastsReport().hasNoRainyDay() && HIKING.equals(context.getTripType()),
            DRY_LIGHT, context ->
                    context.getWeatherForecastsReport().hasNoRainyDay() && TREKKING.equals(context.getTripType())
    ));

    @Override
    public List<Clothes> apply(Context context) {
        return shoesConditions.entrySet().stream()
                .filter(entry -> entry.getValue().test(context))
                .map(Map.Entry::getKey)
                .map(Shoes::new)
                .collect(Collectors.toList());
    }

}
