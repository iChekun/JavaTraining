package by.epam.javatraining.chekun.task_1.model;

import java.util.Random;


public class HeadsOrTails {
    private static final int WRONG_PARAMETERS = -1;
    private static final int COIN_SIDES = 2;


    public static int getTailsCount(int range) {

        if (range > 0) {
            Random random = new Random();
            int tailsCount = 0;

            for (int i = 0; i < range; i++) {
                tailsCount += random.nextInt(COIN_SIDES);
            }

            return tailsCount;
        }

        return WRONG_PARAMETERS;
    }
}
