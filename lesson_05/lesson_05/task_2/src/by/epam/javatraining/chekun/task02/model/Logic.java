package by.epam.javatraining.chekun.task02.model;


public class Logic {


    public static boolean isVowel(char symbol) {

        String vowelSymbols = "aeiouy";

        return vowelSymbols.contains(Character.toString(symbol).toLowerCase());
    }

    public static boolean isVowelEnglish(char symbol) {

        char[] vowelSymbols = {'a', 'e', 'i', 'o', 'u', 'y'};

        // converting symbol to ansi code
        for (int vowel : vowelSymbols) {
            // changing symbol to lowercase and convert to ansi
            if ((int) Character.toLowerCase(symbol) == vowel) {
                return true;
            }
        }

        return false;
    }

    public static boolean isVowelRussian(char symbol) {

        char[] vowelSymbols = {'а', 'о', 'э', 'и', 'у', 'ы', 'е', 'ё', 'ю', 'я'};

        // converting symbol to ansi code
        for (int vowel : vowelSymbols) {
            // changing symbol to lowercase and convert to ansi
            if ((int) Character.toLowerCase(symbol) == vowel) {
                return true;
            }
        }

        return false;
    }

    public static boolean isVowelEnglish2(char symbol) {

        switch (Character.toLowerCase(symbol)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
                return true;
        }

        return false;
    }
}
