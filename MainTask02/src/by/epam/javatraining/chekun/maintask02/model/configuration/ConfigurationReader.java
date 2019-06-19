package by.epam.javatraining.chekun.maintask02.model.configuration;

import by.epam.javatraining.chekun.maintask02.model.exception.FileReadingException;
import by.epam.javatraining.chekun.maintask02.model.exception.NoDataFileException;

import java.util.List;

public interface ConfigurationReader {

    List<String> readConfiguration(String path) throws FileReadingException, NoDataFileException;

    double readMinPrice(String path) throws FileReadingException,NoDataFileException;


}
