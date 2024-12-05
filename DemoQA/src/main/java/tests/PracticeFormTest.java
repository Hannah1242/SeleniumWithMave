package tests;

import common.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTest extends TestCase{
    @Test
    public void SubmitDataSuccessfull(){
        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@gmail.com";
        String gender = "Male";
        String mobileNumber = "123456789";
        String dateOfBirth = "13 Aug 1999";
        String hobbies = "Sports";
        String subjects = "Math";
        String currentAddress = "1A Ha Noi";
        String city = "Uttar Pradesh";
        String state = "Agra";

        HomePage homePage = new HomePage(testBase.driver);
        FormPage formPage = homePage.clickFormPage();
        PracticeFormPage practiceFormPage = formPage.clickPracticeFormPage();
        practiceFormPage.inputData(firstName,lastName,email,mobileNumber,subjects,currentAddress,city,state);
        practiceFormPage.clickGender(gender);
        practiceFormPage.clickHobbies(hobbies);
        WebElement chkHobbie =  practiceFormPage.testBase.findElementByXpathAndParam(practiceFormPage.chkHobbiesXpath,hobbies);
        boolean actualHobbieChecked = practiceFormPage.testBase.isRadioChecked(chkHobbie);
        Assert.assertTrue(actualHobbieChecked);
        practiceFormPage.inputDOB(dateOfBirth);


        Assert.assertTrue(testBase.driver.findElement(practiceFormPage.popThank).isDisplayed());

        String fullName = firstName + " " + lastName;
        String stageAndCity = state + " " + city;
        String actualFullName = practiceFormPage.getText(practiceFormPage.lblFullName);
        String actualEmail = practiceFormPage.getText(practiceFormPage.lblEmail);
        String actualMobileNumber = practiceFormPage.getText(practiceFormPage.lblMobileNumber);
        String actualSubjects = practiceFormPage.getText(practiceFormPage.lblSubjects);
        String actualCurrentAddress = practiceFormPage.getText(practiceFormPage.lblCurrentAdd);
        String actualStageAndCity = practiceFormPage.getText(practiceFormPage.lblStageAndCity);
        String actualGender = practiceFormPage.getText(practiceFormPage.lblGender);
        String actualDateOfBirth = practiceFormPage.getText(practiceFormPage.lblDateOfBirth);
        String actualPicture = practiceFormPage.getText(practiceFormPage.lblPicture);

        Assert.assertEquals(actualFullName, fullName);
        Assert.assertEquals(actualGender, gender);
        Assert.assertEquals(chkHobbie, hobbies);
        Assert.assertEquals(actualDateOfBirth, dateOfBirth);
        Assert.assertEquals(actualPicture,"images.jpeg");
        Assert.assertEquals(actualEmail,email);
        Assert.assertEquals(actualMobileNumber,mobileNumber);
        Assert.assertEquals(actualSubjects,subjects);
        Assert.assertEquals(actualCurrentAddress,currentAddress);
        Assert.assertEquals(actualStageAndCity,stageAndCity);

    }
    @Test
    public void SubmitDataFailed(){
        String firstName = "";
        String lastName = "";
        String email = "john.doe@gmail.com";
        String mobileNumber = "";
        String subjects = "Math";
        String currentAddress = "1A Ha Noi";
        String city = "Uttar Pradesh";
        String state = "Agra";

        HomePage homePage = new HomePage(testBase.driver);
        FormPage formPage = homePage.clickFormPage();
        PracticeFormPage practiceFormPage = formPage.clickPracticeFormPage();
        practiceFormPage.inputData(firstName,lastName,email,mobileNumber,subjects,currentAddress,city,state);
        Assert.assertFalse(testBase.driver.findElement(practiceFormPage.popThank).isDisplayed());
    }
}
