package by.epam.javatraining.chekun.maintask02.model.configuration;

import by.epam.javatraining.chekun.maintask02.model.exception.FileReadingException;
import by.epam.javatraining.chekun.maintask02.model.exception.NoDataFileException;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConfigurationFileReader implements ConfigurationReader {
    private static ConfigurationFileReader instance = new ConfigurationFileReader();

    public static ConfigurationFileReader getInstance() {
        return instance;
    }

    private ConfigurationFileReader() {
    }

    private static final Logger logger = Logger.getLogger(ConfigurationFileReader.class);
    ///

    /**
     * Reads a file with configuration data and returns list of lines in them.
     * @param path path to the file with information
     * @return list with lines
     * @throws FileReadingException if {@code path} is invalid
     * @throws NoDataFileException if {@code path} has zero lines
     */
    @Override
    public List<String> readConfiguration(String path) throws FileReadingException, NoDataFileException {
        try (Stream<String> line = Files.lines(Paths.get(path))) {
            List<String> list = line.collect(Collectors.toList());
            if (list.size() > 0) {
                return list;
            }
        } catch (NullPointerException | IOException ex) {
            logger.error("Path (" + path + ") is incorrect.");
            throw new NoDataFileException("Path (" + path + ") is incorrect.", ex);
        }
        logger.error("File (" + path + ") has 0 correct lines");
        throw new FileReadingException("File (" + path + ") has 0 correct lines.");
    }

    /**
     *  Reads min price from file.
     *
     * @param path path to file with data
     * @return min price
     * @throws FileReadingException if {@code path} is invalid
     * @throws NoDataFileException if {@code path} has zero lines
     */
    @Override
    public double readMinPrice(String path) throws FileReadingException, NoDataFileException {
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            try {
                if (scanner.hasNextLine()) {
                    return Double.parseDouble(scanner.nextLine());
                }
            } catch (NumberFormatException ex) {
                logger.error("path(" + path + ") has wrong data: " + ex.getMessage());
                throw new FileReadingException("path(" + path + ") has wrong data. ");
            }
        } catch (FileNotFoundException | NullPointerException e) {
            logger.error("Path (" + path + ") is incorrect.");
            throw new NoDataFileException("Path (" + path + ") is incorrect.");
        }
        return 0;
    }

}
