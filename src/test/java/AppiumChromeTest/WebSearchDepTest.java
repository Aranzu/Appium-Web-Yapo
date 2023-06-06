package AppiumChromeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class WebSearchDepTest extends BaseClass{
    @Test
    public void searchTest() throws InterruptedException {
        driver.get("https://new.yapo.cl/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        driver.findElement(By.xpath("/html/body/app-root/home-index/home-search/app-search-form/div/app-option-select[2]/button/span")).click();
        driver.findElement(By.xpath("/html/body/app-root/home-index/home-search/app-search-form/div/app-option-select[2]/app-option-menu/" +
                "div/div[2]/div[2]/button[1]/span/app-highlight-text")).click();
        driver.findElement(By.xpath("/html/body/app-root/home-index/home-search/app-search-form/div/app-search-autocomplete/div[1]/input")).click();
        driver.findElement(By.xpath("/html/body/app-root/home-index/home-search/app-search-form/div/app-search-autocomplete/app-option-menu/" +
                "div/div[2]/input")).sendKeys("departamento");
        driver.findElement(By.xpath("/html/body/app-root/home-index/home-search/app-search-form/div/app-search-autocomplete/app-option-menu/" +
                "div/div[2]/input")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        WebElement message = driver.findElement(By.xpath("/html/body/app-root/listing-index/listing-main/div[2]/div/div/listing-result-list/div/h1"));
        String value = message.getText();
        assertEquals("Resultados en Arrendar.", value);

    }
}
