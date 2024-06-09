package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTest {
    @Test
    public void SubmitDataSuccessfull(){
        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@gmail.com";
        String mobileNumber = "123456789";
        String subjects = "Math";
        String currentAddress = "1A Ha Noi";
        String city = "Uttar Pradesh";
        String state = "Agra";

        String projectFolder = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver" , projectFolder + "/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        FormPage formPage = homePage.clickFormPage();
        PracticeFormPage practiceFormPage = formPage.clickPracticeFormPage();
        practiceFormPage.inputData(firstName,lastName,email,mobileNumber,subjects,currentAddress,city,state);

        Assert.assertTrue(driver.findElement(practiceFormPage.popThank).isDisplayed());

        String fullName = firstName + " " + lastName;
        String stageAndCity = state + " " + city;
        String actualFullName = practiceFormPage.getText(practiceFormPage.lblFullName);
        String actualEmail = practiceFormPage.getText(practiceFormPage.lblEmail);
        String actualMobileNumber = practiceFormPage.getText(practiceFormPage.lblMobileNumber);
        String actualSubjects = practiceFormPage.getText(practiceFormPage.lblSubjects);
        String actualCurrentAddress = practiceFormPage.getText(practiceFormPage.lblCurrentAdd);
        String actualStageAndCity = practiceFormPage.getText(practiceFormPage.lblStageAndCity);
        String actualGender = practiceFormPage.getText(practiceFormPage.lblGender);
        String actualHobbies = practiceFormPage.getText(practiceFormPage.lblHobbies);
        String actualDateOfBirth = practiceFormPage.getText(practiceFormPage.lblDateOfBirth);
        String actualPicture = practiceFormPage.getText(practiceFormPage.lblPicture);

        Assert.assertEquals(actualFullName, fullName);
        //Assert.assertEquals(actualGender, actualGender);
        //Assert.assertEquals(actualHobbies, actualHobbies);
        //Assert.assertEquals(actualDateOfBirth, actualDateOfBirth);
        Assert.assertEquals(actualPicture,"images.jpeg");
        Assert.assertEquals(actualEmail,email);
        Assert.assertEquals(actualMobileNumber,mobileNumber);
        Assert.assertEquals(actualSubjects,subjects);
        Assert.assertEquals(actualCurrentAddress,currentAddress);
        Assert.assertEquals(actualStageAndCity,stageAndCity);

    }
    public void SubmitDataFailed(){
        String firstName = "";
        String lastName = "";
        String email = "john.doe@gmail.com";
        String mobileNumber = "";
        String subjects = "Math";
        String currentAddress = "1A Ha Noi";
        String city = "Uttar Pradesh";
        String state = "Agra";

        String projectFolder = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver" , projectFolder + "/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        FormPage formPage = homePage.clickFormPage();
        PracticeFormPage practiceFormPage = formPage.clickPracticeFormPage();
        practiceFormPage.inputData(firstName,lastName,email,mobileNumber,subjects,currentAddress,city,state);
        Assert.assertFalse(driver.findElement(practiceFormPage.popThank).isDisplayed());
        driver.quit();
    }
}
