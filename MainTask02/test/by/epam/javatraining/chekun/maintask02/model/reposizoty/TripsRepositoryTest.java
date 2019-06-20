package by.epam.javatraining.chekun.maintask02.model.reposizoty;

import by.epam.javatraining.chekun.maintask02.model.comparator.*;
import by.epam.javatraining.chekun.maintask02.model.configuration.Configure;
import by.epam.javatraining.chekun.maintask02.model.date.Date;
import by.epam.javatraining.chekun.maintask02.model.entity.HealingTrip;
import by.epam.javatraining.chekun.maintask02.model.entity.RestTrip;
import by.epam.javatraining.chekun.maintask02.model.entity.Trip;
import by.epam.javatraining.chekun.maintask02.model.exception.WrongDateException;
import by.epam.javatraining.chekun.maintask02.model.factory.TripFactoryTest;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TripsRepositoryTest {

    private static Logger logger = Logger.getLogger(TripFactoryTest.class);

    private TripsRepository repository = TripsRepository.getInstance();

    @BeforeClass
    public static void beforeClass() {
        Configure.getInstance().configuration();
        logger.info("TripsRepositoryTest starter!");
    }

    @Before
    public void beforeMethod() throws WrongDateException {
        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new RestTrip(51234, "russian", "moscow_city",
                        3, new Date(5, 5, 2020), 5200,
                        "all_in", "bus"),
                new RestTrip(52000, "belarus", "hotel_Minsk",
                        4, new Date(1, 7, 2019), 5400,
                        "breakfast_dinner", "train"),
                new RestTrip(54000, "egypt", "vega",
                        5, new Date(25, 5, 2019), 5900,
                        "breakfast_lunch_dinner", "plane"),
                new HealingTrip(55000, "greece", "hotel_Europe",
                        5, new Date(25, 5, 2019), 5900,
                        "breakfast", "ship", "cold")
        ));
        repository.setTrips(trips);
    }


    @Test
    public void add_trip_true() throws WrongDateException {
        RestTrip restTrip = new RestTrip(53000, "britain", "hotel_Europe",
                5, new Date(25, 5, 2019), 6000,
                "breakfast", "ship");

        List<Trip> expected = Arrays.asList(
                new RestTrip(51234, "russian", "moscow_city",
                        3, new Date(5, 5, 2020), 5200,
                        "all_in", "bus"),
                new RestTrip(52000, "belarus", "hotel_Minsk",
                        4, new Date(1, 7, 2019), 5400,
                        "breakfast_dinner", "train"),
                new RestTrip(54000, "egypt", "vega",
                        5, new Date(25, 5, 2019), 5900,
                        "breakfast_lunch_dinner", "plane"),
                new HealingTrip(55000, "greece", "hotel_Europe",
                        5, new Date(25, 5, 2019), 5900,
                        "breakfast", "ship", "cold"),
                new RestTrip(53000, "britain", "hotel_Europe",
                        5, new Date(25, 5, 2019), 6000,
                        "breakfast", "ship")
        );

        repository.add(restTrip);

        assertEquals(expected, repository.getTrips());
    }


    @Test
    public void remove_trip_true() throws WrongDateException {
        HealingTrip healingTrip = new HealingTrip(55000, "greece", "hotel_Europe",
                5, new Date(25, 5, 2019), 5900,
                "breakfast", "ship", "cold");

        List<Trip> expected = Arrays.asList(
                new RestTrip(51234, "russian", "moscow_city",
                        3, new Date(5, 5, 2020), 5200,
                        "all_in", "bus"),
                new RestTrip(52000, "belarus", "hotel_Minsk",
                        4, new Date(1, 7, 2019), 5400,
                        "breakfast_dinner", "train"),
                new RestTrip(54000, "egypt", "vega",
                        5, new Date(25, 5, 2019), 5900,
                        "breakfast_lunch_dinner", "plane")
        );

        repository.remove(healingTrip);

        assertEquals(expected, repository.getTrips());
    }


    @Test
    public void sort_comparatorById_true() throws WrongDateException {
        //given
        List<Trip> expected = Arrays.asList(
                new RestTrip(51234, "russian", "moscow_city",
                        3, new Date(5, 5, 2020), 5200,
                        "all_in", "bus"),
                new RestTrip(52000, "belarus", "hotel_Minsk",
                        4, new Date(1, 7, 2019), 5400,
                        "breakfast_dinner", "train"),
                new RestTrip(54000, "egypt", "vega",
                        5, new Date(25, 5, 2019), 5900,
                        "breakfast_lunch_dinner", "plane"),
                new HealingTrip(55000, "greece", "hotel_Europe",
                        5, new Date(25, 5, 2019), 5900,
                        "breakfast", "ship", "cold")
        );
        Comparator<Trip> comparatorById = new TripComparatorByID();
        //when
        repository.sort(comparatorById);
        //
        //then
        assertEquals(expected, repository.getTrips());
    }


    @Test
    public void sort_comparatorByName_true() throws WrongDateException {
        //given
        List<Trip> expected = Arrays.asList(
                new HealingTrip(55000, "greece", "hotel_Europe",
                        5, new Date(25, 5, 2019), 5900,
                        "breakfast", "ship", "cold"),
                new RestTrip(51234, "russian", "moscow_city",
                        3, new Date(5, 5, 2020), 5200,
                        "all_in", "bus"),
                new RestTrip(52000, "belarus", "hotel_Minsk",
                        4, new Date(1, 7, 2019), 5400,
                        "breakfast_dinner", "train"),
                new RestTrip(54000, "egypt", "vega",
                        5, new Date(25, 5, 2019), 5900,
                        "breakfast_lunch_dinner", "plane")

        );
        Comparator<Trip> comparatorByName = new TripComparatorByName();
        //when
        repository.sort(comparatorByName);
        //
        //then
        assertEquals(expected, repository.getTrips());
    }


    @Test
    public void sort_comparatorByCost_true() throws WrongDateException {
        //given
        List<Trip> expected = Arrays.asList(
                new RestTrip(51234, "russian", "moscow_city",
                        3, new Date(5, 5, 2020), 5200,
                        "all_in", "bus"),
                new RestTrip(52000, "belarus", "hotel_Minsk",
                        4, new Date(1, 7, 2019), 5400,
                        "breakfast_dinner", "train"),
                new RestTrip(54000, "egypt", "vega",
                        5, new Date(25, 5, 2019), 5900,
                        "breakfast_lunch_dinner", "plane"),
                new HealingTrip(55000, "greece", "hotel_Europe",
                        5, new Date(25, 5, 2019), 5900,
                        "breakfast", "ship", "cold")
        );
        Comparator<Trip> comparatorByCost = new TripComparatorByCost();
        //when
        repository.sort(comparatorByCost);
        //
        //then
        assertEquals(expected, repository.getTrips());
    }

    @Test
    public void sort_comparatorByCountry_true() throws WrongDateException {
        //given
        List<Trip> expected = Arrays.asList(
                new RestTrip(52000, "belarus", "hotel_Minsk",
                        4, new Date(1, 7, 2019), 5400,
                        "breakfast_dinner", "train"),
                new RestTrip(54000, "egypt", "vega",
                        5, new Date(25, 5, 2019), 5900,
                        "breakfast_lunch_dinner", "plane"),
                new HealingTrip(55000, "greece", "hotel_Europe",
                        5, new Date(25, 5, 2019), 5900,
                        "breakfast", "ship", "cold"),
                new RestTrip(51234, "russian", "moscow_city",
                        3, new Date(5, 5, 2020), 5200,
                        "all_in", "bus")
        );
        Comparator<Trip> comparatorByCountry = new TripComparatorByCountry();
        //when
        repository.sort(comparatorByCountry);
        //
        //then
        assertEquals(expected, repository.getTrips());
    }


    @Test
    public void sort_comparatorByTypeOfFood_true() throws WrongDateException {
        //given
        List<Trip> expected = Arrays.asList(
                new RestTrip(51234, "russian", "moscow_city",
                        3, new Date(5, 5, 2020), 5200,
                        "all_in", "bus"),
                new HealingTrip(55000, "greece", "hotel_Europe",
                        5, new Date(25, 5, 2019), 5900,
                        "breakfast", "ship", "cold"),
                new RestTrip(52000, "belarus", "hotel_Minsk",
                        4, new Date(1, 7, 2019), 5400,
                        "breakfast_dinner", "train"),
                new RestTrip(54000, "egypt", "vega",
                        5, new Date(25, 5, 2019), 5900,
                        "breakfast_lunch_dinner", "plane")
        );
        Comparator<Trip> comparatorByTypeOfFood = new TripComparatorByTypeOfFood();
        //when
        repository.sort(comparatorByTypeOfFood);
        //
        //then
        assertEquals(expected, repository.getTrips());
    }


    @Test
    public void getSize_true() {
        int expectedSize = 4;

        assertEquals(expectedSize, repository.getSize());
    }

    @Test
    public void clear_test_true() {
        int expectedSize = 0;
        repository.clear();

        assertEquals(expectedSize, repository.getSize());
    }

    @Test
    public void update_test_true() {

        List<Trip> expected = Arrays.asList(
                new RestTrip(51234, "russian", "moscow_city",
                        3, new Date(5, 5, 2020), 5200,
                        "all_in", "bus"),
                new RestTrip(52000, "belarus", "hotel_Minsk",
                        4, new Date(1, 7, 2019), 5400,
                        "breakfast_dinner", "train"),
                new RestTrip(54000, "egypt", "vega",
                        5, new Date(25, 5, 2019), 5900,
                        "breakfast_lunch_dinner", "plane"),
                new HealingTrip(55000, "greece", "hotel_Europe",
                        5, new Date(25, 5, 2019), 5900,
                        "breakfast", "ship", "cold"),
                new RestTrip(55555, "egypt", "moscow_city",
                        5, new Date(1, 11, 2020), 10000,
                        "all_in", "plane"
                ));

        //given
        RestTrip restTrip = new RestTrip(55555, "egypt", "moscow_city",
                5, new Date(1, 11, 2020), 10000,
                "all_in", "ship");

        //when
        repository.add(restTrip);
        restTrip.setTypeOfTransport("plane");
        repository.update(restTrip);

        //then
        assertEquals(expected, repository.getTrips());
    }

    @AfterClass
    public static void afterClass() {
        logger.info("TripsRepositoryTest finished!!");
    }

}