package by.chekun.starter;


import by.chekun.action.CalculateAverageValue;
import by.chekun.printer.Printer;

/**
 * Write a program that calculates the mathematical and geometric average of a positive six-digit number.
 */

public class Starter {

    public static void main(String[] argc) {

        int number = 138_652;

        if (number >= 100_000 && number <= 999_999) {

            {
                double arithmeticAverageValue = CalculateAverageValue.calculateArithmeticAverageValue(number);
                Printer.println("Arithmetic average value of " + number + " is " + arithmeticAverageValue + "\n");
            }
            {
                double geometricAverageValue = CalculateAverageValue.calculateGeometricAverageValue(number);
                Printer.println("Geometric average value of " + number + " is " + geometricAverageValue + "\n");
            }
        } else {
            Printer.println("Number must be positive and six-digit!");
        }
    }
}

