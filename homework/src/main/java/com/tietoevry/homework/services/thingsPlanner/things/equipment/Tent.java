package com.tietoevry.homework.services.thingsPlanner.things.equipment;

public class Tent implements Equipment {

    private final int size;

    public Tent(int size) {
        this.size = size;
    }

    @Override
    public String getTitle() {
        return String.format("Tent for %d people", size);
    }
}
