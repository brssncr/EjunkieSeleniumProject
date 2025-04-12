

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.Utilities;

import java.time.Duration;
import java.util.List;

import static Utlity.BaseDriver.driver;

public class US_301 {



    @Test
    public void Test1() {
        driver.get("https://shopdemo.fatfreeshop.com/?");

        List<WebElement> boxes = driver.findElements(By.cssSelector("div.box"));

            }
        }


