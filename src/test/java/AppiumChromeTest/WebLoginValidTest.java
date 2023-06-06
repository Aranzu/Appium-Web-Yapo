package AppiumChromeTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.assertEquals;

public class WebLoginValidTest extends BaseClass{
    @Test
    public void testLogin() throws InterruptedException {
            driver.get("https://www2.yapo.cl/login");
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
            driver.findElement(By.id("accbar_email")).sendKeys("rsol777ddd@gmail.com");
            driver.findElement(By.id("accbar_password")).sendKeys("asdSSRR545");
            driver.findElement(By.id("acc_login_submit_button")).click();
            Thread.sleep(5000);

            String url = driver.getCurrentUrl();
            assertEquals("https://www2.yapo.cl/dashboard", url);
    }
}