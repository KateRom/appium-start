import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ContactListPage;

/*Created by katr on 17.06.2017.
 */
public class MainSearchNegativeTest extends BaseTest{
    @Test(groups = "main_search")
    public void InvalidInputTest(){
        ContactListPage contactListPage = new ContactListPage(driver);
        contactListPage.search("u1salcd||' '||dmname");
        String exp = "No contacts found with \"u1salcd||' '||dmname\" in the name";
        Assert.assertEquals(exp,contactListPage.searchWithoutResult());
    }
}

