package settings;

import settings.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

abstract public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void suitSetup(){
        this.driver = new DriverSetup("Chrome", false).getDriver();
        this.driver.get("https://store.steampowered.com/");
    }

    @AfterSuite
    public void suitTearDown(){
        this.driver.close();
        this.driver.quit();
    }

}