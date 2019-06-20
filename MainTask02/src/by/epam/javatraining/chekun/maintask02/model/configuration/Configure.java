package by.epam.javatraining.chekun.maintask02.model.configuration;

import by.epam.javatraining.chekun.maintask02.model.exception.FileReadingException;
import by.epam.javatraining.chekun.maintask02.model.exception.NoDataFileException;
import by.epam.javatraining.chekun.maintask02.model.reader.TripFileReader;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


/**
 * Class using for configuration the system.
 * Has paths to files which have possible data for trips
 *
 * @author Chekun Ilya
 */
public class Configure implements Configuration {
    private static Configure instance = new Configure();

    public static Configure getInstance() {
        return instance;
    }

    private Configure() {

    }

    ///////////////////////////////////////////////
    private static final Logger logger = Logger.getLogger(TripFileReader.class);

    private ConfigurationFileReader configurationFileReader = ConfigurationFileReader.getInstance();

    ///////////////////////////////////////////////
    public static List<String> countries = new ArrayList<>();
    public static List<String> hotelsNames = new ArrayList<>();
    public static List<String> typesOfFood = new ArrayList<>();
    public static List<String> transportTypes = new ArrayList<>();
    public static double MINIMAL_PRICE = 0;
    ///////////////////////////////////////////////

    /**
     * Method configure system according with parameters from file
     *
     * @return true -> if configuration successfully
     * false -> otherwise
     */
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
