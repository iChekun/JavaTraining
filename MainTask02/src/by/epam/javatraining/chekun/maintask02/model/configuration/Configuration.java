package by.epam.javatraining.chekun.maintask02.model.configuration;

import by.epam.javatraining.chekun.maintask02.model.exception.FileReadingException;
import by.epam.javatraining.chekun.maintask02.model.exception.NoDataFileException;
import by.epam.javatraining.chekun.maintask02.model.reader.TripFileReader;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**Class using for configuration the system.
 * Has paths to files which have possible data for trips
 *
 * @author  Chekun Ilya
 */
public class Configuration {
    private static Configuration instance = new Configuration();

    public static Configuration getInstance() {
        return instance;
    }

    private Configuration() {

    }

    ///////////////////////////////////////////////
    private static final Logger logger = Logger.getLogger(TripFileReader.class);

    private ConfigurationFileReader configurationFileReader = ConfigurationFileReader.getInstance();

    private static final String COUNTRIES_PATH = "./test_data/testConfigurationData/countries.txt";
    private static final String HOTELS_NAMES_PATH = "./test_data/testConfigurationData/hotelsNames.txt";
    private static final String COST_PATH = "./test_data/testConfigurationData/cost.txt";
    private static final String TYPES_OF_FOOD_PATH = "./test_data/testConfigurationData/typesOfFood.txt";
    private static final String TRANSPORT_TYPES_PATH = "./test_data/testConfigurationData/transportTypes.txt";

    ///////////////////////////////////////////////
    public static double MINIMAL_PRICE = 0;
    public static List<String> countries = new ArrayList<>();
    public static List<String> hotelsNames = new ArrayList<>();
    public static List<String> typesOfFood = new ArrayList<>();
    public static List<String> transportTypes = new ArrayList<>();
    public static int MINIMAL_COUNT_OF_STARS_FOR_HOTEL = 1;
    public static int MAXIMUM_COUNT_OF_STARS_FOR_HOTEL = 5;
    ///////////////////////////////////////////////
    public static final int TRIP_TYPE = 0;
    public static final int COUNTRY = 1;
    public static final int HOTEL_NAME = 2;
    public static final int HOTEL_LEVEL = 3;
    public static final int DATE_DAY = 4;
    public static final int DATE_MONTH = 5;
    public static final int DATE_YEAR = 6;
    public static final int COST = 7;
    public static final int TYPE_OF_FOOD = 8;
    public static final int TYPE_OF_TRANSPORT = 9;
    public static final int DIAGNOSIS = 10;
    public static final int PLACES_FOR_EXCURSION = 10;

    public static final int MINIMUM_COUNT_OF_PARAMETERS = 10;
    public static int COUNT_OF_PARAMETERS_FOR_REST_TRIP = 10;
    public static int COUNT_OF_PARAMETERS_FOR_HEALING_TRIP = 11;
    public static int COUNT_OF_PARAMETERS_FOR_EXCURSION_TRIP = 11;
    ///////////////////////////////////////////////
    public boolean configuration() {
        try {
            countries = configurationFileReader.readConfiguration(COUNTRIES_PATH);
            hotelsNames = configurationFileReader.readConfiguration(HOTELS_NAMES_PATH);
            MINIMAL_PRICE = configurationFileReader.readMinPrice(COST_PATH);
            typesOfFood = configurationFileReader.readConfiguration(TYPES_OF_FOOD_PATH);
            transportTypes = configurationFileReader.readConfiguration(TRANSPORT_TYPES_PATH);
            return true;
        } catch (FileReadingException | NoDataFileException e) {
            logger.fatal(e.getMessage());
        }
        return false;
    }
}
