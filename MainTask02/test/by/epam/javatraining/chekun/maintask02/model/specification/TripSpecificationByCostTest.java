package by.epam.javatraining.chekun.maintask02.model.specification;

import by.epam.javatraining.chekun.maintask02.model.action.TripCreatorTest;
import by.epam.javatraining.chekun.maintask02.model.date.Date;
import by.epam.javatraining.chekun.maintask02.model.entity.RestTrip;
import by.epam.javatraining.chekun.maintask02.model.entity.Trip;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TripSpecificationByCostTest {

    private static Logger logger = Logger.getLogger(TripCreatorTest.class);

    private TripSpecification specification = new TripSpecificationByCost(5000);

    @BeforeClass
    public static void beforeClass() {
        logger.info("TripSpecificationByCostTest started!");
    }

    @Test
    public void specified_wrongValues_false() {
        //given
        Trip trip = new RestTrip(5, "belarus", "hotel_Minsk",
                5, new Date(1, 5, 2019), 49000,
                "breakfast", "plane");
        //when
        boolean result = specification.specified(trip);
        //then
        assertFalse(result);
    }

    @Test
    public void specified_correctValues_true() {
        //given
        Trip trip = new RestTrip(5, "belarus", "hotel_Minsk",
                5, new Date(1, 5, 2019), 5000,
                "breakfast", "plane");
        //when
        boolean result = specification.specified(trip);
        //then
        assertTrue(result);
    }

    @AfterClass
    public static void afterClass() {
        logger.info("TripSpecificationByCostTest finished!");
    }
}