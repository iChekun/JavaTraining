package by.epam.javatraining.chekun.maintask02.model.entity;

import by.epam.javatraining.chekun.maintask02.model.date.Date;

import java.util.Objects;

/**
 * Abstract class with type Trip , that contain fields that have all trip types
 * All fields are private and has getters and setters.
 * Names of child classes form with adding unique id to name
 *
 * @author Chekun Ilya
 */
public abstract class Trip {

    private int id;
    protected String name;

    private String country;
    private String hotelName;
    private int hotelLevel;

    private Date departureDate;

    private double cost;

    private String typeOfFood;

    private String typeOfTransport;

    ///////////////////////////////////
    protected Trip() {
    }


    protected Trip(int id, String country, String hotelName, int hotelLevel, Date departureDate,
                   double cost, String typeOfFood, String typeOfTransport) {
        this.id = id;
        this.country = country;
        this.hotelName = hotelName;
        this.hotelLevel = hotelLevel;
        this.departureDate = departureDate;
        this.cost = cost;
        this.typeOfFood = typeOfFood;
        this.typeOfTransport = typeOfTransport;
    }

    //////////////////////
    public String getTypeOfTransport() {
        return typeOfTransport;
    }

    public void setTypeOfTransport(String typeOfTransport) {
        this.typeOfTransport = typeOfTransport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelLevel() {
        return hotelLevel;
    }

    public void setHotelLevel(int hotelLevel) {
        this.hotelLevel = hotelLevel;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "Name = " + this.name +
                ", id=" + id +
                ", country='" + country + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", hotelLevel=" + hotelLevel +
                ", departureDate=" + departureDate +
                ", cost=" + cost +
                ", typeOfFood='" + typeOfFood + '\'' +
                ", typeOfTransport='" + typeOfTransport + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return hotelLevel == trip.hotelLevel &&
                Double.compare(trip.cost, cost) == 0 &&
                Objects.equals(country, trip.country) &&
                Objects.equals(hotelName, trip.hotelName) &&
                Objects.equals(departureDate, trip.departureDate) &&
                Objects.equals(typeOfFood, trip.typeOfFood) &&
                Objects.equals(typeOfTransport, trip.typeOfTransport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, hotelName, hotelLevel, departureDate, cost, typeOfFood, typeOfTransport);
    }
}
