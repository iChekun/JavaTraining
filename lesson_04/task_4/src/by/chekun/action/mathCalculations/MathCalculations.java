package by.chekun.action.mathCalculations;


/**
 * Class used to calculate sum and composition of numbers
 *
 * @author Chekun
 */
public class MathCalculations {

    /**
     * Sum of numbers
     *
     * @param one   {@code int}
     * @param two   {@code int}
     * @param three {@code int}
     * @param four  {@code int}
     * @param five  {@code int}
     * @param six   {@code int}
     * @return {@code int} Sum of numbers
     */
    public static int calculateSum(int one, int two, int three, int four, int five, int six) {
        return one + two + three + four + five + six;
    }

    /**
     * Composition of numbers
     *
     * @param one   {@code int}
     * @param two   {@code int}
     * @param three {@code int}
     * @param four  {@code int}
     * @param five  {@code int}
     * @param six   {@code int}
     * @return {@code int} Multiplication of numbers
     */
    public static int calculateComposition(int one, int two, int three, int four, int five, int six) {
        return one * two * three * four * five * six;
    }
}
