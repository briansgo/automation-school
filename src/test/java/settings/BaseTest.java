package settings;

import components.NavBar;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.GamePage;
import pages.HomePage;

abstract public class BaseTest {

    protected WebDriver driver;
    protected NavBar navBar;
    protected HomePage homePage;
    protected GamePage gamePage;

    @BeforeSuite
    public void suitSetup(){
        this.driver = new DriverSetup("Chrome", false).getDriver();
        this.driver.get("https://store.steampowered.com/");

        navBar = new NavBar(this.driver);
        homePage = new HomePage(this.driver);
        gamePage = new GamePage(this.driver);

    }

    @AfterSuite
    public void suitTearDown(){
        this.driver.close();
        this.driver.quit();
    }

}