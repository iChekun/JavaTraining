package by.epam.javatraining.chekun.maintask02.model.configuration;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConfigurationTest {

    private static Logger logger = Logger.getLogger(ConfigurationFileReaderTest.class);
    private Configuration configuration = Configuration.getInstance();


    @BeforeClass
    public static void beforeClass() {
        logger.info("ConfigurationTest started!");
    }

    @Test
    public void configuration_correctResult() {
        configuration.configuration();
    }


    @AfterClass
    public static void afterClass() {
        logger.info("ConfigurationTest finished!!");
    }
}