package by.chekun;


import by.chekun.action.calculationAverageValue.CalculateAverageValue;
import by.chekun.action.parsingNumbers.ParsingNumbers;
import by.chekun.printer.Printer;
import by.chekun.action.mathCalculations.MathCalculations;

/**
 * Написать программу, которая находит арифметическое и геометрическое среднее цифр положительного шестизначного числа.
 */

public class Starter {

    public static void main(String[] argc) {

        int number = 138_652;

        if (number >= 100_000 && number <= 999_999) {

            int one = ParsingNumbers.getNumeral(number, 6);
            int two = ParsingNumbers.getNumeral(number, 5);
            int three = ParsingNumbers.getNumeral(number, 4);
            int four = ParsingNumbers.getNumeral(number, 3);
            int five = ParsingNumbers.getNumeral(number, 2);
            int six = ParsingNumbers.getNumeral(number, 1);
            {
                int sumOfNumerals = MathCalculations.calculateSum(one, two, three, four, five, six);
                double arithmeticAverageValue = CalculateAverageValue.calculateArithmeticAverageValue(sumOfNumerals, 6);
                Printer.println("Arithmetic average value of " + number + " is " + arithmeticAverageValue + "\n");
            }

            {
                int compositionOfNumerals = MathCalculations.calculateComposition(one, two, three, four, five, six);
                double geometricAverageValue = CalculateAverageValue.calculateGeometricAverageValue(compositionOfNumerals, 6);
                Printer.println("Geometric average value of " + number + " is " + geometricAverageValue + "\n");
            }
        } else {
            Printer.println("Число должно быть положительным и шестизначным");
        }
    }


}

