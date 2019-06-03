package by.epam.javatraining.chekun.task_5.model;

public class NumberLogic {


    public static boolean isSimpleNumber(int number) {

        if (number > 1) {
            boolean flag = true;

            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
            }
            return flag;
        } else {
            return false;
        }
    }
}
