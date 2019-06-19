package by.chekun.model.exception.vector;

public class ArrayIndexBoundsException extends Exception {

    public ArrayIndexBoundsException() {
    }

    public ArrayIndexBoundsException(int index) {
        super("Array index  out of range: " + index);
    }
}
