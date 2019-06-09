package by.epam.javatraining.chekun.maintask01.model;

import by.epam.javatraining.chekun.maintask01.model.action.MatrixLogic;
import by.epam.javatraining.chekun.maintask01.model.exception.WrongArgumentsException;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class MatrixLogicTest {

    private static final Logger LOGGER = Logger.getLogger(MatrixLogicTest.class);
    private static final double DELTA = 0.01;

    @BeforeClass
    public static void beforeClass() {
        LOGGER.info("MatrixLogicTest started!");
    }


    @Test
    public void findMinValue_correctParameters_true() throws WrongArgumentsException {
        double[][] matrix = {
                {1, 2, -1, 6},
                {2, 4, 0, -1},
                {0, 0, -10, 6}};
        double expected = -10;

        assertEquals(expected, MatrixLogic.findMinValue(matrix), DELTA);
    }


    @Test
    public void findMinValue_correctParameters2_true() throws WrongArgumentsException {
        double[][] matrix = {
                {1, 2, -1, 6},
                {2, 4, 0, -1},
                {0, 0, -10, 6},
                {-25, -40, 0, 5}};
        double expected = -40;

        assertEquals(expected, MatrixLogic.findMinValue(matrix), DELTA);
    }

    @Test(expected = WrongArgumentsException.class)
    public void findMinValue_correctParameters_exception() throws WrongArgumentsException {
        double[][] matrix = {};
        MatrixLogic.findMinValue(matrix);
    }

    @Test(expected = WrongArgumentsException.class)
    public void findMinValue_wrongParameters_exception() throws WrongArgumentsException {
        double[][] matrix = {
                {1, 2, -1, 6},
                {2, 4, 0},
                {0, 0, -10, 6},
                {-25, -40, 0, 5}};

        MatrixLogic.findMinValue(matrix);
    }

    @Test(expected = WrongArgumentsException.class)
    public void findMinValue_wrongParameters_exception2() throws WrongArgumentsException {
        double[][] matrix = null;

        MatrixLogic.findMinValue(matrix);
    }

    ////

    @Test
    public void findMaxValue_correctParameters_true() throws WrongArgumentsException {
        double[][] matrix = {
                {1, 2, -1, 15},
                {2, 4, 0, -1},
                {55, 0, -10, 6}};
        double expected = 55;

        assertEquals(expected, MatrixLogic.findMaxValue(matrix), DELTA);
    }


    @Test
    public void findMaxValue_correctParameters2_true() throws WrongArgumentsException {
        double[][] matrix = {
                {1, 2, -1, 6},
                {2, 4, 100, -1},
                {0, 0, -10, 6},
                {-25, -40, 0, 5}};
        double expected = 100;

        assertEquals(expected, MatrixLogic.findMaxValue(matrix), DELTA);
    }

    @Test(expected = WrongArgumentsException.class)
    public void findMaxValue_correctParameters_exception() throws WrongArgumentsException {
        double[][] matrix = {};

        MatrixLogic.findMaxValue(matrix);
    }

    @Test(expected = WrongArgumentsException.class)
    public void findMaxValue_wrongParameters_exception() throws WrongArgumentsException {
        //not a matrix                         ////
        double[][] matrix = {
                {1, 2, -1, 6},
                {2, 4, 0},
                {0, 0, -10, 6},
                {-25, -40, 0, 5}};

        MatrixLogic.findMaxValue(matrix);
    }

    @Test(expected = WrongArgumentsException.class)
    public void findMaxValue_wrongParameters_exception2() throws WrongArgumentsException {
        double[][] matrix = null;

        MatrixLogic.findMaxValue(matrix);
    }


    ////
    @Test
    public void isMatrixSymmetricWithMainDiagonal_correctParameters_true() {
        double[][] matrix = new double[][]{
                {1, 3, 0},
                {3, 2, 6},
                {0, 6, 5}};

        assertTrue(MatrixLogic.isMatrixSymmetricWithMainDiagonal(matrix));
    }

    @Test
    public void isMatrixSymmetricWithMainDiagonal_correctParameters2_true() {
        double[][] matrix = new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}};

        assertTrue(MatrixLogic.isMatrixSymmetricWithMainDiagonal(matrix));
    }

    @Test
    public void isMatrixSymmetricWithMainDiagonal_correctParameters_false() {
        double[][] matrix = new double[][]{
                {1, 0, 0},
                {0, 1, 3},
                {5, 0, 1}};

        assertFalse(MatrixLogic.isMatrixSymmetricWithMainDiagonal(matrix));
    }

    @Test
    public void isMatrixSymmetricWithMainDiagonal_correctParameters2_false() {
        double[][] matrix = new double[][]{
                {1, 15, 0},
                {0, 1, 0},
                {30, 0, 1}};

        assertFalse(MatrixLogic.isMatrixSymmetricWithMainDiagonal(matrix));
    }


    @Test
    public void isMatrixSymmetricWithMainDiagonal_correctParameters3_false() {
        double[][] matrix = new double[][]{};

        assertFalse(MatrixLogic.isMatrixSymmetricWithMainDiagonal(matrix));
    }

    @Test
    public void isMatrixSymmetricWithMainDiagonal_wrongParameters2_false() {
        double[][] matrix = null;

        assertFalse(MatrixLogic.isMatrixSymmetricWithMainDiagonal(matrix));
    }

    @Test
    public void isMatrixSymmetricWithMainDiagonal_wrongParameters3_false() {
        double[][] matrix = {
                {1, 2, 3},
                {2, 1}};

        assertFalse(MatrixLogic.isMatrixSymmetricWithMainDiagonal(matrix));
    }

    ////
    @Test
    public void isMatrixSymmetricWithIncidentalDiagonal_correctParameters_true() {
        double[][] matrix = new double[][]{
                {1, 2, 3, 1},
                {2, 2, 2, 3},
                {3, 3, 2, 2},
                {4, 3, 2, 1}};

        assertTrue(MatrixLogic.isMatrixSymmetricWithIncidentalDiagonal(matrix));
    }

    @Test
    public void isMatrixSymmetricWithIncidentalDiagonal_correctParameters2_true() {
        double[][] matrix = new double[][]{
                {1, 4, 2},
                {4, 3, 4},
                {2, 4, 1}};


        assertTrue(MatrixLogic.isMatrixSymmetricWithIncidentalDiagonal(matrix));
    }

    @Test
    public void isMatrixSymmetricWithIncidentalDiagonal_correctParameters3_false() {
        double[][] matrix = new double[][]{};

        assertFalse(MatrixLogic.isMatrixSymmetricWithMainDiagonal(matrix));
    }

    @Test
    public void isMatrixSymmetricWithIncidentalDiagonal_wrongParameters_false() {
        double[][] matrix = null;

        assertFalse(MatrixLogic.isMatrixSymmetricWithMainDiagonal(matrix));
    }

    @Test
    public void isMatrixSymmetricWithIncidentalDiagonal_wrongParameters2_false() {
        double[][] matrix = {
                {1, 2},
                {1, 2, 3, 4}};

        assertFalse(MatrixLogic.isMatrixSymmetricWithMainDiagonal(matrix));
    }

    ////
    @Test
    public void isMatrixRectangular_correctParameters_true() {
        double[][] matrix = {
                {1, 2, 3},
                {1, 2, 3},
                {3, 4, 3}};

        assertTrue(MatrixLogic.isMatrixRectangular(matrix));
    }

    @Test
    public void isMatrixRectangular_correctParameters2_true() {
        double[][] matrix = {
                {1, 2, 5, 4},
                {1, 2, 5, 4},
                {3, 4, 5, 4},
                {5, 5, 5, 4}};

        assertTrue(MatrixLogic.isMatrixRectangular(matrix));
    }

    @Test
    public void isMatrixRectangular_correctParameters3_false() {
        double[][] matrix = {};

        assertFalse(MatrixLogic.isMatrixRectangular(matrix));
    }


    @Test
    public void isMatrixRectangular_wrongParameters_false() {
        double[][] matrix = null;

        assertFalse(MatrixLogic.isMatrixRectangular(matrix));
    }

    @Test
    public void isMatrixRectangular_wrongParameters2_false() {
        double[][] matrix = new double[][]{
                {1, 2, 3},
                {2}};

        assertFalse(MatrixLogic.isMatrixRectangular(matrix));
    }
    ////

    @Test
    public void transposeMatrix_correctParameters_true() throws WrongArgumentsException {
        double[][] matrix = new double[][]{
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}};
        double[][] expected = new double[][]{
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}};

        assertArrayEquals(expected, MatrixLogic.transposeMatrix(matrix));
    }

    @Test
    public void transposeMatrix_correctParameters2_true() throws WrongArgumentsException {
        double[][] matrix = new double[][]{
                {3, 4, 5, 5},
                {5, 6, 7, 8},
                {8, 9, 10, 5}};
        double[][] expected = new double[][]{
                {3, 5, 8, 5},
                {4, 6, 9, 8},
                {5, 7, 10, 5}};

        assertArrayEquals(expected, MatrixLogic.transposeMatrix(matrix));
    }

    @Test(expected = WrongArgumentsException.class)
    public void transposeMatrix_wrongParameters_true() throws WrongArgumentsException {
        double[][] matrix = new double[][]{
                {3, 4, 5, 5},
                {5, 6, 7, 8},
                {8, 9, 10}};

        MatrixLogic.transposeMatrix(matrix);
    }

    @Test(expected = WrongArgumentsException.class)
    public void transposeMatrix_wrongParameters2_true() throws WrongArgumentsException {
        double[][] matrix = new double[][]{};

        MatrixLogic.transposeMatrix(matrix);
    }

    @Test(expected = WrongArgumentsException.class)
    public void transposeMatrix_wrongParameters3_true() throws WrongArgumentsException {
        double[][] matrix = null;

        MatrixLogic.transposeMatrix(matrix);
    }

    ///
    @Test
    public void findFirstLocalMinPosition_correctParameters_true() throws WrongArgumentsException {
        double[][] matrix = new double[][]{
                {2, 2, 3, 4},
                {2, 2, 2, 3},
                {3, 3, 2, 2},
                {4, 3, 2, 1}};
        //position of local min
        int[] expected = new int[]{3, 3};

        assertArrayEquals(expected, MatrixLogic.findFirstLocalMinPosition(matrix));
    }

    @Test
    public void findFirstLocalMinPosition_correctParameters2_true() throws WrongArgumentsException {
        double[][] matrix = new double[][]{
                {15, 4, 8, 2},
                {3, 11, 25, 3},
                {7, 3, 4, -2},
                {1, 2, 3, 4}};
        //position of local min
        int[] expected = new int[]{0, 1};

        assertArrayEquals(expected, MatrixLogic.findFirstLocalMinPosition(matrix));
    }

    @Test
    public void findFirstLocalMinPosition_correctParameters3_true() throws WrongArgumentsException {
        double[][] matrix = new double[][]{
                {7, 2, 3, 4},
                {5, 1, 6, -1},
                {7, 3, 4, -2}};
        //position of local min
        int[] expected = new int[]{1, 1};

        assertArrayEquals(expected, MatrixLogic.findFirstLocalMinPosition(matrix));
    }

    @Test(expected = WrongArgumentsException.class)
    public void findFirstLocalMinPosition_wrongParameters_exception() throws WrongArgumentsException {
        double[][] matrix = new double[][]{};

        MatrixLogic.findFirstLocalMinPosition(matrix);
    }

    @Test(expected = WrongArgumentsException.class)
    public void findFirstLocalMinPosition_wrongParameters2_exception() throws WrongArgumentsException {
        double[][] matrix = null;

        MatrixLogic.findFirstLocalMinPosition(matrix);
    }

    @Test(expected = WrongArgumentsException.class)
    public void findFirstLocalMinPosition_wrongParameters3_exception() throws WrongArgumentsException {
        double[][] matrix = new double[][]{{1, 2, 3}, {2, 3}};

        MatrixLogic.findFirstLocalMinPosition(matrix);
    }

    ///
    @Test
    public void isMatrix_correctParameters_true() {
        double[][] matrix = new double[][]{
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}};

        assertTrue(MatrixLogic.isMatrixRectangular(matrix));
    }

    @Test
    public void isMatrix_wrongParameters_false() {
        double[][] matrix = new double[][]{
                {1, 2, 3},
                {1, 2, 3}};

        assertFalse(MatrixLogic.isMatrixRectangular(matrix));
    }

    @Test
    public void isMatrix_wrongParameters2_false() {
        double[][] matrix = new double[][]{};

        assertFalse(MatrixLogic.isMatrixRectangular(matrix));
    }

    @Test
    public void isMatrix_wrongParameters3_false() {
        double[][] matrix = null;

        assertFalse(MatrixLogic.isMatrixRectangular(matrix));
    }
    @AfterClass
    public static void afterClass() {
        LOGGER.info("MatrixLogicTest finished!");
    }
}