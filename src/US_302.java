import Utlity.BaseDriver;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.testng.Assert;

public class US_302 extends BaseDriver {

    @Test
    public void invalidPaymentTest() {
        driver.get("http://shopdemo.e-junkie.com/");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".Payment-Button.Credit-Card")));
        driver.switchTo().frame("EJIframe");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".Payment-Button.Credit-Card")));
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String emailError = driver.findElement(By.id("SnackBar")).getText();
        Assert.assertTrue(emailError.contains("Invalid Email") || emailError.contains("Geçersiz"), "Hata mesajı beklenenden farklı: " + emailError);

        driver.switchTo().defaultContent();
    }
}