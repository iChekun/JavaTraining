package by.epam.javatraining.chekun.maintask02.model.configuration;

public interface Configuration {

    boolean configuration();

    String COUNTRIES_PATH = "./test_data/testConfigurationData/countries.txt";
    String HOTELS_NAMES_PATH = "./test_data/testConfigurationData/hotelsNames.txt";
    String COST_PATH = "./test_data/testConfigurationData/cost.txt";
    String TYPES_OF_FOOD_PATH = "./test_data/testConfigurationData/typesOfFood.txt";
    String TRANSPORT_TYPES_PATH = "./test_data/testConfigurationData/transportTypes.txt";

    ///////////////////////////////////////////////

    int MINIMAL_COUNT_OF_STARS_FOR_HOTEL = 1;
    int MAXIMUM_COUNT_OF_STARS_FOR_HOTEL = 5;
    ///////////////////////////////////////////////
    int TRIP_TYPE = 0;
    int COUNTRY = 1;
    int HOTEL_NAME = 2;
    int HOTEL_LEVEL = 3;
    int DATE_DAY = 4;
    int DATE_MONTH = 5;
    int DATE_YEAR = 6;
    int COST = 7;
    int TYPE_OF_FOOD = 8;
    int TYPE_OF_TRANSPORT = 9;
    int DIAGNOSIS = 10;
    int PLACES_FOR_EXCURSION = 10;

    int MINIMUM_COUNT_OF_PARAMETERS = 10;
    int COUNT_OF_PARAMETERS_FOR_REST_TRIP = 10;
    int COUNT_OF_PARAMETERS_FOR_HEALING_TRIP = 11;
    int COUNT_OF_PARAMETERS_FOR_EXCURSION_TRIP = 11;
}
