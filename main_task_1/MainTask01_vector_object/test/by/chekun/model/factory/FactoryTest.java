package by.chekun.model.factory;

import by.chekun.model.entity.Vector;
import by.chekun.model.exception.WrongArgumentsException;
import by.chekun.model.exception.vector.NoSuchElementException;
import org.junit.Assert;
import org.junit.Test;

public class FactoryTest {

    private Factory factory = Factory.getInstance();

    @Test(expected = WrongArgumentsException.class)
    public void getVector_wrongParameters_wrongArgumentsException() throws WrongArgumentsException {
        //given
        //when
        factory.createVector();
        //then
        //expecting WrongArgumentsException
    }

    @Test
    public void getVector_correctParameters_true() throws WrongArgumentsException, NoSuchElementException {
        //given
        //when
        Vector expectedVector = new Vector(11, 2, 4, 5, 6);
        Vector vector = factory.createVector(11, 2, 4, 5, 6);
        //then
        Assert.assertEquals(expectedVector,vector);
//        Assert.assertArrayEquals(expectedVector.getVector(), vector.getVector(),0.1);
    }
}