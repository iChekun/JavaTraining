package by.epam.javatraining.chekun.maintask01.model.action;

import by.epam.javatraining.chekun.maintask01.model.exception.WrongArgumentsException;
import org.apache.log4j.Logger;

import java.util.Arrays;


/**
 * Class has methods manipulation with vectors.
 * Class contain six types of sorting:
 * - bubble sort     - shaker sort (upgrading bubble sort)
 * - insertion sort  - merge sort  - quick sort
 * Also class contain two types of search:
 * -linear search  -binary search
 *
 * <p> Some method from class can throw {@code WrongArgumentsException}
 *
 * @author Chekun Ilya
 * @version 1.0
 */
public class VectorLogic {


    private static final Logger LOGGER = Logger.getLogger(VectorLogic.class);

    /**
     * Can be return if in method {@see findLocalMinPosition}
     * or {@see findLocalMaxPosition} have not local minimum or maximum
     */
    public static final int NO_LOCAL_MIN_OR_MAX_VALUE = -1;

    /**
     * Can be return from {@see findValuePositionLinearSearch} or {@see findValue Position BinarySearch}
     * if given value will do not found
     */
    public static final int NO_SUCH_ELEMENT_IN_ARRAY = -1;

    /**
     * Can be return if received array length will = 1.
     * Also using for testing
     */
    public static final int FIRST_POSITION_ARRAY = 0;


    /**
     * Method receive array and returns MAX value from it
     *
     * @param array {@code double[]} array for search
     * @return max value from array
     * @throws WrongArgumentsException if array == null or  if array length = 0
     */
    public static double findMaxValue(double[] array) throws WrongArgumentsException {
        if (array == null || array.length == 0) {
            LOGGER.error("Method findMaxValue() received wrong parameters! (array == null or array.length==0)");
            throw new WrongArgumentsException("Method findMaxValue() received wrong parameters!" +
                    " (array == null or array.length==0)");
        }

        double maxValue = array[FIRST_POSITION_ARRAY];

        for (double i : array) {
            if (maxValue < i) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    /**
     * Method receive array and returns MIN value from it.
     *
     * @param array {@code double[]} array for search
     * @return min value from array
     * @throws WrongArgumentsException if array == null or  if array length = 0
     */
    public static double findMinValue(double[] array) throws WrongArgumentsException {
        if (array == null || array.length == 0) {
            LOGGER.error("Method findMinValue() received wrong parameters! (array == null or array.length==0)");
            throw new WrongArgumentsException("Method findMinValue() received wrong parameters!" +
                    " (array == null or array.length==0)");
        }

        double minValue = array[FIRST_POSITION_ARRAY];

        for (double i : array) {
            if (minValue > i) {
                minValue = i;
            }
        }
        return minValue;
    }


    /**
     * Method receive array and calculate arithmetic average value
     * (sum  of all values divided by their count)
     *
     * @param array {@code double[]} array for calculating
     * @return {@code double} arithmetic average value
     * if array.length = 0 return 0
     * @throws WrongArgumentsException if array == null
     */
    public static double calculateArithmeticAverageValue(double[] array) throws WrongArgumentsException {
        if (array == null) {
            LOGGER.error("Method calculateArithmeticAverageValue() received wrong parameters!(array == null)");
            throw new WrongArgumentsException("Method calculateArithmeticAverageValue() " +
                    "received wrong parameters! (array == null)");
        }
        if (array.length == 0) {
            return 0;
        }
        double sumOfValues = 0;

        for (double value : array) {
            sumOfValues += value;
        }

        return sumOfValues / array.length;
    }

    /**
     * Method receive array and calculate geometric average value
     * (The root of the count of all values from array  of the multiplication of all values)
     *
     * @param array {@code double[]} array for calculating
     * @return {@code double} geometric average value
     * if array.length = 0 return 0
     * @throws WrongArgumentsException if array == null
     */
    public static double calculateGeometricAverageValue(double[] array) throws WrongArgumentsException {
        if (array == null) {
            LOGGER.error("Method calculateGeometricAverageValue() received wrong parameters (array == null)");
            throw new WrongArgumentsException("Method calculateGeometricAverageValue() " +
                    "received wrong parameters! (array == null)");
        }
        if (array.length == 0) {
            return 0;
        }
        double compositionOfValues = 1;

        for (double value : array) {
            compositionOfValues *= value;
        }
        return Math.exp(Math.log(compositionOfValues) / array.length);
    }

    /**
     * Method receive array and return boolean answer is array sorted by ascending or no.
     *
     * @param array {@code double[]} Array for checking
     * @return true -> if array sorted by ascending
     * false -> if not sorted by ascending
     * false -> if array == null
     * if array.length  == 0 -> false
     */
    public static boolean isArraySortedByAscending(double[] array) {

        if (array == null) {
            LOGGER.error("Method isArraySortedByAscending() received wrong parameters (array == null)");
            return false;
        }
        if (array.length == 0) {
            return false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }


    /**
     * Method receive array and return boolean answer is array sorted or no.
     *
     * @param array {@code double[]} Array for checking
     * @return true -> if array sorted by ascending
     * true -> if array sorted by descending
     * false -> if not sorted by ascending or by descending
     * false -> if array == null
     * if array.length  == 0 -> false
     */
    public static boolean isArraySorted(double[] array) {
        if (array == null) {
            LOGGER.error("Method isArraySorted() received wrong parameters (array == null)");
            return false;
        }
        if (array.length == 0) {
            return false;
        }
        boolean flag = true;

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

    /**
     * Method for search position of first local MINIMUM value.
     *
     * @param array {@code double[]} Array for search
     * @return {@code int} Position of local MINIMUM
     * if array length = 1 position of first value from array
     * if array length = 2 than will check is first value smaller than second and return result
     * if method will not find local MINIMUM will return {@see NO_LOCAL_MIN_OR_MAX_VALUE}
     * @throws WrongArgumentsException if array == null or array.length == 0
     */
    public static int findLocalMinPosition(double[] array) throws WrongArgumentsException {
        if (array == null || array.length == 0) {
            LOGGER.error("Method findLocalMinPosition() received wrong parameters(array==null or array.length=0)");
            throw new WrongArgumentsException("Method findLocalMinPosition() received " +
                    "wrong parameters(array==null or array.length=0)");
        }

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

    /**
     * Method for search position of first local MAXIMUM value.
     *
     * @param array {@code double[]} Array for search
     * @return {@code int} Position of local MAXIMUM
     * if array length = 1 will return position of first value from array
     * if array length = 2 than will check is first value bigger than second and return result
     * if method will not find local MAXIMUM will return {@see NO_LOCAL_MIN_OR_MAX_VALUE}
     * @throws WrongArgumentsException if array == null or array.length == 0
     */
    public static int findLocalMaxPosition(double[] array) throws WrongArgumentsException {
        if (array == null || array.length == 0) {
            LOGGER.error("Method findLocalMaxPosition() received wrong parameters (array == null or array.length==0)");
            throw new WrongArgumentsException("Method findLocalMaxPosition() received " +
                    "wrong parameters(array==null or array.length=0)");
        }

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


    /**
     * Method for linear search in array
     * BigO notation of this algorithm is O(n) (is worst also O(n))
     *
     * @param array         {@code double[]} Array for search
     * @param valueToSearch {@code double} Sought value
     * @return {@code int) Position of searching value
     * @throws WrongArgumentsException if array == null
     */
    public static int findValuePositionLinearSearch(double[] array, double valueToSearch) throws WrongArgumentsException {
        if (array == null) {
            LOGGER.error("Method findValuePositionLinearSearch() received wrong parameters (array == null)");
            throw new WrongArgumentsException("Method findValuePositionLinearSearch() received " +
                    "wrong parameters(array==null)");
        }

        for (int position = 0; position < array.length; position++) {
            if (array[position] == valueToSearch) {
                return position;
            }
        }

        return NO_SUCH_ELEMENT_IN_ARRAY;
    }

    /**
     * Method for binary search in array.
     * Can work only with sorted array.
     * BigO notation of this algorithm is O(log(n)) (in worst also O(log(n))
     *
     * @param array         {@code double[]} Array for search
     * @param valueToSearch {@code double} Sought value
     * @return {@code int) Position of searching value
     * @throws WrongArgumentsException if array == null or array is not sorted
     */
    public static int findValuePositionBinarySearch(double[] array, double valueToSearch) throws WrongArgumentsException {

        if (array == null || !isArraySorted(array)) {
            LOGGER.error("Method findValuePositionBinarySearch() received wrong parameters " +
                    "(array == null or or array not sorted)");
            throw new WrongArgumentsException("Method findValuePositionBinarySearch() received wrong parameters " +
                    "(array == null or or array not sorted)");
        }

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


    /**
     * Method for reverse receive array.
     * i'm throwing exception because don't wanna return null.
     *
     * @param array {@code double[]} Array for reverse
     * @return {@code double[]} reverse array
     * if array = null will return {@see WRONG_ARGUMENT}
     * @throws WrongArgumentsException if array = null
     */
    public static double[] getReverseArray(double[] array) throws WrongArgumentsException {
        if (array == null) {
            LOGGER.error("Method getReverseArray() receive wrong parameters! (array == null)");
            throw new WrongArgumentsException("Method getReverseArray() received wrong parameters!(array == null)");
        }
        if (array.length < 2) {
            return array;
        }

        for (int i = 0; i < array.length / 2; i++) {
            double temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }


    /**
     * Method for sorting array by ascending with bubble sort.
     * BigO of algorithm is O(n^2)
     *
     * @param array {@code double[]}
     * @return sorted {@code array} by ascending
     * if array length < 2 will return received {@code array}
     * @throws WrongArgumentsException if array == null
     */
    public static double[] bubbleSort(double[] array) throws WrongArgumentsException {
        if (array == null) {
            LOGGER.error("Method bubbleSort() receive wrong parameters! (array == null)");
            throw new WrongArgumentsException("Method bubbleSort() received wrong parameters!(array == null)");
        }
        if (array.length < 2) {
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    double temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * Method for sorting array with shaker sort ( upgraded bubble sort)
     * BigO of this algorithm is O(n^2)
     *
     * @param array {@code double[]}
     * @return sorted {@code array} by ascending
     * if array length < 2 will return received {@code array}
     * @throws WrongArgumentsException if array == null
     */
    public static double[] shakerSort(double[] array) throws WrongArgumentsException {
        if (array == null) {
            LOGGER.error("Method shakerSort() receive wrong parameters! (array == null)");
            throw new WrongArgumentsException("Method shakerSort() received wrong parameters!(array == null)");
        }
        if (array.length < 2) {
            return array;
        }

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

        return array;
    }

    /**
     * Method for sorting array with insertion sort
     * </p>BigO of this algorithm is O(n^2)
     *
     * @param array {@code double[]}
     * @return sorted {@code array} by ascending
     * if array length < 2 will return received {@code array}
     * @throws WrongArgumentsException if array == null
     */
    public static double[] insertionSort(double[] array) throws WrongArgumentsException {
        if (array == null) {
            LOGGER.error("Method insertionSort() receive wrong parameters! (array == null)");
            throw new WrongArgumentsException("Method insertionSort() received wrong parameters!(array == null)");
        }
        if (array.length < 2) {
            return array;
        }

        for (int sortedPosition = 1; sortedPosition < array.length; sortedPosition++) {

            double value = array[sortedPosition];
            int notSortedPosition = sortedPosition;

            while (notSortedPosition > 0 && array[notSortedPosition - 1] > value) {
                array[notSortedPosition] = array[notSortedPosition - 1];
                notSortedPosition -= 1;
            }
            array[notSortedPosition] = value;
        }
        return array;
    }


    /**
     * Method for sorting array with selection sort
     * BigO of this algorithm is O(n^2)
     *
     * @param array {@code double[]}
     * @return sorted {@code array} by ascending
     * if array length < 2 will return received {@code array}
     * @throws WrongArgumentsException if array == null
     */
    public static double[] selectionSort(double[] array) throws WrongArgumentsException {
        if (array == null) {
            LOGGER.error("Method selectionSort() receive wrong parameters! (array == null)");
            throw new WrongArgumentsException("Method selectionSort() received wrong parameters!(array == null)");
        }
        if (array.length < 2) {
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            int minValuePosition = i;

            for (int j = i + 1; j < array.length; j++) {
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
        return array;
    }

    /**
     * Method for sorting array with merge sort
     * The method is called recursively until the array is divided into smaller sorted arrays.
     * BigO of this algorithm is O(n log(n))
     * Method using {@see Array.copyOfRange} for copy array from some position.
     *
     * @param array {@code double[]}
     * @return sorted {@code array} by ascending
     * if array length < 2 will return received {@code array}
     * @throws WrongArgumentsException if array == null
     */
    public static double[] sortMerge(double[] array) throws WrongArgumentsException {
        if (array == null) {
            LOGGER.error("Method sortMerge() receive wrong parameters! (array == null)");
            throw new WrongArgumentsException("Method sortMerge() received wrong parameters!(array == null)");
        }
        if (array.length < 2) {
            return array;
        }

        int middlePosition = array.length / 2;

        double[] firstArray = sortMerge(Arrays.copyOfRange(array, FIRST_POSITION_ARRAY, middlePosition));
        double[] secondArray = sortMerge(Arrays.copyOfRange(array, middlePosition, array.length));

        return merge(firstArray, secondArray);
    }

    /**
     * Private method that calling from sortMerge
     *
     * @param firstArray
     * @param secondArray
     * @return {@code double[]} Sorted array
     */
    private static double[] merge(double[] firstArray, double[] secondArray) {
        int firstArrayLength = firstArray.length;
        int secondArrayLength = secondArray.length;
        int firstArrPosition = 0;
        int secondArrPosition = 0;
        int finalArrayLength = firstArrayLength + secondArrayLength;
        double[] resultArray = new double[finalArrayLength];

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
     * @param array {@code double[]}
     * @return sorted {@code array} by ascending
     * if array length < 2 will return received {@code array}
     * @throws WrongArgumentsException if array == null
     */
    public static double[] quickSort(double[] array) throws WrongArgumentsException {
        if (array == null) {
            LOGGER.error("Method quickSort() receive wrong parameters! (array == null)");
            throw new WrongArgumentsException("Method quickSort() received wrong parameters!(array == null)");
        }
        if (array.length < 2) {
            return array;
        }

        int startIndex = 0;
        int endIndex = array.length - 1;

        doQuickSort(array, startIndex, endIndex);

        return array;
    }

    /**
     * Private method that calling from quickSort.
     * Recursion method.
     *
     * @param array
     * @param leftBorder  {@code int}}
     * @param rightBorder {@code int}
     */
    private static void doQuickSort(double[] array, int leftBorder, int rightBorder) {
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


