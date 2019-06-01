package by.epam.javatraining.chekun.task01.model;


public class DragonLogic {

    private static int INVALID_DATA = -1;
    private static int COUNT_OF_EYES = 2;
    private static int TWO_HUNDREDS_YEARS = 200;
    private static int THREE_HUNDREDS_YEARS = 300;
    private static int ZERO_YEARS = 0;
    private static int NUMBER_HEADS_AT_BIRTH = 3;
    private static int NUMBER_HEADS_UP_TO_TWO_HUNDREDS_YEARS = 200;
    private static int NUMBER_HEADS_UP_TO_THREE_HUNDREDS_YEARS = 500;
    private static int NUMBER_HEADS_EVERY_YEAR_BEFORE_TWO_HUNDREDS = 3;
    private static int NUMBER_HEADS_EVERY_YEAR_BEFORE_THREE_HUNDREDS = 2;


    public static int calculateCountOfDragonHeads(int dragonAge) {

        if (dragonAge >= ZERO_YEARS) {

            if (dragonAge < TWO_HUNDREDS_YEARS) {

                return NUMBER_HEADS_EVERY_YEAR_BEFORE_TWO_HUNDREDS * dragonAge
                        + NUMBER_HEADS_AT_BIRTH;

            } else if (dragonAge >= TWO_HUNDREDS_YEARS
                    && dragonAge < THREE_HUNDREDS_YEARS) {

                return NUMBER_HEADS_AT_BIRTH + NUMBER_HEADS_UP_TO_TWO_HUNDREDS_YEARS
                        + dragonAge * NUMBER_HEADS_EVERY_YEAR_BEFORE_THREE_HUNDREDS;

            } else {
                return NUMBER_HEADS_AT_BIRTH + NUMBER_HEADS_UP_TO_THREE_HUNDREDS_YEARS + dragonAge;
            }

        } else {
            return INVALID_DATA;
        }
    }

    public static int calculateCountOfDragonEyes(int dragonAge) {
        if (dragonAge >= 0) {
            return calculateCountOfDragonHeads(dragonAge) * COUNT_OF_EYES;
        } else {
            return INVALID_DATA;
        }
    }
}
