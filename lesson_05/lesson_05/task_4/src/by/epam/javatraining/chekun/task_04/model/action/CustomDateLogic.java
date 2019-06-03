package by.epam.javatraining.chekun.task_04.model.action;

import by.epam.javatraining.chekun.task_04.model.entity.CustomDate;
import by.epam.javatraining.chekun.task_04.model.exception.WrongArgumentsException;

public class CustomDateLogic {

    public static final int FEBRUARY = 2;
    public static final int APRIL = 4;
    public static final int JUNE = 6;
    public static final int SEPTEMBER = 9;
    public static final int NOVEMBER = 11;

    public static final int MAX_DAYS_IN_FEBRUARY_LEAP_YEAR = 29;
    public static final int MAX_DAYS_IN_FEBRUARY_NOT_LEAP_YEAR = 28;
    public static final int MAX_MONTHS_IN_YEAR = 12;

    private static final int THIRTY_DAYS_IN_MONTH = 30;
    private static final int THIRTY_ONE_DAYS_IN_MONTH = 31;

    private static int day = 0;
    private static int month = 0;
    private static int year = 0;


    public static CustomDate getNextDayDate(CustomDate date) throws WrongArgumentsException {
        day = date.getDay();
        month = date.getMonth();
        year = date.getYear();

        if (isParamsCorrect()) {

            if (isLeapYear()) {
                if (month != FEBRUARY) {
                    checkingLeapYearDate();
                } else if (day <= MAX_DAYS_IN_FEBRUARY_LEAP_YEAR) {
                    checkingLeapYearDate();
                } else {
                    throw new WrongArgumentsException(
                            "In February, no more than 29 days, when the year is  a leap year.");
                }
            } else {
                if (month != FEBRUARY) {
                    checkingNotLeapYearDate();
                } else if (day <= MAX_DAYS_IN_FEBRUARY_NOT_LEAP_YEAR) {
                    checkingNotLeapYearDate();
                } else {
                    throw new WrongArgumentsException(
                            "In February, no more than 28 days, when the year is not a leap year.");
                }
            }
            date.setDay(day);
            date.setMonth(month);
            date.setYear(year);

            return date;
        }
        throw new WrongArgumentsException("Method getNextDayDate() received wrong parameters.");
    }

    private static boolean isLeapYear() {
        return year % 4 == 0 && year % 400 == 0 && year % 100 == 0
                || year % 4 == 0 && year % 100 != 0;
    }

    private static boolean isParamsCorrect() {
        return day > 0 && day <= THIRTY_ONE_DAYS_IN_MONTH && month > 0 && month <= MAX_MONTHS_IN_YEAR && year > 0;
    }

    private static void checkingLeapYearDate() {
        day += 1;
        if (month == FEBRUARY && day > MAX_DAYS_IN_FEBRUARY_LEAP_YEAR) {
            day = 1;
            checkingMonthNumber();
        } else if ((month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER) && day > THIRTY_DAYS_IN_MONTH
                || day > THIRTY_ONE_DAYS_IN_MONTH) {
            day = 1;
            checkingMonthNumber();
        }
    }

    private static void checkingNotLeapYearDate() {
        day += 1;
        if (month == FEBRUARY && day > MAX_DAYS_IN_FEBRUARY_NOT_LEAP_YEAR) {
            day = 1;
            checkingMonthNumber();
        } else if ((month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER) && day > THIRTY_DAYS_IN_MONTH
                || day > THIRTY_ONE_DAYS_IN_MONTH) {
            day = 1;
            checkingMonthNumber();
        }
    }

    private static void checkingMonthNumber() {
        month += 1;
        if (month > MAX_MONTHS_IN_YEAR) {
            month = 1;
            year += 1;
        }
    }
}
