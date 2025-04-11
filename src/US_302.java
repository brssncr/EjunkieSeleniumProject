import Utlity.BaseDriver;

public class US_302 extends BaseDriver {

    @Test
    public void invalidPaymentTest() {
        driver.get("http://shopdemo.e-junkie.com/");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".Payment-Button.Credit-Card")));

        driver.switchTo().frmae("EJIframe");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".Payment-Button.Credit-Card")));

        driver.findElement(By.cssSelector("butoon[type='submit']")).click();

        String emailError = driver.findElement(By.id("SnackBar")).get.text();

        Assert.assertTrue(emailError.contains("Invalid Email")) || emailError.contains("Geçersiz");

        driver.switchTo().defaultContent();

    }
}
