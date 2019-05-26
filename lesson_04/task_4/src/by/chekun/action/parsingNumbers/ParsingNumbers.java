package by.chekun.action.parsingNumbers;

/**
 * The class is used to select a numeral from a number
 *
 * @author Chekun
 */
public class ParsingNumbers {

    /**
     * @param number   {@code int} Number for parsing
     * @param position {@code int} Position of the desired digit
     * @return {@code int} numeral from entered position
     */
    public static int getNumeral(int number, int position) {

        number /= (int) Math.pow(10, position - 1);

        return number % 10;
    }
}
