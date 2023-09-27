package com.tietoevry.homework.services.thingsPlanner

import com.tietoevry.homework.services.TripDurationCalculator
import com.tietoevry.homework.services.thingsPlanner.things.clothes.ClothesProvider
import com.tietoevry.homework.services.thingsPlanner.things.equipment.EquipmentProvider
import com.tietoevry.homework.services.thingsPlanner.things.food.FoodProvider
import com.tietoevry.homework.services.weather.WeatherForecastReport
import com.tietoevry.homework.services.weather.WeatherForecastService
import spock.lang.Specification
import spock.lang.Subject

import java.time.LocalDate

import static com.tietoevry.homework.services.thingsPlanner.TripType.HIKING
import static java.time.LocalDate.parse
import static java.time.Period.ofDays

class ThingsPlannerTest extends Specification {

    final WeatherForecastService weatherService = Mock()

    final TripDurationCalculator tripDurationCalculator = Mock()

    final List<ClothesProvider> clothesProviders = []

    final List< FoodProvider> foodProviders = []

    final List<EquipmentProvider> equipmentProviders = []

    @Subject
    final ThingsPlanner thingsPlanner = new ThingsPlanner(weatherService, tripDurationCalculator, clothesProviders, foodProviders, equipmentProviders)

    void 'should setup context\'s additional properties'() {
        given:
            String location = 'Some location'
            LocalDate date = parse('2100-01-01');
            int distance = 100
        and:
            Context context = Context.newBuilder()
                    .withLocation(location)
                    .withDate(date)
                    .withDistance(distance)
                    .withPeopleCount(1)
                    .withType(HIKING)
                    .build()

        when:
            thingsPlanner.prepare(context)

        then:
            1 * tripDurationCalculator.calculateDuration(distance) >> ofDays(13)
            1 * weatherService.getForecast(location, date, ofDays(13)) >> Stub(WeatherForecastReport)
        and:
            context.getWeatherForecastsReport() != null
            context.getPeriod() != null
    }

}
