package com.tietoevry.homework.services.thingsPlanner.things.food;

import com.tietoevry.homework.services.thingsPlanner.things.Measure;

public class Water implements Food {

    private final Double amount;

    public Water(Double amount) {
        this.amount = amount;
    }

    @Override
    public String getTitle() {
        return "Water";
    }

    @Override
    public Double getAmount() {
        return amount;
    }

    @Override
    public Measure getMeasure() {
        return Measure.L;
    }

}
