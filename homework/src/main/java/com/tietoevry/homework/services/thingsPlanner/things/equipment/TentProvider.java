package com.tietoevry.homework.services.thingsPlanner.things.equipment;

import com.tietoevry.homework.services.thingsPlanner.Context;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TentProvider implements EquipmentProvider {

    @Override
    public Optional<Equipment> apply(Context context) { // todo: consider how many people participate in the trip
        return Optional.of(context)
                .filter(ctx -> ctx.getPeriod().getDays() >= 2)
                .map(ctx -> new Tent(ctx.getPeopleCount()));
    }

}
