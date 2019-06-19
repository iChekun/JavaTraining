package by.epam.javatraining.chekun.maintask02.model.specification;

import by.epam.javatraining.chekun.maintask02.model.entity.Trip;

public class TripSpecificationByCountry implements TripSpecification {

    private String country;


    public TripSpecificationByCountry(String country) {
        this.country = country;
    }

    /**
     * Specifies if given trip has defined country.
     *
     * @param trip trip to specify
     * @return {@code true} if trip has defined hotel name;
     * {@code false} otherwise.
     */
    @Override
    public boolean specified(Trip trip) {
        return this.country.equals(trip.getCountry());
    }
}
