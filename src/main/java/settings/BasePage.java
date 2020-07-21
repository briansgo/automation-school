package settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

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

    public void waitForElementBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

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

    //new section * * * * * * * * * * * * * * * * * * * * * * * *

    public boolean isTextPresentOnElement(WebElement element, String text){
        this.waitForElementToAppear(element);
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForElementsToAppear(List<WebElement> elementList){
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
    }

    public boolean elementAttributeIs(WebElement element, String attribute, String value){
        this.waitForElementToAppear(element);
        return wait.until(ExpectedConditions.attributeContains(element, attribute, value));
    }


    // ==================== H O M E W O R K ==========================

    public void repeatClick(WebElement element, int repeats){
        for(int i=0; i<repeats; i++){
            this.click(element);
            System.out.println(i);
        }
    }

    public void repeatClickAndVerifyChange(WebElement clickable, String locator, int repeats){

        WebElement oldElement;
        WebElement newElement;
        String oldElemId;
        String newElemId;

        for(int i=0; i<repeats; i++){

            oldElement = this.findByCss(locator);
            oldElemId =  oldElement.getAttribute("data-ds-appid");

            this.click(clickable);

            newElement = this.findByCss(locator);
            newElemId = newElement.getAttribute("data-ds-appid");

            Assert.assertNotEquals(oldElement, newElement,
                    "ERROR: El elemento verificable no cambió.  "+oldElemId+" = "+newElemId);

            System.out.println(i);
            System.out.println("  -Old: " + oldElemId);
            System.out.println("  -New: " + newElemId);
            System.out.println();
        }
    }

    public WebElement findByCss(String locator){
        return driver.findElement(By.cssSelector(locator));
    }

}
