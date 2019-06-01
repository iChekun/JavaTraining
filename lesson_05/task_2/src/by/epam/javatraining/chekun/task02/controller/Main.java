package by.epam.javatraining.chekun.task02.controller;

import by.epam.javatraining.chekun.task02.model.Logic;
import by.epam.javatraining.chekun.task02.view.Printer;

public class Main {

    public static void main(String[] argc) {
        {
            char[] englishSymbols = {'a', 'U', 95, 'e', 'z', 'y', 'M', 'I', 'q', 125, 130, 'o', 117};

            for (char i : englishSymbols) {
                if (Logic.isVowelEnglish(i)) {
                    Printer.print("English symbol " + i + " is vowel!");
                }
            }
        }

        Printer.print("---------------------------");

        {
            char[] russianSymbols = {'А', 'о', 95, 'Ы', 'м', 'ю', 'э', 'з', 'и', 125, 1102, 'о', 'я'};

            for (char i : russianSymbols) {
                if (Logic.isVowelRussian(i)) {
                    Printer.print("Russian symbol " + i + " is vowel!");
                }
            }
        }

        Printer.print("---------------------------");

        {
            char[] Symbols = {'a', 'U', 95, 'e', 'z', 'y', 'M', 'I', 'q', 125, 130, 'o', 117,
                    'А', 'о', 95, 'Ы', 'м', 'ю', 'э', 'з', 'и', 125, 1102, 'о', 'я'};

            for (char i : Symbols) {
                if (Logic.isVowel(i)) {
                    Printer.print("Symbol " + i + " is vowel!");
                }
            }
        }
    }
}
