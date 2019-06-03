package by.epam.javatraining.chekun.task_4.model;


public class NumberLogic {

    public static boolean isNumeralsEven(int number) {
        boolean flag = false;

        if (number >= 10) {
            while (number / 10 > 0) {

                int currentNumeral = number % 10;
                int previousNumeral = (number / 10) % 10;

                if ((currentNumeral % 2 == 0 && previousNumeral % 2 == 0) //is even?
                        || (currentNumeral % 2 != 0 && previousNumeral % 2 != 0)) { // is not even?
                    flag = true;
                    number /= 10;
                } else {
                    flag = false;
                    break;
                }
            }
            return flag;
        } else {
            return flag;
        }
    }

}
