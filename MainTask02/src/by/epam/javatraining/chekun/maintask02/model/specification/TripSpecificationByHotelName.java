package by.epam.javatraining.chekun.maintask02.model.specification;

import by.epam.javatraining.chekun.maintask02.model.entity.Trip;

public class TripSpecificationByHotelName implements TripSpecification {

    private String hotelName;


    public TripSpecificationByHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * Specifies if given trip has defined hotel name.
     *
     * @param trip trip to specify
     * @return {@code true} if trip has defined hotel name;
     * {@code false} otherwise.
     */
    @Override
    public boolean specified(Trip trip) {
        return this.hotelName.equals(trip.getHotelName());
    }
}
