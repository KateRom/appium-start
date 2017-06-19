package homework1;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/*Created by katr on 17.06.2017.
 */
public class MainSearchPositiveTest {
    private static AndroidDriver driver;
    public static void main(String[] args) {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/app/Android");
        File app = new File(appDir, "Contacts.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "NotUsed");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.jayway.contacts");
        capabilities.setCapability("appActivity", "com.jayway.contacts.MainActivity");

        boolean flag = true;

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        MobileElement main_search = (MobileElement) driver.findElementById("main_search");
        main_search.sendKeys("123456789");
        String exp = "No contacts found with \"123456789\" in the name";
        String act = driver.findElementById("com.jayway.contacts:id/main_text").getText();
        Assert.assertEquals(exp,act);

        main_search.sendKeys("Irma Bolden");
        String exp1 = "Irma Bolden";
        String act1 = driver.findElementById("com.jayway.contacts:id/name").getText();
        Assert.assertEquals(exp1,act1);
        try {
            driver.findElementByXPath("//*[@resource-id='com.jayway.contacts:id/name'][2]");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            flag = false;
        }
        Assert.assertFalse(flag);
    }
}
