package by.epam.javatraining.chekun.maintask02.model.comparator;

import by.epam.javatraining.chekun.maintask02.model.entity.Trip;

import java.util.Comparator;

public class TripComparatorByName implements Comparator<Trip> {

    @Override
    public int compare(Trip o1, Trip o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();

        return name1.compareTo(name2);
    }
}
