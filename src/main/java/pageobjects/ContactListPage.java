package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/*Created by katr on 22.06.2017.
 */
public class ContactListPage extends BasePage{

    @AndroidFindBy(id = "main_search")
    private MobileElement searchField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.jayway.contacts:id/name']")
    private MobileElement nameTo;

    @AndroidFindBy(id = "com.jayway.contacts:id/name")
    private MobileElement firstNameInList;

    @AndroidFindBy(xpath = "//*[@resource-id='com.jayway.contacts:id/name'][2]")
    private MobileElement secondNameInList;

    @AndroidFindBy(id = "com.jayway.contacts:id/main_text")
    private MobileElement searchWithoutResult;

    public ContactListPage(AppiumDriver<MobileElement> driver){
        super(driver);
    }

    public void search(String name){
        searchField.sendKeys(name);
    }

    public ContactDetailsPage clickOnName(){
        nameTo.click();
        return new ContactDetailsPage(driver);
    }

    public String getFirstName(){
        return firstNameInList.getText();
    }

    public void clickSecondName(){
        secondNameInList.click();
    }

    public String searchWithoutResult(){
        return searchWithoutResult.getText();
    }
}
