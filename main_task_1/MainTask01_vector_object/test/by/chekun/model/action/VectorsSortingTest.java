package by.chekun.model.action;

import by.chekun.model.entity.Vector;
import by.chekun.model.exception.WrongArgumentsException;
import by.chekun.model.exception.vector.NoSuchElementException;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class VectorsSortingTest {

    private VectorsSorting vectorsSorting = VectorsSorting.getInstance();
    private static final Logger LOGGER = Logger.getLogger(VectorLogicTest.class);
    private static final double DELTA = 0.01;


    @BeforeClass
    public static void beforeClass() {
        LOGGER.info("VectorsSortingTest started!");
    }

    @Test
    public void bubbleSortTest_correctParameters_true() throws WrongArgumentsException, NoSuchFieldError, NoSuchElementException {
        Vector vector = new Vector(5, 1, 0, -3, 95, 0.25, 75, 4);

        double[] expectedArray = new double[]{-3, 0, 0.25, 1, 4, 5, 75, 95};

        vectorsSorting.bubbleSort(vector);

        assertArrayEquals(expectedArray, vector.getVector(), DELTA);
    }

    @Test
    public void bubbleSortTest_correctParameters2_true() throws WrongArgumentsException, NoSuchFieldError, NoSuchElementException {
        Vector vector = new Vector(1);
        double[] expectedArray = new double[]{1};

        vectorsSorting.bubbleSort(vector);

        assertArrayEquals(expectedArray, vector.getVector(), DELTA);
    }

    @Test
    public void bubbleSortTest_correctParameters3_true() throws WrongArgumentsException, NoSuchFieldError, NoSuchElementException {
        Vector vector = new Vector();

        vectorsSorting.bubbleSort(vector);

        assertArrayEquals(vector.getVector(), vector.getVector(), DELTA);
    }


    @Test(expected = WrongArgumentsException.class)
    public void bubbleSortTest_correctParameters4_exception() throws WrongArgumentsException, NoSuchElementException {
        Vector vector = null;

        vectorsSorting.bubbleSort(vector);

    }

    /////
    @Test
    public void shakerSortTest_correctParameters_true() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = new Vector(5, 1, 0, -3, 95, 0.25, 75, 4);

        double[] expectedArray = new double[]{-3, 0, 0.25, 1, 4, 5, 75, 95};

        vectorsSorting.shakerSort(vector);

        assertArrayEquals(expectedArray, vector.getVector(), DELTA);
    }

    @Test
    public void shakerSortTest_correctParameters2_true() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = new Vector(1);

        double[] expectedArray = new double[]{1};

        vectorsSorting.shakerSort(vector);

        assertArrayEquals(expectedArray, vector.getVector(), DELTA);
    }

    @Test
    public void shakerSortTest_correctParameters3_true() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = new Vector();

        vectorsSorting.shakerSort(vector);

        assertArrayEquals(vector.getVector(), vector.getVector(), DELTA);
    }


    @Test(expected = WrongArgumentsException.class)
    public void shakerSortTest_correctParameters4_exception() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = null;

        vectorsSorting.shakerSort(vector);
    }

    ////
    @Test
    public void insertionSortTest_correctParameters_true() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = new Vector(5, 1, 0, -3, 95, 0.25, 75, 4);

        double[] expectedArray = new double[]{-3, 0, 0.25, 1, 4, 5, 75, 95};

        vectorsSorting.insertionSort(vector);

        assertArrayEquals(expectedArray, vector.getVector(), DELTA);
    }

    @Test
    public void insertionSortTest_correctParameters2_true() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = new Vector(1);

        double[] expectedArray = new double[]{1};

        vectorsSorting.insertionSort(vector);

        assertArrayEquals(expectedArray, vector.getVector(), DELTA);
    }

    @Test
    public void insertionSortTest_correctParameters3_true() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = new Vector();

        vectorsSorting.insertionSort(vector);

        assertArrayEquals(vector.getVector(), vector.getVector(), DELTA);
    }


    @Test(expected = WrongArgumentsException.class)
    public void insertionSortTest_correctParameters4_exception() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = null;

        vectorsSorting.insertionSort(vector);
    }

    ////
    @Test
    public void selectionSortTest_correctParameters_true() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = new Vector(5, 1, 0, -3, 95, 0.25, 75, 4);

        double[] expectedArray = new double[]{-3, 0, 0.25, 1, 4, 5, 75, 95};

        vectorsSorting.selectionSort(vector);

        assertArrayEquals(expectedArray, vector.getVector(), DELTA);
    }

    @Test
    public void selectionSortTest_correctParameters2_true() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = new Vector(1);

        double[] expectedArray = new double[]{1};

        vectorsSorting.selectionSort(vector);

        assertArrayEquals(expectedArray, vector.getVector(), DELTA);
    }

    @Test
    public void selectionSortTest_correctParameters3_true() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = new Vector();

        vectorsSorting.selectionSort(vector);

        assertArrayEquals(vector.getVector(), vector.getVector(), DELTA);
    }


    @Test(expected = WrongArgumentsException.class)
    public void selectionSortTest_correctParameters4_exception() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = null;

        vectorsSorting.selectionSort(vector);
    }

    ////

    @Test
    public void sortMerge_correctParameters_true() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = new Vector(5, 1, 0, -3, 95, 0.25, 75, 4);

        double[] expectedArray = new double[]{-3, 0, 0.25, 1, 4, 5, 75, 95};

        vectorsSorting.sortMerge(vector);

        assertArrayEquals(expectedArray, vector.getVector(), DELTA);
    }

    @Test
    public void sortMergeTest_correctParameters2_true() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = new Vector(1);

        double[] expectedArray = new double[]{1};

        vectorsSorting.sortMerge(vector);

        assertArrayEquals(expectedArray, vector.getVector(), DELTA);
    }

    @Test
    public void sortMergeTest_correctParameters3_true() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = new Vector();

        vectorsSorting.sortMerge(vector);

        assertArrayEquals(vector.getVector(), vector.getVector(), DELTA);
    }


    @Test(expected = WrongArgumentsException.class)
    public void sortMergeTest_correctParameters4_exception() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = null;

        vectorsSorting.sortMerge(vector);
    }

    ////
    @Test
    public void quickSort_correctParameters_true() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = new Vector(5, 1, 0, -3, 95, 0.25, 75, 4);

        double[] expectedArray = new double[]{-3, 0, 0.25, 1, 4, 5, 75, 95};

        vectorsSorting.quickSort(vector);

        assertArrayEquals(expectedArray, vector.getVector(), DELTA);
    }

    @Test
    public void quickSortTest_correctParameters2_true() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = new Vector(1);

        double[] expectedArray = new double[]{1};

        vectorsSorting.quickSort(vector);

        assertArrayEquals(expectedArray, vector.getVector(), DELTA);
    }

    @Test
    public void quickSortTest_correctParameters3_true() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = new Vector();

        vectorsSorting.quickSort(vector);

        assertArrayEquals(vector.getVector(), vector.getVector(), DELTA);
    }


    @Test(expected = WrongArgumentsException.class)
    public void quickSortTest_correctParameters4_exception() throws NoSuchFieldError, NoSuchElementException, WrongArgumentsException {
        Vector vector = null;

        vectorsSorting.quickSort(vector);
    }

    @AfterClass
    public static void afterClass() {
        LOGGER.info("VectorSortingTest finished!");
    }
}