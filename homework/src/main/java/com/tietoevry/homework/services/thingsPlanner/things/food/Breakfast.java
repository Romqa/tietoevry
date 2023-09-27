package com.tietoevry.homework.services.thingsPlanner.things.food;

import com.tietoevry.homework.services.thingsPlanner.things.Measure;

public record Breakfast(int amount) implements Food {

    @Override
    public String getTitle() {
        return "Breakfast pack";
    }

    @Override
    public Double getAmount() {
        return (double) amount;
    }

    @Override
    public Measure getMeasure() {
        return Measure.PCS;
    }

}
