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

    @Test
    public void getHeadsCount_correctParameters_true() {
        int range = 1000;
        int tailsCounts = 494;
        int expected = 506;

        assertEquals(expected, HeadsOrTails.getHeadsCount(range, tailsCounts));
    }

    @Test
    public void getHeadsCount_wrongParameters_true() {
        int range = 500;
        int tailsCounts = 501;
        int expected = -1;

        assertEquals(expected, HeadsOrTails.getHeadsCount(range, tailsCounts));
    }
}