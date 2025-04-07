package Utlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseDriverParameter {
    public  WebDriver driver;
    public  WebDriverWait WaitTime;

    @BeforeClass
    @Parameters("Browser")
    public void Setup(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox": driver = new FirefoxDriver();break;
            case "edge": driver = new EdgeDriver();break;
            default: driver = new ChromeDriver();break;
        }
        driver.manage().window().maximize();
        WaitTime = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        LoginTest();
    }

    public void LoginTest() {
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("geyat20709@boyaga.com");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("taner12345");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
        Assert.assertTrue(driver.getTitle().contains("My Account"), "aranan mesaj ");
    }

    @AfterClass
    public void TearDown() {
        Myfunc.Wait(3);
        driver.quit();
    }
}
