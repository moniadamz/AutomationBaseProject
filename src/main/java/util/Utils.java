package util;

import common.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

public class Utils {
    private static final WebDriver driver;
    private static final WebDriverWait wait;

    static{
        driver = Selenium.getDriver();
        wait = new WebDriverWait(driver, 10);
    }

    public static void isVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static void isVisible(String id){
        isVisible(By.id(id));
    }

    public static void isLocated(By locator){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public static void isLocated(String id){
        isLocated(By.id(id));
    }

    public static void isClickable(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void isClickable(String id){
        isClickable(By.id(id));
    }

    public static void takeScreenshot(String fileName){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Date data = new Date(0);
        try{
            FileUtils.copyFile(scrFile, new File("C:\\Users\\Monica_Adamski\\Desktop\\SeleniumScreenshots"+ fileName + data.getTime()+ ".jpeg"), true);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void wait(final int iTimeInMillis){
        try{
            Thread.sleep(iTimeInMillis);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
