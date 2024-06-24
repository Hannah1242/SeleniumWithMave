package pages;

import common.TestBase;
import org.openqa.selenium.WebDriver;

public class Page {
    WebDriver driver;
    public TestBase testBase = new TestBase();
    public Page(WebDriver dr) {
        testBase.driver = dr;
        this.driver = testBase.driver;
    }
}
