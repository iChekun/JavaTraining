package by.epam.javatraining.chekun.maintask02.model.entity;

import by.epam.javatraining.chekun.maintask02.model.date.Date;

import java.util.Objects;

/**
 * Class child of Trip.
 * <p>
 * Has {@String} places which contains places for visiting in trip.
 * Has super.equals and toString from parent class Trip
 * </p>
 */
public class ExcursionTrip extends Trip {

    private String places;

    public ExcursionTrip() {
    }

    public ExcursionTrip(int id, String country, String hotelName, int hotelLevel, Date departureDate,
                         double cost, String typeOfFood, String transportType, String places) {
        super(id, country, hotelName, hotelLevel, departureDate, cost, typeOfFood, transportType);

        this.places = places;
        this.name = "ExcursionTrip" + id;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ExcursionTrip that = (ExcursionTrip) o;
        return Objects.equals(places, that.places);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), places);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", places='" + places + '\'' +
                '}';
    }
}
