package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;

public class TextBoxTest {
    @Test
    public void submitSucessfully(){

        String fullName = "Thuy Hang";
        String email = "hang@gmail.com";
        String currentAddress = "Ha Noi";
        String permanentAddress = "1234";

        String projectFolder = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver" , projectFolder + "/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
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
        driver.quit();
    }
    public void emailFormatIsWrong(){
        String fullName = "Thuy Hang";
        String email = "hanggmcom";
        String currentAddress = "Ha Noi";
        String permanentAddress = "1234";

        String projectFolder = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver" , projectFolder + "/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        ElementsPage elementsPage = homePage.clickElement();
        TextBoxPage textBoxPage = elementsPage.clickTextBox();
        textBoxPage.inputData(fullName,email,currentAddress,permanentAddress);

        String actualFullName = textBoxPage.getString(textBoxPage.lblFullName);
        String actualEmail = textBoxPage.getString(textBoxPage.lblEmail);
        String actualCurrentAddress = textBoxPage.getString(textBoxPage.lblCurrentAddress);
        String actualpermanentAddress = textBoxPage.getString(textBoxPage.lblpermanentAddress);
        String inputEmail = textBoxPage.getEmail(textBoxPage.lblInputEmail);
        Assert.assertEquals(actualFullName, null);
        Assert.assertEquals(actualEmail, null);
        Assert.assertEquals(actualCurrentAddress, null);
        Assert.assertEquals(actualpermanentAddress, null);
        Assert.assertNotEquals(inputEmail,null);
        Assert.assertEquals(inputEmail,email);
    }

}
