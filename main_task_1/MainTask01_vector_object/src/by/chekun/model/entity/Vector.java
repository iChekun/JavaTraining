package by.chekun.model.entity;

import by.chekun.model.exception.vector.NoSuchElementException;

import java.util.Arrays;

public class Vector {

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private double[] vector;
    private int size;
    private int capacity;

    public Vector() {
        this(2);
    }

    private Vector(int capacity) {
        this.capacity = capacity;
        vector = new double[capacity];
    }

    public Vector(double... params) {
        if (params.length < MAX_ARRAY_SIZE && params.length > 0) {
            int newSize = params.length;
            this.capacity = newSize;
            this.size = newSize;

            vector = new double[capacity];
            for (int i = 0; i < newSize; i++) {
                vector[i] = params[i];
            }
        }

    }

    public void add(double value) {
        if (size + 1 >= capacity) {
            grow(1);
        }
        vector[size++] = value;
    }

    public void add(double... values) {
        if (size + values.length >= capacity) {
            grow(values.length);
        }

        int oldSize = size;
        size = size + values.length;

        for (int i = oldSize, j = 0; i < size; i++, j++) {
            vector[i] = values[j];
        }
    }

    //растем вверх
    private void grow(int growUpFor) {
        //потом проверимся на возможные размеры
        int newSize = this.capacity + growUpFor;//+ 5;
        this.vector = Arrays.copyOf(this.vector, newSize);
        this.capacity = newSize;
    }

    public boolean remove(double value) throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int i = indexOfValue(value);

        if (i >= 0) {
            removeElement(i);
            return true;
        }
        return false;
    }

    private void removeElement(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= capacity || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        size--;
        System.arraycopy(vector, index + 1, vector, index, capacity - 1 - index);
    }

    public int indexOfValue(double value) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (value == vector[i]) {
                    return i;
                }
            }
        }

        return -1;
    }


    public void clear() {
        vector = null;
        size = 0;
        capacity = 0;
    }

    public double get(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index); //выход за границу массива
        }
        return vector[index];
    }

    public double getElementFromPosition(int position) {
        if (position >= 0 && position < size) {
            return vector[position];
        }
        return -1;
    }


    //устаонвить эелмент в позицию
    public void changeValueOnIndex(int index, double value) throws ArrayIndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index); //выход за границу массива
        }

        vector[index] = value;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isVectorContainsValue(double value) {
        return indexOfValue(value) >= 0;
    }


    public void setVector(double[] newVector) throws NoSuchElementException {
        if (newVector == null || newVector.length == 0) {
            throw new NoSuchElementException();
        }
        this.capacity = newVector.length;
        this.size = newVector.length;
        this.vector = newVector;
    }

    public double[] getVector() throws NoSuchElementException {
        if (vector != null) {
            return vector;
        }
        throw new NoSuchElementException();
    }

    public String getVectorToString() throws NoSuchElementException {
        if (vector != null) {
            return vector.toString();
        }
        throw new NoSuchElementException();
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        if (size <= 0) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append('[');
        for (int i = 0; i < size; i++) {
            result.append(vector[i]);
            if (i + 1 < size) {
                result.append(',');
            }
        }
        result.append(']');

        return result.toString();
    }
}
