package by.epam.javatraining.chekun.task_2.model;


/*
Разработайте программу, которая проверяет, что цифры заданного числа образуют возрастающую
(убывающую) последовательность (к примеру, число 1357 удовлетворяет условию,
 т.к. его цифры соответствуют следующему неравенству: 1 < 3 < 5 < 7,
 т.е. идут в порядке возрастания; число 98765 также удовлетворяет условию,
 т.к. его цифры соответствуют следующему неравенству 9 > 8 > 7 > 6 > 5;
  а вот числа 192837, 777, 19283746 – не удовлетворяют условию).
 */

public class CheckingSequence {


    public static boolean isSequenceGrowing(int number) {

        boolean flag = true;

        if (number > 10) {

            while (number / 10 != 0) {

                int currentNumeral = number % 10;
                int previousNumeral = (number / 10) % 10;

                if (previousNumeral < currentNumeral) {
                    number /= 10;
                } else {
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }

    public static boolean isSequenceDecreases(int number) {

        boolean flag = true;

        if (number > 10) {

            while (number / 10 != 0) {

                int currentNumeral = number % 10;
                int previousNumeral = (number /= 10) % 10;

                if (previousNumeral < currentNumeral) {
                    flag = false;
                    break;
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }

}
