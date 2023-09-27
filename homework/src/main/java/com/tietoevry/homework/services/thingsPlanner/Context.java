package com.tietoevry.homework.services.thingsPlanner;

import com.tietoevry.homework.services.weather.WeatherForecastReport;

import java.time.LocalDate;
import java.time.Period;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;

public class Context {

    private final String location;

    private final LocalDate date;

    private final int distance;

    private final int peopleCount;

    private final TripType tripType;

    private Period period;

    private WeatherForecastReport weatherForecastsReport;

    private Context(String location, LocalDate date, int distance, int peopleCount, TripType tripType) {
        this.location = location;
        this.date = date;
        this.distance = distance;
        this.peopleCount = peopleCount;
        this.tripType = tripType;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getDistance() {
        return distance;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public TripType getTripType() {
        return tripType;
    }

    public WeatherForecastReport getWeatherForecastsReport() {
        return weatherForecastsReport;
    }

    public void setWeatherForecastsReport(WeatherForecastReport weatherForecastsReport) {
        this.weatherForecastsReport = weatherForecastsReport;
    }

    public static class Builder {

        private String location;

        private LocalDate date;

        private int distance;

        private int peopleCount;

        private TripType type;

        public Builder withLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder withDistance(int distance) {
            this.distance = distance;
            return this;
        }

        public Builder withPeopleCount(int peopleCount) {
            this.peopleCount = peopleCount;
            return this;
        }

        public Builder withType(TripType type) {
            this.type = type;
            return this;
        }

        public Context build() {
            notNull(location, "Location must be set");
            notNull(date, "Date must be set");
            isTrue(distance > 0, "Distance must be set");
            isTrue(peopleCount > 0, "People count must be set");
            notNull(type, "Type must be set");

            return new Context(location, date, distance, peopleCount, type);
        }
    }
}
