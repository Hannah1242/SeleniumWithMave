package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import pages.ElementsPage;
import pages.HomePage;

import static org.testng.Assert.*;

public class CheckBoxTest {
    @Test
    public void VerifyCheckBoxCorrectly(){
        String check1= "Desktop";
        String check2= "Documents";
        String check3= "Downloads";
        String projectFolder = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver" , projectFolder + "/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = homePage.clickElement();
        CheckBoxPage checkBoxPage = elementsPage.clickCheckBoxPage();
        String fullClassValue = checkBoxPage.getAttributeTag(checkBoxPage.chkHome);
        assertTrue(fullClassValue.contains("uncheck"));
        checkBoxPage.clickOnCheckBox();
        String actualText = checkBoxPage.getText();
        assertEquals(actualText,"You have selected : home desktop notes commands documents workspace react angular veu office public private classified general downloads wordFile excelFile");
        checkBoxPage.clickOnIcon();
        System.out.println(checkBoxPage.countChk());
        Assert.assertEquals(checkBoxPage.countChk(),4);
        Assert.assertEquals(checkBoxPage.getTextCheckBox(checkBoxPage.desktop),check1);
        Assert.assertEquals(checkBoxPage.getTextCheckBox(checkBoxPage.documents),check2);
        Assert.assertEquals(checkBoxPage.getTextCheckBox(checkBoxPage.downloads),check3);
        driver.quit();
    }

}
