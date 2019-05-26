package by.chekun.action.checkingSequences;

/**
 * Using for checking sequences and definition her type
 *
 * @author Chekun
 */
public class CheckingSequences {

    /**
     * Takes three numerals, returns sequences type
     *
     * @param firstNumeral  {@code int}
     * @param secondNumeral {@code int}
     * @param thirdNumeral  {@code int}
     * @param fourthNumeral {@code int}
     * @return {@code String} String line with answer about sequences type
     */
    public static String isGrowingSequences(int firstNumeral,
                                            int secondNumeral,
                                            int thirdNumeral,
                                            int fourthNumeral) {

        if ((firstNumeral < secondNumeral)
                && (secondNumeral < thirdNumeral)
                && (thirdNumeral < fourthNumeral)) {
            return "Цифры идут в порядке возрастания: "
                    + firstNumeral + secondNumeral + thirdNumeral + fourthNumeral;
        } else if ((firstNumeral > secondNumeral)
                && (secondNumeral > thirdNumeral)
                && (thirdNumeral > fourthNumeral)) {
            return "Цифры идут в порядке убывания: "
                    + firstNumeral + secondNumeral + thirdNumeral + fourthNumeral;
        } else {
            return "Цифры не образует последовательность";
        }
    }
}
