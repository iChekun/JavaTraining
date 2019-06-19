package by.chekun.model.reader;

import by.chekun.model.exception.FileReadingException;
import by.chekun.model.exception.NoVectorFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VectorFileReader {
    private static VectorFileReader INSTANCE = new VectorFileReader();

    public static VectorFileReader getInstance() {
        return INSTANCE;
    }

    private VectorFileReader() {
    }
    ////////////

    public List<String> read(String path) throws NoVectorFileException, FileReadingException {

        VectorInputValidator validator = VectorInputValidator.getInstance();
        try (Stream<String> line = Files.lines(Paths.get(path))) {

            List<String> list = line.filter(validator::validate).collect(Collectors.toList());
            if (list.size() > 0) {
                return list;
            }
        } catch (NullPointerException | IOException ex) {
            throw new NoVectorFileException("Path " + path + " is incorrect");
        }
        throw new FileReadingException("File (" + path + ") has 0 correct lines!");
    }


}
