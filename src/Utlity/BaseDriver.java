package Utlity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeClass
    public void Setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();// Ekranı max yapıyor.
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 20 sn mühlet: elementi bulma mühleti
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
