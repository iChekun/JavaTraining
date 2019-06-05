package by.epam.javatraining.chekun.task_2.model;


public class CheckingSequence {


    public static boolean isSequenceGrowing(int number) {

        if (number < 10) {
            return false;
        }

        while (number / 10 != 0) {

            int currentNumeral = number % 10;
            int previousNumeral = (number / 10) % 10;

            if (previousNumeral < currentNumeral) {
                number /= 10;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isSequenceDecreases(int number) {

        if (number < 10) {
            return false;
        }

        while (number / 10 != 0) {

            int currentNumeral = number % 10;
            int previousNumeral = (number / 10) % 10;

            if (previousNumeral > currentNumeral) {
                number /= 10;
            } else {
                return false;
            }
        }
        return true;
    }
}

