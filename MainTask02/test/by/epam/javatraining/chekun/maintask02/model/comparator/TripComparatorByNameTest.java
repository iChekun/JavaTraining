package by.epam.javatraining.chekun.maintask02.model.comparator;

import by.epam.javatraining.chekun.maintask02.model.configuration.Configuration;
import by.epam.javatraining.chekun.maintask02.model.date.Date;
import by.epam.javatraining.chekun.maintask02.model.entity.RestTrip;
import by.epam.javatraining.chekun.maintask02.model.exception.WrongDateException;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TripComparatorByNameTest {

    private TripComparatorByName comparator = new TripComparatorByName();
    private static Logger logger = Logger.getLogger(TripComparatorByNameTest.class);

    @BeforeClass
    public static void beforeClass() {
        Configuration.getInstance().configuration();
        logger.info("TripComparatorByNameTest started!");
    }

    @Test
    public void compare_firstIsLess_negativeNumber() throws WrongDateException {
        RestTrip trip1 = new RestTrip(51234, "belarus", "hotel_Minsk",
                4, new Date(1, 5, 2019), 5200,
                "all_in", "bus");
        RestTrip trip2 = new RestTrip(55599, "russian", "moscow_city",
                5, new Date(1, 5, 2019), 5700,
                "breakfast", "plane");

        boolean result = comparator.compare(trip1, trip2) < 0;

        Assert.assertTrue(result);
    }

    @Test
    public void compare_areEqual_zero() throws WrongDateException {
        RestTrip trip1 = new RestTrip(51234, "belarus", "hotel_Minsk",
                5, new Date(1, 5, 2019), 5700,
                "breakfast", "plane");
        RestTrip trip2 = new RestTrip(51234, "russian", "moscow_city",
                5, new Date(1, 5, 2019), 5700,
                "breakfast", "plane");

        boolean result = comparator.compare(trip1, trip2) == 0;

        Assert.assertTrue(result);
    }

    @Test
    public void compare_firstIsBigger_positiveNumber() throws WrongDateException {
        RestTrip trip1 = new RestTrip(60000, "belarus", "hotel_Minsk",
                5, new Date(1, 5, 2019), 5900,
                "breakfast_dinner", "train");
        RestTrip trip2 = new RestTrip(51234, "russian", "moscow_city",
                4, new Date(1, 5, 2019), 5700,
                "breakfast", "ship");

        boolean result = comparator.compare(trip1, trip2) > 0;

        Assert.assertTrue(result);
    }

    @AfterClass
    public static void afterClass() {
        logger.info("TripComparatorByNameTest finished!");
    }

}