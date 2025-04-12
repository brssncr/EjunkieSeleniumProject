import Utlity.BaseDriver;
import Utlity.Myfunc;
import org.junit.Assert;
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

        driver.switchTo().parentFrame();

        WebElement payBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='Pay-Button']")));
        payBtn.click();

        driver.switchTo().defaultContent();

        WebElement shoppingCartMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='green_text_margin']")));
        Assert.assertTrue("Siparişiniz Hatalı", shoppingCartMessage.getText().contains("your order is confirmed. Thank you!"));

        WebElement qtyPrice = driver.findElement(By.cssSelector("div[class='col-md-3 col-sm-3 col-xs-4 text-right'] > :nth-child(1)"));
        WebElement totalPrice = driver.findElement(By.cssSelector("div[class='col-md-6 col-sm-6 col-xs-6 text-right'] > :nth-child(1)"));

        Assert.assertEquals("Fiyatlar uyuşmuyor",
                qtyPrice.getText().replaceAll("Qty\\(\\d+\\)\\s*USD\\s*", ""),
                totalPrice.getText().replaceAll("[^0-9.]", ""));

        WebElement downloadBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='download_btn top10']")));
        downloadBtn.click();

        driver.quit();
    }
}
