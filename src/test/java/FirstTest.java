import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FirstTest {

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
        try {
             driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //неявний вейт поставлений для пошуку кожного елементу в аплікейшині
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        MobileElement main_search = (MobileElement) driver.findElementById("main_search");
        main_search.sendKeys("Joy");

        MobileElement elementByXPath = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.jayway.contacts:id/name']");
        elementByXPath.click();

        String elementById = findElementById("email").getText();

        WebDriverWait driverWait = new WebDriverWait(driver,10);
        driverWait.until((ExpectedConditions.presenceOfElementLocated(By.id("email"))));

        System.out.println(elementById.equals("alstclair11@yopmail.com"));
        Assert.assertEquals("alstclair11@yopmail.com",elementById);

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private static MobileElement findElementById(String id){
        return (MobileElement) driver.findElementById(id);
    }
}
