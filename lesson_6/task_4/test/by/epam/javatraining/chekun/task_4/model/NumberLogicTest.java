package by.epam.javatraining.chekun.task_4.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumberLogicTest {

    @Test
    public void isNumeralsEven_correctParameters_true() {
        int number = 2468;

        assertTrue(NumberLogic.isAllNumeralsEvenOrOdd(number));
    }

    @Test
    public void isNumeralsEven_correctParameters2_true() {
        int number = 1579;

        assertTrue(NumberLogic.isAllNumeralsEvenOrOdd(number));
    }

    @Test
    public void isNumeralsEven_correctParameters0_false() {
        int number = 24586;

        assertFalse(NumberLogic.isAllNumeralsEvenOrOdd(number));
    }

    @Test
    public void isNumeralsEven_correctParameters1_false() {
        int number = 1579792797;

        assertFalse(NumberLogic.isAllNumeralsEvenOrOdd(number));
    }

    @Test
    public void isNumeralsEven_correctParameters_false() {
        int number = 12572;

        assertFalse(NumberLogic.isAllNumeralsEvenOrOdd(number));
    }

    @Test
    public void isNumeralsEven_wrongParameters_false() {
        int number = -1;

        assertFalse(NumberLogic.isAllNumeralsEvenOrOdd(number));
    }

    @Test
    public void isNumeralsEven_wrongParameters2_false() {
        int number = 6;

        assertFalse(NumberLogic.isAllNumeralsEvenOrOdd(number));
    }


}