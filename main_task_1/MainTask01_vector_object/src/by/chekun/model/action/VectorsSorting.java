package by.chekun.model.action;

import by.chekun.model.entity.Vector;
import by.chekun.model.exception.VectorLogicValidatorException;
import by.chekun.model.exception.WrongArgumentsException;
import by.chekun.model.exception.vector.NoSuchElementException;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class VectorsSorting {

    private static VectorsSorting INSTANCE = new VectorsSorting();

    public static VectorsSorting getInstance() {
        return INSTANCE;
    }

    private VectorsSorting() {
    }

    //////////////////////////////////
    private static final VectorLogicValidator validator = VectorLogicValidator.getInstance();
    private static final Logger LOGGER = Logger.getLogger(VectorLogic.class);
    public static final int FIRST_POSITION_ARRAY = 0;


    /**
     * Method for sorting array by ascending with bubble sort.
     * BigO of algorithm is O(n^2)
     *
     * @param vector
     * @return sorted {@code array} by ascending
     * if array length < 2 will return received {@code array}
     * @throws WrongArgumentsException if array == null
     */
    public void bubbleSort(Vector vector) throws WrongArgumentsException, NoSuchElementException {
        if (!validator.validate(vector)) {
            LOGGER.warn("Method bubbleSort() receive wrong parameters! (array == null)");
            throw new WrongArgumentsException("Method bubbleSort() received wrong parameters!(array == null)");
        }
        double[] array = vector.getVector();
        double arraySize = vector.getSize();

        for (int i = 0; i < arraySize; i++) {
            for (int j = i + 1; j < arraySize; j++) {
                if (array[i] > array[j]) {
                    double temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        vector.setVector(array);
    }

    /**
     * Method for sorting array with shaker sort ( upgraded bubble sort)
     * BigO of this algorithm is O(n^2)
     *
     * @param vector
     * @return sorted {@code array} by ascending
     * if array length < 2 will return received {@code array}
     * @throws WrongArgumentsException if array == null
     */
    public void shakerSort(Vector vector) throws WrongArgumentsException, NoSuchElementException {
        if (!validator.validate(vector)) {
            LOGGER.warn("Method shakerSort() receive wrong parameters! (array == null)");
            throw new WrongArgumentsException("Method shakerSort() received wrong parameters!(array == null)");
        }
        double[] array = vector.getVector();
        int leftPosition = 1;
        int rightPosition = array.length - 1;

        while (leftPosition <= rightPosition) {

            for (int i = rightPosition; i >= leftPosition; i--) {
                if (array[i - 1] > array[i]) {
                    double temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }

            leftPosition++;

            for (int i = leftPosition; i <= rightPosition; i++) {
                if (array[i - 1] > array[i]) {
                    double temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
            rightPosition--;
        }
        vector.setVector(array);
    }

    /**
     * Method for sorting array with insertion sort
     * </p>BigO of this algorithm is O(n^2)
     *
     * @param vector
     * @return sorted {@code array} by ascending
     * if array length < 2 will return received {@code array}
     * @throws WrongArgumentsException if array == null
     */
    public void insertionSort(Vector vector) throws WrongArgumentsException, NoSuchElementException {
        if (!validator.validate(vector)) {
            LOGGER.warn("Method insertionSort() receive wrong parameters! (array == null)");
            throw new WrongArgumentsException("Method insertionSort() received wrong parameters!(array == null)");
        }

        double[] array = vector.getVector();
        int arraySize = vector.getSize();

        for (int sortedPosition = 1; sortedPosition < arraySize; sortedPosition++) {

            double value = array[sortedPosition];
            int notSortedPosition = sortedPosition;

            while (notSortedPosition > 0 && array[notSortedPosition - 1] > value) {
                array[notSortedPosition] = array[notSortedPosition - 1];
                notSortedPosition -= 1;
            }
            array[notSortedPosition] = value;
        }
        vector.setVector(array);
    }


    /**
     * Method for sorting array with selection sort
     * BigO of this algorithm is O(n^2)
     *
     * @param vector
     * @return sorted {@code array} by ascending
     * if array length < 2 will return received {@code array}
     * @throws WrongArgumentsException if array == null
     */
    public void selectionSort(Vector vector) throws WrongArgumentsException, NoSuchElementException {
        if (!validator.validate(vector)) {
            LOGGER.warn("Method selectionSort() receive wrong parameters! (array == null)");
            throw new WrongArgumentsException("Method selectionSort() received wrong parameters!(array == null)");
        }

        double[] array = vector.getVector();
        int arraySize = vector.getSize();

        for (int i = 0; i < arraySize; i++) {
            int minValuePosition = i;

            for (int j = i + 1; j < arraySize; j++) {
                if (array[j] < array[minValuePosition]) {
                    minValuePosition = j;
                }
            }
            if (minValuePosition != i) {
                double temp = array[minValuePosition];
                array[minValuePosition] = array[i];
                array[i] = temp;
            }
        }

        vector.setVector(array);
    }

    /**
     * Method for sorting array with merge sort
     * The method is called recursively until the array is divided into smaller sorted arrays.
     * BigO of this algorithm is O(n log(n))
     * Method using {@see Array.copyOfRange} for copy array from some position.
     *
     * @param vector
     * @return sorted {@code array} by ascending
     * if array length < 2 will return received {@code array}
     * @throws WrongArgumentsException if array == null
     */
    public void sortMerge(Vector vector) throws WrongArgumentsException, NoSuchElementException {
        if (!validator.validate(vector)) {
            LOGGER.warn("Method sortMerge() receive wrong parameters! (array == null)");
            throw new WrongArgumentsException("Method sortMerge() received wrong parameters!(array == null)");
        }

        double[] array = vector.getVector();
        //break our big array to  smaller arrays
        breakArrayToArrays(array);

        vector.setVector(array);
    }

    /**
     * Private method that calling from sortMerger() for break big array to  smaller arrays
     *
     * @param array
     * @return smaller arrays
     */
    private double[] breakArrayToArrays(double[] array) {
        if (array.length < 2) {
            return array;
        }
        final int middlePosition = array.length / 2;

        final double[] firstArray = breakArrayToArrays(Arrays.copyOfRange(array, FIRST_POSITION_ARRAY, middlePosition));
        final double[] secondArray = breakArrayToArrays(Arrays.copyOfRange(array, middlePosition, array.length));

        return merge(firstArray, secondArray, array);
    }

    /**
     * Private method that calling from sortMerge
     *
     * @param firstArray
     * @param secondArray
     * @return {@code double[]} Sorted array
     */
    private double[] merge(double[] firstArray, double[] secondArray, final double[] resultArray) {

        final int firstArrayLength = firstArray.length;
        final int secondArrayLength = secondArray.length;
        final int finalArrayLength = resultArray.length;
        int firstArrPosition = 0;
        int secondArrPosition = 0;

        for (int i = 0; i < finalArrayLength; i++) {
            if (secondArrPosition < secondArrayLength && firstArrPosition < firstArrayLength) {
                if (firstArray[firstArrPosition] > secondArray[secondArrPosition]) {
                    resultArray[i] = secondArray[secondArrPosition];
                    secondArrPosition++;
                } else {
                    resultArray[i] = firstArray[firstArrPosition];
                    firstArrPosition++;
                }
            } else if (secondArrPosition < secondArrayLength) {
                resultArray[i] = secondArray[secondArrPosition];
                secondArrPosition++;
            } else {
                resultArray[i] = firstArray[firstArrPosition];
                firstArrPosition++;
            }
        }
        return resultArray;
    }


    /**
     * Method for sorting array with quick sort
     * BigO of this algorithm is O(n log(n)) at best
     * or O(n^2) in worst way
     *
     * @param vector
     * @return sorted {@code array} by ascending
     * if array length < 2 will return received {@code array}
     * @throws WrongArgumentsException if array == null
     */
    public void quickSort(Vector vector) throws WrongArgumentsException, NoSuchElementException {
        if (!validator.validate(vector)) {
            LOGGER.warn("Method quickSort() receive wrong parameters! (array == null)");
            throw new WrongArgumentsException("Method quickSort() received wrong parameters!(array == null)");
        }

        double[] array = vector.getVector();
        int startIndex = 0;
        int endIndex = array.length - 1;

        doQuickSort(array, startIndex, endIndex);
    }

    /**
     * Private method that calling from quickSort.
     * Recursion method.
     *
     * @param array
     * @param leftBorder  {@code int}}
     * @param rightBorder {@code int}
     */
    private void doQuickSort(double[] array, int leftBorder, int rightBorder) {
        if (leftBorder >= rightBorder) {
            return;
        }

        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        double value = array[(leftMarker + rightMarker) / 2];

        while (leftMarker <= rightMarker) {
            while (array[leftMarker] < value) {
                leftMarker++;
            }

            while (array[rightMarker] > value) {
                rightMarker--;
            }

            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    double temp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = temp;
                }
                leftMarker++;
                rightMarker--;
            }
        }
        //recursion for parts
        if (leftMarker < rightBorder) {
            doQuickSort(array, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            doQuickSort(array, leftBorder, rightMarker);
        }
    }

}
