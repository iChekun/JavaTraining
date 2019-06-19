package by.epam.javatraining.chekun.maintask02.model.reposizoty;

import by.epam.javatraining.chekun.maintask02.model.entity.Trip;
import by.epam.javatraining.chekun.maintask02.model.exception.WrongArgumentsException;
import by.epam.javatraining.chekun.maintask02.model.specification.TripSpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TripsRepository implements Repository {

    private static TripsRepository instance = new TripsRepository();

    public static TripsRepository getInstance() {
        return instance;
    }

    private TripsRepository() {
    }

    ////////////////////

    private List<Trip> tripList = new ArrayList<>();

    @Override
    public List<Trip> getTrips() {
        return tripList;
    }

    public void setTrips(List<Trip> tripList) {
        this.tripList = tripList;
    }

    @Override
    public void add(Trip trip) {
        if (trip != null) {
            tripList.add(trip);
        }
    }

    @Override
    public void remove(Trip trip) {
        tripList.remove(trip);
    }

    @Override
    public void remove(int id) {
        for (Trip trip : tripList) {
            if (trip.getId() == id) {
                tripList.remove(trip);
                break;
            }
        }
    }

    @Override
    public void clear() {
        tripList.clear();
    }

    @Override
    public int getSize() {
        return tripList.size();
    }

    @Override
    public void update(Trip trip) {
        if (trip != null) {
            tripList.stream().filter(s -> s.getId() == trip.getId()).findFirst().ifPresent(s -> s = trip);
        }
    }


    @Override
    public Trip getById(int id) throws WrongArgumentsException {
        for (Trip trip : tripList) {
            if (trip.getId() == id) {
                return trip;
            }
        }
        throw new WrongArgumentsException("Method getById() received incorrect id: " + id);
    }

    @Override
    public Trip getLastTrip() {
        return tripList.get(getSize() - 1);
    }

    @Override
    public void sort(Comparator comparator) {
        tripList.sort(comparator);
    }

    @Override
    public List query(TripSpecification specification) {
        return tripList.stream().filter(specification::specified).collect(Collectors.toList());
    }
}

