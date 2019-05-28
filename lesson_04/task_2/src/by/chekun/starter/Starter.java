package by.chekun.starter;

import by.chekun.action.CircleLogic;
import by.chekun.action.RingLogic;
import by.chekun.printer.Printer;

/**
 * On the plane are two circles with a common center and radius of R1 and R2.
 * Develop program for finding the area of the ring, the outer * radius of this is R1 ,
 * and inner radius - R2
 */

public class Starter {

    public static void main(String[] argc) {
        double outerCircleRadius = 10;
        double innerCircleRadius = 5;

        double firstCircleSquare = CircleLogic.calculateCircleSquare(outerCircleRadius);
        double secondCircleSquare = CircleLogic.calculateCircleSquare(innerCircleRadius);
        double ringSquare = RingLogic.calculateRingSquare(firstCircleSquare, secondCircleSquare);

        Printer.println("Square of outer circle: " + firstCircleSquare +
                "\nSquare of inner circle: " + secondCircleSquare +
                "\nRing square: " + ringSquare);
    }
}
