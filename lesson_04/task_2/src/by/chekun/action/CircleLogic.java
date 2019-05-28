package by.chekun.action;

import static java.lang.Math.PI;

/**
 * Using for calculate circle square
 *
 * @author Chekun
 * @version 1.
 */
public class CircleLogic {

    /**
     * Method for calculate circle square.
     *
     * @param radius {@code double} using to calculate square
     * @return circle square or -1 if bad params
     */
    public static double calculateCircleSquare(double radius) {
        if (radius > 0) {
            return PI * radius * radius;
        } else {
            return -1;
        }
    }
}
