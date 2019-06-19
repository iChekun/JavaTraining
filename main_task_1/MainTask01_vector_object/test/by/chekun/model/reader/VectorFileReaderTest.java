package by.chekun.model.reader;

import by.chekun.model.exception.FileReadingException;
import by.chekun.model.exception.NoVectorFileException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class VectorFileReaderTest {

    private VectorFileReader fileReader = VectorFileReader.getInstance();

    @Test
    public void read_correctValues_true() throws FileReadingException, NoVectorFileException {
        //given
        List<String> expectedResult = Arrays.asList("1,2,3,4,5", "2,4,5,6,7");
        //when
        List<String> testList = fileReader.read("./vector_data/text.txt");
        //then
        assertEquals(expectedResult, testList);
    }

    @Test
    public void read_correctValues_true2() throws FileReadingException, NoVectorFileException {
        //given
        List<String> expectedResult = Arrays.asList("1,2,3,4,5", "2,4,5,");
        //when
        List<String> testList = fileReader.read("./vector_data/text.txt");
        //then
        assertNotEquals(expectedResult, testList);
    }


    @Test(expected = NoVectorFileException.class)
    public void read_correctValues_exception2() throws FileReadingException, NoVectorFileException {
        List<String> testList = fileReader.read("./vector_data/text_2.txt");
    }

    @Test(expected = NoVectorFileException.class)
    public void read_correctValues_exception_3() throws FileReadingException, NoVectorFileException {
        List<String> testList = fileReader.read("./vector_data/text_2.txt");
    }


}