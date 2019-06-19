package by.chekun.model.action;


import by.chekun.model.entity.Vector;
import by.chekun.model.exception.VectorLogicValidatorException;
import by.chekun.model.exception.WrongArgumentsException;
import by.chekun.model.exception.vector.NoSuchElementException;
import org.apache.log4j.Logger;


public class VectorLogic {

    private static VectorLogic INSTANCE = new VectorLogic();

    public static VectorLogic getInstance() {
        return INSTANCE;
    }

    private VectorLogic() {
    }

    /////////////////////////
    private static final Logger LOGGER = Logger.getLogger(VectorLogic.class);


    public static final int NO_LOCAL_MIN_OR_MAX_VALUE = -1;


    public static final int NO_SUCH_ELEMENT_IN_ARRAY = -1;

    public static final int FIRST_POSITION_ARRAY = 0;

    private VectorLogicValidator validator = VectorLogicValidator.getInstance();


    public double findMaxValue(Vector vector) throws VectorLogicValidatorException, NoSuchElementException {

        if (validator.validate(vector)) {
            double maxValue = vector.getElementFromPosition(FIRST_POSITION_ARRAY);
            double[] array = vector.getVector();

            for (double i : array) {
                if (maxValue < i) {
                    maxValue = i;
                }
            }
            return maxValue;
        }
        LOGGER.warn("Method findMaxValue() received not valid vector");
        throw new VectorLogicValidatorException("Method findMaxValue() received not valid vector!");
    }


    public double findMinValue(Vector vector) throws VectorLogicValidatorException, NoSuchElementException {

        if (validator.validate(vector)) {
            double minValue = vector.getElementFromPosition(FIRST_POSITION_ARRAY);
            double[] array = vector.getVector();

            for (double i : array) {
                if (minValue > i) {
                    minValue = i;
                }
            }
            return minValue;
        }
        LOGGER.warn("Method findMinValue() received not valid vector");
        throw new VectorLogicValidatorException("Method findMinValue() received not valid vector!");
    }


    public double calculateArithmeticAverageValue(Vector vector) throws VectorLogicValidatorException, NoSuchElementException {

        if (validator.validate(vector)) {
            int vectorSize = vector.getSize();
            double sumOfValues = 0;
            for (double value : vector.getVector()) {
                sumOfValues += value;
            }
            return sumOfValues / vectorSize;
        }
        LOGGER.warn("Method calculateArithmeticAverageValue() received not valid vector");
        throw new VectorLogicValidatorException("Method calculateArithmeticAverageValue() received not valid vector!");
    }


    public double calculateGeometricAverageValue(Vector vector) throws VectorLogicValidatorException, NoSuchElementException {
        if (validator.validate(vector)) {
            int vectorSize = vector.getSize();
            double compositionOfValues = 1;
            for (double value : vector.getVector()) {
                compositionOfValues *= value;
            }
            return Math.exp(Math.log(compositionOfValues) / vectorSize);
        }
        LOGGER.warn("Method calculateGeometricAverageValue() received not valid vector");
        throw new VectorLogicValidatorException("Method calculateGeometricAverageValue() received not valid vector!");
    }


    public boolean isArraySortedByAscending(Vector vector) throws NoSuchElementException {

        if (validator.validate(vector) && vector.getSize() > 0) {
            final double[] array = vector.getVector();
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    public boolean isArraySorted(Vector vector) throws NoSuchElementException {
        if (validator.validate(vector) && vector.getSize() > 0) {
            boolean flag = true;
            final double[] array = vector.getVector();

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] < array[i + 1]) {
                        return false;
                    }
                }
            }

            return true;
        }
        //? exception
        return false;
    }


    public int findLocalMinPosition(Vector vector) throws VectorLogicValidatorException, NoSuchElementException {

        if (validator.validate(vector)) {
            double[] array = vector.getVector();
            if (array.length == 1 || array[0] < array[1]) {
                return FIRST_POSITION_ARRAY;
            } else {
                for (int position = 1; position < array.length - 1; position++) {
                    if (array[position] < array[position - 1] && array[position] < array[position + 1]) {
                        return position;
                    }
                }
            }

            return NO_LOCAL_MIN_OR_MAX_VALUE;
        }
        LOGGER.warn("Method findLocalMinPosition() received not valid vector");
        throw new VectorLogicValidatorException("Method findLocalMinPosition() received not valid vector!");
    }


    public int findLocalMaxPosition(Vector vector) throws VectorLogicValidatorException, NoSuchElementException {

        if (validator.validate(vector)) {
            final double[] array = vector.getVector();
            if (array.length == 1 || array[0] > array[1]) {
                return FIRST_POSITION_ARRAY;
            } else {
                for (int position = 1; position < array.length - 1; position++) {
                    if (array[position] > array[position - 1] && array[position] > array[position + 1]) {
                        return position;
                    }
                }
            }
            return NO_LOCAL_MIN_OR_MAX_VALUE;
        }
        LOGGER.warn("Method findLocalMaxPosition() received not valid vector");
        throw new VectorLogicValidatorException("Method findLocalMaxPosition() received not valid vector!");
    }


    public int findValuePositionLinearSearch(Vector vector, double valueToSearch)
            throws VectorLogicValidatorException, NoSuchElementException {
        if (validator.validate(vector)) {
            final double[] array = vector.getVector();
            for (int position = 0; position < array.length; position++) {
                if (array[position] == valueToSearch) {
                    return position;
                }
            }
            return NO_SUCH_ELEMENT_IN_ARRAY;
        }
        LOGGER.warn("Method findValuePositionLinearSearch() received not valid vector");
        throw new VectorLogicValidatorException("Method findValuePositionLinearSearch() received not valid vector!");
    }


    public int findValuePositionBinarySearch(Vector vector, double valueToSearch) throws NoSuchElementException {
        if (isArraySorted(vector)) {
            double[] array = vector.getVector();

            int firstIndex = 0;
            int lastIndex = array.length - 1;
            while (firstIndex <= lastIndex) {
                int middleIndex = (firstIndex + lastIndex) / 2;
                if (array[middleIndex] == valueToSearch) {
                    return middleIndex;
                } else if (array[middleIndex] < valueToSearch) {
                    firstIndex = middleIndex + 1;
                } else if (array[middleIndex] > valueToSearch) {
                    lastIndex = middleIndex - 1;
                }
            }

            return NO_SUCH_ELEMENT_IN_ARRAY;
        }
        return -1;
    }

    /**
     * Method for reverse receive array.
     * i'm throwing exception because don't wanna return null.
     *
     * @param {@code double[]} Array for reverse
     * @return {@code double[]} reverse array
     * if array = null will return {@see WRONG_ARGUMENT}
     * @throws WrongArgumentsException if array = null
     */
    public void flipArray(Vector vector) throws VectorLogicValidatorException, NoSuchElementException {
        if (validator.validate(vector)) {
            double[] array = vector.getVector();
            for (int i = 0; i < array.length / 2; i++) {
                double temp = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = temp;
            }

            vector.setVector(array);
        } else {
            LOGGER.warn("Method flipArray() received not valid vector");
            throw new VectorLogicValidatorException("Method flipArray() received not valid vector!");
        }
    }


}

