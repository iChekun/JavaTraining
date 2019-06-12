package by.epam.javatraining.chekun.maintask01;


import by.epam.javatraining.chekun.maintask01.model.action.VectorLogic;
import by.epam.javatraining.chekun.maintask01.model.exception.WrongArgumentsException;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class VectorLogicTest {

    private static final Logger LOGGER = Logger.getLogger(VectorLogicTest.class);
    private static final double DELTA = 0.01;

    @BeforeClass
    public static void beforeClass() {
        LOGGER.info("VectorLogicTest started!");
    }

    @Test
    public void findMaxValue_correctParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{1, 5, 0, 9, 25, 2, 99};
        double expected = 99;

        Assert.assertEquals(expected, VectorLogic.findMaxValue(array), DELTA);
    }

    @Test
    public void findMaxValue_correctParameters_2_true() throws WrongArgumentsException {
        double[] array = new double[]{99, 0.25, 0.1, 25, 75, 999.02578, 0};
        double expected = 999.02578;

        assertEquals(expected, VectorLogic.findMaxValue(array), DELTA);
    }

    @Test
    public void findMaxValue_correctParameters_3_true() throws WrongArgumentsException {
        double[] array = new double[]{95.25};
        double expected = 95.25;

        assertEquals(expected, VectorLogic.findMaxValue(array), DELTA);
    }

    @Test(expected = WrongArgumentsException.class)
    public void findMaxValue_wrongParameters1_exception() throws WrongArgumentsException {
        double[] array = new double[]{};

        VectorLogic.findMaxValue(array);
    }

    @Test(expected = WrongArgumentsException.class)
    public void findMaxValue_wrongParameters_exception() throws WrongArgumentsException {
        //given
        double[] array = null;
        //when
        //then
        VectorLogic.findMaxValue(array);
    }

    ///
    @Test
    public void findMinValue_correctParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{1, 5, -2.25, 9, 25, 2, 99};
        double expected = -2.25;

        assertEquals(expected, VectorLogic.findMinValue(array), DELTA);
    }

    @Test
    public void findMinValue_correctParameters_2_true() throws WrongArgumentsException {
        double[] array = new double[]{99, 0.25, 0.1, 25, 75, 999.02578, 0.05};
        double expected = 0.05;

        assertEquals(expected, VectorLogic.findMinValue(array), DELTA);
    }

    @Test(expected = WrongArgumentsException.class)
    public void findMinValue_wrongParameters1_exception() throws WrongArgumentsException {
        double[] array = new double[]{};


        VectorLogic.findMinValue(array);
    }

    @Test(expected = WrongArgumentsException.class)
    public void findMinValue_wrongParameters_exception() throws WrongArgumentsException {
        double[] array = null;

        VectorLogic.findMinValue(array);
    }

    ///
    @Test
    public void calculateArithmeticAverageValue_correctParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{1, 2, 3, 9.02, 25.01, 99, 25, 101};
        double expected = 33.12875;

        assertEquals(expected, VectorLogic.calculateArithmeticAverageValue(array), DELTA);
    }

    @Test
    public void calculateArithmeticAverageValue_correctParameters2_true() throws WrongArgumentsException {
        double[] array = new double[]{1};
        double expected = 1;

        assertEquals(expected, VectorLogic.calculateArithmeticAverageValue(array), DELTA);
    }

    @Test
    public void calculateArithmeticAverageValue_wrongParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{};
        double expected = 0;

        assertEquals(expected, VectorLogic.calculateArithmeticAverageValue(array), DELTA);
    }

    @Test(expected = WrongArgumentsException.class)
    public void calculateArithmeticAverageValue_wrongParameters_exception() throws WrongArgumentsException {
        double[] array = null;

        VectorLogic.calculateArithmeticAverageValue(array);
    }

    ///
    @Test
    public void calculateGeometricAverageValue_correctParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{1, 2, 3, 9.02, 25.01, 99, 25, 101};
        double expected = 11.645845040398333;

        assertEquals(expected, VectorLogic.calculateGeometricAverageValue(array), DELTA);
    }

    @Test
    public void calculateGeometricAverageValue_correctParameters2_true() throws WrongArgumentsException {
        double[] array = new double[]{5};
        double expected = 5;

        assertEquals(expected, VectorLogic.calculateGeometricAverageValue(array), DELTA);
    }

    @Test
    public void calculateGeometricAverageValue_correctParameters3_true() throws WrongArgumentsException {
        double[] array = new double[]{5, 7.25};
        double expected = 6.020797289396148;

        assertEquals(expected, VectorLogic.calculateGeometricAverageValue(array), DELTA);
    }

    @Test
    public void calculateGeometricAverageValue_WrongParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{};
        double expected = 0;

        assertEquals(expected, VectorLogic.calculateGeometricAverageValue(array), DELTA);
    }

    @Test(expected = WrongArgumentsException.class)
    public void calculateGeometricAverageValue_WrongParameters_exception() throws WrongArgumentsException {
        double[] array = null;

        VectorLogic.calculateGeometricAverageValue(array);
    }

    ///
    @Test
    public void isArraySorted_correctParameters_true() {
        double[] array = new double[]{1, 2, 3, 4, 5, 6, 7, 10, 12};

        assertTrue(VectorLogic.isArraySorted(array));
    }

    @Test
    public void isArraySorted_correctParameters2_true() {
        double[] array = new double[]{1, 2};

        assertTrue(VectorLogic.isArraySorted(array));
    }

    @Test
    public void isArraySorted_correctParameters3_false() {
        double[] array = new double[]{1, 2, 15, 22, 3, 4, 5, 6, 7, 10, 12};

        assertFalse(VectorLogic.isArraySorted(array));
    }

    @Test
    public void isArraySorted_correctParameters4_true() {
        double[] array = new double[]{5, 4, 3, 2, 1, 0};

        assertTrue(VectorLogic.isArraySorted(array));
    }


    @Test
    public void isArraySorted_badParameters_false() {
        double[] array = new double[]{};

        assertFalse(VectorLogic.isArraySorted(array));
    }

    @Test
    public void isArraySorted_badParameters2_false() {
        double[] array = null;

        assertFalse(VectorLogic.isArraySorted(array));
    }

    ///
    @Test
    public void isArraySortedByAscending_correctParameters_true() {
        double[] array = new double[]{1, 2, 3, 4, 5, 6, 7, 10, 12};

        assertTrue(VectorLogic.isArraySortedByAscending(array));
    }

    @Test
    public void isArraySortedByAscending_correctParameters2_true() {
        double[] array = new double[]{1, 2};

        assertTrue(VectorLogic.isArraySortedByAscending(array));
    }

    @Test
    public void isArraySortedByAscending_badParameters_false() {
        double[] array = new double[]{};

        assertFalse(VectorLogic.isArraySortedByAscending(array));
    }

    @Test
    public void isArraySortedByAscending_badParameters2_false() {
        double[] array = null;

        assertFalse(VectorLogic.isArraySortedByAscending(array));
    }


    ///
    @Test
    public void findLocalMinPosition_correctParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{9, 8, 2, 1, 2, 5, 10};
        int expectedIndex = 3;

        assertEquals(expectedIndex, VectorLogic.findLocalMinPosition(array));
    }

    @Test
    public void findLocalMinPosition_correctParameters2_true() throws WrongArgumentsException {
        double[] array = new double[]{9, 8, 2, 3, 2, 5, 10};
        int expectedIndex = 2;

        assertEquals(expectedIndex, VectorLogic.findLocalMinPosition(array));
    }

    @Test
    public void findLocalMinPosition_correctParameters3_true() throws WrongArgumentsException {
        double[] array = new double[]{2, 2, 2, 2, 2, 2, 2, 2};

        assertEquals(VectorLogic.NO_LOCAL_MIN_OR_MAX_VALUE, VectorLogic.findLocalMinPosition(array));
    }

    @Test
    public void findLocalMinPosition_correctParameters4_true() throws WrongArgumentsException {
        double[] array = new double[]{5};

        assertEquals(VectorLogic.FIRST_POSITION_ARRAY, VectorLogic.findLocalMinPosition(array));
    }


    @Test(expected = WrongArgumentsException.class)
    public void findLocalMinPosition_wrongParameters1_exception() throws WrongArgumentsException {
        double[] array = new double[]{};

        VectorLogic.findLocalMinPosition(array);
    }

    @Test(expected = WrongArgumentsException.class)
    public void findLocalMinPosition_wrongParameters2_exception() throws WrongArgumentsException {
        double[] array = null;

        VectorLogic.findLocalMinPosition(array);
    }

    ///
    @Test
    public void findLocalMaxPosition() {
    }

    @Test
    public void findLocalMaxPosition_correctParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{8, 8, 2, 15, 2, 5, 10};
        int expectedIndex = 3;

        assertEquals(expectedIndex, VectorLogic.findLocalMaxPosition(array));
    }

    @Test
    public void findLocalMaxPosition_correctParameters2_true() throws WrongArgumentsException {
        double[] array = new double[]{7, 7, 7, 6, 7, 10, 5, 9};
        int expectedIndex = 5;

        assertEquals(expectedIndex, VectorLogic.findLocalMaxPosition(array));
    }

    @Test
    public void findLocalMaxPosition_correctParameters3_true() throws WrongArgumentsException {
        double[] array = new double[]{2, 2, 2, 2, 2, 2, 2, 2};

        assertEquals(VectorLogic.NO_LOCAL_MIN_OR_MAX_VALUE, VectorLogic.findLocalMaxPosition(array));
    }

    @Test
    public void findLocalMaxPosition_correctParameters4_true() throws WrongArgumentsException {
        double[] array = new double[]{8, 8, 2, 1, 2, 5, 10};

        assertEquals(VectorLogic.NO_LOCAL_MIN_OR_MAX_VALUE, VectorLogic.findLocalMaxPosition(array));
    }

    @Test
    public void findLocalMaxPosition_correctParameters5_true() throws WrongArgumentsException {
        double[] array = new double[]{102.25};

        assertEquals(VectorLogic.FIRST_POSITION_ARRAY, VectorLogic.findLocalMaxPosition(array));
    }


    @Test(expected = WrongArgumentsException.class)
    public void findLocalMaxPosition_wrongParameters_exception() throws WrongArgumentsException {
        double[] array = new double[0];

        VectorLogic.findLocalMaxPosition(array);
    }

    @Test(expected = WrongArgumentsException.class)
    public void findLocalMaxPosition_wrongParameters2_exception() throws WrongArgumentsException {
        double[] array = null;

        VectorLogic.findLocalMaxPosition(array);
    }

    ///
    @Test
    public void findValuePositionLinearSearch_correctParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{1, 7, 9, 0.25, 2, 109};
        double valueToSearch = 2;

        int expectedPosition = 4;

        assertEquals(expectedPosition, VectorLogic.findValuePositionLinearSearch(array, valueToSearch));
    }

    @Test
    public void findValuePositionLinearSearch_correctParameters2_true() throws WrongArgumentsException {
        double[] array = new double[]{1, 2, 9, 0.25, 2, 109, 502.2, 25.25, 0.6};
        double valueToSearch = 502.2;

        int expectedPosition = 6;

        assertEquals(expectedPosition, VectorLogic.findValuePositionLinearSearch(array, valueToSearch));
    }


    @Test
    public void findValuePositionLinearSearch_correctParameters3_true() throws WrongArgumentsException {
        double[] array = new double[]{1, 2, 9, 0.25, 2, 109, 502.2, 25.25, 0.6};
        double valueToSearch = 9999;

        assertEquals(VectorLogic.NO_SUCH_ELEMENT_IN_ARRAY, VectorLogic.findValuePositionLinearSearch(array, valueToSearch));
    }


    @Test
    public void findValuePositionLinearSearch_badParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{};
        double valueToSearch = 25;

        assertEquals(VectorLogic.NO_SUCH_ELEMENT_IN_ARRAY, VectorLogic.findValuePositionLinearSearch(array, valueToSearch));
    }


    @Test(expected = WrongArgumentsException.class)
    public void findValuePositionLinearSearch_badParameters2_exception() throws WrongArgumentsException {
        double[] array = null;
        double valueToSearch = 25;

        VectorLogic.findValuePositionLinearSearch(array, valueToSearch);
    }

    ///
    @Test
    public void findValuePositionBinarySearch_correctParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{1, 2, 2.2, 7.2, 55, 105, 255, 905};
        double valueToSearch = 2.2;
        int expectedPosition = 2;

        assertEquals(expectedPosition, VectorLogic.findValuePositionBinarySearch(array, valueToSearch));
    }

    @Test
    public void findValuePositionBinarySearch_correctParameters2_true() throws WrongArgumentsException {
        double[] array = new double[]{1, 2, 2.2, 7.2, 55, 105, 255.25, 445, 605, 905};
        double valueToSearch = 255.25;
        int expectedPosition = 6;

        assertEquals(expectedPosition, VectorLogic.findValuePositionBinarySearch(array, valueToSearch));
    }

    @Test
    public void findValuePositionBinarySearch_correctParameters3_true() throws WrongArgumentsException {
        double[] array = new double[]{1, 2, 2.2, 7.2, 55, 105, 255.25, 445, 605, 905};
        double valueToSearch = 1000;

        assertEquals(VectorLogic.NO_SUCH_ELEMENT_IN_ARRAY, VectorLogic.findValuePositionBinarySearch(array, valueToSearch));
    }

    @Test(expected = WrongArgumentsException.class)
    public void findValuePositionBinarySearch_badParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{1, 5, 7, 2, 2.2, 7.2, 55, 105, 255.25, 445, 605, 905};
        double valueToSearch = 1000;

        VectorLogic.findValuePositionBinarySearch(array, valueToSearch);
    }


    @Test(expected = WrongArgumentsException.class)
    public void findValuePositionBinarySearch_badParameters2_exception() throws WrongArgumentsException {
        double[] array = new double[]{};
        double valueToSearch = 1000;

        VectorLogic.findValuePositionBinarySearch(array, valueToSearch);
    }

    @Test(expected = WrongArgumentsException.class)
    public void findValuePositionBinarySearch_badParameters3_exception() throws WrongArgumentsException {
        double[] array = null;
        double valueToSearch = 1000;

        VectorLogic.findValuePositionBinarySearch(array, valueToSearch);
    }

    ///
    @Test
    public void getReverseArray_correctParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{1, 5, 7, 2, 2.2, 7.2, 55, 105, 255.25, 445, 605, 905};
        double[] expectedArray = new double[]{905.0, 605.0, 445.0, 255.25, 105.0, 55.0, 7.2, 2.2, 2.0, 7.0, 5.0, 1.0};

        VectorLogic.flipArray(array);

        assertArrayEquals(expectedArray, array, DELTA);
    }

    @Test
    public void getReverseArray_correctParameters2_true() throws WrongArgumentsException {
        double[] array = new double[]{1, 5, 8, 2, 1, 7};
        double[] expectedArray = new double[]{7, 1, 2, 8, 5, 1};

        VectorLogic.flipArray(array);

        assertArrayEquals(expectedArray, array, DELTA);
    }

    @Test
    public void getReverseArray_correctParameters3_true() throws WrongArgumentsException {
        double[] array = new double[]{2};
        double[] expectedArray = new double[]{2};

        VectorLogic.flipArray(array);

        assertArrayEquals(expectedArray, array, DELTA);
    }

    @Test(expected = WrongArgumentsException.class)
    public void getReverseArray_wrongParameters_exception() throws WrongArgumentsException {
        //given
        double[] array = null;
        //when
        //then
        VectorLogic.flipArray(array);
    }

    @Test
    public void getReverseArray_wrongParameters2_true() throws WrongArgumentsException {
        //given
        double[] array = new double[0];
        //when
        //then
        VectorLogic.flipArray(array);

        assertArrayEquals(array, array, DELTA);
    }

    /////
    @Test
    public void bubbleSortTest_correctParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{5, 1, 0, -3, 95, 0.25, 75, 4};
        double[] expectedArray = new double[]{-3, 0, 0.25, 1, 4, 5, 75, 95};

        VectorLogic.bubbleSort(array);

        assertArrayEquals(expectedArray, array, DELTA);
    }

    @Test
    public void bubbleSortTest_correctParameters2_true() throws WrongArgumentsException {
        double[] array = new double[]{1};
        double[] expectedArray = new double[]{1};

        VectorLogic.bubbleSort(array);

        assertArrayEquals(expectedArray, array, DELTA);
    }

    @Test
    public void bubbleSortTest_correctParameters3_true() throws WrongArgumentsException {
        double[] array = new double[]{};

        VectorLogic.bubbleSort(array);

        assertArrayEquals(array, array, DELTA);
    }


    @Test(expected = WrongArgumentsException.class)
    public void bubbleSortTest_correctParameters4_exception() throws WrongArgumentsException {
        double[] array = null;

        VectorLogic.bubbleSort(array);
    }

    /////
    @Test
    public void shakerSortTest_correctParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{5, 1, 0, -3, 95, 0.25, 75, 4};
        double[] expectedArray = new double[]{-3, 0, 0.25, 1, 4, 5, 75, 95};

        VectorLogic.shakerSort(array);

        assertArrayEquals(expectedArray, array, DELTA);
    }

    @Test
    public void shakerSortTest_correctParameters2_true() throws WrongArgumentsException {
        double[] array = new double[]{1};
        double[] expectedArray = new double[]{1};

        VectorLogic.shakerSort(array);

        assertArrayEquals(expectedArray, array, DELTA);
    }

    @Test
    public void shakerSortTest_correctParameters3_true() throws WrongArgumentsException {
        double[] array = new double[]{};

        VectorLogic.shakerSort(array);

        assertArrayEquals(array, array, DELTA);
    }


    @Test(expected = WrongArgumentsException.class)
    public void shakerSortTest_correctParameters4_exception() throws WrongArgumentsException {
        double[] array = null;

        VectorLogic.shakerSort(array);
    }

    ////
    @Test
    public void insertionSortTest_correctParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{5, 1, 0, -3, 95, 0.25, 75, 4};
        double[] expectedArray = new double[]{-3, 0, 0.25, 1, 4, 5, 75, 95};

        VectorLogic.insertionSort(array);

        assertArrayEquals(expectedArray, array, DELTA);
    }

    @Test
    public void insertionSortTest_correctParameters2_true() throws WrongArgumentsException {
        double[] array = new double[]{1};
        double[] expectedArray = new double[]{1};

        VectorLogic.insertionSort(array);

        assertArrayEquals(expectedArray, array, DELTA);
    }

    @Test
    public void insertionSortTest_correctParameters3_true() throws WrongArgumentsException {
        double[] array = new double[]{};

        VectorLogic.insertionSort(array);

        assertArrayEquals(array, array, DELTA);
    }


    @Test(expected = WrongArgumentsException.class)
    public void insertionSortTest_correctParameters4_exception() throws WrongArgumentsException {
        double[] array = null;

        VectorLogic.insertionSort(array);
    }

    ////
    @Test
    public void selectionSortTest_correctParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{5, 1, 0, -3, 95, 0.25, 75, 4};
        double[] expectedArray = new double[]{-3, 0, 0.25, 1, 4, 5, 75, 95};

        VectorLogic.selectionSort(array);

        assertArrayEquals(expectedArray, array, DELTA);
    }

    @Test
    public void selectionSortTest_correctParameters2_true() throws WrongArgumentsException {
        double[] array = new double[]{1};
        double[] expectedArray = new double[]{1};

        VectorLogic.selectionSort(array);

        assertArrayEquals(expectedArray, array, DELTA);
    }

    @Test
    public void selectionSortTest_correctParameters3_true() throws WrongArgumentsException {
        double[] array = new double[]{};


        VectorLogic.selectionSort(array);

        assertArrayEquals(array, array, DELTA);
    }


    @Test(expected = WrongArgumentsException.class)
    public void selectionSortTest_correctParameters4_exception() throws WrongArgumentsException {
        double[] array = null;

        VectorLogic.selectionSort(array);
    }

    ////

    @Test
    public void sortMerge_correctParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{5, 1, 0, -3, 95, 0.25, 75, 4};
        double[] expectedArray = new double[]{-3, 0, 0.25, 1, 4, 5, 75, 95};


        VectorLogic.sortMerge(array);

        assertArrayEquals(expectedArray, array, DELTA);
    }

    @Test
    public void sortMergeTest_correctParameters2_true() throws WrongArgumentsException {
        double[] array = new double[]{1};
        double[] expectedArray = new double[]{1};

        VectorLogic.sortMerge(array);

        assertArrayEquals(expectedArray, array, DELTA);
    }

    @Test
    public void sortMergeTest_correctParameters3_true() throws WrongArgumentsException {
        double[] array = new double[]{};

        VectorLogic.sortMerge(array);

        assertArrayEquals(array, array, DELTA);
    }


    @Test(expected = WrongArgumentsException.class)
    public void sortMergeTest_correctParameters4_exception() throws WrongArgumentsException {
        double[] array = null;

        VectorLogic.sortMerge(array);
    }

    ////
    @Test
    public void quickSort_correctParameters_true() throws WrongArgumentsException {
        double[] array = new double[]{5, 1, 0, -3, 95, 0.25, 75, 4};
        double[] expectedArray = new double[]{-3, 0, 0.25, 1, 4, 5, 75, 95};

        VectorLogic.quickSort(array);

        assertArrayEquals(expectedArray, array, DELTA);
    }

    @Test
    public void quickSortTest_correctParameters2_true() throws WrongArgumentsException {
        double[] array = new double[]{1};
        double[] expectedArray = new double[]{1};

        VectorLogic.quickSort(array);

        assertArrayEquals(expectedArray, array, DELTA);
    }

    @Test
    public void quickSortTest_correctParameters3_true() throws WrongArgumentsException {
        //given
        double[] array = new double[]{};
        //when
        VectorLogic.quickSort(array);
        //then
        assertArrayEquals(array, array, DELTA);
    }


    @Test(expected = WrongArgumentsException.class)
    public void quickSortTest_correctParameters4_exception() throws WrongArgumentsException {
        double[] array = null;

        VectorLogic.quickSort(array);
    }


    ////
    @AfterClass
    public static void afterClass() {
        LOGGER.info("VectorLogicTest finished!");
    }
}