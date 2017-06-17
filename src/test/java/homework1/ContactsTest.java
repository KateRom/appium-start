package homework1;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*Created by katr on 14.06.2017.
 */
public class ContactsTest {
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

        int a = 0;
        boolean flag = false;

        List<List<String>> allInfo = new ArrayList<List<String>>();

        ArrayList<String> contactsList = new ArrayList<String>(){{
            add("//*[@class='android.widget.RelativeLayout'][1]");
            add("//*[@class='android.widget.RelativeLayout'][2]");
            add("//*[@class='android.widget.RelativeLayout'][3]");
            add("//*[@class='android.widget.RelativeLayout'][4]");
            add("//*[@class='android.widget.RelativeLayout'][5]");
        }};
        ArrayList<String> contactDetailsXpaths = new ArrayList<String>(){{
           add("//*[@resource-id='com.jayway.contacts:id/detail_name']");
           add("//*[@resource-id='com.jayway.contacts:id/phonenumber']");
           add("//*[@resource-id='com.jayway.contacts:id/email']");
           add("//*[@resource-id='com.jayway.contacts:id/street1']");
           add("//*[@resource-id='com.jayway.contacts:id/street2']");
        }};
        ArrayList<String> firstContact = new ArrayList<String>(){{
           add("Jenny Cherry");
           add("+1(959)-1775994");
           add("jqjenny16@yopmail.com");
           add("201 Metz Bates");
           add("15840 New York");
        }};
        ArrayList<String> secondContact = new ArrayList<String>(){{
           add("Garance Epperson");
           add("+1(747)-8330134");
           add("duepperson20@gmail.com");
           add("542 American Circle");
           add("49100 Washington");
        }};
        ArrayList<String> thirdContact = new ArrayList<String>(){{
           add("Nadia Patten");
           add("+1(131)-9550402");
           add("jnnadia13@gmail.com");
           add("791 Bombardier Court");
           add("93809 New York");
        }};
        ArrayList<String> fourContact = new ArrayList<String>(){{
           add("Jennifer Krantz");
           add("+1(656)-6779916");
           add("eekrantz4@yopmail.com");
           add("413 Wescam Drive");
           add("43115 Miami");
        }};
        ArrayList<String> fiveContact = new ArrayList<String>(){{
           add("Christin Steinberg");
           add("+1(656)-1115633");
           add("awchristin22@yahoo.com");
           add("412 Barfield Trail");
           add("53713 Houston");
        }};

        allInfo.add(firstContact);
        allInfo.add(secondContact);
        allInfo.add(thirdContact);
        allInfo.add(fourContact);
        allInfo.add(fiveContact);


        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        MobileElement elementByXPath = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.jayway.contacts:id/name']");
        elementByXPath.click();

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        for(String contact:contactsList) {
            MobileElement contactByXPath = (MobileElement) driver.findElementByXPath(contact);
            contactByXPath.click();
            for (int i = 0; i < contactDetailsXpaths.size(); i++) {
                MobileElement infoByXPath = (MobileElement) driver.findElementByXPath(contactDetailsXpaths.get(i));
                String actual = infoByXPath.getText();
                WebDriverWait driverWait = new WebDriverWait(driver, 10);
                driverWait.until((ExpectedConditions.presenceOfElementLocated(By.xpath(contactDetailsXpaths.get(i)))));
                String exp = allInfo.get(a).get(i);
                if(exp.equals(actual))
                flag = true;
                else {
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.println(a+1 + " contact in the list is correct");
            else System.out.println(a+1 + " contact in the list is NOT correct");

            a++;
            driver.navigate().back();
        }
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
