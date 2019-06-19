package by.chekun.model.factory;

import by.chekun.model.action.VectorChecker;
import by.chekun.model.entity.Vector;
import by.chekun.model.exception.WrongArgumentsException;

public class Factory {

    private static final Factory INSTANCE = new Factory();

    public static Factory getInstance() {
        return INSTANCE;
    }

    private Factory() {
    }

    /////////

    public Vector createVector(double... params) throws WrongArgumentsException {

        VectorChecker vectorChecker = VectorChecker.getInstance();
        if (vectorChecker.isVector(params)) {
            return new Vector(params);
        }
        //then exception
        throw new WrongArgumentsException("Method createVector() received wrong parameters");
    }

}
