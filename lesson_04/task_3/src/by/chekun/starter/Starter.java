package by.chekun.starter;

import by.chekun.action.checkingSequences.CheckingSequences;
import by.chekun.action.parsingNumbers.ParsingNumbers;
import by.chekun.printer.Printer;

/**
 * @author Chekun
 * Разработайте программу, которая проверяет, что цифры положительного четырёхзначного числа
 * образуют возрастающую (убывающую) последовательность
 * (к примеру, число 1357 удовлетворяет условию,
 * т.к. его цифры соответствуют следующему неравенству: 1 < 3 < 5 < 7, т.е.
 * идут в порядке возрастания).
 */

public class Starter {

    public static void main(String[] argc) {

        int number = 3456;
        String result = "Число не является четырехзначным";

        if ((number >= 1000) && (number <= 9999)) {
            //1
            result = getSequenceType(number);
            Printer.println("Число " + number + ". " + result);
            //2
            number = 7654;
            result = getSequenceType(number);
            Printer.println("Число " + number + ". " + result);
            //3
            number = 7777;
            result = getSequenceType(number);
            Printer.println("Число " + number + ". " + result);
        }
    }

    /**
     * Private function which helps in parsing numbers
     * and returns answer about sequence type of numerals in number.
     *
     * @param number (@code int) Number for parsing
     * @return String line with answer
     */
    private static String getSequenceType(int number) {

        int firstNumeral = ParsingNumbers.getNumeral(number, 4);
        int secondNumeral = ParsingNumbers.getNumeral(number, 3);
        int thirdNumeral = ParsingNumbers.getNumeral(number, 2);
        int fourthNumeral = ParsingNumbers.getNumeral(number, 1);

        return CheckingSequences.isGrowingSequences(firstNumeral,
                secondNumeral, thirdNumeral, fourthNumeral);
    }
}

