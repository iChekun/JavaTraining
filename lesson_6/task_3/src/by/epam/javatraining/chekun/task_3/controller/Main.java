package by.epam.javatraining.chekun.task_3.controller;


import by.epam.javatraining.chekun.task_3.model.FactorialLogic;
import by.epam.javatraining.chekun.task_3.view.Printer;

public class Main {

    public static void main(String[] argc) {

        int number = 10;
        Printer.print("Factorial of " + number + " is " + FactorialLogic.getFactorial_long(number));

        number = 20;
        Printer.print("Factorial with bigInteger of " + number + " is " + FactorialLogic.getFactorial_BigInteger(number));
    }
}
