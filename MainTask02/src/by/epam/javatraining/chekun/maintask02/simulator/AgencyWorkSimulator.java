package by.epam.javatraining.chekun.maintask02.simulator;

import by.epam.javatraining.chekun.maintask02.model.action.TripCreator;
import by.epam.javatraining.chekun.maintask02.model.comparator.TripComparatorByCost;
import by.epam.javatraining.chekun.maintask02.model.comparator.TripComparatorByHotelLevel;
import by.epam.javatraining.chekun.maintask02.model.configuration.Configuration;
import by.epam.javatraining.chekun.maintask02.model.entity.Trip;
import by.epam.javatraining.chekun.maintask02.model.exception.FileReadingException;
import by.epam.javatraining.chekun.maintask02.model.exception.NoDataFileException;
import by.epam.javatraining.chekun.maintask02.model.exception.WrongArgumentsException;
import by.epam.javatraining.chekun.maintask02.model.reader.TripFileReader;
import by.epam.javatraining.chekun.maintask02.model.reader.TripReader;
import by.epam.javatraining.chekun.maintask02.model.reposizoty.Repository;
import by.epam.javatraining.chekun.maintask02.model.reposizoty.TripsRepository;
import by.epam.javatraining.chekun.maintask02.model.specification.*;
import org.apache.log4j.Logger;

import java.util.List;

public class AgencyWorkSimulator implements WorkSimulator {

    private static AgencyWorkSimulator instance = new AgencyWorkSimulator();

    public static AgencyWorkSimulator getInstance() {
        return instance;
    }

    private AgencyWorkSimulator() {
    }
    ///////////////////


    private static final Logger logger = Logger.getLogger(AgencyWorkSimulator.class);

    private Configuration configuration = Configuration.getInstance();
    private TripReader fileReader = TripFileReader.getInstance();
    private TripCreator creator = TripCreator.getInstance();
    private Repository repository = TripsRepository.getInstance();

    /**
     * Simulator of work with tourist trips
     * <p>
     * All information about trips are available in {@see log\work_log_file.log}
     * In some places calling method {@code saveInfo} in which logger write {@code repository} data in file
     * </p>
     *
     * <p>
     * Calls {@code configuration } to configuration a system  with values than can be in trip.
     * Calls {@code read} for reading customer data and get list with trips parameters.
     * Getting {@code list} with parameters.
     * Calls {@code create} for create trip with according parameters in {@code list}
     * Calls {@code add} for adding new trip in {@code repository}
     * Calls {@code sort} for sorting {@code repository}
     * 1. by cost 2. by hotelName
     * Calls {@code add} for adding a new trip
     * Calls {@code getLastTrip} for getting last trip in {@code repository}
     * Calls {@code remove} for removing trip from  {@code repository}
     * Calls {@code update} for updating trip in {@code repository}
     * Calls {@code query} for specify {@code repository} by any parameter:
     * 1. cost 2. country 3. hotelName 4. id
     * Calls {@code clear} for clear {@code repository}
     * </p>
     */
    @Override
    public void simulateWork() {
        if (configuration.configuration()) {
            try {
                List<String> initialValues = fileReader.read("./customer_data/trip_data.txt");
                {
                    initialValues.forEach(s -> {
                        try {
                            Trip trip = creator.create(s);
                            repository.add(trip);
                        } catch (WrongArgumentsException e) {
                            e.printStackTrace();
                        }
                    });
                }
                {
                    logger.info("Save repository");
                    saveInfo();
                }
                logger.info("\n");
                {
                    //sort data
                    repository.sort(new TripComparatorByCost());
                    logger.info("Repository after SORT by cost: ");
                    saveInfo();
                }
                ///
                logger.info("\n");
                {
                    logger.info("Repository after SORT by HotelLevel: ");
                    repository.sort(new TripComparatorByHotelLevel());
                    saveInfo();
                    ///
                }
                logger.info("\n");
                {
                    logger.info("Repository after ADD new trip: ");
                    repository.add(creator.create("healing turkey vega 5 15 11 2019 10000.2 without plane cold "));
                    saveInfo();
                }
                logger.info("\n");
                ///
                {
                    logger.info("Repository after REMOVE one: ");
                    Trip trip = repository.getLastTrip();
                    int idForRemove = trip.getId();
                    repository.remove(idForRemove);
                    saveInfo();
                }
                logger.info("\n");
                ///////
                {
                    logger.info("Repository after UPDATE this: " + repository.getLastTrip());
                    Trip trip = repository.getLastTrip();
                    trip.setCountry("newCountry");
                    repository.update(trip);
                    logger.info("Last trip after UPDATE: " + repository.getLastTrip());
                }
                //////
                logger.info("\n");
                {
                    try {
                        logger.info("Repository after ADD wrongTrip: ");
                        repository.add(creator.create("healing turkey vega 5 15 11 2019 10000.2 without  cold "));
                        saveInfo();
                    } catch (WrongArgumentsException e) {
                        logger.error(e.getMessage());
                    }
                }
                //////
                logger.info("\n");
                {
                    logger.info("Specification by COST 1000 ");
                    double cost = 1000;
                    TripSpecification specification = new TripSpecificationByCost(cost);
                    List<Trip> tripsSpecificationByCost = repository.query(specification);
                    tripsSpecificationByCost.forEach(s -> logger.info(s));
                }
                logger.info("\n");
                ////////////////
                {
                    logger.info("Specification by COUNTRY russian ");
                    String countryName = "russian";
                    TripSpecification specification = new TripSpecificationByCountry(countryName);
                    List<Trip> tripsSpecificationByCountry = repository.query(specification);
                    tripsSpecificationByCountry.forEach(s -> logger.info(s));
                }
                logger.info("\n");
                {
                    logger.info("Specification by HOTEL NAME moscow_city ");
                    String hotelName = "moscow_city";
                    TripSpecification specification = new TripSpecificationByHotelName(hotelName);
                    List<Trip> tripsSpecificationByCountry = repository.query(specification);
                    tripsSpecificationByCountry.forEach(s -> logger.info(s));
                }
                logger.info("\n");
                {
                    logger.info("Specification by ID 5125 ");
                    int id = 5125;
                    TripSpecification specification = new TripSpecificationById(id);
                    List<Trip> tripsSpecificationById = repository.query(specification);
                    if (!tripsSpecificationById.isEmpty()) {
                        tripsSpecificationById.forEach(s -> logger.info(s));
                    } else {
                        logger.info("Repository has no such object with that id ");
                    }
                }
                logger.info("\n");

                //////////
                logger.info("Repository after CLEAR: ");
                repository.clear();
                logger.info("repository size: " + repository.getSize());


                //////////

            } catch (WrongArgumentsException | FileReadingException | NoDataFileException e) {
                logger.error(e.getMessage());
            }
        } else {
            System.exit(-1);
        }
    }

    private void saveInfo() {
        repository.getTrips().forEach(s -> logger.info(s));
    }
}
