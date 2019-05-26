package by.chekun.numberInverting;

import by.chekun.parsingNumbers.ParsingNumbers;

/**
 * @author Chekun
 */
public class NumbersInverting {

    /**
     * Public method for inverting numbers
     *
     * @param number ({@code int}  number for inverting
     * @return {@code int} Inverted number
     */
    public static int getInvertedNumber(int number) {

        int invertedNumber = 0;

        int one = ParsingNumbers.getNumeral(number, 1);
        int two = ParsingNumbers.getNumeral(number, 2);
        int three = ParsingNumbers.getNumeral(number, 3);
        int four = ParsingNumbers.getNumeral(number, 4);
        int five = ParsingNumbers.getNumeral(number, 5);
        int six = ParsingNumbers.getNumeral(number, 6);
        int seven = ParsingNumbers.getNumeral(number, 7);

        invertedNumber += addNumeral(one, 7);
        invertedNumber += addNumeral(two, 6);
        invertedNumber += addNumeral(three, 5);
        invertedNumber += addNumeral(four, 4);
        invertedNumber += addNumeral(five, 3);
        invertedNumber += addNumeral(six, 2);
        invertedNumber += addNumeral(seven, 1);

        return invertedNumber;
    }

    /**
     * Private method for adding numeral to the desired position
     *
     * @param numeral  {@code int} Numeral for adding to the final inverted number
     * @param position {@code int} Position of {@link @param#numeral}
     * @return {@code int} New part of the number
     */
    private static int addNumeral(int numeral, int position) {
        return numeral * (int) Math.pow(10, position - 1);
    }
}
