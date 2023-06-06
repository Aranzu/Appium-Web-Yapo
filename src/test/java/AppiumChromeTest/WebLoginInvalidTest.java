package AppiumChromeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.assertEquals;

public class WebLoginInvalidTest extends BaseClass{
    @Test
    public void testLogin() throws InterruptedException {
        driver.get("https://www2.yapo.cl/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        driver.findElement(By.id("accbar_email")).sendKeys("rsol777ddd@gmail.com");
        driver.findElement(By.id("accbar_password")).sendKeys("fghd56565");
        driver.findElement(By.id("acc_login_submit_button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));

        WebElement message = driver.findElement(By.xpath("//*[@id=\"login-box\"]/form/span[2]"));
        String value = message.getText();
        assertEquals("El correo electrónico y/o la contraseña que ingresaste son incorrectos.", value);
    }
}