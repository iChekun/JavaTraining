package by.chekun.action.ringAction;

/**
 * Using for calculating ring square
 *
 * @author Chekun
 * @version 1.0
 */
public class RingLogic {

    /**
     * @param firstCircleSquare  {@code double} Square of the first circle.
     *                           The value must be greater than the second parameter.
     * @param secondCircleSquare {@code double} Square of the second circle
     * @return ring square or -1 if bad params
     */
    public static double calculateRingSquare(double firstCircleSquare, double secondCircleSquare) {
        if (firstCircleSquare > secondCircleSquare) {
            return (firstCircleSquare - secondCircleSquare);
        } else {
            return -1;
        }
    }
}
