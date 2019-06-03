package by.epam.javatraining.chekun.task01.controller;

import by.epam.javatraining.chekun.task01.model.DragonLogic;
import by.epam.javatraining.chekun.task01.view.Printer;

public class Main {

    public static void main(String[] argc) {

        int dragonAge = 10;
        Printer.print("Dragon age: " + dragonAge
                + "\nCount of heads: " + DragonLogic.calculateCountOfDragonHeads(dragonAge)
                + "\nCount of yeas: " + DragonLogic.calculateCountOfDragonEyes(dragonAge));

    }
}
