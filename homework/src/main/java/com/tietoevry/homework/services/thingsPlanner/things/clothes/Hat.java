package com.tietoevry.homework.services.thingsPlanner.things.clothes;

public class Hat implements Clothes {

    private final Type type;

    public Hat(Type type) {
        this.type = type;
    }

    @Override
    public String getTitle() {
        return type.title;
    }

    public enum Type {
        SUN("Sunhat"),
        WARM("Warm hat");

        public final String title;

        Type(String title) {
            this.title = title;
        }
    }

}
