package by.epam.javatraining.chekun.task_1.model;

import java.util.Random;


public class HeadsOrTails {
    private static final int WRONG_PARAMETERS = -1;

    private static final int COIN_SIDES = 2;
    private static int tailsCount = 0;


    public static int getTailsCount(int range) {

        Random random = new Random();

        if (range > 0) {
            for (int i = 0; i < range; i++) {
                tailsCount += random.nextInt(COIN_SIDES);
            }
            return tailsCount;
        }
        return WRONG_PARAMETERS;
    }

    public static int getHeadsCount(int range, int tailsCount) {
        if (tailsCount >= 0 && range > tailsCount) {
            return range - tailsCount;
        } else {
            return WRONG_PARAMETERS;
        }
    }
}
