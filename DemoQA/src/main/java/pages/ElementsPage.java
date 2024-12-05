package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends Page{
    public By textBoxPage = By.xpath("//span[text()='Text Box']");
    public By checkBoxPage = By.xpath("//span[text()='Check Box']");
    public By webTablePage = By.xpath("//span[text()='Web Tables']");

    public ElementsPage(WebDriver dr) {
        super(dr);
    }
    public TextBoxPage clickTextBox(){
        driver.findElement(textBoxPage).click();
        return new TextBoxPage(driver);
    }
    public CheckBoxPage clickCheckBoxPage(){
        driver.findElement(checkBoxPage).click();
        return new CheckBoxPage(driver);
    }
    public WebTablePage clickWebTablePage(){
        driver.findElement(webTablePage).click();
        return new WebTablePage(driver);
    }
}
