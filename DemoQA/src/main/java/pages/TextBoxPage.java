package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends Page{
    public By txtFullName = By.id("userName");
    public By txtEmail = By.id("userEmail");
    public By txtCurrentAddress = By.id("currentAddress");
    public By txtpermanentAddress = By.id("permanentAddress");

    public By lblFullName = By.id("name");
    public By lblEmail = By.id("email");
    public By lblCurrentAddress = By.xpath("currentAddress");
    public By lblpermanentAddress = By.id("permanentAddress");
    public By lblInputEmail = By.className("mr-sm-2 field-error form-control");
    public By btnSubmit = By.id("submit");

    public TextBoxPage(WebDriver dr) {

        super(dr);
    }
    public void inputData(String fullName,String email,String currentAddress,String permanentAddress) {
        driver.findElement(txtFullName).sendKeys(fullName);
        driver.findElement(txtEmail).sendKeys(email);
        driver.findElement(txtCurrentAddress).sendKeys(currentAddress);
        driver.findElement(txtpermanentAddress).sendKeys(permanentAddress);
        driver.findElement(txtpermanentAddress).sendKeys(Keys.DOWN);
        driver.findElement(txtpermanentAddress).sendKeys(Keys.DOWN);
        driver.findElement(txtpermanentAddress).sendKeys(Keys.DOWN);
        driver.findElement(btnSubmit).click();

    }
    public String getString(By locator){
        String fullText = driver.findElement(locator).getText();
        int indexOfColon = fullText.indexOf(":");
        return fullText.substring(indexOfColon+1);
    }
    public String getEmail(By locator){
       String fullText = driver.findElement(locator).getText();
       return fullText;
    }

}
