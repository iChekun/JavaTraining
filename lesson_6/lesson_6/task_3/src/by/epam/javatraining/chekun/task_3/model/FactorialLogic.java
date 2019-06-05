package by.epam.javatraining.chekun.task_3.model;

import java.math.BigInteger;

public class FactorialLogic {

    private static final int WRONG_PARAMETERS = 1;

    public static long getFactorial_long(long number) {
        long result = WRONG_PARAMETERS;

        if (number >= 0) {
            for (int i = 1; i <= number; i++) {
                result = result * i;
            }
        }

        return result;
    }

    public static BigInteger getFactorial_BigInteger(int number) {
        BigInteger result = BigInteger.valueOf(WRONG_PARAMETERS);

        if (number >= 0) {
            for (int i = 1; i <= number; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
        }

        return result;
    }
}
