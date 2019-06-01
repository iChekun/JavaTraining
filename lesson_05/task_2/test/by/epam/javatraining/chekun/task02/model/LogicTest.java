package by.epam.javatraining.chekun.task02.model;


import org.junit.Test;

import static org.junit.Assert.*;


public class LogicTest {

    @Test
    public void testIsVowel_true() {

        char symbol = 'A';

        assertTrue(Logic.isVowel(symbol));
    }

    @Test
    public void testIsVowel_false() {

        char symbol = 'о';

        assertFalse(Logic.isVowel(symbol));
    }


    @Test
    public void testIsVowelUpperCase_true() {

        char symbol = 'и';

        assertTrue(Logic.isVowel(symbol));
    }

    @Test
    public void testIsVowelEnglish_true() {

        char symbol = 'A';

        assertTrue(Logic.isVowelEnglish(symbol));
    }

    @Test
    public void testIsVowelEnglish_false() {

        char symbol = 'b';

        assertFalse(Logic.isVowelEnglish(symbol));
    }


    @Test
    public void testIsVowelEnglishUpperCase_true() {

        char symbol = 'U';

        assertTrue(Logic.isVowelEnglish(symbol));
    }


    @Test
    public void testIsVowelEnglish_giveSymbol_true() {

        char symbol = 117; // equal u

        assertTrue(Logic.isVowelEnglish(symbol));
    }

    @Test
    public void testIsVowelEnglish_giveSymbol_false() {

        char symbol = 50; // equal 2

        assertFalse(Logic.isVowelEnglish(symbol));
    }

    @Test
    public void testIsVowelEnglish_giveBadSymbol_false() {

        char symbol = '.';

        assertFalse(Logic.isVowelEnglish(symbol));
    }

    @Test
    public void testIsVowelRussian_true() {

        char symbol = 'ы';

        assertTrue(Logic.isVowelRussian(symbol));
    }

    @Test
    public void testIsVowelRussian_false() {

        char symbol = 'м';

        assertFalse(Logic.isVowelRussian(symbol));
    }


    @Test
    public void testIsVowelRussianUpperCase_true() {

        char symbol = 'э';

        assertTrue(Logic.isVowelRussian(symbol));
    }


    @Test
    public void testIsVowelRussian_giveSymbol_true() {

        char symbol = 1102; // equal 'ю'

        assertTrue(Logic.isVowelRussian(symbol));
    }

    @Test
    public void testIsVowelRussian_giveSymbol_false() {

        char symbol = 50; // equal 2

        assertFalse(Logic.isVowelRussian(symbol));
    }

    @Test
    public void testIsVowelRussian_giveBadSymbol_false() {

        char symbol = '.';

        assertFalse(Logic.isVowelRussian(symbol));
    }


}
