package by.epam.javatraining.chekun.task_5.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumberLogicTest {

    @Test
    public void isSimpleNumber_correctParameters_true() {
        int number = 3;

        assertTrue(NumberLogic.isSimpleNumber(number));
    }

    @Test
    public void isSimpleNumber_correctParameters2_true() {
        int number = 13;

        assertTrue(NumberLogic.isSimpleNumber(number));
    }

    @Test
    public void isSimpleNumber_correctParameters3_true() {
        int number = 31;

        assertTrue(NumberLogic.isSimpleNumber(number));
    }

    @Test
    public void isSimpleNumber_correctParameters4_true() {
        int number = 3571;

        assertTrue(NumberLogic.isSimpleNumber(number));
    }

    @Test
    public void isSimpleNumber_correctParameters_false() {
        int number = 1;

        assertFalse(NumberLogic.isSimpleNumber(number));
    }

    @Test
    public void isSimpleNumber_correctParameters2_false() {
        int number = 24;

        assertFalse(NumberLogic.isSimpleNumber(number));
    }

    @Test
    public void isSimpleNumber_wrongParameters_false() {
        int number = -5;

        assertFalse(NumberLogic.isSimpleNumber(number));
    }
}