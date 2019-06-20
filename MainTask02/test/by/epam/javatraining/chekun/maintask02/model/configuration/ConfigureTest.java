package by.epam.javatraining.chekun.maintask02.model.configuration;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConfigureTest {

    private static Logger logger = Logger.getLogger(ConfigureFileReaderTest.class);
    private Configure configure = Configure.getInstance();


    @BeforeClass
    public static void beforeClass() {
        logger.info("ConfigureTest started!");
    }

    @Test
    public void configuration_correctResult() {
        configure.configuration();
    }


    @AfterClass
    public static void afterClass() {
        logger.info("ConfigureTest finished!!");
    }
}