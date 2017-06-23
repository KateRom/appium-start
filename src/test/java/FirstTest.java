import org.junit.Assert;
import org.testng.annotations.Test;
import pageobjects.ContactDetailsPage;
import pageobjects.ContactListPage;

public class FirstTest extends BaseTest{

    @Test(groups = {"main_search", "contact_details"})
    public void testSearch() {
        ContactListPage contactListPage = new ContactListPage(driver);
        contactListPage.search("Joy");
        ContactDetailsPage contactDetailsPage = contactListPage.clickOnName();
        String email = contactDetailsPage.getEmailAdress();
        Assert.assertEquals("alstclair11@yopmail.com", email);
    }
}
