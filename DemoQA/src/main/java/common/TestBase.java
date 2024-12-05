package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {
    public WebDriver driver;

    public void openSingleDriver(String browser){
        String projectFolder = System.getProperty("user.dir");
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver" , projectFolder + "/driver/chromedriver");
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver" , projectFolder + "/driver/edgedriver");
            driver = new EdgeDriver();
        }
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
    }
    /**
     * get element by dynamic xpath
     * @param elementXpath
     * @param param
     * @return
     */
    public WebElement findElementByXpathAndParam(String elementXpath, String param){
       return driver.findElement(By.xpath(elementXpath.replace("@param", param)));
    }

    public boolean isRadioChecked(WebElement e){
        boolean result = false;
        if(e.isSelected()){
            result = true;
        }
        return result;
    }


}
