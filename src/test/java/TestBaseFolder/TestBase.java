package TestBaseFolder;
import Pages.HomePage;
import configuration.BrowserEnvironment;
import configuration.EnvironmentProperty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import static java.lang.System.getProperty;
public class TestBase {
    protected static WebDriver driver;
    public HomePage homePage;

    private static Logger logger = LoggerFactory.getLogger("TestBase.class");
    private static BrowserEnvironment browserEnvironment;
    public static EnvironmentProperty environmentProperty;

    @BeforeAll
    public static void connect() {
        environmentProperty = EnvironmentProperty.getInstance();
        browserEnvironment = new BrowserEnvironment();
        driver = browserEnvironment.getDriver();
        logger.debug("Driver initialized");
        logger.debug("implicit wait set for 15 sec");
    }

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(driver);
        logger.debug("create object homePage");
    }

    @AfterEach
    void TearDown() {
        driver.quit();
        logger.debug("Driver closed");
    }
}