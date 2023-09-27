package com.tietoevry.homework.services.weather;

import com.tietoevry.homework.services.weather.WeatherForecast.Temperature;
import com.tietoevry.homework.services.weather.WeatherForecast.WeatherCondition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class WeatherComApi {

    private final String url;

    private final String username;

    private final String password;

    WeatherComApi(@Value("${weather-com-api.url}") String url,
                  @Value("${weather-com-api.username}") String username,
                  @Value("${weather-com-api.password}") String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public WeatherForecast getForecast(String location, LocalDate date) { // todo: call real api instead of fake

        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        WeatherCondition condition = WeatherCondition.values()[day % WeatherCondition.values().length];
        Temperature temperature = Temperature.values()[month % Temperature.values().length];
        return new WeatherForecast(condition, temperature);
    }
}
