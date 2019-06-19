package by.epam.javatraining.chekun.maintask02.model.comparator;

import by.epam.javatraining.chekun.maintask02.model.entity.Trip;

import java.util.Comparator;

public class TripComparatorByTypeOfFood implements Comparator<Trip> {

    @Override
    public int compare(Trip o1, Trip o2) {
        String first = o1.getTypeOfFood();
        String second = o2.getTypeOfFood();

        return first.compareTo(second);
    }
}