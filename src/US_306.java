import Utlity.BaseDriver;
import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class US_306 extends BaseDriver {

    @Test
    public void communicationMessageSendingProcess() {

        driver.get("https://shopdemo.e-junkie.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement contactUsButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Contact Us")));
        actionDriver.moveToElement(contactUsButton).click().perform();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeID")));

        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement subjectField = driver.findElement(By.id("subject"));
        WebElement messageField = driver.findElement(By.id("message"));
        nameField.sendKeys("Testing");
        emailField.sendKeys("team006test@gmail.com");
        subjectField.sendKeys("Test");
        messageField.sendKeys("The test isn't working.");

        WebElement sendButton = driver.findElement(By.id("sendMessage"));
        actionDriver.moveToElement(sendButton).click().perform();

        WebElement recaptchaAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recaptchaError")));
        String alertText = "Recaptcha Didn't Match";

        wait.until(ExpectedConditions.elementToBeClickable(sendButton));

        Actions actionDriver = new Actions(driver);

        actionDriver.moveToElement(sendButton).click().perform();

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successMessage")));
        String successMessageText = "Message sent successfully";

        driver.switchTo().defaultContent();
    }
}


