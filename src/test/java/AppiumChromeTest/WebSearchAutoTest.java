package AppiumChromeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.assertEquals;

public class WebSearchAutoTest extends BaseClass{
    @Test
    public void searchTest() throws InterruptedException {
        driver.get("https://new.yapo.cl/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        driver.findElement(By.xpath("/html/body/app-root/home-index/home-search/div/a[2]/img")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        driver.findElement(By.xpath("/html/body/app-root/home-index/div/home-filters/div/div/div[1]/div[9]/home-search-text/input")).sendKeys("moto kawasaki");
        driver.findElement(By.xpath("/html/body/app-root/home-index/div/home-filters/div/div/div[2]/button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));

        WebElement message = driver.findElement(By.xpath("/html/body/app-root/listing-index/listing-main/div[2]/div/div/listing-result-list/div/h1"));
        String value = message.getText();
        assertEquals("Resultados en Autos, camionetas y 4x4.", value);

    }
}
