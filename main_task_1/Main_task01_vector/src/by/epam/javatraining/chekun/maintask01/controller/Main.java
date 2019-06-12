package by.epam.javatraining.chekun.maintask01.controller;

import by.epam.javatraining.chekun.maintask01.model.action.VectorLogic;
import by.epam.javatraining.chekun.maintask01.model.exception.WrongArgumentsException;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static final Random random = new Random();
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] argc) {

        int arraySize = 10;
        double[] array = new double[arraySize];

        LOGGER.info("Create and initialize array");

        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(50 - 5);
        }

        LOGGER.info("Start array: " + Arrays.toString(array));

        try {
            LOGGER.info("MAX value: " + VectorLogic.findMaxValue(array));
        } catch (WrongArgumentsException e) {
            LOGGER.error(e.getMessage());
        }

        try {
            LOGGER.info("MIN value: " + VectorLogic.findMinValue(array));
        } catch (WrongArgumentsException e) {
            LOGGER.error(e.getMessage());
        }


        try {
            LOGGER.info("Arithmetic Average Value is: " + VectorLogic.calculateArithmeticAverageValue(array));
        } catch (WrongArgumentsException e) {
            LOGGER.error(e.getMessage());
        }

        try {
            LOGGER.info("Geometric Average Value is: " + VectorLogic.calculateGeometricAverageValue(array));
        } catch (WrongArgumentsException e) {
            LOGGER.error(e.getMessage());
        }

        try {
            LOGGER.info("Local min position is: " + VectorLogic.findLocalMinPosition(array));
        } catch (WrongArgumentsException e) {
            LOGGER.error(e.getMessage());
        }

        try {
            LOGGER.info("Local max position is: " + VectorLogic.findLocalMaxPosition(array));
        } catch (WrongArgumentsException e) {
            LOGGER.error(e.getMessage());
        }

        try {
            double valueForSearch = 2;
            LOGGER.info("(linearSearch) Find value = " + valueForSearch + " position: " +
                    VectorLogic.findValuePositionLinearSearch(array, valueForSearch));
        } catch (WrongArgumentsException e) {
            LOGGER.error(e.getMessage());
        }

        try {
            double valueForSearch = 2;

            LOGGER.info("(BinarySearch) Find value = " + valueForSearch + " position: " +
                    VectorLogic.findValuePositionBinarySearch(array, valueForSearch));
        } catch (WrongArgumentsException e) {
            LOGGER.error(e.getMessage());
        }

        try {
            //i'm doing this because don't want to lose start array
            double[] copyArray = array;

            VectorLogic.flipArray(copyArray);
            LOGGER.info("Reversed array: " + Arrays.toString(copyArray));
        } catch (WrongArgumentsException e) {
            LOGGER.error(e.getMessage());
        }

        try {
            double[] copyArray = array;

            VectorLogic.bubbleSort(copyArray);
            LOGGER.info("(bubbleSort) Array: " + Arrays.toString(copyArray));
        } catch (WrongArgumentsException e) {
            LOGGER.error(e.getMessage());
        }

        try {
            double[] copyArray = array;

            VectorLogic.shakerSort(copyArray);
            LOGGER.info("(shakerSort) Array: " + Arrays.toString(copyArray));
        } catch (WrongArgumentsException e) {
            LOGGER.error(e.getMessage());
        }

        try {
            double[] copyArray = array;

            VectorLogic.insertionSort(copyArray);
            LOGGER.info("(insertionSort) Array: " + Arrays.toString(copyArray));
        } catch (WrongArgumentsException e) {
            LOGGER.error(e.getMessage());
        }

        try {
            double[] copyArray = array;

            VectorLogic.selectionSort(copyArray);
            LOGGER.info("(selectionSort) Array: " + Arrays.toString(copyArray));
        } catch (WrongArgumentsException e) {
            LOGGER.error(e.getMessage());
        }

        try {
            double[] copyArray = array;

            VectorLogic.sortMerge(copyArray);
            LOGGER.info("(sortMerge) Array: " + Arrays.toString(copyArray));
        } catch (WrongArgumentsException e) {
            LOGGER.error(e.getMessage());
        }


        try {
            double[] copyArray = array;

            VectorLogic.quickSort(copyArray);
            LOGGER.info("(quickSort) Array: " + Arrays.toString(copyArray));
        } catch (WrongArgumentsException e) {
            LOGGER.error(e.getMessage());
        }
    }


}
