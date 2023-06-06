package AppiumChromeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class WebComprarNoEmailTest extends BaseClass{
    @Test
    public void comprarWrongTest() throws InterruptedException {
        driver.get("https://www2.yapo.cl/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        driver.findElement(By.id("accbar_email")).sendKeys("rsol777ddd@gmail.com");
        driver.findElement(By.id("accbar_password")).sendKeys("asdSSRR545");
        driver.findElement(By.id("acc_login_submit_button")).click();
        Thread.sleep(5000);

        driver.get("https://new.yapo.cl/");
        driver.findElement(By.xpath("/html/body/app-root/home-index/home-search/app-search-form/div/app-search-autocomplete/div[1]/input")).sendKeys("Reposamuñecas DeltaHub Carpio 2.0");
        driver.findElement(By.xpath("/html/body/app-root/home-index/home-search/app-search-form/div/button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get("https://new.yapo.cl/marketplace/reposamuecas-delta-hub-carpio-20_87245217");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.findElement(By.xpath("/html/body/app-root/adview-index/adview-bottom-bar/div/div/a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.findElement(By.id("delivery_strategies-PICK_UP")).click();
        driver.findElement(By.xpath("//*[@id=\"Form1\"]/div[1]/div/div[2]/div[2]/div[1]/button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        Thread.sleep(2000);

        WebElement message = driver.findElement(By.id("error-for-email"));
        String value = message.getText();
        assertEquals("Introduce un correo electrónico", value);
    }
}