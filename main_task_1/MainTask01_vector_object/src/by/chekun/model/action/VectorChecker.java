package by.chekun.model.action;

public class VectorChecker {

    private static VectorChecker INSTANCE = new VectorChecker();

    public static VectorChecker getInstance() {
        return INSTANCE;
    }

    private VectorChecker() {
    }
    ////////////

    public boolean isVector(double... params) {
        return params.length != 0;
    }

}
