package by.epam.javatraining.chekun.maintask02.model.action;

import by.epam.javatraining.chekun.maintask02.model.configuration.Configure;
import by.epam.javatraining.chekun.maintask02.model.date.Date;
import by.epam.javatraining.chekun.maintask02.model.entity.RestTrip;
import by.epam.javatraining.chekun.maintask02.model.entity.Trip;
import by.epam.javatraining.chekun.maintask02.model.exception.WrongArgumentsException;
import by.epam.javatraining.chekun.maintask02.model.exception.WrongDateException;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TripCreatorTest {

    private static Logger logger = Logger.getLogger(TripCreatorTest.class);
    private TripCreator creator = TripCreator.getInstance();

    @BeforeClass
    public static void beforeClass() {
        Configure.getInstance().configuration();
        logger.info("TripCreatorTest started!");
    }


    @Test(expected = WrongArgumentsException.class)
    public void create_emptyString_exception() throws WrongArgumentsException, WrongDateException {
        creator.create("");
    }

    @Test(expected = WrongArgumentsException.class)
    public void create_wrongParameters_exception() throws WrongArgumentsException {

        creator.create("belarus minsk 1 2 2019 5");
    }

    @Test
    public void create_correctParameters() throws WrongArgumentsException {

        Trip expectedTrip = new RestTrip(5, "belarus", "hotel_Minsk",
                5, new Date(1, 5, 2019), 5700,
                "breakfast", "plane");

        Trip trip = creator.create("rest belarus hotel_Minsk 5 1 5 2019 5700 breakfast plane");

        Assert.assertEquals(expectedTrip, trip);
    }

    @AfterClass
    public static void afterClass() {
        logger.info("TripCreatorTest finished!");
    }

}