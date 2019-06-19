package by.epam.javatraining.chekun.maintask02.model.reposizoty;

import by.epam.javatraining.chekun.maintask02.model.entity.Trip;
import by.epam.javatraining.chekun.maintask02.model.exception.WrongArgumentsException;
import by.epam.javatraining.chekun.maintask02.model.specification.TripSpecification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T extends Trip> {


    void add(T t);

    void remove(T t);

    void remove(int id);

    void clear();

    int getSize();

    T getLastTrip();

    void update(T t);

    void sort(Comparator<T> comparator);

    List<T> getTrips();

    T getById(int id) throws WrongArgumentsException;

    List query(TripSpecification specification);
}
