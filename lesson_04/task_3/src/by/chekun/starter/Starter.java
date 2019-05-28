package by.chekun.starter;

import by.chekun.action.CheckingSequencesType;
import by.chekun.printer.Printer;

/**
 * @author Chekun
 * Develop a program that verifies that the digits are a positive four-digit number.
 */

public class Starter {

    public static void main(String[] argc) {

        int number = 3456;

        if ((number >= 1000) && (number <= 9999)) {

            Printer.println("Number " + number + ". Is sequences growing ? -> "
                    + CheckingSequencesType.isSequenceGrowing(number));

            number = 7654;
            Printer.println("Number " + number + ". Is sequences growing ? -> "
                    + CheckingSequencesType.isSequenceGrowing(number));

            number = 7777;
            Printer.println("Number " + number + ". Is sequences growing ? -> "
                    + CheckingSequencesType.isSequenceGrowing(number));
        }
    }
}

