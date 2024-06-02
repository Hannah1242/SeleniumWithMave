package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends Page{
    public ElementsPage(WebDriver dr) {
        super(dr);
    }
    public TextBoxPage clickTextBox(){
        driver.findElement(By.xpath("//span[text()='Text Box']")).click();
        return new TextBoxPage(driver);
    }
}
