package by.epam.javatraining.chekun.task_2.controller;

import by.epam.javatraining.chekun.task_2.model.CheckingSequence;
import by.epam.javatraining.chekun.task_2.view.Printer;

public class Main {

    public static void main(String[] argc) {

        int number = 9871;

        Printer.print("Is numerals of " + number + " has sequence decreased?->"
                + CheckingSequence.isSequenceDecreases(number));

        number = 1234;
        Printer.print("Is numerals of " + number + " has sequence growing?->"
                + CheckingSequence.isSequenceGrowing(number));
    }
}
