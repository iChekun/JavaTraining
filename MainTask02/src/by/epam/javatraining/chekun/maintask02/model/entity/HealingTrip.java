package by.epam.javatraining.chekun.maintask02.model.entity;

import by.epam.javatraining.chekun.maintask02.model.date.Date;

import java.util.Objects;


/**
 * Class child of Trip
 * Has {@String} field diagnosis.
 * Field has getter and setter.
 * <p>
 * Here using toString with super.toString from parent class.
 * Here using super.equals() to check is objects equals.
 * </p>
 */
public class HealingTrip extends Trip {

    private String diagnosis;

    public HealingTrip(int id, String country, String hotelName, int hotelLevel, Date departureDate,
                       double cost, String typeOfFood, String transportType, String diagnosis) {
        super(id, country, hotelName, hotelLevel, departureDate, cost, typeOfFood, transportType);

        this.name = "HealingTrip" + id;
        this.diagnosis = diagnosis;
    }


    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HealingTrip that = (HealingTrip) o;
        return Objects.equals(diagnosis, that.diagnosis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diagnosis);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }
}
