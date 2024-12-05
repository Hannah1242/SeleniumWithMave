package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxPage extends Page{
    //By clickCheckBox = By.id("tree-node-home");
    public By chkHome = By.xpath("//*[@for='tree-node-home']/span[@class='rct-checkbox']/*[name()='svg']");
    public By chkIcon = By.xpath("//button[@class='rct-collapse rct-collapse-btn']/*[name()='svg']");
    public By checked = By.xpath("//*[@class='rct-icon rct-icon-check']");
    public By listE = By.xpath("//div[@id ='result']//span");

    public By desktop = By.xpath("//span[text()='Desktop']");
    public By documents = By.xpath("//span[text()='Documents']");
    public By downloads = By.xpath("//span[text()='Downloads']");



    public CheckBoxPage(WebDriver dr) {
        super(dr);
    }
    public void clickOnCheckBox() {
        driver.findElement(chkHome).click();
    }
    public void clickOnIcon(){
        driver.findElement(chkIcon).click();
    }
    public int countChk(){
        List<WebElement> listE = driver.findElements(checked);
        return listE.size();
    }
    public String getAttributeTag(By locator){
        String classValue = driver.findElement(locator).getAttribute("class");
        return classValue;
    }
    public String getText(){
        List<WebElement> elementList = driver.findElements(listE);
        String result = "";
        for(WebElement element : elementList){
            String text = element.getText();
            result = result + " " + text;
        }
        return result.trim();
    }
    public String getTextCheckBox(By locator){
        String textCheckBox = driver.findElement(locator).getText();
        return textCheckBox;
    }
}
