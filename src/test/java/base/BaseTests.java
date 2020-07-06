package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {

    private WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://opentable.com");

        driver.manage().window().setSize(new Dimension(350, 900));

        System.out.println(driver.getTitle());
        //driver.quit();
    }

    public static void main (String args[]){
        BaseTests tests = new BaseTests();
        tests.setUp();
    }
}
