import Utlity.BaseDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.NoAlertPresentException;

import java.time.Duration;

public class US_306 extends BaseDriver {
    private Actions actionDriver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test
    public void communicationMessageSendingProcess() {
        actionDriver = new Actions(driver);
        driver.get("https://shopdemo.e-junkie.com/");
        WebElement contactUsButton = driver.findElement(By.linkText("Contact Us"));
        actionDriver.moveToElement(contactUsButton).click().perform();

        WebElement nameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sender_name")));
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sender_email")));
        WebElement subjectField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sender_subject")));
        WebElement messageField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sender_message")));
        WebElement sendButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("send_message_button")));

        nameField.click();
        nameField.clear();
        nameField.sendKeys("Testing");

        emailField.click();
        emailField.clear();
        emailField.sendKeys("team006test@gmail.com");

        subjectField.click();
        subjectField.clear();
        subjectField.sendKeys("Test");

        messageField.click();
        messageField.clear();
        messageField.sendKeys("The test isn't working.");

        sendButton.click();

        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert Text: " + alertText);
            Assert.assertEquals(alertText, "Recaptcha didn't match", "Alert text is not as expected");
            alert.dismiss();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert found.");
        }

        try {
            WebDriverWait captchaWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement captchaError = captchaWait.until(ExpectedConditions.presenceOfElementLocated(By.id("myCaptcha")));
            Assert.assertTrue(captchaError.isDisplayed(), "Captcha error message is not displayed");
        } catch (Exception e) {
            System.out.println("Captcha error message not found: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}