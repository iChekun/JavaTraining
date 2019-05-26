package by.chekun.action.circleAction;

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
            return Math.PI * Math.pow(radius, 2);
        } else {
            return -1;
        }
    }
}
