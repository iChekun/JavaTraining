package by.chekun.model.entity;

import by.chekun.model.exception.vector.NoSuchElementException;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {

    private static final Logger log = Logger.getLogger(VectorTest.class);
    private static double DELTA = 0.01;

    @Test
    public void add_oneValue_correctParameters_true() {
        double value = 5;
        double expected = 5;

        Vector vector = new Vector();
        vector.add(value);

        assertEquals(expected, vector.get(0), DELTA);
    }

    @Test
    public void add_oneValue_correctParameters1_true() throws NoSuchElementException {
        double firstValue = 5;
        double secondValue = 7;
        double[] expectedVector = new double[10];
        expectedVector[0] = 5;
        expectedVector[1] = 7;

        Vector vector = new Vector();

        vector.add(firstValue);
        vector.add(secondValue);

        assertArrayEquals(expectedVector, vector.getVector(), DELTA);

    }


    //////
    @Test
    public void add_addValues_correctParameters_true() throws NoSuchElementException {
        double[] expectedVector = new double[10];
        expectedVector[0] = 1;
        expectedVector[1] = 2;
        expectedVector[2] = 3;
        expectedVector[3] = 4;
        expectedVector[4] = 5;
        Vector vector = new Vector(1, 2, 3, 4, 5);

        assertArrayEquals(expectedVector, vector.getVector(), DELTA);
    }


    ///////////
    @Test
    public void remove_correctParameters_true() throws NoSuchElementException {

        Vector vector = new Vector(1, 2, 3, 4, 5, 6);
        // Vector expectedVector = new Vector(1, 2, 3, 4, 5);
        assertTrue(vector.remove(6));
        //with string...
        //assertTrue(expectedVector.toString().equals(vector.toString()));
    }

    @Test
    public void remove_badParameters_false() throws NoSuchElementException {

        Vector vector = new Vector(1, 2, 3, 4, 5, 6);
        assertFalse(vector.remove(7));

    }

    @Test(expected = NoSuchElementException.class)
    public void remove_badParameters_exception() throws NoSuchElementException {
        Vector vector = new Vector();

        vector.remove(7);
    }

    ///////////
    @Test
    public void indexOfValue_correctParameter_true() {
        Vector vector = new Vector(1, 2, 3, 4, 5);
        double expected = 2;
        double value = 3;

        assertEquals(expected, vector.indexOfValue(value), DELTA);
    }

    @Test
    public void indexOfValue_correctParameter_false() {
        Vector vector = new Vector(1, 2, 3, 4, 5);
        double expected = 2;
        double value = 15;

        assertNotEquals(expected, vector.indexOfValue(value));
    }

    @Test
    public void indexOfValue_badParameters_true() {
        Vector vector = new Vector();
        double expected = -1;
        double value = 15;

        assertNotEquals(expected, vector.indexOfValue(value));
    }

    ////
    @Test
    public void clear() {
        Vector vector = new Vector(1, 2, 3, 4);
        vector.clear();

        assertTrue(vector.getSize() == 0);
    }

    //////////
    @Test
    public void get_correctParameters_true() {
        Vector vector = new Vector(1, 2, 3, 4, 5);
        double expected = 3;

        assertEquals(expected, vector.get(2), DELTA);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void get_wrongParameters_exception() {
        Vector vector = new Vector(1, 2, 3, 4, 5);

        vector.get(15);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void get_wrongParameters_exception2() {
        Vector vector = new Vector(1, 2, 3, 4, 5);

        vector.get(-1);
    }

    /////////
    @Test
    public void changeValueOnIndex_correctParameters_true() {
        Vector vector = new Vector(1, 2, 3, 4);
        int index = 1;
        double newValue = 15;

        vector.changeValueOnIndex(index, newValue);
        assertEquals(newValue, vector.get(index), DELTA);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void changeValueOnIndex_wrongParameters_exception() {
        Vector vector = new Vector(1, 2, 3, 4, 5);

        int index = -1;
        double newValue = 15;

        vector.changeValueOnIndex(index, newValue);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void changeValueOnIndex_wrongParameters_exception2() {
        Vector vector = new Vector(1, 2, 3, 4, 5);

        int index = 15;
        double newValue = 15;

        vector.changeValueOnIndex(index, newValue);
    }

    /////
    @Test
    public void isEmpty_true() {
        Vector vector = new Vector();

        assertTrue(vector.isEmpty());
    }

    @Test
    public void isEmpty_False() {
        Vector vector = new Vector(1, 2, 3);

        assertFalse(vector.isEmpty());
    }


    ////
    @Test
    public void isVectorContainsValue_correctParameters_true() {
        Vector vector = new Vector(1, 2, 3, 4, 5);
        double value = 3;

        assertTrue(vector.isVectorContainsValue(value));
    }

    @Test
    public void isVectorContainsValue_correctParameters_false() {
        Vector vector = new Vector(1, 2, 3, 4, 5);
        double value = 15;

        assertFalse(vector.isVectorContainsValue(value));
    }

    ////
    @Test
    public void getVector_true() throws NoSuchElementException {
        Vector vector = new Vector(1, 2, 3, 4, 5);
        double[] expectedVector = new double[10];
        expectedVector[0] = 1;
        expectedVector[1] = 2;
        expectedVector[2] = 3;
        expectedVector[3] = 4;
        expectedVector[4] = 5;

        assertArrayEquals(expectedVector, vector.getVector(), DELTA);

    }

    @Test(expected = NoSuchElementException.class)
    public void getVector_exception() throws NoSuchElementException {
        Vector vector = new Vector();
        vector.clear();

        vector.getVector();

    }

    ////////
    @Test
    public void getVectorToString() {
        Vector vector = new Vector(1, 2, 3, 4, 5);
        String expected = "[1.0,2.0,3.0,4.0,5.0]";

        assertEquals(expected, vector.toString());
    }

    @Test
    public void getVectorToString_true() {
        Vector vector = new Vector();
        String expected = "[]";

        assertEquals(expected, vector.toString());
    }

    ///
    @Test
    public void getSize() {
        Vector vector = new Vector(1, 2, 3, 4);
        int expected = 4;

        assertEquals(expected, vector.getSize());
    }


    ////
    @Test
    public void getVectorSize() {
        Vector vector = new Vector();
        int expected = 10;

        assertEquals(expected, vector.getCapacity());

    }

}