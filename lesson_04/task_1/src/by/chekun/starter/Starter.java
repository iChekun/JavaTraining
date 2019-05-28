package by.chekun.starter;


import by.chekun.action.CheckNumbersAction;
import by.chekun.printer.Printer;

/**
 * Develop a program that check three (a, b, c) number on equaling (not equaling)
 */

public class Starter {

    public static void main(String[] argc) {
        double a = 3.45;
        double b = 1;
        double c = 3.45;

        String info = CheckNumbersAction.checkEqualsToString(a, b, c);
        Printer.println(info);

        a = 2;
        b = 2;
        c = 2;

        Printer.println("Is numbers " + a + ", " + b + ", " + c + " equals? -> "
                + CheckNumbersAction.isNumbersEquals(a, b, c));

        a = 3;
        b = 4;
        c = 3;

        Printer.println("Is numbers " + a + ", " + b + ", " + c + " equals? -> "
                + CheckNumbersAction.isNumbersEquals(a, b, c));
    }
}
