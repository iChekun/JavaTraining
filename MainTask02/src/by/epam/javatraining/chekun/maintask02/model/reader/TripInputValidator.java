package by.epam.javatraining.chekun.maintask02.model.reader;

import by.epam.javatraining.chekun.maintask02.model.date.DateChecker;
import by.epam.javatraining.chekun.maintask02.model.entity.TripTypes;

import java.util.Arrays;

import static by.epam.javatraining.chekun.maintask02.model.configuration.Configure.*;


public class TripInputValidator {

    private static TripInputValidator instance = new TripInputValidator();

    public static TripInputValidator getInstance() {
        return instance;
    }

    private TripInputValidator() {

    }

    ///////////////////

    /**
     * Validates given string by checking is parameters has in list  configuration of system.
     * checks is  string  correct to create a trip with according type
     *
     * @param parameters string to validate
     * @return {@code true} if given string is correct to create a trip with according type
     * {@code false } otherwise.
     */
    public boolean validate(String parameters) {

        String[] values = parameters.split(" ");

        if (values.length >= MINIMUM_COUNT_OF_PARAMETERS && isTripTypeCorrect(values[TRIP_TYPE])) {

            switch (TripTypes.valueOf(values[TRIP_TYPE].toUpperCase())) {
                case REST:
                    return values.length == COUNT_OF_PARAMETERS_FOR_REST_TRIP
                            && isCountryCorrect(values[COUNTRY])
                            && isHotelNameCorrect(values[HOTEL_NAME])
                            && isHotelLevelCorrect(values[HOTEL_LEVEL])
                            && isDateCorrect(values[DATE_DAY], values[DATE_MONTH], values[DATE_YEAR])
                            && isCostCorrect(values[COST])
                            && isTypeOfFoodCorrect(values[TYPE_OF_FOOD])
                            && isTypeOfTransportCorrect(values[TYPE_OF_TRANSPORT]);

                case HEALING:
                    return values.length >= COUNT_OF_PARAMETERS_FOR_HEALING_TRIP
                            && isCountryCorrect(values[COUNTRY])
                            && isHotelNameCorrect(values[HOTEL_NAME])
                            && isHotelLevelCorrect(values[HOTEL_LEVEL])
                            && isDateCorrect(values[DATE_DAY], values[DATE_MONTH], values[DATE_YEAR])
                            && isCostCorrect(values[COST])
                            && isTypeOfFoodCorrect(values[TYPE_OF_FOOD])
                            && isTypeOfTransportCorrect(values[TYPE_OF_TRANSPORT])
                            && isDiagnosisCorrect(values[DIAGNOSIS]);

                case EXCURSION:
                    return values.length == COUNT_OF_PARAMETERS_FOR_EXCURSION_TRIP
                            && isCountryCorrect(values[COUNTRY])
                            && isHotelNameCorrect(values[HOTEL_NAME])
                            && isHotelLevelCorrect(values[HOTEL_LEVEL])
                            && isDateCorrect(values[DATE_DAY], values[DATE_MONTH], values[DATE_YEAR])
                            && isCostCorrect(values[COST])
                            && isTypeOfFoodCorrect(values[TYPE_OF_FOOD])
                            && isTypeOfTransportCorrect(values[TYPE_OF_TRANSPORT]);
            }
        }

        return false;
    }


    public boolean isCountryCorrect(String country) {
        return countries.contains(country.toLowerCase());
    }

    public boolean isHotelNameCorrect(String hotelName) {
        return hotelsNames.contains(hotelName.toLowerCase());
    }

    public boolean isHotelLevelCorrect(String hotelLevel) {

        try {
            int level = Integer.valueOf(hotelLevel);
            return level > MINIMAL_COUNT_OF_STARS_FOR_HOTEL
                    && level <= MAXIMUM_COUNT_OF_STARS_FOR_HOTEL;
        } catch (NumberFormatException ex) {
            return false;
        }
    }


    public boolean isHotelLevelCorrect(int hotelLevel) {
        return hotelLevel > MINIMAL_COUNT_OF_STARS_FOR_HOTEL
                && hotelLevel <= MAXIMUM_COUNT_OF_STARS_FOR_HOTEL;
    }

    public boolean isCostCorrect(String cost) {
        try {
            return Double.valueOf(cost) >= MINIMAL_PRICE;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public boolean isCostCorrect(double cost) {
        return cost >= MINIMAL_PRICE;
    }

    public boolean isTypeOfFoodCorrect(String typeOfFood) {
        return typesOfFood.contains(typeOfFood.toLowerCase());
    }

    public boolean isTypeOfTransportCorrect(String transportType) {
        return transportTypes.contains(transportType.toLowerCase());
    }

    public boolean isDiagnosisCorrect(String diagnosis) {
        return !diagnosis.equals("");
    }

    public boolean isTripTypeCorrect(String value) {
        return Arrays.toString(TripTypes.values()).contains(value.trim().toUpperCase());
    }

    public boolean isDateCorrect(String day, String month, String year) {
        try {
            return DateChecker.getInstance().isDateCorrect(
                    Integer.valueOf(day),
                    Integer.valueOf(month),
                    Integer.valueOf(year));
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
