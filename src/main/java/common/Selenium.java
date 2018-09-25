package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Selenium {
    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        String browser = Property.BROWSER_NAME;
        if (driver == null) {
            if (Browser.CHROME.equals(browser)) {
                File file = new File(Property.CHROME_DRIVE_PATH);
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                driver = new ChromeDriver();
            }
        }
        return driver;
    }
}


