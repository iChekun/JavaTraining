package by.epam.javatraining.chekun;

import by.epam.javatraining.chekun.model.action.NumberLogic;
import by.epam.javatraining.chekun.model.exception.WrongArgumentsException;
import by.epam.javatraining.chekun.view.Printer;

public class Main {

    public static void main(String[] argc) {
        long number = 8128;

        try {
            Printer.print("Count of even numerals: " + NumberLogic.calculateCountOfEvenNumeralsInNumber(number));
            Printer.print("Multiplication of numerals: " + NumberLogic.calculateMultiplicationNumeralsOfNumber(number));
            Printer.print("Sum of numerals: " + NumberLogic.calculateSumNumeralsOfNumber(number));
            Printer.print("Arithmetic sum of numerals: " + NumberLogic.calculateArithmeticSumNumeralsOfNumber(number));
            Printer.print("Geometric average value of numerals: " + NumberLogic.calculateGeometricAverageValueNumeralsOfNumber(number));
            Printer.print("Is palindromeL " + NumberLogic.isNumberPalindrom(number));
            Printer.print("is all numerals equals? " + NumberLogic.isAllNumeralsOfNumberEquals(number));
            Printer.print("Max numeral is: " + NumberLogic.findMaxNumeralInNumber(number));
            Printer.print("is number perfect? -> " + NumberLogic.isNumberPerfect(number));
        } catch (WrongArgumentsException ex) {
            Printer.print(ex.getMessage());
        }
    }
}
