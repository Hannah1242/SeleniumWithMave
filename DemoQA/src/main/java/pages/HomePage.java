package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page{
    public HomePage(WebDriver dr) {
        super(dr);
    }
    public ElementsPage clickElement(){
        driver.findElement(By.xpath("//*[text()='Elements']")).click();
        return new ElementsPage(driver);
    }
    public FormPage clickFormPage(){
        driver.findElement(By.xpath("//*[text()='Forms']")).click();
        return new FormPage(driver);
    }

}
