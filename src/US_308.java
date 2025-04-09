import Utlity.BaseDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class US_308 extends BaseDriver {
    @Test(priority = 1)
    public void openingTheWebsite() {
        driver.get("https://shopdemo.fatfreeshop.com/?");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("EJ-ShopLink")));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("EJ-ShopLink")));
        WebElement eCommerceButton = driver.findElement(By.className("EJ-ShopLink"));
        actionDriver.scrollToElement(eCommerceButton).moveToElement(eCommerceButton).click().build().perform();

        wait.until(ExpectedConditions.urlMatches("https://www.e-junkie.com"));
        Assert.assertTrue("Siteye geçiş yapılamadı.",driver.getCurrentUrl().contains("e-junkie"));
    }
    @Test(priority = 2)
    public void navigateToTheVideo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"offerModal\"]/div[2]/section/div")));
        WebElement blueButtonForVideo =driver.findElement(By.cssSelector("a[class='blue_btn'][onclick='toggleYoutubeModal(true)']"));

        actionDriver.moveToElement(blueButtonForVideo,-100,-100).click().build().perform();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"offerModal\"]/div[2]/section/div")));

        actionDriver.moveToElement(blueButtonForVideo).click().build().perform();

        WebElement youtubeFrame = driver.findElement(By.cssSelector("iframe[src='https://www.youtube.com/embed/kODFTdj9Ifc']"));

        driver.switchTo().frame(youtubeFrame);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[title='Oynat']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Oynat']")));
        driver.findElement(By.cssSelector("button[title='Oynat']")).click();
    }
}
