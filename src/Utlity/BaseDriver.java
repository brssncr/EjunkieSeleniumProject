package Utlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver;
    public Actions actionDriver;
    public static WebDriverWait wait;

    @BeforeClass
    public void Setup() {
        driver = new ChromeDriver();
        actionDriver = new Actions(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

   @AfterClass
    public void TearDown() {
        Myfunc.Wait(10);
        driver.quit();
    }
}
