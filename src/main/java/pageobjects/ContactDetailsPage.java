package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/*Created by katr on 22.06.2017.
 */
public class ContactDetailsPage extends BasePage{

    @AndroidFindBy(id = "email")
    private MobileElement emailAdress;

    @AndroidFindBy(id = "detail_name")
    private MobileElement contactName;

    @AndroidFindBy(id = "phonenumber")
    private MobileElement contactPhone;

    @AndroidFindBy(id = "street1")
    private MobileElement contactAdress1;

    @AndroidFindBy(id = "street2")
    private MobileElement contactAdress2;



    public ContactDetailsPage(AppiumDriver<MobileElement> driver){
        super(driver);
    }

    public String getEmailAdress(){
        String elementById;
        return elementById = emailAdress.getText();
    }

    public String getContactName(){
        String elementById;
        return elementById = contactName.getText();
    }

    public String getContactPhone(){
        String elementById;
        return elementById = contactPhone.getText();
    }

    public String getContactAdress(){
        String elementById;
        return elementById = contactAdress1.getText();
    }

    public String getContactAdress2(){
        String elementById;
        return elementById = contactAdress2.getText();
    }
}
