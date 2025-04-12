

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

        for (WebElement box : boxes) {
            if (box.findElement(By.cssSelector("h4.title")).getText().equals("Demo eBook")) {
                box.findElement(By.cssSelector("button.view_product")).click();
                break;
            }
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement cartModal = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.EJIframeV3")));
        driver.switchTo().frame(cartModal);

        WebElement addPromoBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='Apply-Button Show-Promo-Code-Button']")));
        addPromoBtn.click();

        WebElement addPromoPlaceHolder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='Promo-Code-Value']")));
        addPromoPlaceHolder.sendKeys("123456");

        WebElement applyBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='Promo-Apply']")));
        applyBtn.click();


    }
}


