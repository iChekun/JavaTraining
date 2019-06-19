package by.epam.javatraining.chekun.maintask02.model.reader;

import by.epam.javatraining.chekun.maintask02.model.action.TripCreatorTest;
import by.epam.javatraining.chekun.maintask02.model.configuration.Configuration;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TripInputValidatorTest {

    private static Logger logger = Logger.getLogger(TripCreatorTest.class);
    private TripInputValidator checker = TripInputValidator.getInstance();

    @BeforeClass
    public static void beforeClass() {
        Configuration.getInstance().configuration();
        System.out.println(Arrays.toString(Configuration.countries.toArray()));
        logger.info("TripInputValidatorTest started!");
    }

    @Test
    public void validate_wrongTripType_false() {
        String values = "belarus hotel_Minsk 5 1 5 2019 5700 breakfast plane";
        boolean result = checker.validate(values);

        assertFalse(result);
    }

    @Test
    public void validate_wrongTripType_wrongCost_false() {
        String values = "rest belarus hotel_Minsk 5 1 5 2019 f breakfast plane";
        boolean result = checker.validate(values);

        assertFalse(result);
    }

    @Test
    public void validate_wrongTripType_wrongHotelLevel_false() {
        String values = "rest belarus hotel_Minsk 6 1 5 2019 2000 breakfast plane";
        boolean result = checker.validate(values);

        assertFalse(result);
    }

    @Test
    public void validate_wrongTripType_wrongHotelLevel_letter_false() {
        String values = "rest belarus hotel_Minsk gg 1 5 2019 2000 breakfast plane";
        boolean result = checker.validate(values);

        assertFalse(result);
    }


    @Test
    public void validate_wrongTripType_wrongDay_letter_false() {
        String values = "rest belarus hotel_Minsk 5 h 5 2019 2000 breakfast plane";
        boolean result = checker.validate(values);

        assertFalse(result);
    }

    @Test
    public void validate_wrongTripType_wrongDay_false() {
        String values = "rest belarus hotel_minsk 5 -1 5 2019 5700 breakfast plane";
        boolean result = checker.validate(values);

        assertFalse(result);
    }

    @Test
    public void validate_wrongTripType_wrongMonth_letter_false() {
        String values = "rest belarus hotel_minsk 5 1 h 2019 5700 breakfast plane";
        boolean result = checker.validate(values);

        assertFalse(result);
    }

    @Test
    public void validate_wrongTripType_wrongYear_letter_false() {
        String values = "rest belarus hotel_minsk 5 1 5 j 5700 breakfast plane";
        boolean result = checker.validate(values);

        assertFalse(result);
    }

    @Test
    public void validate_wrongTripType_wrongMonth_false() {
        String values = "rest belarus hotel_minsk 5 1 -5 2019 5700 breakfast plane";
        boolean result = checker.validate(values);

        assertFalse(result);
    }

    @Test
    public void validate_wrongTripType_wrongYear_false() {
        String values = "rest belarus hotel_minsk 5 1 5 2017 5700 breakfast plane";
        boolean result = checker.validate(values);

        assertFalse(result);
    }

    //////
    @Test
    public void isTripTypeCorrect_correct_lower_true() {
        String type = "rest";

        assertTrue(checker.isTripTypeCorrect(type));
    }

    @Test
    public void isTripTypeCorrect_correct_upper_true() {
        String type = "Rest";

        assertTrue(checker.isTripTypeCorrect(type));
    }

    @Test
    public void isTripTypeCorrect_correct2_lower_true() {
        String type = "healing";

        assertTrue(checker.isTripTypeCorrect(type));
    }

    @Test
    public void isTripTypeCorrect_correct_3_upper_true() {
        String type = "healing";

        assertTrue(checker.isTripTypeCorrect(type));
    }


    @Test
    public void isTripTypeCorrect_false() {
        String type = "saf";

        assertFalse(checker.isTripTypeCorrect(type));
    }
    ////////////

    @Test
    public void isCountryCorrect_true() {
        String country = "belarus";

        assertTrue(checker.isCountryCorrect(country));
    }

    @Test
    public void isCountryCorrect_false() {
        String country = "asdf";

        assertFalse(checker.isCountryCorrect(country));
    }

    ////////
    @Test
    public void isHotelNameCorrect_true() {
        String hotelName = "moscow_city";

        assertTrue(checker.isHotelNameCorrect(hotelName));
    }

    @Test
    public void isHotelNameCorrect_False() {
        String hotelName = "asdf";

        assertFalse(checker.isHotelNameCorrect(hotelName));
    }
    ///

    @Test
    public void isHotelLevelCorrect_true() {
        int level = 4;

        assertTrue(checker.isHotelLevelCorrect(level));
    }

    @Test
    public void isHotelLevelCorrect_False() {
        int level = 7;

        assertFalse(checker.isHotelLevelCorrect(level));
    }

    ////
    @Test
    public void isCostCorrect_true() {
        double cost = 525.5;

        assertTrue(checker.isCostCorrect(cost));
    }

    @Test
    public void isCostCorrect_false() {
        double cost = 500;

        assertFalse(checker.isCostCorrect(cost));
    }

    ///
    @Test
    public void isTypeOfFoodCorrect_true() {
        String food = "breakfast";

        assertTrue(checker.isTypeOfFoodCorrect(food));
    }

    @Test
    public void isTypeOfFoodCorrect_false() {
        String food = "vodka";

        assertFalse(checker.isTypeOfFoodCorrect(food));
    }


    ////////
    @Test
    public void isTransportTypeCorrect_true() {
        String transport = "plane";

        assertTrue(checker.isTypeOfTransportCorrect(transport));
    }

    @Test
    public void isTransportTypeCorrect_false() {
        String transport = "moped";

        assertFalse(checker.isTypeOfTransportCorrect(transport));
    }

    ///
    @Test
    public void isDiagnosisCorrect_true() {
        String diagnosis = "cold";

        assertTrue(checker.isDiagnosisCorrect(diagnosis));
    }

    @Test
    public void isDiagnosisCorrect_false() {
        String diagnosis = "";

        assertFalse(checker.isDiagnosisCorrect(diagnosis));
    }
    ////


    /////////
    @AfterClass
    public static void afterClass() {
        logger.info("TripInputValidatorTest finished!");
    }
}