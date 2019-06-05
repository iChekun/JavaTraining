package by.epam.javatraining.chekun.task_2.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckingSequenceTest {

    @Test
    public void isSequenceGrowing_correctParameters_true() {

        int number = 12345;

        assertTrue(CheckingSequence.isSequenceGrowing(number));
    }

    @Test
    public void isSequenceGrowing_wrongParameters_false() {

        int number = -1;

        assertFalse(CheckingSequence.isSequenceGrowing(number));
    }

    @Test
    public void isSequenceGrowing_wrongParameters2_false() {

        int number = 59214;

        assertFalse(CheckingSequence.isSequenceGrowing(number));
    }

    @Test
    public void isSequenceGrowing_wrongParameters3_false() {

        int number = 7;

        assertFalse(CheckingSequence.isSequenceGrowing(number));
    }

    @Test
    public void isSequenceDecreases_correctParameters_true() {

        int number = 987_654_321;

        assertTrue(CheckingSequence.isSequenceDecreases(number));
    }

    @Test
    public void isSequenceDecreases_correctParameters2_true() {

        int number = 654;

        assertTrue(CheckingSequence.isSequenceDecreases(number));
    }

    @Test
    public void isSequenceDecreases_wrongParameters_false() {

        int number = 12345;

        assertFalse(CheckingSequence.isSequenceDecreases(number));
    }

    @Test
    public void isSequenceDecreases_wrongParameters2_false() {

        int number = 2;

        assertFalse(CheckingSequence.isSequenceDecreases(number));
    }
}