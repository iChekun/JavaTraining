package by.epam.javatraining.chekun.maintask02.model.action;

import by.epam.javatraining.chekun.maintask02.model.entity.Trip;
import by.epam.javatraining.chekun.maintask02.model.exception.WrongArgumentsException;
import by.epam.javatraining.chekun.maintask02.model.factory.TripFactory;
import by.epam.javatraining.chekun.maintask02.model.reader.TripInputValidator;
import org.apache.log4j.Logger;

import static by.epam.javatraining.chekun.maintask02.model.configuration.Configuration.MINIMUM_COUNT_OF_PARAMETERS;

public class TripCreator {

    private static TripCreator instance = new TripCreator();

    public static TripCreator getInstance() {
        return instance;
    }

    private TripCreator() {
    }

    ////////////////////
    private TripInputValidator validator = TripInputValidator.getInstance();
    private static final Logger logger = Logger.getLogger(TripCreator.class);

    /**
     *Creates and returns a Trip in according with parameters given
     * in a string (type country hotelName hotelLevel day month year typeOfFood typeOfTransport
     * if type = healing  will has diagnosis
     * if type = excursion will has countries
     * @param parameters
     * @return trip with given parameters
     * @throws WrongArgumentsException if parameters are invalid
     */
    public Trip create(String parameters) throws WrongArgumentsException {

        String[] values = parameters.split(" ");

        if (values.length >= MINIMUM_COUNT_OF_PARAMETERS && validator.validate(parameters)) {

            TripFactory factory = TripFactory.getInstance();

            try {
                int id = FreeIdFinder.find();
                Trip trip = factory.createTrip(id, values);
                return trip;
            } catch (WrongArgumentsException e) {
                logger.error(e.getMessage());
                throw e;
            }
        } else {
            logger.error("Method create() received wrong trip type: " + parameters);
            throw new WrongArgumentsException("Method create() received wrong trip type: " + parameters);
        }
    }


}
