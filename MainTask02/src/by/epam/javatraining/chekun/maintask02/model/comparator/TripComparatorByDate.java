package by.epam.javatraining.chekun.maintask02.model.comparator;

import by.epam.javatraining.chekun.maintask02.model.date.DateChecker;
import by.epam.javatraining.chekun.maintask02.model.entity.Trip;

import java.util.Comparator;

public class TripComparatorByDate implements Comparator<Trip> {

    @Override
    public int compare(Trip o1, Trip o2) {

        DateChecker dateChecker = DateChecker.getInstance();
        if (dateChecker.compare(o1.getDepartureDate(), o2.getDepartureDate())) {
            return 1;
        }
        if (o1.getDepartureDate().equals(o2.getDepartureDate())) {
            return 0;
        }
        return -1;
    }
}

