package by.epam.javatraining.chekun.maintask02.model.comparator;

import by.epam.javatraining.chekun.maintask02.model.entity.Trip;

import java.util.Comparator;

public class TripComparatorByID implements Comparator<Trip> {

    @Override
    public int compare(Trip o1, Trip o2) {
        return o1.getId() - o2.getId();
    }
}
