package by.chekun.model.reader;

import static org.junit.Assert.*;
import org.junit.Test;

public class VectorInputValidatorTest {

    private VectorInputValidator validator = VectorInputValidator.getInstance();

    @Test
    public void validate_correctParameters_true() {
        String line = "1,2,3,4,5";

        assertTrue(validator.validate(line));
    }

    @Test
    public void validate_correctParameters_false() {
        String line = "1 2 3 4 5";

        assertFalse(validator.validate(line));
    }

    @Test
    public void validate_correctParameters_false_2() {
        String line = "1.2.3.4.5";

        assertFalse(validator.validate(line));
    }

    @Test
    public void validate_correctParameters_false_3() {
        String line = "1.2.3.4.asdf";

        assertFalse(validator.validate(line));
    }

    @Test
    public void validate_correctParameters_false_4() {
        String line = "asdfasdf";

        assertFalse(validator.validate(line));
    }
}