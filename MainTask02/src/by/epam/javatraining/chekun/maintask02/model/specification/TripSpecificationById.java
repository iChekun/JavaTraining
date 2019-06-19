package by.epam.javatraining.chekun.maintask02.model.specification;

import by.epam.javatraining.chekun.maintask02.model.entity.Trip;

public class TripSpecificationById implements TripSpecification {

    private int id;

    public TripSpecificationById(int id) {
        this.id = id;
    }

    /**
     * Specifies if given trip has defined id.
     *
     * @param trip trip to specify
     * @return {@code true} if trip has defined id;
     * {@code false} otherwise.
     */
    @Override
    public boolean specified(Trip trip) {
        return id == trip.getId();
    }
}