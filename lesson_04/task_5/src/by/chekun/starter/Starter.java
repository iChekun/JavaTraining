package by.chekun.starter;

import by.chekun.action.NumbersInverting;
import by.chekun.printer.Printer;

/**
 * Write a program that reverses a positive seven-digit number
 *
 * @author Chekun
 */
public class Starter {

    public static void main(String[] argc) {

        int number = 1234567;

        if ((number >= 1_000_000) && (number <= 9_999_999)) {
            Printer.println("Original number: " + number + "\n" +
                    "Reversed number: " + NumbersInverting.getInvertedNumber(number));
        } else {
            Printer.println("Number must be positive and seven-digit!");
        }
    }
}
