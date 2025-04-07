import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_308 extends BaseDriver {
    @Test
    public void openingTheWebsite(){
        driver.get("https://shopdemo.fatfreeshop.com/?");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("EJ-ShopLink")));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("EJ-ShopLink")));
        WebElement eCommerceButton=driver.findElement(By.className("EJ-ShopLink"));
        actionDriver.scrollToElement(eCommerceButton).moveToElement(eCommerceButton).click().build().perform();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.e-junkie.com");
    }
}
