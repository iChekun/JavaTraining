package by.epam.javatraining.chekun.maintask02.model.comparator;

import by.epam.javatraining.chekun.maintask02.model.entity.Trip;

import java.util.Comparator;

public class TripComparatorByTransportType implements Comparator<Trip> {

    @Override
    public int compare(Trip o1, Trip o2) {
        String first = o1.getTypeOfTransport();
        String second = o2.getTypeOfTransport();

        return first.compareTo(second);
    }
}
