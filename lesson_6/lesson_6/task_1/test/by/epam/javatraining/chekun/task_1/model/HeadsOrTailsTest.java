package by.epam.javatraining.chekun.task_1.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeadsOrTailsTest {

    @Test
    public void getTailsCount_wrongParameters_true() {
        int range = -5;
        int expected = -1;

        assertEquals(expected, HeadsOrTails.getTailsCount(range));
    }

}