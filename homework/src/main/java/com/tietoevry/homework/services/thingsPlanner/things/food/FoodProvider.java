package com.tietoevry.homework.services.thingsPlanner.things.food;

import com.tietoevry.homework.services.thingsPlanner.Context;

import java.util.Optional;

public interface FoodProvider {

    Optional<Food> apply(Context context);

}
