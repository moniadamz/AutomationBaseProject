import common.Property;
import common.Selenium;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseTestCase {
    protected static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception{
        driver = Selenium.getDriver();
        driver.navigate().to(Property.SITE_ADDRESS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void afterClass() throws Exception{
        driver.quit();
    }
}
