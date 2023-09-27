package com.tietoevry.homework.services.thingsPlanner.things.clothes;

public class Shoes implements Clothes {

    private final Type type;

    public Shoes(Type type) {
        this.type = type;
    }

    @Override
    public String getTitle() {
        return type.title;
    }

    public enum Type {
        DRY_LIGHT("Light shoes for dry weather"),
        WET_LIGHT("Waterproof light shoes"),
        DRY_HIGH("High shoes for dry weather"),
        WET_HIGH("Waterproof high shoes");

        public final String title;

        Type(String title) {
            this.title = title;
        }
    }
}
