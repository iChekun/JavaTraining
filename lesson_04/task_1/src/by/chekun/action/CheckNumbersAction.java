package by.chekun.action;

/**
 * Class for comparing numbers for equality
 *
 * @author Chekun
 */
public class CheckNumbersAction {

    /**
     * @param a {@code int} first number
     * @param b {@code int} second number
     * @param c {@code int} third number
     * @return {@code String} String line with answer which numbers are equals
     */
    public static String checkEqualsToString(double a, double b, double c) {
        String info = "\nNumbers equals!\n";

        if (a != b && b != c && a != c) {
            info = "Numbers not equals!\n";
        } else if (a == b && b != c && a != c) {
            info = "A  and B is equals (" + a + " == " + b + ") " + "and" +
                    " b != c (" + b + " != " + c + ") " +
                    "&& a != c (" + a + "!= " + c + ").";
        } else if (a != b && b == c && a != c) {
            info = "B  and C is equals (" + b + "==" + c + ") " + "and" +
                    " a != b (" + a + " != " + b + ") " +
                    "&& a != c (" + a + "!= " + c + ").";
        } else if (a != b && b != c && a == c) {
            info = "A  and C is equals (" + a + "==" + c + ") " + "and" +
                    " a != b (" + a + " != " + b + ") " +
                    "&& b != c (" + b + " != " + c + ").";
        }
        return info;
    }

    /**
     * @param a {@code int} first number
     * @param b {@code int} second number
     * @param c {@code int}third number
     * @return {@code boolean} true or false (equals or not)
     */
    public static boolean isNumbersEquals(double a, double b, double c) {
        return a == b && b == c;
    }
}
