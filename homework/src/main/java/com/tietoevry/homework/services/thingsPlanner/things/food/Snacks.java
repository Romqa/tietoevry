package com.tietoevry.homework.services.thingsPlanner.things.food;

import com.tietoevry.homework.services.thingsPlanner.things.Measure;

public class Snacks implements Food {

    private final int amount;

    public Snacks(int amount) {
        this.amount = amount;
    }

    @Override
    public String getTitle() {
        return "Snacks";
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
