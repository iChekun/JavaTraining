package by.epam.javatraining.chekun.maintask02.model.action;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FreeIdFinderTest {
    private static Logger logger = Logger.getLogger(TripCreatorTest.class);

    @BeforeClass
    public static void beforeClass() {
        logger.info("FreeIdFinderTest started!");
    }
    @Test
    public void find_true() {
        //given
        //when
        int id = FreeIdFinder.find();
        //then
        System.out.println(id);
        assertTrue(id >= 0 && id <= 100_000_000);
    }

    @AfterClass
    public static void afterClass() {
        logger.info("FreeIdFinderTest finished!");
    }
}
