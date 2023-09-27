package com.tietoevry.homework.controllers;

import com.tietoevry.homework.controllers.ThingsController.ThingsListResponse.AccountableThing;
import com.tietoevry.homework.controllers.ThingsController.ThingsListResponse.Thing;
import com.tietoevry.homework.services.thingsPlanner.Context;
import com.tietoevry.homework.services.thingsPlanner.ThingsList;
import com.tietoevry.homework.services.thingsPlanner.ThingsPlanner;
import com.tietoevry.homework.services.thingsPlanner.TripType;
import com.tietoevry.homework.services.thingsPlanner.things.Measure;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/things")
@Validated
public class ThingsController {

    private final ThingsPlanner thingsPlanner;

    public ThingsController(ThingsPlanner thingsPlanner) {
        this.thingsPlanner = thingsPlanner;
    }

    @GetMapping
    public ThingsListResponse getThingsList(@RequestParam @NotEmpty String location,
                                            @RequestParam @Future LocalDate date,
                                            @RequestParam @Min(1) int distanceInKm,
                                            @RequestParam @Min(1) int peopleCount,
                                            @RequestParam TripType type
    ) {
        Context context = Context.newBuilder()
                .withLocation(location)
                .withDate(date)
                .withDistance(distanceInKm)
                .withPeopleCount(peopleCount)
                .withType(type)
                .build();

        ThingsList thingsList = thingsPlanner.prepare(context);

        return mapToResponse(thingsList);
    }

    private ThingsListResponse mapToResponse(ThingsList list) {
        List<AccountableThing> food = list.food().stream()
                .map(f -> new AccountableThing(f.getTitle(), f.getAmount(), f.getMeasure()))
                .toList();

        List<Thing> clothes = list.clothes().stream()
                .map(c -> new Thing(c.getTitle()))
                .toList();

        List<Thing> equipments = list.equipments().stream()
                .map(e -> new Thing(e.getTitle()))
                .toList();

        return new ThingsListResponse(food, clothes, equipments);
    }

    public record ThingsListResponse(List<AccountableThing> food, List<Thing> clothes, List<Thing> equipments) {

        public static class Thing {

            public final String title;

            public Thing(String title) {
                this.title = title;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Thing thing = (Thing) o;
                return Objects.equals(title, thing.title);
            }

            @Override
            public int hashCode() {
                return Objects.hash(title);
            }
        }

        public static class AccountableThing extends Thing {

            public final Double amount;

            public final Measure measure;

            public AccountableThing(String title, Double amount, Measure measure) {
                super(title);
                this.amount = amount;
                this.measure = measure;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                if (!super.equals(o)) return false;
                AccountableThing that = (AccountableThing) o;
                return Objects.equals(title, that.title) && Objects.equals(amount, that.amount) && measure == that.measure;
            }

            @Override
            public int hashCode() {
                return Objects.hash(super.hashCode(), amount, measure);
            }
        }

    }

}
