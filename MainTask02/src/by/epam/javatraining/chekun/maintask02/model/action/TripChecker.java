package by.epam.javatraining.chekun.maintask02.model.action;

import static by.epam.javatraining.chekun.maintask02.model.configuration.Configuration.MINIMUM_COUNT_OF_PARAMETERS;

public class TripChecker {
    private static TripChecker instance = new TripChecker();

    public static TripChecker getInstance() {
        return instance;
    }

    private TripChecker() {
    }
    ////////////

    /**
     * Method checks if the parameters are correct to create a trip.
     * <p>
     * can be add new conditions.
     * </p>
     *
     * @param params {@String} parameters of trip (should be bigger than 10)
     * @return true -> if parameters are correct to create a trip;
     * false -> if parameters are not correct to create a trip.
     */
    public boolean isTrip(String[] params) {
        return params.length >= MINIMUM_COUNT_OF_PARAMETERS;
    }
}
