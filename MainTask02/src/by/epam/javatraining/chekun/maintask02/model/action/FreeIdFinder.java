package by.epam.javatraining.chekun.maintask02.model.action;

import by.epam.javatraining.chekun.maintask02.model.entity.Trip;
import by.epam.javatraining.chekun.maintask02.model.reposizoty.TripsRepository;

import java.util.Random;

public class FreeIdFinder {

    public static int find() {

        TripsRepository repository = TripsRepository.getInstance();
        Random random = new Random();
        boolean notFound = true;
        int id = random.nextInt(5005) * 10000;
        while (notFound) {
            notFound = false;
            for (Trip trip : repository.getTrips()) {
                if (trip.getId() == id) {
                    notFound = true;
                }
            }
            id = random.nextInt(5005) * 10000;
        }

        return id;
    }
}
