package by.epam.javatraining.chekun.task01.controller;

import by.epam.javatraining.chekun.task01.model.DragonLogic;
import by.epam.javatraining.chekun.task01.view.Printer;

import java.util.Random;

public class Main {

    public static void main(String[] argc) {

        Random random = new Random();
        int dragonAge = random.nextInt(0 + 5000);

        Printer.print("Dragon age: " + dragonAge
                + "\nCount of heads: " + DragonLogic.calculateCountOfDragonHeads(dragonAge)
                + "\nCount of yeas: " + DragonLogic.calculateCountOfDragonEyes(dragonAge));

    }
}
