package by.epam.javatraining.chekun.task_1.controller;

import by.epam.javatraining.chekun.task_1.model.HeadsOrTails;
import by.epam.javatraining.chekun.task_1.view.Printer;

public class Main {

    public static void main(String[] argc) {
        int range = 1000;

        int tailsCount = HeadsOrTails.getTailsCount(range);

        Printer.print("Count of tails: " + tailsCount
                + "\nCount of eagles: " + (range - tailsCount));
    }
}
