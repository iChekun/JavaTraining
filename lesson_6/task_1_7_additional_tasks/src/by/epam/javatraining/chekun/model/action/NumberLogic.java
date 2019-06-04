package by.epam.javatraining.chekun.model.action;

import by.epam.javatraining.chekun.model.exception.WrongArgumentsException;


public class NumberLogic {

    private static final String WRONG_ARGUMENTS = "Enter number > 0 ! ";

    public static int calculateCountOfEvenNumeralsInNumber(long number) throws WrongArgumentsException {
        if (number > 0) {
            int countOfEvenNumerals = 0;

            while (number > 0) {

                if ((number % 10) % 2 == 0) {
                    countOfEvenNumerals++;
                }
                number /= 10;
            }
            return countOfEvenNumerals;
        }
        throw new WrongArgumentsException(WRONG_ARGUMENTS);
    }

    public static int calculateSumNumeralsOfNumber(long number) throws WrongArgumentsException {

        if (number > 0) {
            int sumOfNumerals = 0;

            while (number > 0) {
                sumOfNumerals += number % 10;
                number /= 10;
            }
            return sumOfNumerals;
        }
        throw new WrongArgumentsException(WRONG_ARGUMENTS);
    }

    public static long calculateMultiplicationNumeralsOfNumber(long number) throws WrongArgumentsException {

        if (number > 0) {
            long multiplicationOfNumerals = 1;

            while (number > 0) {
                multiplicationOfNumerals *= number % 10;
                number /= 10;
            }
            return multiplicationOfNumerals;
        }
        throw new WrongArgumentsException(WRONG_ARGUMENTS);
    }

    public static double calculateArithmeticSumNumeralsOfNumber(long number) throws WrongArgumentsException {
        if (number > 0) {

            int sumOfNumerals = 0;
            int countOfNumerals = 0;

            while (number > 0) {

                sumOfNumerals += number % 10;
                countOfNumerals++;

                number /= 10;
            }
            return (double) sumOfNumerals / (double) countOfNumerals; //return arithmetic sum
        }
        throw new WrongArgumentsException(WRONG_ARGUMENTS);
    }

    public static double calculateGeometricAverageValueNumeralsOfNumber(long number) throws WrongArgumentsException {
        if (number > 0) {

            int compositionOfNumerals = 1;
            int countOfNumerals = 0;

            while (number > 0) {
                compositionOfNumerals *= number % 10;
                countOfNumerals++;

                number /= 10;
            }
            return Math.exp(Math.log(compositionOfNumerals) / countOfNumerals);
        }
        throw new WrongArgumentsException(WRONG_ARGUMENTS);
    }

    public static boolean isNumberPalindrom(long number) throws WrongArgumentsException {
        if (number > 0) {
            long palindrom = number;
            long reverseNumber = 0;

            while (palindrom != 0) {
                long currentNumeral = palindrom % 10;
                reverseNumber = reverseNumber * 10 + currentNumeral;
                palindrom /= 10;
            }

            return reverseNumber == number;
        }
        throw new WrongArgumentsException(WRONG_ARGUMENTS);
    }

    public static boolean isAllNumeralsOfNumberEquals(long number) throws WrongArgumentsException {
        if (number > 0) {
            while (number / 10 != 0) {

                int currentNumeral = (int) (number % 10);
                int previousNumeral = (int) ((number / 10) % 10);

                if (currentNumeral != previousNumeral) {
                    return false;
                }
                number /= 10;
            }
            return true;
        }
        throw new WrongArgumentsException(WRONG_ARGUMENTS);
    }

    public static int findMaxNumeralInNumber(long number) throws WrongArgumentsException {
        if (number > 0) {
            //зачем бежать по циклу если можно сразу вернуть цифру
            if (number < 10) {
                return (int) number;
            }

            int maxNumeral = (int) number % 10;
            number /= 10;

            while (number / 10 != 0) {
                int currentNumeral = (int) number % 10;

                if (currentNumeral > maxNumeral) {
                    maxNumeral = currentNumeral;
                }
                number /= 10;
            }
            return maxNumeral;
        }
        throw new WrongArgumentsException(WRONG_ARGUMENTS);
    }

    public static boolean isNumberPerfect(long number) throws WrongArgumentsException {
        if (number > 0) {
            int sumOfDel = 0;

            for (int i = 1; i != number; i++) {
                if (number % i == 0) {
                    sumOfDel += i;
                }
            }
            return sumOfDel == number;
        }
        throw new WrongArgumentsException(WRONG_ARGUMENTS);
    }
}
