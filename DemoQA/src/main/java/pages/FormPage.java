package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage extends Page {
    By linkForm = By.xpath("//span[text()='Practice Form']");

    public FormPage(WebDriver dr) {
        super(dr);
    }
    public PracticeFormPage clickPracticeFormPage(){
        driver.findElement(linkForm).click();
        return new PracticeFormPage(driver);
    }
}
