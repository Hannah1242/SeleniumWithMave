package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PracticeFormPage extends Page{
    public By txtFirstName = By.id("firstName");
    public By txtLastName = By.id("lastName");
    public By txtEmail = By.id("userEmail");
    public String rdGenderXpath = "//label[text()='{@param}']";
    public String chkHobbiesXpath = "//label[text()='{@param}']";
    public By txtMobileNumber = By.id("userNumber");
    public By drpYearElement = By.xpath("//*[@class = 'react-datepicker__year-select']");
    public By drpMonthElement = By.xpath("//*[@class = 'react-datepicker__month-select']");
    public String dateXpath = "//*[text()='{@param}']";
    public By txtSubjects = By.id("subjectsIn");
    public By txtUpload = By.id("uploadPicture");
    public By txtCurrentAddress = By.id("currentAddress");
    public By txtStage = By.id("react-select-3-input");
    public By txtCity = By.id("react-select-4-input");
    public By popThank = By.xpath("//*[div[text()='Thanks for submitting the form']])");
    public By btnSubmit = By.id("submit");

    public By lblFullName = By.xpath("//table//tr[contains(., 'Name')]/td[2]");
    public By lblEmail = By.xpath("//table//tr[contains(., 'Email')]/td[2]");
    public By lblMobileNumber = By.xpath("//table//tr[contains(., 'Mobile')]/td[2]");
    public By lblSubjects = By.xpath("//table//tr[contains(., 'Subjects')]/td[2]");
    public By lblCurrentAdd = By.xpath("//table//tr[contains(., 'Address')]/td[2]");
    public By lblStageAndCity = By.xpath("//table//tr[contains(., 'Stage')]");
    public By lblPicture = By.xpath("//table//tr[contains(., 'Picture')]");
    public By lblDateOfBirth = By.xpath("//table//tr[contains(., 'Date')]");
    public By lblGender = By.xpath("//table//tr[contains(., 'Gender')]");
    public By lblHobbies = By.xpath("//table//tr[contains(., 'Hobbies')]");



    public PracticeFormPage(WebDriver dr) {
        super(dr);
    }

    public void inputData(String firstName, String lastName, String email, String mobileNumber, String subjects, String currentAddress,String city, String stage){
        driver.findElement(txtFirstName).sendKeys(firstName);
        driver.findElement(txtLastName).sendKeys(lastName);
        driver.findElement(txtEmail).sendKeys(email);
        driver.findElement(txtMobileNumber).sendKeys(mobileNumber);
        driver.findElement(txtSubjects).sendKeys(subjects);
        driver.findElement(txtUpload).sendKeys("/Users/mac/Automation_testing/image/images.jpeg");
        driver.findElement(txtCurrentAddress).sendKeys(currentAddress);
        driver.findElement(txtStage).sendKeys(stage);
        driver.findElement(txtCity).sendKeys(city);

        driver.findElement(btnSubmit).click();
    }
    public String getText(By locator){
        String text = driver.findElement(locator).getText();
        return text;
    }

    public void clickGender(String gender){
        //driver.findElement(By.xpath(rdGenderXpath.replace("@param", gender))).click();
        testBase.findElementByXpathAndParam(rdGenderXpath, gender).click();
    }

    public void clickHobbies(String hobbies){
        //driver.findElement(By.xpath(chkHobbiesXpath.replace("@param", hobbies))).click();
        testBase.findElementByXpathAndParam(chkHobbiesXpath, hobbies).click();
    }
    public void inputDOB(String dateOfBirth){
        DateFormat fmt = new SimpleDateFormat("dd MMM yyyy", Locale.US);
        String dateOfBirthArr[] ;
        try {
            Date d = fmt.parse(dateOfBirth);
            dateOfBirthArr = d.toString().split(" ");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Select drpYear = new Select(driver.findElement(drpYearElement));
        drpYear.selectByVisibleText(dateOfBirthArr[2]);
        Select drpMonth = new Select(driver.findElement(drpMonthElement));
        drpMonth.selectByVisibleText(dateOfBirthArr[1]);
        testBase.findElementByXpathAndParam(dateXpath,dateOfBirthArr[0]);
    }



}
