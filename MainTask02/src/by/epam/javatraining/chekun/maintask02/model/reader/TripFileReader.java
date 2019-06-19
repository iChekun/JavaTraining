package by.epam.javatraining.chekun.maintask02.model.reader;

import by.epam.javatraining.chekun.maintask02.model.exception.FileReadingException;
import by.epam.javatraining.chekun.maintask02.model.exception.NoDataFileException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TripFileReader implements TripReader {
    private static TripFileReader instance = new TripFileReader();

    public static TripFileReader getInstance() {
        return instance;
    }

    private TripFileReader() {
    }
    ////////////

    private static final Logger logger = Logger.getLogger(TripFileReader.class);
    private TripInputValidator validator = TripInputValidator.getInstance();


    /**
     * Reads a file with configuration data and returns list of valid lines
     *
     * @param path path to the file with information
     * @return list valid with lines
     * @throws FileReadingException if {@code path} is invalid
     * @throws NoDataFileException  if {@code path} has zero valid lines
     */
    @Override
    public List<String> read(String path) throws FileReadingException, NoDataFileException {

        try (Stream<String> line = Files.lines(Paths.get(path))) {
            List<String> list = line.filter(validator::validate).collect(Collectors.toList());
            if (list.size() > 0) {
                return list;
            }
        } catch (NullPointerException | IOException ex) {
            logger.error("Path (" + path + ") is incorrect.");
            throw new NoDataFileException("Path (" + path + ") is incorrect.", ex);
        }
        logger.error("File (" + path + ") has 0 correct lines.");
        throw new FileReadingException("File (" + path + ") has 0 correct lines.");
    }
}
