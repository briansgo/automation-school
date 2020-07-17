package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BasePage {

    private static final int TIMEOUT = 5;

    protected WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, TIMEOUT);
        actions = new Actions(this.driver);
    }

    public void waitForElementToAppear(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementBeClickable(WebElement element){ wait.until(ExpectedConditions.elementToBeClickable(element)); }

    public void click(WebElement element) {
        this.waitForElementToAppear(element);
        this.waitForElementBeClickable(element);
        element.click();
    }

    public void writeInInput(WebElement element, String message){
        this.waitForElementToAppear(element);
        element.sendKeys(message);
    }

    public void hoverElement(WebElement element){
        this.waitForElementToAppear(element);
        actions.moveToElement(element).perform();
    }

}
