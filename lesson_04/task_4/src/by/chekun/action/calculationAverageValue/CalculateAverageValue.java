package by.chekun.action.calculationAverageValue;

/**
 * The class used to calculate the arithmetic and geometric average value of number.
 *
 * @author Chekun
 */
public class CalculateAverageValue {

    /**
     * @param sumOfNumerals  {@code int} Sum of numerals of number
     * @param countOfNumbers {@code int} Count of numerals
     * @return {@code double} Arithmetic average value of number
     */
    public static double calculateArithmeticAverageValue(int sumOfNumerals, int countOfNumbers) {
        return (double) sumOfNumerals / countOfNumbers;
    }

    /**
     * Method uses formula Math.pow(n, 1.0 / i) but with Log in 3 times faster
     *
     * @param compositionOfNumerals {@code int} Composition of numerals of number
     * @param countOfNumbers        {@code int} Count of numerals
     * @return {@code double}  Geometric average value
     */
    public static double calculateGeometricAverageValue(int compositionOfNumerals, int countOfNumbers) {
        return Math.exp(Math.log(compositionOfNumerals) / countOfNumbers);
    }
}
