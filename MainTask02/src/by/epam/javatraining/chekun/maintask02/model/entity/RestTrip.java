package by.epam.javatraining.chekun.maintask02.model.entity;

import by.epam.javatraining.chekun.maintask02.model.date.Date;

/**
 * Class contains all fields and methods from parent class Trip;
 * <p>
 * Can be updated with any new field(Now using equals and toString from parent class Trip)
 */
public class RestTrip extends Trip {

    public RestTrip() {
    }

    public RestTrip(int id, String country, String hotelName, int hotelLevel, Date departureDate,
                    double cost, String typeOfFood, String transportType) {
        super(id, country, hotelName, hotelLevel, departureDate, cost, typeOfFood, transportType);

        this.name = "RestTrip" + id;
    }


}
