package by.chekun.starter;

import by.chekun.numberInverting.NumbersInverting;
import by.chekun.printer.Printer;

/**
 * Написать программу, которая переворачивает положительное семизначное число
 * (к примеру, число 1234567 переворачивает в число 7654321).
 *
 * @author Chekun
 */
public class Starter {

    public static void main(String[] argc) {

        int number = 1234567;

        if ((number >= 1_000_000) && (number <= 9_999_999)) {
            Printer.println("Первоначальное число: " + number + "\n" +
                    "Перевернутое число: " + NumbersInverting.getInvertedNumber(number));
        } else {
            Printer.println("Число должно быть семизначное и положительно!");
        }
    }
}
