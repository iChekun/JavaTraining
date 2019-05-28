package by.chekun.action;

import static java.lang.Math.pow;

/**
 * Using for checking sequences and definition her type
 *
 * @author Chekun
 */
public class CheckingSequencesType {

    private static final int NUMERICAL_POSITION_THOUSANDS = 4;
    private static final int NUMERICAL_POSITION_HUNDREDS = 3;
    private static final int NUMERICAL_POSITION_TENS = 2;
    private static final int NUMERICAL_POSITION_UNITS = 1;

    /**
     * Private function which helps in parsing numbers
     * and returns answer about sequence type of numerals in number.
     *
     * @param number {@code int} Number for parsing
     * @return {@code  boolean }
     */
    public static boolean isSequenceGrowing(int number) {

        int firstNumeral = getNumeral(number, NUMERICAL_POSITION_THOUSANDS);
        int secondNumeral = getNumeral(number, NUMERICAL_POSITION_HUNDREDS);
        int thirdNumeral = getNumeral(number, NUMERICAL_POSITION_TENS);
        int fourthNumeral = getNumeral(number, NUMERICAL_POSITION_UNITS);

        return firstNumeral < secondNumeral
                && secondNumeral < thirdNumeral
                && thirdNumeral < fourthNumeral;
    }

    /**
     * Private method for parsing numbers and take numerals by position.
     *
     * @param number   {@code int} Number for parsing
     * @param position {@code int} Position of the desired digit
     * @return {@code int}  numeral from entered position
     */
    private static int getNumeral(int number, int position) {

        number /= (int) pow(10, position - 1);

        return number % 10;
    }
}
