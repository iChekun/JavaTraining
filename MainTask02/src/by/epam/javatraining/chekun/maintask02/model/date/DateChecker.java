package by.epam.javatraining.chekun.maintask02.model.date;

import org.apache.log4j.Logger;

import java.util.Arrays;


public class DateChecker {

    private static DateChecker instance = new DateChecker();

    public static DateChecker getInstance() {
        return instance;
    }

    private DateChecker() {
    }

    private static final Logger logger = Logger.getLogger(DateChecker.class);
    /////////////////////////////
    public static final int FEBRUARY = 2;
    public static final int APRIL = 4;
    public static final int JUNE = 6;
    public static final int SEPTEMBER = 9;
    public static final int NOVEMBER = 11;

    private static final int LIMIT_YEAR = 2025;
    private static final int STARTING_YEAR = 2019;
    private static final int MAX_COUNT_MONTH_IN_YEAR = 12;
    private static final Integer[] MONTH_WITH_30_DAYS = {FEBRUARY, APRIL, JUNE, SEPTEMBER, NOVEMBER};

    public boolean isLeapYear(final int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    /**
     * @param day
     * @param month
     * @param year
     * @return true -> if date correct
     * false -> if day incorrect
     */
    public boolean isDateCorrect(final int day, final int month, final int year) {

        if (checkMoth(month) && checkYear(year) && day > 0) {

            if (day <= 29 && month == FEBRUARY && isLeapYear(year)) {
                return true;
            } else if (day <= 28 && month == FEBRUARY && !isLeapYear(year)) {
                return true;
            } else if (day <= 30 && Arrays.asList(MONTH_WITH_30_DAYS).contains(Integer.valueOf(month))) {
                return true;
            } else if (day <= 31 && month != FEBRUARY &&
                    !Arrays.asList(MONTH_WITH_30_DAYS).contains(Integer.valueOf(month))) {
                return true;
            }
        }
        logger.warn("Method isDateCorrect() received wrong parameters: " + day + "." + month + "." + year);
        return false;
    }

   /* public boolean checkDay(final int day) {
        return day > 0 && day <= 31;
    }*/

    public boolean checkMoth(final int month) {
        return month > 0 && month <= MAX_COUNT_MONTH_IN_YEAR;
    }

    public boolean checkYear(final int year) {
        return year >= STARTING_YEAR && year <= LIMIT_YEAR;
    }

    public boolean compare(Date first, Date second) {
        return first.getYear() >= second.getYear()
                && first.getMonth() >= second.getMonth()
                && first.getDay() > second.getDay();
    }


}
