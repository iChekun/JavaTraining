package by.epam.javatraining.chekun.task_4.model;


public class NumberLogic {

    public static boolean isAllNumeralsEvenOrOdd(int number) {
        if (number < 10) {
            return false;
        }

        while (number / 10 > 0) {

            int currentNumeral = number % 10;
            int previousNumeral = (number / 10) % 10;

            if (currentNumeral % 2 == 0 && previousNumeral % 2 == 0 //is even current and previous?
                    || currentNumeral % 2 != 0 && previousNumeral % 2 != 0) { // or is not even?
                number /= 10;
            } else {
                return false;
            }
        }
        return true;
    }

}
