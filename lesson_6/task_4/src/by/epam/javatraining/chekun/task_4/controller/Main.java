package by.epam.javatraining.chekun.task_4.controller;

import by.epam.javatraining.chekun.task_4.model.NumberLogic;
import by.epam.javatraining.chekun.task_4.view.Printer;

public class Main {

    public static void main(String[] argc) {

        int number = 1579792797;
        Printer.print("are all numerals even or odd in the " + number + " ?-> "
                + NumberLogic.isAllNumeralsEvenOrOdd(number));
        number = 2468;
        Printer.print("are all numerals even or odd in the " + number + " ?-> "
                + NumberLogic.isAllNumeralsEvenOrOdd(number));
    }
}
