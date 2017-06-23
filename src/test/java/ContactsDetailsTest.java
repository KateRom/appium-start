import org.junit.Assert;
import org.testng.annotations.Test;
import pageobjects.ContactDetailsPage;
import pageobjects.ContactListPage;

import java.util.List;

/*Created by katr on 23.06.2017.
 */
public class ContactsDetailsTest extends BaseTest{

    private List<List<String>> allDetailsInfo = AllContactDetailsInfo.allDetailedInfo();

    @Test(groups = "contact_details")
    public void contactDetailsTest() {
        ContactListPage contactListPage = new ContactListPage(driver);
        ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
        for (List contact:allDetailsInfo) {
            contactListPage.search(String.valueOf(contact.get(0)));
            contactListPage.clickOnName();
            Assert.assertEquals(String.valueOf(contact.get(0)), contactDetailsPage.getContactName());
            Assert.assertEquals(String.valueOf(contact.get(1)), contactDetailsPage.getContactPhone());
            Assert.assertEquals(String.valueOf(contact.get(2)), contactDetailsPage.getEmailAdress());
            Assert.assertEquals(String.valueOf(contact.get(3)), contactDetailsPage.getContactAdress());
            Assert.assertEquals(String.valueOf(contact.get(4)), contactDetailsPage.getContactAdress2());
            driver.navigate().back();
        }
    }
}

