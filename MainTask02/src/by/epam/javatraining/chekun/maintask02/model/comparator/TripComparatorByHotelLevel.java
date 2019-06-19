package by.epam.javatraining.chekun.maintask02.model.comparator;

import by.epam.javatraining.chekun.maintask02.model.entity.Trip;

import java.util.Comparator;

public class TripComparatorByHotelLevel implements Comparator<Trip> {

    @Override
    public int compare(Trip o1, Trip o2) {
        if (o1.getHotelLevel() > o2.getHotelLevel()) {
            return 1;
        }
        if (o1.getHotelLevel() == o2.getHotelLevel()) {
            return 0;
        }
        return -1;
    }
}
