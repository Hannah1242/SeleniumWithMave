package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page{
    public By elementPage = By.xpath("//*[text()='Elements']");
    public By formPage = By.xpath("//*[text()='Forms']");
    public By alertsFrameWindowsPage = By.xpath("//span[text()='Alerts, Frame & Windows']");
    public HomePage(WebDriver dr) {
        super(dr);
    }
    public ElementsPage clickElement(){
        driver.findElement(elementPage).click();
        return new ElementsPage(driver);
    }
    public FormPage clickFormPage(){
        driver.findElement(formPage).click();
        return new FormPage(driver);
    }
    public AlertsFrameWindowsPage clickWebTablePage(){
        driver.findElement(alertsFrameWindowsPage).click();
        return new AlertsFrameWindowsPage(driver);
    }

}
