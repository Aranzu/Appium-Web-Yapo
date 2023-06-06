package AppiumChromeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.assertEquals;

public class AllTest extends BaseClass{
    @Test(priority = 1)
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
    @Test(priority = 2)
    public void testLoginEmpty() throws InterruptedException {
        driver.get("https://www2.yapo.cl/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        driver.findElement(By.id("acc_login_submit_button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));

        WebElement message = driver.findElement(By.xpath("//*[@id=\"login-box\"]/form/span[1]"));
        String value = message.getText();
        assertEquals("Escribe tu e-mail", value);
    }

    @Test(priority = 3)
    public void testLoginWrong() throws InterruptedException {
        driver.get("https://www2.yapo.cl/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        driver.findElement(By.id("accbar_email")).sendKeys("rsol777ddd@gmail.com");
        driver.findElement(By.id("accbar_password")).sendKeys("fghd56565");
        driver.findElement(By.id("acc_login_submit_button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));

        String url = driver.getCurrentUrl();
        assertEquals("https://www2.yapo.cl/login", url);
    }

    @Test(priority = 4)
    public void searchTestAuto() throws InterruptedException {
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
    @Test(priority = 5)
    public void searchTestDept() throws InterruptedException {
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

        /*WebElement message = driver.findElement(By.xpath("/html/body/app-root/listing-index/listing-main/div[2]/div/div/listing-result-list/div/h1"));
        String value = message.getText();
        assertEquals("Resultados en Arrendar.", value);*/

    }

    @Test(priority = 6)
    public void publicarTest() throws InterruptedException {
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
        driver.findElement(By.id("body")).sendKeys("Florero en excelente estado");
        driver.findElement(By.id("price")).sendKeys("5000");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        Thread.sleep(5000);

        driver.findElement(By.id("label_phoneInputTypeHome")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.findElement(By.xpath("//*[@id=\"newad_form\"]/fieldset[7]/div/button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        Thread.sleep(5000);

        /*WebElement message = driver.findElement(By.xpath("//*[@id=\"ai-account-success\"]/div[2]/div[1]/div[2]/div/h1"));
        String value = message.getText();
        assertEquals("¡Aviso en Revisión!", value);*/

    }
    @Test(priority = 7)
    public void publicarInvalidTest1() throws InterruptedException {
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

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.findElement(By.id("subject")).sendKeys("Florero");
        driver.findElement(By.id("body")).sendKeys("Florero en excelente estado");
        driver.findElement(By.id("price")).sendKeys("5000");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        Thread.sleep(5000);

        driver.findElement(By.id("label_phoneInputTypeHome")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.findElement(By.xpath("//*[@id=\"newad_form\"]/fieldset[7]/div/button")).click();
        //driver.findElement(By.id("iat-adhesion-bar-514057")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        Thread.sleep(5000);

        WebElement message = driver.findElement(By.id("parent_category-error"));
        String value = message.getText();
        assertEquals("Selecciona una categoría", value);

    }

    @Test(priority = 8)
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

    @Test(priority = 9)
    public void publicarInvalidTest3() throws InterruptedException {
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
        driver.findElement(By.id("body")).sendKeys("Florero en excelente estado");
        driver.findElement(By.id("price")).sendKeys("5000");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        Thread.sleep(5000);

        driver.findElement(By.id("label_phoneInputTypeHome")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.findElement(By.xpath("//*[@id=\"newad_form\"]/fieldset[7]/div/button")).click();
        //driver.findElement(By.id("iat-adhesion-bar-514057")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        Thread.sleep(5000);

        WebElement message = driver.findElement(By.id("subject-error"));
        String value = message.getText();
        assertEquals("Escribe un título", value);

    }
    @Test(priority = 10)
    public void comprarTest() throws InterruptedException {
        driver.get("https://www2.yapo.cl/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
        driver.findElement(By.id("accbar_email")).sendKeys("rsol777ddd@gmail.com");
        driver.findElement(By.id("accbar_password")).sendKeys("asdSSRR545");
        driver.findElement(By.id("acc_login_submit_button")).click();
        Thread.sleep(5000);

        driver.get("https://new.yapo.cl/");
        driver.findElement(By.xpath("/html/body/app-root/home-index/home-search/app-search-form/div/app-search-autocomplete/div[1]/input")).sendKeys("Smartwatch soymomo space lite rosado openbox");
        driver.findElement(By.xpath("/html/body/app-root/home-index/home-search/app-search-form/div/button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get("https://new.yapo.cl/marketplace/reposamuecas-delta-hub-carpio-20_87245217");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.findElement(By.xpath("/html/body/app-root/adview-index/adview-bottom-bar/div/div/a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.findElement(By.id("email")).sendKeys("rsol777ddd@gmail.com");
        driver.findElement(By.id("delivery_strategies-PICK_UP")).click();
        driver.findElement(By.xpath("//*[@id=\"Form1\"]/div[1]/div/div[2]/div[2]/div[1]/button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        Thread.sleep(2000);

        String url = driver.getCurrentUrl();
        assertEquals("https://compra.yapo.cl/checkouts/c/7ecc3ebef3e6e3dabc68039d8e9b6b47/shipping", url);
    }

    @Test(priority = 11)
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
