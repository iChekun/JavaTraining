package by.epam.javatraining.chekun.maintask02.model.comparator;

import by.epam.javatraining.chekun.maintask02.model.entity.Trip;

import java.util.Comparator;

public class TripComparatorByCountry  implements Comparator<Trip> {

    @Override
    public int compare(Trip o1, Trip o2) {
        String first = o1.getCountry();
        String second = o2.getCountry();

        return first.compareTo(second);
    }
}

