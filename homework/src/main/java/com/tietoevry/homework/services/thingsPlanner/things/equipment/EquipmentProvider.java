package com.tietoevry.homework.services.thingsPlanner.things.equipment;

import com.tietoevry.homework.services.thingsPlanner.Context;

import java.util.Optional;

public interface EquipmentProvider {

    Optional<Equipment> apply(Context context);

}
