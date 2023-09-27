package com.tietoevry.homework.services.thingsPlanner.things.clothes;

import com.tietoevry.homework.services.thingsPlanner.Context;

import java.util.List;

public interface ClothesProvider {

    List<Clothes> apply(Context context);

}
