package by.epam.javatraining.chekun.maintask01.model.action;


import by.epam.javatraining.chekun.maintask01.model.exception.WrongArgumentsException;
import org.apache.log4j.Logger;

/**
 * Class contains methods for manipulation with matrices.
 *
 * <p> Some method from class can throw {@code WrongArgumentsException}
 *
 * @author Chekun Ilya
 * @version 1.0
 */
public class MatrixLogic {

    private static final Logger LOGGER = Logger.getLogger(MatrixLogic.class);


    /**
     * Method for checking is matrix rectangular
     *
     * @param matrix {@code double[][]}
     * @return if matrix rectangular -> true
     * if matrix == null -> false
     * if it`s not a matrix -> false
     * if matrix is not a rectangular -> false
     */
    public static boolean isMatrixRectangular(double[][] matrix) {
        if (matrix == null || !isMatrix(matrix)) {
            LOGGER.error("Method isMatrixRectangular() received wrong parameter!" +
                    "(matrix == null or it`s not a matrix)");
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length != matrix[i].length) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param matrix {@code double[][]}
     * @return if it is a matrix -> true
     * if matrix == null -> false
     * if matrix.length == 0 -> false
     * if it is not a matrix -> false
     */
    public static boolean isMatrix(double[][] matrix) {
        if (matrix == null) {
            LOGGER.error("Method isMatrix() received wrong parameter!(matrix == null)");
            return false;
        }
        if (matrix.length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length - 1; i++) {
            if (matrix[i].length != matrix[i + 1].length) {
                return false;
            }
        }
        return true;
    }


    /**
     * Method for find MINIMUM value in matrix.
     * Using foreach cycle.
     *
     * @param matrix {@code double[][]}
     * @return {@code double} MINIMUM value from matrix.
     * @throws WrongArgumentsException if matrix == null or it is not a matrix.
     */
    public static double findMinValue(double[][] matrix) throws WrongArgumentsException {
        if (matrix == null || !isMatrix(matrix)) {
            LOGGER.error("Method findMinValue() received wrong parameter!(matrix == null or it's not a matrix)");
            throw new WrongArgumentsException("Method findMinValue() received wrong parameter " +
                    "(matrix == null or it's not a matrix)");
        }
        double minValue = matrix[0][0];

        for (double[] columns : matrix) {
            for (double lines : columns) {
                if (minValue > lines) {
                    minValue = lines;
                }
            }
        }
        return minValue;
    }

    /**
     * Method for find MAXIMUM value in matrix.
     * Using foreach cycle.
     *
     * @param matrix {@code double[][]}
     * @return {@code double} MAXIMUM value from matrix.
     * @throws WrongArgumentsException if matrix == null or it is not a matrix.
     */
    public static double findMaxValue(double[][] matrix) throws WrongArgumentsException {
        if (matrix == null || !isMatrix(matrix)) {
            LOGGER.error("Method findMaxValue() received wrong parameter(matrix == null or it's not a matrix)");
            throw new WrongArgumentsException("Method findMaxValue() received wrong parameter " +
                    "(matrix == null or it's not a matrix)");
        }

        double maxValue = matrix[0][0];

        for (double[] columns : matrix) {
            for (double lines : columns) {
                if (maxValue < lines) {
                    maxValue = lines;
                }
            }
        }
        return maxValue;
    }

    /**
     * @param matrix {@code double[][]}
     * @return if matrix symmetric with main diagonal -> true
     * if matrix not symmetric with main diagonal -> false
     * (!!!)if matrix == null or matrix is not a rectangular -> false
     */
    public static boolean isMatrixSymmetricWithMainDiagonal(double[][] matrix) {
        if (matrix == null || !isMatrixRectangular(matrix)) {
            LOGGER.error("Method isMatrixSymmetricWithMainDiagonal() received wrong parameter!(matrix == null" +
                    "or matrix is not rectangular)");
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * @param matrix {@code double[][]}
     * @return if matrix incidental with main diagonal -> true
     * if matrix not symmetric with incidental diagonal -> false
     * (!!!)if matrix == null or matrix is not a rectangular -> false
     */
    public static boolean isMatrixSymmetricWithIncidentalDiagonal(double[][] matrix) {
        if (matrix == null || !isMatrixRectangular(matrix)) {
            LOGGER.error("Method isMatrixSymmetricWithIncidentalDiagonal() received wrong parameter!(matrix == null" +
                    "or matrix is not rectangular)");
            return false;
        }
        final int MATRIX_SIZE = matrix.length;

        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE - i; j++) {
                if (matrix[i][j] != matrix[MATRIX_SIZE - j - 1][MATRIX_SIZE - i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Method for transposing matrix.
     *
     * @param matrix {@code double[][]}
     * @return {@code double[][]} if it was possible to transpose
     * @throws WrongArgumentsException if matrix == null or it is not a matrix
     */
    public static double[][] transposeMatrix(double[][] matrix) throws WrongArgumentsException {
        if (matrix == null || !isMatrix(matrix)) {
            LOGGER.error("Method transposeMatrix() received wrong parameter!(matrix == null or it`s not a matrix)");
            throw new WrongArgumentsException("Method transposeMatrix() received wrong parameter!" +
                    "(matrix == null or it`s not a matrix)");
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                double temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }


    /**
     * Method for search position of the fist local minimum in matrix.
     *
     * @param matrix {@code double[][]}
     * @return {@code int[]} int array with position of local minimum value.
     * @throws WrongArgumentsException if received matrix == null or it is not a matrix
     */
    public static int[] findFirstLocalMinPosition(double[][] matrix) throws WrongArgumentsException {
        if (matrix == null || !isMatrix(matrix)) {
            LOGGER.error("Method findFirstLocalMinPosition() received wrong parameter!(matrix == null or it`s not a matrix))");
            throw new WrongArgumentsException("Method findFirstLocalMinPosition() received wrong parameter!" +
                    " (matrix == null or it`s not a matrix))");
        }
        final int ARRAY_SIZE = 2;
        final int POSITION_MIN_VALUE_IN_MATRIX_LINE = 0;
        final int POSITION_MIN_VALUE_IN_MATRIX_COLUMN = 1;

        int matrixSize = matrix.length;
        int[] localMinPositions = new int[ARRAY_SIZE];
        boolean flag = true;

        for (int i = 0; i < matrixSize && flag; i++) {
            for (int j = 0; j < matrixSize; j++) {
                int count = 0;

                if (i - 1 > 0 && matrix[i][j] < matrix[i - 1][j]) {
                    count++;
                }
                if (j - 1 > 0 && matrix[i][j] < matrix[i][j - 1]) {
                    count++;
                }
                if (i + 1 < matrixSize && matrix[i][j] < matrix[i + 1][j]) {
                    count++;
                }
                if (j + 1 < matrixSize && matrix[i][j] < matrix[i][j + 1]) {
                    count++;
                }

                if (count == 2 || count == 3 || count == 4) {
                    localMinPositions[POSITION_MIN_VALUE_IN_MATRIX_LINE] = i;
                    localMinPositions[POSITION_MIN_VALUE_IN_MATRIX_COLUMN] = j;
                    flag = false;
                    break;
                }
            }
        }
        return localMinPositions;
    }

}

