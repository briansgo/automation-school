package pages;

import org.openqa.selenium.By;
import settings.BasePage;

import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    @FindBy(xpath = "//li[.='Popular']")
    private WebElement popularProductsButton;

    @FindBy(xpath = "//li[.='Best Sellers']")
    private WebElement bestSellerProductsButton;

    @FindBy(css = ".right[data-usability='1']")
    private WebElement nextRecommendationButton;

    @FindBy(css = ".left[data-usability='1']")
    private WebElement previousRecommendationButton;


    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickPopularProductsButton(){
        this.click(popularProductsButton);
        String is_active = popularProductsButton.getAttribute("class");
        Assert.assertEquals(is_active,"active");
    }

    public void clickBestSellerProductsButton(){
        this.click(bestSellerProductsButton);
        String is_active = bestSellerProductsButton.getAttribute("class");
        Assert.assertEquals(is_active,"active");
    }

    public WebElement getFeaturedNextButton(){
        return nextRecommendationButton;
    }

    public WebElement getFeaturedPreviousButton(){
        return previousRecommendationButton;
    }

    public WebElement getCurrentFeaturedElement(){
        return driver.findElement(By.cssSelector("#home_maincap_v7 a[class*='focus']"));
    }


}