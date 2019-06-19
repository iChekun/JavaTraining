package by.epam.javatraining.chekun.maintask02.model.reader;

import by.epam.javatraining.chekun.maintask02.model.exception.FileReadingException;
import by.epam.javatraining.chekun.maintask02.model.exception.NoDataFileException;

import java.util.List;

public interface TripReader {

    List<String> read(String path) throws FileReadingException, NoDataFileException;
}
