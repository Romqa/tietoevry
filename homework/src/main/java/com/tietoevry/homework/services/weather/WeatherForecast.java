package com.tietoevry.homework.services.weather;

import java.util.function.Predicate;

public class WeatherForecast {
    private final WeatherCondition condition;
    private final Temperature temperature;

    public WeatherForecast(WeatherCondition condition, Temperature temperature) {
        this.condition = condition;
        this.temperature = temperature;
    }

    public WeatherCondition getCondition() {
        return condition;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "WeatherForecast{" +
                "condition=" + condition +
                ", temperature=" + temperature +
                '}';
    }

    public enum WeatherCondition {
        SUNNY, RAINY, CLOUDY
    }

    public enum Temperature {
        FREEZING, COLD, WARM, HOT;

        public static Predicate<Temperature> isHot() {
            return HOT::equals;
        }
        public static Predicate<Temperature> isWarm() {
            return WARM::equals;
        }
        public static Predicate<Temperature> isCold() {
            return COLD::equals;
        }
        public static Predicate<Temperature> isFreezing() {
            return FREEZING::equals;
        }
    }
}
