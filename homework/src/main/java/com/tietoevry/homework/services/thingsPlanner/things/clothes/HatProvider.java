package com.tietoevry.homework.services.thingsPlanner.things.clothes;

import com.tietoevry.homework.services.thingsPlanner.Context;
import com.tietoevry.homework.services.thingsPlanner.things.clothes.Hat.Type;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.tietoevry.homework.services.thingsPlanner.things.clothes.Hat.Type.SUN;
import static com.tietoevry.homework.services.weather.WeatherForecast.Temperature.HOT;
import static com.tietoevry.homework.services.weather.WeatherForecast.Temperature.WARM;
import static com.tietoevry.homework.services.weather.WeatherForecast.WeatherCondition.SUNNY;

@Component
public class HatProvider implements ClothesProvider {

    final static Map<Hat.Type, Predicate<Context>> shoesConditions = new LinkedHashMap<>(Map.of(
            Type.WARM, context -> context.getWeatherForecastsReport().hasColdOrFreezingDay(),
            SUN, context -> context.getWeatherForecastsReport().getForecasts().values().stream()
                    .filter(daysForecast -> SUNNY.equals(daysForecast.getCondition()))
                    .anyMatch(daysForecast -> {
                        return (daysForecast.getTemperature().equals(WARM) || daysForecast.getTemperature().equals(HOT));
                    })
    ));

    @Override
    public List<Clothes> apply(Context context) {
         return shoesConditions.entrySet().stream()
                .filter(entry -> entry.getValue().test(context))
                .map(Map.Entry::getKey)
                .map(Hat::new)
                .collect(Collectors.toList());
    }

}
