package by.epam.javatraining.chekun.maintask02.model.reposizoty;

import by.epam.javatraining.chekun.maintask02.model.entity.Trip;
import by.epam.javatraining.chekun.maintask02.model.exception.WrongArgumentsException;
import by.epam.javatraining.chekun.maintask02.model.specification.TripSpecification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Vector {

    private Trip[] vector;
    private int size = 0;
    private int capacity = 10;

    public Vector() {
        vector = new Trip[capacity];
    }

    private Vector(Trip trip) {
        if (trip != null) {
            vector = new Trip[capacity];
            vector[++size] = trip;
        }
    }


    public void add(Trip trip) {
        if (trip != null) {
            if (size + 1 >= capacity) {
                grow(1);
            }
            vector[size++] = trip;

        }
    }

    private void grow(int growUpFor) {
        int newSize = this.capacity + growUpFor;
        this.vector = Arrays.copyOf(this.vector, newSize);
        this.capacity = newSize;
    }

    public void remove(Trip trip) {
        if (size == 0 || trip == null) {
            return;
        }
        int index = findTripIndex(trip);
        if (index >= 0) {
            size--;
            System.arraycopy(vector, index + 1, vector, index, capacity - 1 - index);
        }
    }

    public void remove(int id) {
        for (Trip trip : vector) {
            if (trip.getId() == id) {
                remove(trip);
                break;
            }
        }
    }

    public Trip getById(int id) throws WrongArgumentsException {
        if (id > 0) {
            for (int i = 0; i < size; i++) {
                if (vector[i].getId() == id) {
                    return vector[i];
                }
            }
        }
        throw new WrongArgumentsException("Method getById() received incorrect id: " + id);
    }

    public void clear() {
        vector = null;
        size = 0;
        capacity = 0;
    }

    public void update(Trip trip) {
        if (trip != null) {

            int index = findTripIndex(trip);
            if (index >= 0) {
                vector[index] = trip;
            }
        }
    }


    public int findTripIndex(Trip trip) {
        if (trip != null) {
            for (int i = 0; i < size; i++) {
                if (vector[i].equals(trip)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Trip getLastTrip() {
        if (size > 0) {
            return vector[size - 1];
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public Trip[] getTripsArray() {
        return vector;
    }

    public List<Trip> getTripsList() {
        List<Trip> tripList2 = new ArrayList<>();
        for (Trip i : vector) {
            if (i != null)
                tripList2.add(i);
        }
        return tripList2;
    }

    public void sort(Comparator comparator) {
        getTripsList().sort(comparator);

    }


    public List query(TripSpecification specification) {
        return getTripsList().stream().filter(specification::specified).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        if (size <= 0) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append('[');
        for (int i = 0; i < size; i++) {
            result.append(vector[i]);
            if (i + 1 < size) {
                result.append(',');
            }
        }
        result.append(']');

        return result.toString();
    }
}