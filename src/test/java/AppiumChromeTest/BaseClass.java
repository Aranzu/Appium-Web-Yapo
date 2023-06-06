package AppiumChromeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseClass {

    AppiumDriver driver;

        @BeforeMethod
        public void setUp() throws MalformedURLException {
            try {
                DesiredCapabilities cap = new DesiredCapabilities();

                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
                cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11 RP1A.200720.011");
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redme Note 8 Pro");
                cap.setCapability(MobileCapabilityType.UDID, "p789irz5dyemw4y9");
                cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

                URL url = new URL("http://127.0.0.1:4723/wd/hub");
                driver = new AppiumDriver(url, cap);
                driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

            }catch (Exception exp){
                System.out.println("Causa es: "+exp.getCause());
                System.out.println("Mensaje es: "+exp.getMessage());
                exp.printStackTrace();
            }
        }

        @AfterMethod
        public void tearDown() {
            driver.close();
            driver.quit();
        }
    }

/*Appium inspector config
yapo
{
  "deviceName": "Redme Note 8 Pro",
  "udid": "p789irz5dyemw4y9",
  "platformName": "Android",
  "plataformVersion": "11 RP1A.200720.011",
  "appPackage": "cl.yapo",
  "appActivity": "cl.yapo.milkyway.launch.LaunchActivity"
}
chrome
{
  "deviceName": "Redme Note 8 Pro",
  "udid": "p789irz5dyemw4y9",
  "platformName": "Android",
  "plataformVersion": "11 RP1A.200720.011",
  "appPackage": "com.android.chrome",
  "appActivity": "com.google.android.apps.chrome.Main"
}
 */