package by.epam.javatraining.chekun.task01.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class DragonLogicTest {

    @Test
    public void calculateCountOfDragonHeads_BeforeTwoHundreds_correctValues_true() {

        int dragonAge = 153;
        int expected = 462;

        assertEquals(expected, DragonLogic.calculateCountOfDragonHeads(dragonAge));
    }

    @Test
    public void calculateCountOfDragonHeads_AfterTwoHundreds_correctValues_true() {

        int dragonAge = 250;
        int expected = 703;

        assertEquals(expected, DragonLogic.calculateCountOfDragonHeads(dragonAge));
    }

    @Test
    public void calculateCountOfDragonHeads_AfterThreeHundreds_correctValues_true() {

        int dragonAge = 350;
        int expected = 853;

        assertEquals(expected, DragonLogic.calculateCountOfDragonHeads(dragonAge));
    }


    @Test
    public void calculateCountOfDragonHeads_wrongValue_true() {

        int dragonAge = -500;
        int expected = -1;

        assertEquals(expected, DragonLogic.calculateCountOfDragonHeads(dragonAge));
    }


    ////
    @Test
    public void calculateCountOfDragonEyes_BeforeTwoHundreds_correctValues_true() {

        int dragonAge = 150;
        int expected = 906;

        assertEquals(expected, DragonLogic.calculateCountOfDragonEyes(dragonAge));
    }

    @Test
    public void calculateCountOfDragonEyes_AfterTwoHundreds_correctValues_true() {

        int dragonAge = 250;
        int expected = 1406;

        assertEquals(expected, DragonLogic.calculateCountOfDragonEyes(dragonAge));
    }

    @Test
    public void calculateCountOfDragonEyes_AfterThreeHundreds_correctValues_true() {

        int dragonAge = 350;
        int expected = 1706;

        assertEquals(expected, DragonLogic.calculateCountOfDragonEyes(dragonAge));
    }


    @Test
    public void calculateCountOfDragonEyes_wrongValue_true() {

        int dragonAge = -500;
        int expected = -1;

        assertEquals(expected, DragonLogic.calculateCountOfDragonEyes(dragonAge));
    }
}
