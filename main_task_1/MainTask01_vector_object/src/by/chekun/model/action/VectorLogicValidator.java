package by.chekun.model.action;

import by.chekun.model.entity.Vector;

public class VectorLogicValidator {

    private static VectorLogicValidator INSTANCE = new VectorLogicValidator();

    public static VectorLogicValidator getInstance() {
        return INSTANCE;
    }

    private VectorLogicValidator() {
    }
    ///////////

    public boolean validate(Vector vector) {
        return vector != null;
    }

}
