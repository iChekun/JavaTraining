package by.epam.javatraining.chekun.maintask02.model.exception;

public class WrongDateException extends Exception {

    public WrongDateException() {
    }

    public WrongDateException(int day, int month, int year) {
        super("Date received wrong parameters: " + day + "." + month + "." + year);
    }
}
