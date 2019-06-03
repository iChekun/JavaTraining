package by.epam.javatraining.chekun.task_3.model;

import static org.junit.Assert.*;

import org.junit.Test;

import java.math.BigInteger;

public class FactorialLogicTest {

    @Test
    public void getFactorial_long_true() {

        int number = 5;
        int expected = 120;

        assertEquals(expected, FactorialLogic.getFactorial_long(number));
    }

    @Test
    public void getFactorial_long2_true() {

        int number = 15;
        long expected = 1307674368000L;

        assertEquals(expected, FactorialLogic.getFactorial_long(number));
    }

    @Test
    public void getFactorial_long3_true() {

        int number = 1;
        int expected = 1;

        assertEquals(expected, FactorialLogic.getFactorial_long(number));
    }

    @Test
    public void getFactorial_long4_true() {

        int number = 0;
        int expected = 1;

        assertEquals(expected, FactorialLogic.getFactorial_long(number));
    }

    @Test
    public void getFactorial_long5_true() {

        int number = 14;
        long expected = 87178291200L;

        assertEquals(expected, FactorialLogic.getFactorial_long(number));
    }

    @Test
    public void getFactorial_long_badParams_true() {

        int number = -1;
        int expected = -1;

        assertEquals(expected, FactorialLogic.getFactorial_long(number));
    }

    @Test
    public void getFactorial_BigInteger_true() {

        int number = 20;
        BigInteger expected = BigInteger.valueOf(2432902008176640000L);

        assertEquals(expected, FactorialLogic.getFactorial_BigInteger(number));
    }

    @Test
    public void getFactorial_BigInteger_badParams_true() {

        int number = 0;
        BigInteger expected = BigInteger.valueOf(1);

        assertEquals(expected, FactorialLogic.getFactorial_BigInteger(number));
    }

}
