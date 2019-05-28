package by.chekun.action;

import static java.lang.Math.pow;

/**
 * Class for getting inverted number
 *
 * @author Chekun
 */
public class NumbersInverting {

    private static final int NUMERICAL_POSITION_OF_TENS_THOUSANDS = 7;
    private static final int NUMERICAL_POSITION_OF_HUNDREDS_OF_THOUSANDS = 6;
    private static final int NUMERICAL_POSITION_OF_TENS_OF_THOUSANDS = 5;
    private static final int NUMERICAL_POSITION_THOUSANDS = 4;
    private static final int NUMERICAL_POSITION_HUNDREDS = 3;
    private static final int NUMERICAL_POSITION_TENS = 2;
    private static final int NUMERICAL_POSITION_UNITS = 1;

    /**
     * Public method for inverting numbers
     *
     * @param number ({@code int}  number for inverting
     * @return {@code int} Inverted number
     */
    public static int getInvertedNumber(int number) {

        int firstNumeral = getNumeral(number, NUMERICAL_POSITION_UNITS);
        int secondNumeral = getNumeral(number, NUMERICAL_POSITION_TENS);
        int thirdNumeral = getNumeral(number, NUMERICAL_POSITION_HUNDREDS);
        int fourthNumeral = getNumeral(number, NUMERICAL_POSITION_THOUSANDS);
        int fifthNumeral = getNumeral(number, NUMERICAL_POSITION_OF_TENS_OF_THOUSANDS);
        int sixthNumeral = getNumeral(number, NUMERICAL_POSITION_OF_HUNDREDS_OF_THOUSANDS);
        int seventhNumeral = getNumeral(number, NUMERICAL_POSITION_OF_TENS_THOUSANDS);

        int invertedNumber = addNumeral(firstNumeral, NUMERICAL_POSITION_OF_TENS_THOUSANDS);
        invertedNumber += addNumeral(secondNumeral, NUMERICAL_POSITION_OF_HUNDREDS_OF_THOUSANDS);
        invertedNumber += addNumeral(thirdNumeral, NUMERICAL_POSITION_OF_TENS_OF_THOUSANDS);
        invertedNumber += addNumeral(fourthNumeral, NUMERICAL_POSITION_THOUSANDS);
        invertedNumber += addNumeral(fifthNumeral, NUMERICAL_POSITION_HUNDREDS);
        invertedNumber += addNumeral(sixthNumeral, NUMERICAL_POSITION_TENS);
        invertedNumber += addNumeral(seventhNumeral, NUMERICAL_POSITION_UNITS);

        return invertedNumber;
    }

    /**
     * Private method for adding numeral to the desired position
     *
     * @param numeral  {@code int} Numeral for adding to the final inverted number
     * @param position {@code int} Position of {@link {@param numeral}}
     * @return {@code int} New part of the number
     */
    private static int addNumeral(int numeral, int position) {
        return numeral * (int) pow(10, position - 1);
    }


    /**
     * @param number   (@code int) Number for parsing
     * @param position (@code int) Position of the desired digit
     * @return numeral from entered position
     */
    private static int getNumeral(int number, int position) {

        number /= (int) pow(10, position - 1);

        return number % 10;
    }
}
