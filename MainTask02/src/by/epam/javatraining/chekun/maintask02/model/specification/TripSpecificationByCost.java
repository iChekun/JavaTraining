package by.epam.javatraining.chekun.maintask02.model.specification;

import by.epam.javatraining.chekun.maintask02.model.entity.Trip;

public class TripSpecificationByCost implements TripSpecification {

    private double cost;

    public TripSpecificationByCost(double cost) {
        this.cost = cost;
    }

    /**
     *Specifies if given trip has defined cost.
     * @param trip trip to specify
     * @return {@code true} if trip has defined cost;
     *   {@code false} otherwise.
     */
    @Override
    public boolean specified(Trip trip) {
        return cost == trip.getCost();
    }
}
