package com.tietoevry.homework.services.weather;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.stream.IntStream;

import static com.fasterxml.jackson.databind.util.ClassUtil.nonNull;
import static org.springframework.util.Assert.notNull;

@Service
public class WeatherForecastService {

    private final WeatherComApi weatherApi;

    public WeatherForecastService(WeatherComApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    public WeatherForecastReport getForecast(String location, LocalDate startDate, Period period) {
        notNull(location, "Location must be provided");
        notNull(startDate, "Start date must be provided");
        notNull(period, "Period must be provided");

        WeatherForecastReport.Builder reportBuilder = WeatherForecastReport.newBuilder();

        IntStream.range(0, period.getDays()).boxed()
                .forEach(i -> {
                    LocalDate date = startDate.plusDays(i);
                    reportBuilder.put(date, weatherApi.getForecast(location, date));
                });

        return reportBuilder.build();
    }
}
