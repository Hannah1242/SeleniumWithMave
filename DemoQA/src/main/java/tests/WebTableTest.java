package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsFrameWindowsPage;
import pages.ElementsPage;
import pages.HomePage;
import pages.WebTablePage;

public class WebTableTest extends TestCase{
    @Test
    public void SearchByFirstNameSuccessfully() {
        String keyword = "Vega";
        HomePage homePage = new HomePage(testBase.driver);
        ElementsPage elementsPage = homePage.clickElement();
        WebTablePage webTablePage = elementsPage.clickWebTablePage();
        webTablePage.inputSearchKeyWord(keyword);
        boolean searchResultCorrect = webTablePage.isSearchResultCorrect(keyword);
        Assert.assertTrue(searchResultCorrect);
    }
}
