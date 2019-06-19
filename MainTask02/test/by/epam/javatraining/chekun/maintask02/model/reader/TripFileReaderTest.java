package by.epam.javatraining.chekun.maintask02.model.reader;

import by.epam.javatraining.chekun.maintask02.model.configuration.Configuration;
import by.epam.javatraining.chekun.maintask02.model.configuration.ConfigurationFileReaderTest;
import by.epam.javatraining.chekun.maintask02.model.exception.FileReadingException;
import by.epam.javatraining.chekun.maintask02.model.exception.NoDataFileException;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TripFileReaderTest {

    private static Logger logger = Logger.getLogger(ConfigurationFileReaderTest.class);
    private TripReader fileReader = TripFileReader.getInstance();


    @BeforeClass
    public static void beforeClass() {
        Configuration.getInstance().configuration();
        logger.info("TripFileReaderTest started!");
    }

    @Test(expected = NoDataFileException.class)
    public void readConfiguration_nullString_exception() throws FileReadingException, NoDataFileException {
        fileReader.read(null);
    }

    @Test(expected = NoDataFileException.class)
    public void readConfiguration_emptyString_exception() throws FileReadingException, NoDataFileException {
        fileReader.read("");
    }


    @Test(expected = FileReadingException.class)
    public void readConfiguration_noSuchFile_exception() throws FileReadingException, NoDataFileException {
        fileReader.read("./test_data/testInputData/badTripsData.txt");
    }

    @Test
    public void readConfiguration_correctValues_true() throws FileReadingException, NoDataFileException {
        List<String> expectedResult = new ArrayList<>(Arrays.asList(
                "rest belarus hotel_Minsk 4 1 7 2019 5400 all_in train",
                "rest egypt vega 3 25 5 2019 5900 breakfast_lunch_dinner plane",
                "healing greece president_hotel 4 22 10 2019 5900 all_in ship cold",
                "rest russian moscow_city 5 5 5 2021 5200 breakfast_dinner bus",
                "excursion belarus vega 4 11 2 2019 8000 without plane stela,medvejino,dvoresSporta",
                "excursion russian moscow_city 3 24 8 2019 8500 breakfast plane stela,ledovii_dvores,mir,silver_screen"));

        List<String> countries = fileReader.read("./test_data/testInputData/correctTrips.txt");

        assertEquals(expectedResult, countries);
    }

    @Test
    public void readConfiguration_halfCorrectValues_true() throws FileReadingException, NoDataFileException {
        List<String> expectedResult = new ArrayList<>(Arrays.asList(
                "rest belarus hotel_Minsk 4 1 7 2019 5400 breakfast train",
                "rest egypt vega 3 25 5 2019 5900 breakfast_lunch_dinner plane",
                "healing greece hotel_europe 4 20 10 2020 5900 all_in ship cold",
                "rest russian moscow_city 5 5 5 2021 5200 breakfast_dinner bus"

        ));

        List<String> countries = fileReader.read("./test_data/testInputData/halfCorrectTrips.txt");

        assertEquals(expectedResult, countries);

    }
    ///////////////////


    @AfterClass
    public static void afterClass() {
        logger.info("TripFileReaderTest finished!!");
    }

}