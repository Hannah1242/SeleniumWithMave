package tests;

import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;

public class TextBoxTest extends TestCase {
    @Test
    public void submitSucessfully(){

        String fullName = "Thuy Hang";
        String email = "hang@gmail.com";
        String currentAddress = "Ha Noi";
        String permanentAddress = "1234";

        HomePage homePage = new HomePage(testBase.driver);
        ElementsPage elementsPage = homePage.clickElement();
        TextBoxPage textBoxPage = elementsPage.clickTextBox();
        textBoxPage.inputData(fullName,email,currentAddress,permanentAddress);

        String actualFullName = textBoxPage.getString(textBoxPage.lblFullName);
        String actualEmail = textBoxPage.getString(textBoxPage.lblEmail);
        String actualCurrentAddress = textBoxPage.getString(textBoxPage.lblCurrentAddress);
        String actualpermanentAddress = textBoxPage.getString(textBoxPage.lblpermanentAddress);
        Assert.assertEquals(actualFullName, fullName);
        Assert.assertEquals(actualEmail, email);
        Assert.assertEquals(actualCurrentAddress, currentAddress);
        Assert.assertEquals(actualpermanentAddress, permanentAddress);
    }
    public void emailFormatIsWrong(){
        String fullName = "Thuy Hang";
        String email = "hanggmcom";
        String currentAddress = "Ha Noi";
        String permanentAddress = "1234";

        HomePage homePage = new HomePage(testBase.driver);
        ElementsPage elementsPage = homePage.clickElement();
        TextBoxPage textBoxPage = elementsPage.clickTextBox();
        textBoxPage.inputData(fullName,email,currentAddress,permanentAddress);

        String actualFullName = textBoxPage.getString(textBoxPage.lblFullName);
        String actualEmail = textBoxPage.getString(textBoxPage.lblEmail);
        String actualCurrentAddress = textBoxPage.getString(textBoxPage.lblCurrentAddress);
        String actualpermanentAddress = textBoxPage.getString(textBoxPage.lblpermanentAddress);
        String inputEmail = textBoxPage.getEmail(textBoxPage.lblInputEmail);
        Assert.assertTrue(testBase.driver.findElement(textBoxPage.lblInputEmail).isDisplayed());
        Assert.assertEquals(inputEmail,email);
    }

}
