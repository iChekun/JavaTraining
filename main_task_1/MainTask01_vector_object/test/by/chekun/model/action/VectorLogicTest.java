package by.chekun.model.action;

import by.chekun.model.entity.Vector;
import by.chekun.model.exception.VectorLogicValidatorException;
import by.chekun.model.exception.WrongArgumentsException;
import by.chekun.model.exception.vector.NoSuchElementException;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static by.chekun.model.action.VectorLogic.NO_LOCAL_MIN_OR_MAX_VALUE;
import static by.chekun.model.action.VectorLogic.NO_SUCH_ELEMENT_IN_ARRAY;
import static org.junit.Assert.*;

public class VectorLogicTest {

    private static final Logger LOGGER = Logger.getLogger(VectorLogicTest.class);
    private static final double DELTA = 0.01;
    private VectorLogic vectorLogic = VectorLogic.getInstance();

    @BeforeClass
    public static void beforeClass() {
        LOGGER.info("VectorLogicTest started!");
    }

    @Test
    public void findMaxValue_correctParameters_true() throws VectorLogicValidatorException, NoSuchElementException {

        Vector vector = new Vector(1, 5, 0, 9, 25, 2, 99);
        double expected = 99;

        assertEquals(expected, vectorLogic.findMaxValue(vector), DELTA);
    }

    @Test
    public void findMaxValue_correctParameters_2_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(1, 5, 0, 9, 25, 2, 99);
        double expected = 99.0;

        assertEquals(expected, vectorLogic.findMaxValue(vector), DELTA);
    }

    @Test
    public void findMaxValue_correctParameters_3_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(1, 5, 0, 9, 25, 2, 99);
        double expected = 99.0;

        assertEquals(expected, vectorLogic.findMaxValue(vector), DELTA);
    }

    @Test
    public void findMaxValue_wrongParameters1_exception() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector();

        double expected = 0.0;

        assertEquals(expected, vectorLogic.findMaxValue(vector), DELTA);
    }

    @Test
    public void findMaxValue_wrongParameters_exception() throws VectorLogicValidatorException, NoSuchElementException {
        //given
        Vector vector = new Vector();
        //when
        //then
        vectorLogic.findMaxValue(vector);
    }

    ///
    @Test
    public void findMinValue_correctParameters_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(1, 5, -2.25, 9, 25, 2, 99);
        double expected = -2.25;

        assertEquals(expected, vectorLogic.findMinValue(vector), DELTA);
    }

    @Test
    public void findMinValue_correctParameters_2_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(99, 0.25, 0.1, 25, 75, 999.02578, 0.05);
        double expected = 0.05;

        assertEquals(expected, vectorLogic.findMinValue(vector), DELTA);
    }

    @Test
    public void findMinValue_wrongParameters1_exception() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector();

        double expected = -1;

        assertEquals(expected, vectorLogic.findMinValue(vector), DELTA);
    }

    @Test(expected = VectorLogicValidatorException.class)
    public void findMinValue_wrongParameters_exception() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = null;

        vectorLogic.findMinValue(vector);
    }

    ///
    @Test
    public void calculateArithmeticAverageValue_correctParameters_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(1, 2, 3, 9.02, 25.01, 99, 25, 101);
        double expected = 33.12875;

        assertEquals(expected, vectorLogic.calculateArithmeticAverageValue(vector), DELTA);
    }

    @Test
    public void calculateArithmeticAverageValue_correctParameters2_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(1);
        double expected = 1;

        assertEquals(expected, vectorLogic.calculateArithmeticAverageValue(vector), DELTA);
    }

    @Test
    public void calculateArithmeticAverageValue_wrongParameters_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector();
        double expected = 0;

        assertEquals(Double.NaN, vectorLogic.calculateArithmeticAverageValue(vector), DELTA);
    }

    @Test(expected = VectorLogicValidatorException.class)
    public void calculateArithmeticAverageValue_wrongParameters_exception() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = null;

        vectorLogic.calculateArithmeticAverageValue(vector);
    }

    ///
    @Test
    public void calculateGeometricAverageValue_correctParameters_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(1, 2, 3, 9.02, 25.01, 99, 25, 101);
        double expected = 11.645845040398333;

        assertEquals(expected, vectorLogic.calculateGeometricAverageValue(vector), DELTA);
    }

    @Test
    public void calculateGeometricAverageValue_correctParameters2_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(5);
        double expected = 5;

        assertEquals(expected, vectorLogic.calculateGeometricAverageValue(vector), DELTA);
    }

    @Test
    public void calculateGeometricAverageValue_correctParameters3_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(5, 7.25);
        double expected = 6.020797289396148;

        assertEquals(expected, vectorLogic.calculateGeometricAverageValue(vector), DELTA);
    }

    @Test
    public void calculateGeometricAverageValue_WrongParameters_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector();
        double expected = 0;

        assertEquals(expected, vectorLogic.calculateGeometricAverageValue(vector), DELTA);
    }

    @Test(expected = VectorLogicValidatorException.class)
    public void calculateGeometricAverageValue_WrongParameters_exception() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = null;

        vectorLogic.calculateGeometricAverageValue(vector);
    }

    ///
    @Test
    public void isArraySorted_correctParameters_true() throws NoSuchElementException {
        Vector vector = new Vector(1, 2, 3, 4, 5, 6, 7, 10, 12);

        assertTrue(vectorLogic.isArraySorted(vector));
    }

    @Test
    public void isArraySorted_correctParameters2_true() throws NoSuchElementException {
        Vector vector = new Vector(1, 2);

        assertTrue(vectorLogic.isArraySorted(vector));
    }

    @Test
    public void isArraySorted_correctParameters3_false() throws NoSuchElementException {
        Vector vector = new Vector(1, 2, 15, 22, 3, 4, 5, 6, 7, 10, 12);

        assertFalse(vectorLogic.isArraySorted(vector));
    }

    @Test
    public void isArraySorted_correctParameters4_true() throws NoSuchElementException {
        Vector vector = new Vector(5, 4, 3, 2, 1, 0);

        assertTrue(vectorLogic.isArraySorted(vector));
    }


    @Test
    public void isArraySorted_badParameters_false() throws NoSuchElementException {
        Vector vector = new Vector();

        assertFalse(vectorLogic.isArraySorted(vector));
    }

    @Test
    public void isArraySorted_badParameters2_false() throws NoSuchElementException {
        Vector vector = null;

        assertFalse(vectorLogic.isArraySorted(vector));
    }

    ///
    @Test
    public void isArraySortedByAscending_correctParameters_true() throws NoSuchElementException {
        Vector vector = new Vector(1, 2, 3, 4, 5, 6, 7, 10, 12);

        assertTrue(vectorLogic.isArraySortedByAscending(vector));
    }

    @Test
    public void isArraySortedByAscending_correctParameters2_true() throws NoSuchElementException {
        Vector vector = new Vector(1, 2);

        assertTrue(vectorLogic.isArraySortedByAscending(vector));
    }

    @Test
    public void isArraySortedByAscending_badParameters_false() throws NoSuchElementException {
        Vector vector = new Vector();

        assertFalse(vectorLogic.isArraySortedByAscending(vector));
    }

    @Test
    public void isArraySortedByAscending_badParameters2_false() throws NoSuchElementException {
        Vector vector = null;

        assertFalse(vectorLogic.isArraySortedByAscending(vector));
    }


    ///
    @Test
    public void findLocalMinPosition_correctParameters_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(9, 8, 2, 1, 2, 5, 10);
        int expectedIndex = 3;

        assertEquals(expectedIndex, vectorLogic.findLocalMinPosition(vector));
    }

    @Test
    public void findLocalMinPosition_correctParameters2_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(9, 8, 2, 1, 2, 5, 10);
        int expectedIndex = 3;

        assertEquals(expectedIndex, vectorLogic.findLocalMinPosition(vector));
    }

    @Test
    public void findLocalMinPosition_correctParameters3_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(2, 2, 2, 2, 2, 2, 2, 2);

        assertEquals(NO_LOCAL_MIN_OR_MAX_VALUE, vectorLogic.findLocalMinPosition(vector));
    }

    @Test
    public void findLocalMinPosition_correctParameters4_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(5);

        assertEquals(VectorLogic.FIRST_POSITION_ARRAY, vectorLogic.findLocalMinPosition(vector));
    }


    @Test
    public void findLocalMinPosition_wrongParameters1_exception() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector();

        vectorLogic.findLocalMinPosition(vector);
    }

    @Test(expected = VectorLogicValidatorException.class)
    public void findLocalMinPosition_wrongParameters2_exception() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vectot = null;

        vectorLogic.findLocalMinPosition(vectot);
    }

    //

    @Test
    public void findLocalMaxPosition_correctParameters_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(8, 8, 2, 15, 2, 5, 10);
        int expectedIndex = 3;

        assertEquals(expectedIndex, vectorLogic.findLocalMaxPosition(vector));
    }

    @Test
    public void findLocalMaxPosition_correctParameters2_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(7, 7, 7, 6, 7, 10, 5, 9);
        int expectedIndex = 5;

        assertEquals(expectedIndex, vectorLogic.findLocalMaxPosition(vector));
    }

    @Test
    public void findLocalMaxPosition_correctParameters3_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(2, 2, 2, 2, 2, 2, 2, 2);

        assertEquals(NO_LOCAL_MIN_OR_MAX_VALUE, vectorLogic.findLocalMaxPosition(vector));
    }

    @Test
    public void findLocalMaxPosition_correctParameters4_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(8, 8, 2, 1, 2, 5, 10);

        assertEquals(NO_LOCAL_MIN_OR_MAX_VALUE, vectorLogic.findLocalMaxPosition(vector));
    }

    @Test
    public void findLocalMaxPosition_correctParameters5_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(102.25);

        assertEquals(VectorLogic.FIRST_POSITION_ARRAY, vectorLogic.findLocalMaxPosition(vector));
    }


    @Test
    public void findLocalMaxPosition_wrongParameters_exception() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(0);

        assertEquals(0, vectorLogic.findLocalMaxPosition(vector));
    }

    @Test(expected = VectorLogicValidatorException.class)
    public void findLocalMaxPosition_wrongParameters2_exception() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = null;

        vectorLogic.findLocalMaxPosition(vector);
    }

    ///
    @Test
    public void findValuePositionLinearSearch_correctParameters_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(1, 7, 9, 0.25, 2, 109);
        double valueToSearch = 2;

        int expectedPosition = 4;

        assertEquals(expectedPosition, vectorLogic.findValuePositionLinearSearch(vector, valueToSearch));
    }

    @Test
    public void findValuePositionLinearSearch_correctParameters2_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(1, 2, 9, 0.25, 2, 109, 502.2, 25.25, 0.6);
        double valueToSearch = 502.2;

        int expectedPosition = 6;

        assertEquals(expectedPosition, vectorLogic.findValuePositionLinearSearch(vector, valueToSearch));
    }


    @Test
    public void findValuePositionLinearSearch_correctParameters3_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(1, 2, 9, 0.25, 2, 109, 502.2, 25.25, 0.6);
        double valueToSearch = 9999;

        assertEquals(VectorLogic.NO_SUCH_ELEMENT_IN_ARRAY, vectorLogic.findValuePositionLinearSearch(vector, valueToSearch));
    }


    @Test
    public void findValuePositionLinearSearch_badParameters_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector();
        double valueToSearch = 25;

        assertEquals(VectorLogic.NO_SUCH_ELEMENT_IN_ARRAY, vectorLogic.findValuePositionLinearSearch(vector, valueToSearch));
    }


    @Test(expected = VectorLogicValidatorException.class)
    public void findValuePositionLinearSearch_badParameters2_exception() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = null;
        double valueToSearch = 25;

        vectorLogic.findValuePositionLinearSearch(vector, valueToSearch);
    }

    ///
    @Test
    public void findValuePositionBinarySearch_correctParameters_true() throws NoSuchElementException, WrongArgumentsException {
        Vector vector = new Vector(1, 2, 2.2, 7.2, 55, 105, 255, 905);

        double valueToSearch = 2.2;
        int expectedPosition = 2;

        assertEquals(expectedPosition, vectorLogic.findValuePositionBinarySearch(vector, valueToSearch));
    }

    @Test
    public void findValuePositionBinarySearch_correctParameters2_true() throws NoSuchElementException {
        Vector vector = new Vector(1, 2, 2.2, 7.2, 55, 105, 255, 905);
        double valueToSearch = 255;
        int expectedPosition = 6;

        assertEquals(expectedPosition, vectorLogic.findValuePositionBinarySearch(vector, valueToSearch));
    }

    @Test
    public void findValuePositionBinarySearch_correctParameters3_true() throws NoSuchElementException {
        Vector vector = new Vector(1, 2, 2.2, 7.2, 55, 105, 255.25, 445, 605, 905);
        double valueToSearch = 1000;

        assertEquals(VectorLogic.NO_SUCH_ELEMENT_IN_ARRAY, vectorLogic.findValuePositionBinarySearch(vector, valueToSearch));
    }

    @Test
    public void findValuePositionBinarySearch_badParameters_true() throws NoSuchElementException {
        Vector vector = new Vector(1, 5, 7, 2, 2.2, 7.2, 55, 105, 255.25, 445, 605, 905);
        double valueToSearch = 1000;

      assertEquals(NO_SUCH_ELEMENT_IN_ARRAY,vectorLogic.findValuePositionBinarySearch(vector, valueToSearch));
    }


    @Test
    public void findValuePositionBinarySearch_badParameters2_exception() throws NoSuchElementException {
        Vector vector = new Vector();
        double valueToSearch = 1000;
        int expectedValue = -1;

        assertEquals(expectedValue, vectorLogic.findValuePositionBinarySearch(vector, valueToSearch));
    }

    @Test
    public void findValuePositionBinarySearch_badParameters3_exception() throws NoSuchElementException {
        Vector vector = null;
        double valueToSearch = 1000;

        assertEquals(-1, vectorLogic.findValuePositionBinarySearch(vector, valueToSearch));
    }

    ///
    @Test
    public void getReverseArray_correctParameters_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(1, 5, 7, 2, 2.2, 7.2, 55, 105, 255.25, 445, 605, 905);
        Vector expectedArray = new Vector(905.0, 605.0, 445.0, 255.25, 105.0, 55.0, 7.2, 2.2, 2.0, 7.0, 5.0, 1.0);

        vectorLogic.flipArray(vector);

        assertArrayEquals(expectedArray.getVector(), vector.getVector(), DELTA);
    }

    @Test
    public void getReverseArray_correctParameters2_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(1, 5, 8, 2, 1, 7);
        Vector expectedArray = new Vector(7, 1, 2, 8, 5, 1);

        vectorLogic.flipArray(vector);

        assertArrayEquals(expectedArray.getVector(), vector.getVector(), DELTA);
    }

    @Test
    public void getReverseArray_correctParameters3_true() throws VectorLogicValidatorException, NoSuchElementException {
        Vector vector = new Vector(2);
        Vector expectedArray = new Vector(2);

        vectorLogic.flipArray(vector);

        assertArrayEquals(expectedArray.getVector(), vector.getVector(), DELTA);
    }

    @Test(expected = VectorLogicValidatorException.class)
    public void getReverseArray_wrongParameters_exception() throws VectorLogicValidatorException, NoSuchElementException {
        //given
        Vector vector = null;
        //when
        //then
        vectorLogic.flipArray(vector);
    }

    @Test
    public void getReverseArray_wrongParameters2_true() throws VectorLogicValidatorException, NoSuchElementException {
        //given
        Vector vector = new Vector(0);
        //when
        //then
        vectorLogic.flipArray(vector);

        assertArrayEquals(vector.getVector(), vector.getVector(), DELTA);
    }

    /////


    ////
    @AfterClass
    public static void afterClass() {
        LOGGER.info("VectorLogicTest finished!");
    }
}

