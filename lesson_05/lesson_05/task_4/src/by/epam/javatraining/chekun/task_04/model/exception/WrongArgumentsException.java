package by.epam.javatraining.chekun.task_04.model.exception;

public class WrongArgumentsException extends  Throwable {

    public WrongArgumentsException() {}

    public WrongArgumentsException(String message){
        super(message);
    }

}
