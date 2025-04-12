import Utlity.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US_303 extends BaseDriver {
    @Test
    public void US_303(){
        driver.get("https://shopdemo.fatfreeshop.com/?");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='view_product'])[2]"))).click();
        driver.switchTo().frame(5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='Payment-Button CC']"))).click();
        WebElement email= driver.findElement(By.xpath("//input[@placeholder='Email']"));
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys("team006test@gmail.com");
        WebElement confirmEmail= driver.findElement(By.xpath("//input[@placeholder='Confirm Email']"));
        wait.until(ExpectedConditions.visibilityOf(confirmEmail));
        confirmEmail.sendKeys("team006test@gmail.com");
        WebElement nameOnCard= driver.findElement(By.xpath("//input[@placeholder='Name On Card']"));
        wait.until(ExpectedConditions.visibilityOf(nameOnCard));
        nameOnCard.sendKeys("Testing");
        WebElement iframe=driver.findElement(By.xpath("(//iframe[@allow='payment *'])[1]"));
        driver.switchTo().frame(iframe);
        WebElement cardNumbers=driver.findElement(By.xpath("(//span[@class='InputContainer'])[1]/input"));
        wait.until(ExpectedConditions.visibilityOf(cardNumbers));
        cardNumbers.sendKeys("1111 1111 1111 1111");





    }
}
