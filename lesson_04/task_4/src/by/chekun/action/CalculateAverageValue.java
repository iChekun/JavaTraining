package by.chekun.action;


import static java.lang.Math.exp;
import static java.lang.Math.log;
import static java.lang.Math.pow;

/**
 * The class used to calculate the arithmetic and geometric average value of number.
 *
 * @author Chekun
 */
public class CalculateAverageValue {

    private static final int NUMERICAL_POSITION_OF_HUNDREDS_OF_THOUSANDS = 6;
    private static final int NUMERICAL_POSITION_OF_TENS_OF_THOUSANDS = 5;
    private static final int NUMERICAL_POSITION_THOUSANDS = 4;
    private static final int NUMERICAL_POSITION_HUNDREDS = 3;
    private static final int NUMERICAL_POSITION_TENS = 2;
    private static final int NUMERICAL_POSITION_UNITS = 1;

    private static final int COUNT_OF_NUMERALS = 6;

    /**
     * @param number {@code int}
     * @return {@code double} Arithmetic average value of number
     */
    public static double calculateArithmeticAverageValue(int number) {

        int firstNumeral = getNumeral(number, NUMERICAL_POSITION_OF_HUNDREDS_OF_THOUSANDS);
        int secondNumeral = getNumeral(number, NUMERICAL_POSITION_OF_TENS_OF_THOUSANDS);
        int thirdNumeral = getNumeral(number, NUMERICAL_POSITION_THOUSANDS);
        int fourthNumeral = getNumeral(number, NUMERICAL_POSITION_HUNDREDS);
        int fifthNumeral = getNumeral(number, NUMERICAL_POSITION_TENS);
        int sixthNumeral = getNumeral(number, NUMERICAL_POSITION_UNITS);

        double sumOfNumerals = firstNumeral + secondNumeral +
                thirdNumeral + fourthNumeral + fifthNumeral + sixthNumeral;

        return sumOfNumerals / COUNT_OF_NUMERALS;
    }

    /**
     * Method uses formula Math.pow(n, 1.0 / i) but with Log in 3 times faster
     *
     * @param number {@code int}
     * @return {@code double}  Geometric average value
     */
    public static double calculateGeometricAverageValue(int number) {

        int firstNumeral = getNumeral(number, NUMERICAL_POSITION_OF_HUNDREDS_OF_THOUSANDS);
        int secondNumeral = getNumeral(number, NUMERICAL_POSITION_OF_TENS_OF_THOUSANDS);
        int thirdNumeral = getNumeral(number, NUMERICAL_POSITION_THOUSANDS);
        int fourthNumeral = getNumeral(number, NUMERICAL_POSITION_HUNDREDS);
        int fifthNumeral = getNumeral(number, NUMERICAL_POSITION_TENS);
        int sixthNumeral = getNumeral(number, NUMERICAL_POSITION_UNITS);

        int compositionOfNumerals = firstNumeral * secondNumeral *
                thirdNumeral * fourthNumeral * fifthNumeral * sixthNumeral;

        return exp(log(compositionOfNumerals) / COUNT_OF_NUMERALS);
    }

    /**
     * @param number   {@code int} Number for parsing
     * @param position {@code int} Position of the desired digit
     * @return {@code int} numeral from entered position
     */
    private static int getNumeral(int number, int position) {

        number /= (int) pow(10, position - 1);

        return number % 10;
    }
}
