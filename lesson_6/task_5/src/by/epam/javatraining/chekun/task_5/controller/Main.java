package by.epam.javatraining.chekun.task_5;

import by.epam.javatraining.chekun.task_5.model.NumberLogic;
import by.epam.javatraining.chekun.task_5.view.Printer;

public class Main {

    public static void main(String[] argc) {
        int number = 3571;

        Printer.print("Is " + number + " simple ? -> " + NumberLogic.isSimpleNumber(number));
    }
}
