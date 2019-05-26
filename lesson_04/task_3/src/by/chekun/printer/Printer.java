package by.chekun.printer;

/**
 * Use for displaying message on console
 *
 * @author Chekun
 */
public class Printer {
    /**
     * Use for displaying message and move to the next line
     *
     * @param line {@code String}
     */
    public static void println(String line) {
        System.out.println(line);
    }

    /**
     * Use for displaying message in current line
     *
     * @param line {@code String}
     */
    public static void print(String line) {
        System.out.println(line);
    }
}