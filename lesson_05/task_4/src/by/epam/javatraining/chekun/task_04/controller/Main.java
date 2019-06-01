package by.epam.javatraining.chekun.task_04.controller;

import by.epam.javatraining.chekun.task_04.model.action.CustomDateLogic;
import by.epam.javatraining.chekun.task_04.model.entity.CustomDate;
import by.epam.javatraining.chekun.task_04.model.exception.WrongArgumentsException;
import by.epam.javatraining.chekun.task_04.view.Printer;

public class Main {

    public static void main(String[] argc) {

        CustomDate customDate = new CustomDate(28, 2, 2007);
        try {
            Printer.print("Today: " + customDate
                    + "\nTomorrow: " + CustomDateLogic.getNextDayDate(customDate));
        } catch (WrongArgumentsException e) {
            Printer.print(e.getMessage()); // or any view like logger
        }
    }
}
