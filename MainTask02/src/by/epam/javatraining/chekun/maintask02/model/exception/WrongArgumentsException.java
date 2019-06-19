package by.epam.javatraining.chekun.maintask02.model.exception;

public class WrongArgumentsException extends Exception {
    public WrongArgumentsException(){}

    public WrongArgumentsException(String message){
        super(message);
    }
}
