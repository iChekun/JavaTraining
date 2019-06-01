package by.epam.javatraining.chekun.task_3.model;

import java.util.Random;

public class MoodCheckerLogic {

    private static final int RANGE_OF_NUMBERS = 11;

    public static String chooseMoodToString() {

        Random random = new Random();

        int randomNumber = random.nextInt(RANGE_OF_NUMBERS);

        String face = "";

        switch (randomNumber) {
            case 0:
                face = ":-X"; //silent
                break;
            case 1:
                face = ":-)"; // smile
                break;
            case 2:
                face = ":-(";  //sadness
                break;
            case 3:
                face = ":-|"; //thoughtfulness
                break;
            case 4:
                face = ":D";  //laugh
                break;
            case 5:
                face = ":-/"; // discontent
                break;
            case 6:
                face = "O_o"; //surprise
                break;
            case 7:
                face = "^_^"; //embarrassment
                break;
            case 8:
                face = ">_<"; //tiredness
                break;
            case 9:
                face = "u_u"; //depression
                break;
            case 10:
                face = "(-.-)Zzz"; // sleepy
                break;
            case 11:
                face = "(x_x)"; // corpse
                break;
        }

        return face;
    }
}
