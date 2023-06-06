package AppiumChromeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class WebLoginEmptyTest extends BaseClass{
    @Test
    public void testLogin() throws InterruptedException {
        driver.get("https://www2.yapo.cl/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        driver.findElement(By.id("acc_login_submit_button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));

        WebElement message = driver.findElement(By.xpath("//*[@id=\"login-box\"]/form/span[1]"));
        String value = message.getText();
        assertEquals("Escribe tu e-mail", value);
    }
}