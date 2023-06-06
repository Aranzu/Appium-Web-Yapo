package AppiumChromeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class WebPublicarNoDescTest extends BaseClass{
    @Test
    public void publicarInvalidTest2() throws InterruptedException {
        driver.get("https://www2.yapo.cl/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        driver.findElement(By.id("accbar_email")).sendKeys("rsol777ddd@gmail.com");
        driver.findElement(By.id("accbar_password")).sendKeys("asdSSRR545");
        driver.findElement(By.id("acc_login_submit_button")).click();
        Thread.sleep(5000);

        //una vez loguado, dirigirse a la publicación
        driver.get("https://m.yapo.cl/publica-un-aviso");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"hst-parent_category\"]/a")).click();
        driver.findElement(By.id("parent_category-8000")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.findElement(By.id("subject")).sendKeys("Florero");
        driver.findElement(By.id("price")).sendKeys("5000");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        Thread.sleep(5000);

        driver.findElement(By.id("label_phoneInputTypeHome")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.findElement(By.xpath("//*[@id=\"newad_form\"]/fieldset[7]/div/button")).click();
        //driver.findElement(By.id("iat-adhesion-bar-514057")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        Thread.sleep(5000);

        WebElement message = driver.findElement(By.id("body-error"));
        String value = message.getText();
        assertEquals("Escribe una descripción", value);

    }
}