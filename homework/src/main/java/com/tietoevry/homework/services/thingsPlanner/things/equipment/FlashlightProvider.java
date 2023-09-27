package com.tietoevry.homework.services.thingsPlanner.things.equipment;

import com.tietoevry.homework.services.thingsPlanner.Context;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FlashlightProvider implements EquipmentProvider {

    @Override
    public Optional<Equipment> apply(Context context) {
        return Optional.of(context)
                .filter(ctx -> ctx.getPeriod().getDays() >= 2)
                .map(ctx -> new Flashlight());
    }

}
