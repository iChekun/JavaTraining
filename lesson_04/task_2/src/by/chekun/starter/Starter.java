package by.chekun.starter;

import by.chekun.action.circleAction.CircleLogic;
import by.chekun.action.ringAction.RingLogic;
import by.chekun.printer.Printer;

/**
 * На плоскости даны два круга с общим центром и радиусами R1 и R2 (R1 > R2).
 * Разработайте программу нахождения площади кольца,
 * внешний радиус которого равен R1,  а внутренний радиус равен R2.
 */

public class Starter {

    public static void main(String[] argc) {
        double R1 = 10;
        double R2 = 5;

        double firstCircleSquare = CircleLogic.calculateCircleSquare(R1);
        double secondCircleSquare = CircleLogic.calculateCircleSquare(R2);
        double ringSquare = RingLogic.calculateRingSquare(firstCircleSquare, secondCircleSquare);

        Printer.println("Площадь внешнего круга: " + firstCircleSquare +
                "\nПлощадь внутреннего круга: " + secondCircleSquare +
                "\nПлощадь кольца: " + ringSquare);
    }
}
