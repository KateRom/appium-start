import org.junit.Assert;
import org.testng.annotations.Test;
import pageobjects.ContactListPage;

/*Created by katr on 17.06.2017.
 */
public class MainSearchPositiveTest extends BaseTest{

    @Test
    public void SearchRandomTest() {
        ContactListPage contactListPage = new ContactListPage(driver);
        contactListPage.search("123456789");
        String exp = "No contacts found with \"123456789\" in the name";
        Assert.assertEquals(exp, contactListPage.searchWithoutResult());
    }

    @Test(groups = "main_search")
    public void SearchPresentContactTest() {
        ContactListPage contactListPage = new ContactListPage(driver);
        contactListPage.search("Irma Bolden");
        Assert.assertEquals("Irma Bolden", contactListPage.getFirstName());
    }
    @Test(groups = "main_search")
    public void OnlyOneContactTest() {
        boolean flag = true;
        ContactListPage contactListPage = new ContactListPage(driver);
        try {
            contactListPage.clickSecondName();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            flag = false;
        }
        Assert.assertFalse(flag);
    }
}
