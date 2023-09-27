package com.tietoevry.homework.services.thingsPlanner;

import com.tietoevry.homework.services.TripDurationCalculator;
import com.tietoevry.homework.services.thingsPlanner.things.clothes.Clothes;
import com.tietoevry.homework.services.thingsPlanner.things.clothes.ClothesProvider;
import com.tietoevry.homework.services.thingsPlanner.things.equipment.Equipment;
import com.tietoevry.homework.services.thingsPlanner.things.equipment.EquipmentProvider;
import com.tietoevry.homework.services.thingsPlanner.things.food.Food;
import com.tietoevry.homework.services.thingsPlanner.things.food.FoodProvider;
import com.tietoevry.homework.services.weather.WeatherForecastReport;
import com.tietoevry.homework.services.weather.WeatherForecastService;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class ThingsPlanner {

    private final WeatherForecastService weatherService;

    private final TripDurationCalculator tripDurationCalculator;

    private final List<ClothesProvider> clothesProviders;

    private final List<FoodProvider> foodProviders;

    private final List<EquipmentProvider> equipmentProviders;

    /**
     * todo: reduce arguments count, for instance:
     * List<ThingsProvider<?>>: FoodProvider extends ThingsProvider<Food>, ClothesProvider extends ThingsProvider<Clothes>
     */
    public ThingsPlanner(WeatherForecastService weatherService,
                         TripDurationCalculator tripDurationCalculator,
                         List<ClothesProvider> clothesProviders,
                         List<FoodProvider> foodProviders,
                         List<EquipmentProvider> equipmentProviders) {
        this.weatherService = weatherService;
        this.tripDurationCalculator = tripDurationCalculator;
        this.clothesProviders = clothesProviders;
        this.foodProviders = foodProviders;
        this.equipmentProviders = equipmentProviders;
    }

    public ThingsList prepare(Context context) {
        context.setPeriod(calculatePeriod(context));
        context.setWeatherForecastsReport(getWeatherForecasts(context));

        return ThingsList.newBuilder()
                .withClothes(prepareClothesList(context))
                .withFood(prepareFoodList(context))
                .withEquiplemts(prepareEquipmentsList(context))
                .build();
    }

    private Period calculatePeriod(Context context) {
        return tripDurationCalculator.calculateDuration(context.getDistance());
    }

    private WeatherForecastReport getWeatherForecasts(Context context) {
        return weatherService.getForecast(context.getLocation(), context.getDate(), context.getPeriod());
    }

    private List<Equipment> prepareEquipmentsList(Context context) {
        return equipmentProviders.stream()
                .map(provider -> provider.apply(context))
                .flatMap(Optional::stream)
                .toList();
    }

    private List<Food> prepareFoodList(Context context) {
        return foodProviders.stream()
                .map(provider -> provider.apply(context))
                .flatMap(Optional::stream)
                .toList();
    }

    private List<Clothes> prepareClothesList(Context context) {
        return clothesProviders.stream()
                .map(provider -> provider.apply(context))
                .flatMap(List::stream)
                .toList();
    }

}
