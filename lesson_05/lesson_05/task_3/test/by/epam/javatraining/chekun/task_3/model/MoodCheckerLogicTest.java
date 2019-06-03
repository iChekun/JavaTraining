package by.epam.javatraining.chekun.task_3.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoodCheckerLogicTest {

    @Test
    public void chooseMoodToStringTest_correctValues_true() {
        int number = 1;
        String expected = MoodCheckerLogic.SMILE;

        assertEquals(expected, MoodCheckerLogic.chooseMoodToStringTest(number));
    }

    @Test
    public void chooseMoodToStringTest_correctValues2_true() {
        int number = 2;
        String expected = MoodCheckerLogic.SADNESS;

        assertEquals(expected, MoodCheckerLogic.chooseMoodToStringTest(number));
    }


    @Test
    public void chooseMoodToStringTest_correctValues3_true() {
        int number = 3;
        String expected = MoodCheckerLogic.THOUGHTFULNESS;

        assertEquals(expected, MoodCheckerLogic.chooseMoodToStringTest(number));
    }

    @Test
    public void chooseMoodToStringTest_correctValues4_true() {
        int number = 4;
        String expected = MoodCheckerLogic.LAUGH;

        assertEquals(expected, MoodCheckerLogic.chooseMoodToStringTest(number));
    }

    @Test
    public void chooseMoodToStringTest_correctValues5_true() {
        int number = 5;
        String expected = MoodCheckerLogic.DISCONTENT;

        assertEquals(expected, MoodCheckerLogic.chooseMoodToStringTest(number));
    }

    @Test
    public void chooseMoodToStringTest_correctValues6_true() {
        int number = 6;
        String expected = MoodCheckerLogic.SURPRISE;

        assertEquals(expected, MoodCheckerLogic.chooseMoodToStringTest(number));
    }

    @Test
    public void chooseMoodToStringTest_correctValues7_true() {
        int number = 7;
        String expected = MoodCheckerLogic.EMBARRASSMENT;

        assertEquals(expected, MoodCheckerLogic.chooseMoodToStringTest(number));
    }


    @Test
    public void chooseMoodToStringTest_correctValues8_true() {
        int number = 8;
        String expected = MoodCheckerLogic.TIREDNESS;

        assertEquals(expected, MoodCheckerLogic.chooseMoodToStringTest(number));
    }


    @Test
    public void chooseMoodToStringTest_correctValues9_true() {
        int number = 9;
        String expected = MoodCheckerLogic.DEPRESSION;

        assertEquals(expected, MoodCheckerLogic.chooseMoodToStringTest(number));
    }

    @Test
    public void chooseMoodToStringTest_correctValues10_true() {
        int number = 10;
        String expected = MoodCheckerLogic.SLEEPY;

        assertEquals(expected, MoodCheckerLogic.chooseMoodToStringTest(number));
    }

    @Test
    public void chooseMoodToStringTest_correctValues11_true() {
        int number = 11;
        String expected = MoodCheckerLogic.CORPSE;

        assertEquals(expected, MoodCheckerLogic.chooseMoodToStringTest(number));
    }

    @Test
    public void chooseMoodToStringTest_correctValues12_true() {
        int number = 0;
        String expected = MoodCheckerLogic.SILENT;

        assertEquals(expected, MoodCheckerLogic.chooseMoodToStringTest(number));
    }

    //means if something will go wrong what does we will have
    @Test
    public void chooseMoodToStringTest_wrongValues_true() {
        int number = -1;
        String expected = MoodCheckerLogic.SILENT;

        assertEquals(expected, MoodCheckerLogic.chooseMoodToStringTest(number));
    }
}
