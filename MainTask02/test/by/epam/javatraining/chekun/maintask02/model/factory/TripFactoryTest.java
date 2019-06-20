package by.epam.javatraining.chekun.maintask02.model.factory;

import by.epam.javatraining.chekun.maintask02.model.configuration.Configure;
import by.epam.javatraining.chekun.maintask02.model.date.Date;
import by.epam.javatraining.chekun.maintask02.model.entity.ExcursionTrip;
import by.epam.javatraining.chekun.maintask02.model.entity.HealingTrip;
import by.epam.javatraining.chekun.maintask02.model.entity.RestTrip;
import by.epam.javatraining.chekun.maintask02.model.entity.Trip;
import by.epam.javatraining.chekun.maintask02.model.exception.WrongArgumentsException;
import by.epam.javatraining.chekun.maintask02.model.exception.WrongDateException;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TripFactoryTest {

    private static Logger logger = Logger.getLogger(TripFactoryTest.class);
    private TripFactory factory = TripFactory.getInstance();

    @BeforeClass
    public static void beforeClass() {
        Configure.getInstance().configuration();
        logger.info("TripFactoryTest starter!");
    }

    /////////
    @Test(expected = WrongArgumentsException.class)
    public void createTrip_wrongParameters_exception() throws WrongArgumentsException, WrongDateException {
        String[] values = {"5"};
        factory.createTrip(52,  values);
    }

    @Test(expected = WrongArgumentsException.class)
    public void createTrip_wrongParameters_exception_2() throws WrongArgumentsException, WrongDateException {
        String[] values = {"belarus vega 5 1 2 2019 breakfast plane"};
        factory.createTrip(52,  values);
    }

    @Test(expected = WrongArgumentsException.class)
    public void createTripRest_correctParameters_true() throws WrongArgumentsException, WrongDateException {
        String[] values = {"rest belarus vega 5 1 2 2019 breakfast plane"};
        Trip expectedTrip = new RestTrip(52, "belarus", "vega", 5,
                new Date(1, 2, 2019), 2, "breakfast", "plane");

        Trip trip = factory.createTrip(52,  values);

        assertEquals(expectedTrip, trip);
    }


    @Test(expected = WrongArgumentsException.class)
    public void createTripHealing_correctParameters_true() throws WrongArgumentsException, WrongDateException {
        String[] values = {"healing belarus vega 5 1 2 2019 breakfast plane cold"};
        Trip expectedTrip = new HealingTrip(52, "belarus", "vega", 5,
                new Date(1, 2, 2019), 2, "breakfast", "plane" , "cold");

        Trip trip = factory.createTrip(52,  values);

        assertEquals(expectedTrip, trip);
    }


    @Test(expected = WrongArgumentsException.class)
    public void createTripHealing_correctParameters_excursion_true() throws WrongArgumentsException, WrongDateException {
        String[] values = {"excursion belarus vega 5 1 2 2019 breakfast plane stela,medvejino,dvoresSporta"};

        Trip expectedTrip = new ExcursionTrip(52, "belarus", "vega", 5,
                new Date(1, 2, 2019), 2, "breakfast", "plane" , "stela,medvejino,dvoresSporta");

        Trip trip = factory.createTrip(52,  values);

        assertEquals(expectedTrip, trip);
    }

    ////////
    @AfterClass
    public static void afterClass() {
        logger.info("TripFactoryTest finished!!");
    }
}