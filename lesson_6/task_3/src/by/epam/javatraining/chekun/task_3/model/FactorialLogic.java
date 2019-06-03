package by.epam.javatraining.chekun.task_3.model;

import java.math.BigInteger;

public class FactorialLogic {

    private static final int WRONG_PARAMETERS = -1;

    public static long getFactorial_long(long number) {
        if (number >= 0) {

            long result = 1L;

            for (int i = 1; i <= number; i++) {
                result = result * i;
            }
            return result;
        } else {
            return WRONG_PARAMETERS;
        }
    }

    public static BigInteger getFactorial_BigInteger(int number) {
        if (number >= 0) {

            BigInteger result = BigInteger.ONE;

            for (int i = 1; i <= number; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result;
        } else {
            return BigInteger.valueOf(WRONG_PARAMETERS);
        }
    }
}
