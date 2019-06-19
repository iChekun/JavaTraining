package by.chekun.model.reader;

public class VectorInputValidator {

    private static VectorInputValidator INSTANCE = new VectorInputValidator();

    public static VectorInputValidator getInstance() {
        return INSTANCE;
    }
    private VectorInputValidator() { }
    ////////////


    private static final String FORMAT = "(\\d+, ?)+(\\d+)?";

    public boolean validate(String line) {
        return line != null && line.matches(FORMAT);
    }
}
