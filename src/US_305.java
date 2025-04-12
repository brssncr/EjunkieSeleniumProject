import Utlity.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
    }
}
