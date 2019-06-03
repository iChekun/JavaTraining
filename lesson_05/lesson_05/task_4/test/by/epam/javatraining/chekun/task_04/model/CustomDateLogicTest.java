package by.epam.javatraining.chekun.task_04.model;

import by.epam.javatraining.chekun.task_04.model.entity.CustomDate;
import by.epam.javatraining.chekun.task_04.model.action.CustomDateLogic;
import by.epam.javatraining.chekun.task_04.model.exception.WrongArgumentsException;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomDateLogicTest {

    @Test
    public void getNextDayDate_correctArguments_true_LeapYear() throws WrongArgumentsException {

        CustomDate customDate = new CustomDate(27, 12, 2000);
        CustomDate expected = CustomDateLogic.getNextDayDate(new CustomDate(26, 12, 2000));

        assertEquals(expected, customDate);
    }

    @Test
    public void getNextDayDate_correctArguments_true_LeapYear_2() throws WrongArgumentsException {

        CustomDate customDate = new CustomDate(1, 1, 1957);
        CustomDate expected = CustomDateLogic.getNextDayDate(new CustomDate(31, 12, 1956));

        assertEquals(expected, customDate);
    }

    @Test
    public void getNextDayDate_correctArguments_true_NotLeapYear() throws WrongArgumentsException {

        CustomDate customDate = new CustomDate(1, 6, 2006);
        CustomDate expected = CustomDateLogic.getNextDayDate(new CustomDate(31, 5, 2006));

        assertEquals(expected, customDate);
    }

    @Test
    public void getNextDayDate_correctArguments_true_NotLeapYear_2() throws WrongArgumentsException {

        CustomDate customDate = new CustomDate(1, 11, 1957);
        CustomDate expected = CustomDateLogic.getNextDayDate(new CustomDate(31, 10, 1957));

        assertEquals(expected, customDate);
    }


    @Test
    public void getNextDayDate_correctArguments_false_NotLeapYear() throws WrongArgumentsException {

        CustomDate customDate = new CustomDate(2, 2, 2007);
        CustomDate expected = CustomDateLogic.getNextDayDate(new CustomDate(4, 5, 2007));

        assertNotEquals(expected, customDate);
    }

    @Test
    public void getNextDayDate_correctArguments_false_NotLeapYear_2() throws WrongArgumentsException {

        CustomDate customDate = new CustomDate(1, 11, 1957);
        CustomDate expected = CustomDateLogic.getNextDayDate(new CustomDate(28, 2, 1957));

        assertNotEquals(expected, customDate);
    }


    @Test
    public void getNextDayDate_correctArguments_true() throws WrongArgumentsException {

        CustomDate customDate = new CustomDate(21, 2, 2011);
        CustomDate expected = CustomDateLogic.getNextDayDate(new CustomDate(20, 2, 2011));

        assertEquals(expected, customDate);
    }

    @Test
    public void getNextDayDate_correctArguments_false() throws WrongArgumentsException {

        CustomDate customDate = new CustomDate(3, 2, 2019);
        CustomDate expected = CustomDateLogic.getNextDayDate(new CustomDate(1, 2, 2019));

        assertNotEquals(expected, customDate);
    }

    @Test(expected = WrongArgumentsException.class)
    public void getNextDayDate_wrongArgumentsException() throws WrongArgumentsException {
        //given
        //when
        CustomDate expected = CustomDateLogic.getNextDayDate(new CustomDate(-1, 2, 2019));
        //then
        //expecting WrongArgumentsException
    }

    @Test(expected = WrongArgumentsException.class)
    public void getNextDayDate_wrongArgumentsException_badDayFebruary_LeapYear() throws WrongArgumentsException {
        //given
        //when
        CustomDate expected = CustomDateLogic.getNextDayDate(new CustomDate(30, 2, 2012));
        //then
        //expecting WrongArgumentsException
    }

    @Test(expected = WrongArgumentsException.class)
    public void getNextDayDate_wrongArgumentsException_badDayFebruary_NotLeapYear() throws WrongArgumentsException {
        //given
        //when
        CustomDate expected = CustomDateLogic.getNextDayDate(new CustomDate(29, 2, 2007));
        //then
        //expecting WrongArgumentsException
    }
}
