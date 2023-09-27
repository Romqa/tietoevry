package com.tietoevry.homework.services.thingsPlanner;

import com.tietoevry.homework.services.thingsPlanner.things.clothes.Clothes;
import com.tietoevry.homework.services.thingsPlanner.things.equipment.Equipment;
import com.tietoevry.homework.services.thingsPlanner.things.food.Food;

import java.util.ArrayList;
import java.util.List;

public record ThingsList(List<Clothes> clothes, List<Food> food, List<Equipment> equipments) {

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        List<Clothes> clothes = new ArrayList<>();

        List<Food> food = new ArrayList<>();

        List<Equipment> equipments = new ArrayList<>();

        public Builder withClothes(List<Clothes> clothes) {
            this.clothes = clothes;
            return this;
        }

        public Builder withFood(List<Food> food) {
            this.food = food;
            return this;
        }

        public Builder withEquiplemts(List<Equipment> equipments) {
            this.equipments = equipments;
            return this;
        }

        public ThingsList build() {
            return new ThingsList(clothes, food, equipments);
        }

    }
}
