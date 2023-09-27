package com.tietoevry.homework.services.weather;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static com.tietoevry.homework.services.weather.WeatherForecast.Temperature.isCold;
import static com.tietoevry.homework.services.weather.WeatherForecast.Temperature.isFreezing;
import static com.tietoevry.homework.services.weather.WeatherForecast.WeatherCondition.RAINY;
import static java.util.Collections.unmodifiableMap;

public class WeatherForecastReport {

    private final Map<LocalDate, WeatherForecast> forecasts;

    private WeatherForecastReport(Map<LocalDate, WeatherForecast> forecasts) {
        this.forecasts = forecasts;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Map<LocalDate, WeatherForecast> getForecasts() {
        return forecasts;
    }

    public boolean hasColdOrFreezingDay() {
        return forecasts.values().stream()
                .map(WeatherForecast::getTemperature)
                .anyMatch(isCold().or(isFreezing()));
    }

    public boolean hasRainyDay() {
        return forecasts.values().stream()
                .map(WeatherForecast::getCondition)
                .anyMatch(RAINY::equals);
    }

    public boolean hasNoRainyDay() {
        return forecasts.values().stream()
                .map(WeatherForecast::getCondition)
                .noneMatch(RAINY::equals);
    }

    public static class Builder {
        private final HashMap<LocalDate, WeatherForecast> forecasts = new HashMap<>();

        public void put(LocalDate date, WeatherForecast forecast) {
            forecasts.put(date, forecast);
        }

        public WeatherForecastReport build() {
            return new WeatherForecastReport(unmodifiableMap(forecasts));
        }
    }
}
