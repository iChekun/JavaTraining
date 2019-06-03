package by.epam.javatraining.chekun.task01.model;


public class DragonLogic {

    private static int INVALID_DATA = -1;
    private static int COUNT_OF_EYES = 2;
    private static int SECOND_LIFE_PERIOD = 200;
    private static int THIRD_LIFE_PERIOD = 300;
    private static int NUMBER_HEADS_AT_BIRTH = 3;
    private static int NUMBER_HEADS_UP_TO_TWO_SECOND_LIFE_PERIOD = 200;
    private static int NUMBER_HEADS_UP_TO_THIRD_FILE_PERIOD = 500;
    private static int NUMBER_HEADS_EVERY_YEAR_BEFORE_SECOND_LIFE_PERIOD = 3;
    private static int NUMBER_HEADS_EVERY_YEAR_BEFORE_THIRD_LIFE_PERIOD = 2;


    public static int calculateCountOfDragonHeads(int dragonAge) {
        int result = INVALID_DATA;

        if (dragonAge >= 0) {

            if (dragonAge < SECOND_LIFE_PERIOD) {

                result = NUMBER_HEADS_EVERY_YEAR_BEFORE_SECOND_LIFE_PERIOD * dragonAge
                        + NUMBER_HEADS_AT_BIRTH;

            } else if (dragonAge < THIRD_LIFE_PERIOD) {

                result = NUMBER_HEADS_AT_BIRTH + NUMBER_HEADS_UP_TO_TWO_SECOND_LIFE_PERIOD
                        + dragonAge * NUMBER_HEADS_EVERY_YEAR_BEFORE_THIRD_LIFE_PERIOD;

            } else {
                result = NUMBER_HEADS_AT_BIRTH + NUMBER_HEADS_UP_TO_THIRD_FILE_PERIOD + dragonAge;
            }
        }
        return result;

    }

    public static int calculateCountOfDragonEyes(int dragonAge) {
        if (dragonAge >= 0) {
            return calculateCountOfDragonHeads(dragonAge) * COUNT_OF_EYES;
        } else {
            return INVALID_DATA;
        }
    }
}
