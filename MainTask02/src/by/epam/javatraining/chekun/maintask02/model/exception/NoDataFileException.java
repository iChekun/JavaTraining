package by.epam.javatraining.chekun.maintask02.model.exception;

public class NoDataFileException extends Exception {

    public NoDataFileException() {
    }

    public NoDataFileException(String message) {
        super(message);
    }

    public NoDataFileException(String message,Throwable cause) {
        super(message,cause);
    }
}
