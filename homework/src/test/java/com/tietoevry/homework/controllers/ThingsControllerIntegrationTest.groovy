package com.tietoevry.homework.controllers

import com.tietoevry.homework.IntegrationTest
import com.tietoevry.homework.services.thingsPlanner.TripType
import org.springframework.beans.factory.annotation.Autowired

import static com.tietoevry.homework.controllers.ThingsController.ThingsListResponse.AccountableThing
import static com.tietoevry.homework.controllers.ThingsController.ThingsListResponse.Thing
import static com.tietoevry.homework.services.thingsPlanner.things.Measure.L
import static com.tietoevry.homework.services.thingsPlanner.things.Measure.PCS
import static java.time.LocalDate.parse
import static org.apache.commons.collections4.CollectionUtils.isEqualCollection

class ThingsControllerIntegrationTest extends IntegrationTest {

    @Autowired
    ThingsController controller

    void 'should return response'() {
        when:
            ThingsController.ThingsListResponse response = controller.getThingsList("Some location",
                    parse("2100-01-01"), 100, 2, TripType.HIKING)
        Thread.sleep(100_000)

        then:
            isEqualCollection(response.clothes(), [
                    new Thing("Rainwear"),
                    new Thing("Warm hat"),
                    new Thing("Waterproof high shoes")
            ])
            isEqualCollection(response.equipments(), [
                    new Thing("Flashlight"),
                    new Thing("Tent for 2 people"),
            ])
            isEqualCollection(response.food(), [
                    new AccountableThing("Breakfast pack", 3.0, PCS),
                    new AccountableThing("Dinner pack", 3.0, PCS),
                    new AccountableThing("Lunch pack", 4.0, PCS),
                    new AccountableThing("Snacks", 8.0, PCS),
                    new AccountableThing("Water", 2.0, L),
            ])
    }

}
