package by.epam.javatraining.chekun.maintask02.model.date;

import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateCheckerTest {

    private final Logger logger = Logger.getLogger(DateCheckerTest.class);
    private final DateChecker checker = DateChecker.getInstance();

    @Test
    public void isLeapYear_true() {
        int year = 2000;

        assertTrue(checker.isLeapYear(year));
    }

    @Test
    public void isLeapYear_true_2() {
        int year = 1956 ;

        assertTrue(checker.isLeapYear(year));

    }

    @Test
    public void isLeapYear_true_3() {
        int year = 2020 ;

        assertTrue(checker.isLeapYear(year));

    }


    @Test
    public void isLeapYear_false() {
        int year = 2006;

        assertFalse(checker.isLeapYear(year));
    }


    @Test
    public void isLeapYear_false_2() {
        int year = 1957;

        assertFalse(checker.isLeapYear(year));

    }

    @Test
    public void isDateCorrect_correctParameters_true() {
        int day = 5;
        int month = 12;
        int year = 2019;

        assertTrue(checker.isDateCorrect(day,month,year));
    }

    @Test
    public void isDateCorrect_correctParameters_true2() {
        int day = 31;
        int month = 12;
        int year = 2019;

        assertTrue(checker.isDateCorrect(day,month,year));
    }

    @Test
    public void isDateCorrect_correctParameters_true3() {
        int day = 29;
        int month = 2;
        int year = 2020;

        assertTrue(checker.isDateCorrect(day,month,year));
    }

    @Test
    public void isDateCorrect_correctParameters_true4() {
        int day = 28;
        int month = 2;
        int year = 2019;

        assertTrue(checker.isDateCorrect(day,month,year));
    }

    @Test
    public void isDateCorrect_correctParameters_true5() {
        int day = 30;
        int month = 6;
        int year = 2019;

        assertTrue(checker.isDateCorrect(day,month,year));
    }

    @Test
    public void isDateCorrect_correctParameters_true6() {
        int day = 31;
        int month = 3;
        int year = 2019;

        assertTrue(checker.isDateCorrect(day,month,year));
    }


    @Test
    public void isDateCorrect_wrongParameters_false() {
        int day = 0;
        int month = 3;
        int year = 2019;

        assertFalse(checker.isDateCorrect(day,month,year));
    }


    @Test
    public void isDateCorrect_wrongParameters_false_2() {
        int day = 12;
        int month = 0;
        int year = 2019;

        assertFalse(checker.isDateCorrect(day,month,year));
    }

    @Test
    public void isDateCorrect_wrongParameters_false_3() {
        int day = 12;
        int month = 0;
        int year = 2018;

        assertFalse(checker.isDateCorrect(day,month,year));
    }

    @Test
    public void isDateCorrect_wrongParameters_false_4() {
        int day = 32;
        int month = 0;
        int year = 2020;

        assertFalse(checker.isDateCorrect(day,month,year));
    }

    @Test
    public void isDateCorrect_wrongParameters_false_5() {
        int day = 31;
        int month = 13;
        int year = 2020;

        assertFalse(checker.isDateCorrect(day,month,year));
    }

    @Test
    public void isDateCorrect_wrongParameters_false_6() {
        int day = 31;
        int month = 2;
        int year = 2020;

        assertFalse(checker.isDateCorrect(day,month,year));
    }

    @Test
    public void isDateCorrect_wrongParameters_false_7() {
        int day = 31;
        int month = 2;
        int year = 2019;

        assertFalse(checker.isDateCorrect(day,month,year));
    }

    @Test
    public void isDateCorrect_wrongParameters_false_8() {
        int day = 31;
        int month = 6;
        int year = 2019;

        assertFalse(checker.isDateCorrect(day,month,year));
    }

    @Test
    public void isDateCorrect_wrongParameters_true10() {
        int day = 1;
        int month = 2;
        int year = 2019;

        assertTrue(checker.isDateCorrect(day,month,year));
    }
}