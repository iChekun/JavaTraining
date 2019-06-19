package by.epam.javatraining.chekun.maintask02.model.date;

import by.epam.javatraining.chekun.maintask02.model.exception.WrongDateException;

import java.util.Objects;

/**
 * Class has three fields: day month year
 * Use to define date
 * <p>
 *     Can be updated with method to work with date
 * </p>
 *
 * @author  Chekun Ilya
 */
public class Date {

    private int day;
    private int month;
    private int year;
    private DateChecker dateChecker = DateChecker.getInstance();

    public Date() {

    }

    public Date(int day, int month, int year){
        if (dateChecker.isDateCorrect(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } /*else {
            throw new WrongDateException(day, month, year);
        }*/

    }


    public void setDate(int day, int year, int month) throws WrongDateException {
        if (dateChecker.isDateCorrect(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
        throw new WrongDateException(day, month, year);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return day + "." + month + "." + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day &&
                month == date.month &&
                year == date.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year, dateChecker);
    }
}
