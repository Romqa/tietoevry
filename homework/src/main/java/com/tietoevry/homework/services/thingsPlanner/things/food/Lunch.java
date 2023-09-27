package com.tietoevry.homework.services.thingsPlanner.things.food;

import com.tietoevry.homework.services.thingsPlanner.things.Measure;

public class Lunch implements Food {

    private final int amount;

    public Lunch(int amount) {
        this.amount = amount;
    }

    @Override
    public String getTitle() {
        return "Lunch pack";
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
