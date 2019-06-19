package by.epam.javatraining.chekun.maintask02.model.factory;

import by.epam.javatraining.chekun.maintask02.model.action.TripChecker;
import by.epam.javatraining.chekun.maintask02.model.configuration.ConfigurationFileReader;
import by.epam.javatraining.chekun.maintask02.model.date.Date;
import by.epam.javatraining.chekun.maintask02.model.entity.*;
import by.epam.javatraining.chekun.maintask02.model.exception.WrongArgumentsException;
import org.apache.log4j.Logger;

import java.util.Arrays;

import static by.epam.javatraining.chekun.maintask02.model.configuration.Configuration.*;


public class TripFactory {
    private static TripFactory instance = new TripFactory();

    public static TripFactory getInstance() {
        return instance;
    }

    private TripFactory() {
    }

    private static final Logger logger = Logger.getLogger(ConfigurationFileReader.class);
    private TripChecker checker = TripChecker.getInstance();
    ///////////////////////

    /**
     * Creates and returns trips in accordance with given parameters.
     * Can create any object of any class extending class Trip
     *
     * @param id     unique id of trip that will be created
     * @param values trip parameters
     * @return trip with given parameters
     * @throws WrongArgumentsException if given parameters don`t match to any trips
     */
    public Trip createTrip(int id, String[] values) throws WrongArgumentsException {

        if (checker.isTrip(values)) {

            switch (TripTypes.valueOf(values[TRIP_TYPE].toUpperCase())) {

                case REST:
                    return new RestTrip(id, values[COUNTRY], values[HOTEL_NAME],
                            Integer.valueOf(values[HOTEL_LEVEL]),
                            new Date(Integer.valueOf(values[DATE_DAY]),
                                    Integer.valueOf(values[DATE_MONTH]),
                                    Integer.valueOf(values[DATE_YEAR])),
                            Double.valueOf(values[COST]), values[TYPE_OF_FOOD], values[TYPE_OF_TRANSPORT]);

                case HEALING:
                    return new HealingTrip(id, values[COUNTRY], values[HOTEL_NAME],
                            Integer.valueOf(values[HOTEL_LEVEL]),
                            new Date(Integer.valueOf(values[DATE_DAY]),
                                    Integer.valueOf(values[DATE_MONTH]),
                                    Integer.valueOf(values[DATE_YEAR])),
                            Double.valueOf(values[COST]), values[TYPE_OF_FOOD], values[TYPE_OF_TRANSPORT],
                            values[DIAGNOSIS]);
                case EXCURSION:
                    return new ExcursionTrip(id, values[COUNTRY], values[HOTEL_NAME],
                            Integer.valueOf(values[HOTEL_LEVEL]),
                            new Date(Integer.valueOf(values[DATE_DAY]),
                                    Integer.valueOf(values[DATE_MONTH]),
                                    Integer.valueOf(values[DATE_YEAR])),
                            Double.valueOf(values[COST]), values[TYPE_OF_FOOD], values[TYPE_OF_TRANSPORT],
                            values[PLACES_FOR_EXCURSION]);
            }
        }
        logger.error("Method from TripFactory createTrip() received wrong parameters: " + Arrays.toString(values));
        throw new WrongArgumentsException("Method createTrip() received wrong parameters: " + Arrays.toString(values));
    }
}