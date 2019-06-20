package by.epam.javatraining.chekun.maintask02.model.reposizoty;

import by.epam.javatraining.chekun.maintask02.model.entity.Trip;
import by.epam.javatraining.chekun.maintask02.model.exception.WrongArgumentsException;
import by.epam.javatraining.chekun.maintask02.model.specification.TripSpecification;

import java.util.Comparator;
import java.util.List;

public class TripsRepositoryArray implements Repository {

    private static TripsRepositoryArray instance = new TripsRepositoryArray();

    public static TripsRepositoryArray getInstance() {
        return instance;
    }

    private TripsRepositoryArray() {
    }
    ////////////////////

    private static Vector tripList = new Vector();

    @Override
    public void add(Trip trip) {
        tripList.add(trip);
    }

    @Override
    public void remove(Trip trip) {
        tripList.remove(trip);
    }


    @Override
    public void remove(int id) {
        tripList.remove(id);
    }

    @Override
    public void clear() {
        tripList.clear();
    }

    @Override
    public int getSize() {
        return tripList.getSize();
    }

    @Override
    public Trip getLastTrip() {
        return tripList.getLastTrip();
    }


    @Override
    public List getTrips() {
        return tripList.getTripsList();
    }

    @Override
    public void update(Trip trip) {
        tripList.update(trip);
    }

    @Override
    public void sort(Comparator comparator) {
        tripList.sort(comparator);
    }


    public Trip[] getTripArray() {
        return tripList.getTripsArray();
    }

    @Override
    public Trip getById(int id) throws WrongArgumentsException {
        return tripList.getById(id);
    }

    @Override
    public List query(TripSpecification specification) {
        return tripList.query(specification);
    }
}
