package by.epam.javatraining.chekun.task_5.model;

public class NumberLogic {


    public static boolean isSimpleNumber(int number) {
        boolean flag = false;

        if (number > 1) {
            flag = true;

            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }
}
