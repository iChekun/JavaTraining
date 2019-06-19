package by.epam.javatraining.chekun.maintask02.model.configuration;

import by.epam.javatraining.chekun.maintask02.model.exception.FileReadingException;
import by.epam.javatraining.chekun.maintask02.model.exception.NoDataFileException;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConfigurationFileReaderTest {


    private static Logger logger = Logger.getLogger(ConfigurationFileReaderTest.class);
    private ConfigurationReader fileReader = ConfigurationFileReader.getInstance();


    @BeforeClass
    public static void beforeClass() {
        logger.info("ConfigurationFileReaderTest started!");
    }


    @Test(expected = NoDataFileException.class)
    public void readConfiguration_nullString_exception() throws FileReadingException, NoDataFileException {
        fileReader.readConfiguration(null);
    }

    @Test(expected = NoDataFileException.class)
    public void readConfiguration_emptyString_exception() throws FileReadingException, NoDataFileException {
        fileReader.readConfiguration("");
    }


    @Test(expected = NoDataFileException.class)
    public void readConfiguration_noSuchFile_exception() throws FileReadingException, NoDataFileException {
        fileReader.readConfiguration("./test_data/testConfigurationData/conf.txt");
    }

    @Test
    public void readConfiguration_correctValues_true() throws FileReadingException, NoDataFileException {
        List<String> expectedResult = Arrays.asList("belarus",
                "russian", "italy", "greece", "egypt", "turkey", "britain");
        List<String> countries = fileReader.readConfiguration("./test_data/testConfigurationData/countries.txt");
        assertEquals(expectedResult, countries);

    }
    ///////////////////

    @Test(expected = NoDataFileException.class)
    public void readMinPrice_nullString_exception() throws FileReadingException, NoDataFileException {
        fileReader.readMinPrice(null);
    }


    @Test(expected = NoDataFileException.class)
    public void readMinPrice_emptyString_exception() throws FileReadingException, NoDataFileException {
        fileReader.readMinPrice("");
    }

    @Test(expected = NoDataFileException.class)
    public void readMinPrice_noSuchFile_exception() throws FileReadingException, NoDataFileException {
        fileReader.readConfiguration("./test_data/testConfigurationData/cost1.txt");
    }


    @Test
    public void readMinPrice_correctValues_true() throws FileReadingException, NoDataFileException {
        double expected = 525.5;
        double cost = fileReader.readMinPrice("./test_data/testConfigurationData/cost.txt");
        final double DELTA = 0.01;

        assertEquals(expected, cost, DELTA);

    }

    ////////

    @AfterClass
    public static void afterClass() {
        logger.info("ConfigurationFileReaderTest finished!!");
    }
}