package by.epam.javatraining.chekun.model.action;

import by.epam.javatraining.chekun.model.exception.WrongArgumentsException;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberLogicTest {

    @Test
    public void calculateCountOfEvenNumeralsInNumber_true() throws WrongArgumentsException {
        int number = 123456;
        int expected = 3;

        assertEquals(expected, NumberLogic.calculateCountOfEvenNumeralsInNumber(number));
    }

    @Test(expected = WrongArgumentsException.class)
    public void calculateCountOfEvenNumeralsInNumber_exception() throws WrongArgumentsException {

        int number = -1;
        NumberLogic.calculateCountOfEvenNumeralsInNumber(number);
    }

    @Test
    public void calculateSumNumeralsOfNumber() throws WrongArgumentsException {
        int number = 123456;
        int expected = 21;

        assertEquals(expected, NumberLogic.calculateSumNumeralsOfNumber(number));
    }

    @Test(expected = WrongArgumentsException.class)
    public void calculateSumNumeralsOfNumber_exception() throws WrongArgumentsException {

        int number = -1;
        NumberLogic.calculateSumNumeralsOfNumber(number);
    }

    @Test
    public void calculateMultiplicationNumeralsOfNumber() throws WrongArgumentsException {
        int number = 2345;
        int expected = 120;

        assertEquals(expected, NumberLogic.calculateMultiplicationNumeralsOfNumber(number));
    }

    @Test(expected = WrongArgumentsException.class)
    public void calculateMultiplicationNumeralsOfNumber_exception() throws WrongArgumentsException {

        int number = -1;
        NumberLogic.calculateMultiplicationNumeralsOfNumber(number);
    }

    @Test
    public void calculateArithmeticSumNumeralsOfNumber() throws WrongArgumentsException {
        int number = 123456;
        double expected = 3.5;
        double delta = 0.01;

        assertEquals(expected, NumberLogic.calculateArithmeticSumNumeralsOfNumber(number), delta);
    }

    @Test(expected = WrongArgumentsException.class)
    public void calculateArithmeticSumNumeralsOfNumber_exception() throws WrongArgumentsException {

        int number = -1;
        NumberLogic.calculateArithmeticSumNumeralsOfNumber(number);
    }

    @Test
    public void calculateGeometricAverageValueNumeralsOfNumber() throws WrongArgumentsException {
        int number = 12345;
        double expected = 2.6051710846973517;
        double delta = 0.01;

        assertEquals(expected, NumberLogic.calculateGeometricAverageValueNumeralsOfNumber(number), delta);
    }

    @Test(expected = WrongArgumentsException.class)
    public void calculateGeometricAverageValueNumeralsOfNumber_exception() throws WrongArgumentsException {

        int number = -1;
        NumberLogic.calculateGeometricAverageValueNumeralsOfNumber(number);
    }

    @Test
    public void isNumberPalindrom_true() throws WrongArgumentsException {

        int number = 123321;

        assertTrue(NumberLogic.isNumberPalindrom(number));
    }

    @Test
    public void isNumberPalindrom_true2() throws WrongArgumentsException {

        int number = 98766789;

        assertTrue(NumberLogic.isNumberPalindrom(number));
    }

    @Test
    public void isNumberPalindrom_false() throws WrongArgumentsException {

        int number = 12344312;

        assertFalse(NumberLogic.isNumberPalindrom(number));
    }

    @Test(expected = WrongArgumentsException.class)
    public void isNumberPalindrom_exception() throws WrongArgumentsException {

        int number = -1;
        NumberLogic.isNumberPalindrom(number);
    }

    @Test
    public void isAllNumeralsOfNumberEquals_true() throws WrongArgumentsException {
        int number = 1111111;

        assertTrue(NumberLogic.isAllNumeralsOfNumberEquals(number));
    }

    @Test
    public void isAllNumeralsOfNumberEquals_false() throws WrongArgumentsException {
        int number = 11221111;

        assertFalse(NumberLogic.isAllNumeralsOfNumberEquals(number));
    }


    @Test(expected = WrongArgumentsException.class)
    public void isAllNumeralsOfNumberEquals_exception() throws WrongArgumentsException {

        int number = -1;
        NumberLogic.isNumberPalindrom(number);
    }

    @Test
    public void findMaxNumeralInNumber() throws WrongArgumentsException {
        int number = 12345689;
        int expected = 9;
        assertEquals(expected, NumberLogic.findMaxNumeralInNumber(number));
    }

    @Test(expected = WrongArgumentsException.class)
    public void findMaxNumeralInNumber_exception() throws WrongArgumentsException {

        int number = -1;
        NumberLogic.findMaxNumeralInNumber(number);
    }

    @Test
    public void isNumberPerfect_true() throws WrongArgumentsException {
        int number = 8128;

        assertTrue(NumberLogic.isNumberPerfect(number));

    }

    @Test
    public void isNumberPerfect_true2() throws WrongArgumentsException {
        int number = 496;

        assertTrue(NumberLogic.isNumberPerfect(number));

    }

    @Test
    public void isNumberPerfect_false() throws WrongArgumentsException {
        int number = 24;

        assertFalse(NumberLogic.isNumberPerfect(number));

    }

    @Test(expected = WrongArgumentsException.class)
    public void isNumberPerfect_exception() throws WrongArgumentsException {

        int number = -1;
        NumberLogic.isNumberPerfect(number);
    }
}

