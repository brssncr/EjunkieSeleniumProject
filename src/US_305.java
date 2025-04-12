import Utlity.BaseDriver;
import Utlity.Myfunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class US_305 extends BaseDriver {
    @Test
    public void paymentProcessApprocalAndDowload() {
        driver.get("https://shopdemo.fatfreeshop.com/?");

        List<WebElement> boxes = driver.findElements(By.cssSelector("div.box"));

        for (WebElement box : boxes) {
            if (box.findElement(By.cssSelector("h4.title")).getText().equals("Demo eBook")) {
                box.findElement(By.cssSelector("button.view_product")).click();
                break;
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement cartModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe.EJIframeV3")));
        driver.switchTo().frame(cartModal);

        WebElement creditCardButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.Payment-Button.CC")));
        creditCardButton.click();

        WebElement emailPlaceHolder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Email']")));
        emailPlaceHolder.sendKeys("team006test@gmail.com");

        WebElement confirmEmailPlaceHolder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Confirm Email']")));
        confirmEmailPlaceHolder.sendKeys("team006test@gmail.com");

        WebElement namePlaceHolder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Name On Card']")));
        namePlaceHolder.sendKeys("´TEAMSIX");

        driver.switchTo().frame(1);

        WebElement cardNumberPlaceHolder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@autocomplete='cc-number']")));
        cardNumberPlaceHolder.sendKeys("4242424242424242");

        WebElement expiration = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='InputElement is-empty Input Input--empty']")));
        expiration.sendKeys("1225");

        WebElement cvv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@autocomplete='cc-csc']")));
        cvv.sendKeys("000");

        Myfunc.Wait(20);
    }
}
