package by.epam.javatraining.chekun.task_3.model;

import java.util.Random;

public class MoodCheckerLogic {

    public static final String SILENT = ":-X";
    public static final String SMILE = ":-)";
    public static final String SADNESS = ":-(";
    public static final String THOUGHTFULNESS = ":-L";
    public static final String LAUGH = ":D";
    public static final String DISCONTENT = ":-/";
    public static final String SURPRISE = "O_o";
    public static final String EMBARRASSMENT = "^_^";
    public static final String TIREDNESS = ">_<";
    public static final String DEPRESSION = "u_u";
    public static final String SLEEPY = "(-.-)Zzz";
    public static final String CORPSE = "(x_x)";

    public static final int COUNT_OF_MOODS = 12;

    private static final Random random = new Random(COUNT_OF_MOODS);

    public static String chooseMoodToString() {

        String face = SILENT;

        switch (random.nextInt(COUNT_OF_MOODS)) {
            case 1:  face = SMILE;          break;
            case 2:  face = SADNESS;        break;
            case 3:  face = THOUGHTFULNESS; break;
            case 4:  face = LAUGH;          break;
            case 5:  face = DISCONTENT;     break;
            case 6:  face = SURPRISE;       break;
            case 7:  face = EMBARRASSMENT;  break;
            case 8:  face = TIREDNESS;      break;
            case 9:  face = DEPRESSION;     break;
            case 10: face = SLEEPY;         break;
            case 11: face = CORPSE;         break;
        }

        return face;
    }

    //package level  Method  for Testing!
     static String chooseMoodToStringTest(int number) {

        String face = SILENT;

        switch (number) {
            case 1:  face = SMILE;          break;
            case 2:  face = SADNESS;        break;
            case 3:  face = THOUGHTFULNESS; break;
            case 4:  face = LAUGH;          break;
            case 5:  face = DISCONTENT;     break;
            case 6:  face = SURPRISE;       break;
            case 7:  face = EMBARRASSMENT;  break;
            case 8:  face = TIREDNESS;      break;
            case 9:  face = DEPRESSION;     break;
            case 10: face = SLEEPY;         break;
            case 11: face = CORPSE;         break;
        }

        return face;
    }
}
