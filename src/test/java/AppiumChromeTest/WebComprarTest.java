package AppiumChromeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class WebComprarTest extends BaseClass{
    @Test
    public void comprarTest() throws InterruptedException {
        driver.get("https://www2.yapo.cl/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        driver.findElement(By.id("accbar_email")).sendKeys("rsol777ddd@gmail.com");
        driver.findElement(By.id("accbar_password")).sendKeys("asdSSRR545");
        driver.findElement(By.id("acc_login_submit_button")).click();
        Thread.sleep(5000);

        //una vez loguado, di
        driver.get("https://new.yapo.cl/");
        driver.findElement(By.xpath("/html/body/app-root/home-index/home-search/app-search-form/div/app-search-autocomplete/div[1]/input")).sendKeys("Smartwatch soymomo space lite rosado openbox");
        driver.findElement(By.xpath("/html/body/app-root/home-index/home-search/app-search-form/div/button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get("https://new.yapo.cl/marketplace/smartwatch-soymomo-space-lite-rosado-openbox_86959824");
        driver.findElement(By.xpath("/html/body/app-root/adview-index/adview-bottom-bar/div/div/a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.findElement(By.id("email")).sendKeys("rsol777ddd@gmail.com");
        driver.findElement(By.id("delivery_strategies-PICK_UP")).click();
        driver.findElement(By.xpath("//*[@id=\"Form1\"]/div[1]/div/div[2]/div[2]/div[1]/button")).submit();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        Thread.sleep(2000);

        String url = driver.getCurrentUrl();
        assertEquals("https://compra.yapo.cl/checkouts/c/0f81d27bb27f6807c887cb3cd37c36fa/payment", url);
    }
}