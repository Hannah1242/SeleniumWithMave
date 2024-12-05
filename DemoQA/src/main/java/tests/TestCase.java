package tests;

import common.TestBase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestCase {
    public TestBase testBase = new TestBase();
    @BeforeTest
    public void openWeb(){
        testBase.openSingleDriver("chrome");
    }

    @AfterTest
    public void closeBrower(){
        testBase.driver.quit();
    }
}
