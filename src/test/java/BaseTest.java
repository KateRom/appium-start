import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/*Created by katr on 22.06.2017.
 */
public class BaseTest {

    public AppiumDriver driver;
    public static OS executionOS = OS.ANDROID;
    public static boolean ios = executionOS.equals(OS.IOS);
    public static boolean android = executionOS.equals(OS.ANDROID);

    public enum OS {
        ANDROID,
        IOS
    }

    private AppiumDriver setUp() {
        try {
            switch (executionOS) {
                case ANDROID:
                    File classpathRoot = new File(System.getProperty("user.dir"));
                    File appDir = new File(classpathRoot, "/app/Android");
                    File app = new File(appDir, "Contacts.apk");
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability("platformName", "Android");
                    capabilities.setCapability("deviceName", "NotUsed");
                    capabilities.setCapability("app", app.getAbsolutePath());
                    capabilities.setCapability("appPackage", "com.jayway.contacts");
                    capabilities.setCapability("appActivity", "com.jayway.contacts.MainActivity");
                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                    break;
                case IOS:
                    classpathRoot = new File(System.getProperty("user.dir"));
                    appDir = new File(classpathRoot, "/app/iOS/");
                    app = new File(appDir, "ContactsSimulator.app");
                    capabilities = new DesiredCapabilities();
                    capabilities.setCapability("platformName", "ios");
                    capabilities.setCapability("automationName", "XCUITest");
                    capabilities.setCapability("deviceName", "iPhone 6");
                    capabilities.setCapability("app", app.getAbsolutePath());
                    capabilities.setCapability("udid", "397EA871-F172-4758-8FE4-86DDAB088A41");
                    driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                    break;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }


    @BeforeTest
    public void start() throws Exception {
        if (driver == null) {
            driver = new BaseTest().setUp();
        }
    }

    @AfterTest
    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
