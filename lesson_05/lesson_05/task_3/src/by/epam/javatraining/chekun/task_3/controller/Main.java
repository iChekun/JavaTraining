package by.epam.javatraining.chekun.task_3.controller;

import by.epam.javatraining.chekun.task_3.model.MoodCheckerLogic;
import by.epam.javatraining.chekun.task_3.view.Printer;

public class Main {

    public static void main(String[] argc) {

        for(int i=0;i<11;i++)
        Printer.print(MoodCheckerLogic.chooseMoodToString());

    }
}
