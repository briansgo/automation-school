package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.BaseTest;

public class RetryClickTest extends BaseTest {

    //1st method: asserts and logic on the BasePage method
    @Test
    public void repeatFeaturedNextBtnTest(){
        WebElement nextBtn = homePage.getFeaturedNextButton();
        homePage.hoverElement(nextBtn);
        homePage.repeatClickAndVerifyChange(nextBtn, "#home_maincap_v7 a[class*='focus']", 9);
    }

    // 2nd method: asserts and logic on the Test method
    @Test
    public void repeatFeaturedPreviousBtnTest(){
        WebElement previousBtn = homePage.getFeaturedPreviousButton();
        homePage.hoverElement(previousBtn);

        WebElement oldElement;
        WebElement newElement;
        String oldElementId;
        String newElementId;
        int repeats = 9;

        for(int i=0; i<repeats; i++){

            oldElement = homePage.getCurrentFeaturedElement();
            oldElementId = oldElement.getAttribute("data-ds-appid");

            homePage.click(previousBtn);

            newElement = homePage.getCurrentFeaturedElement();
            newElementId = newElement.getAttribute("data-ds-appid");

            Assert.assertNotEquals(oldElement, newElement,
                    "ERROR: El elemento no cambió. "+oldElementId+" = "+newElementId);

            System.out.println(i);
            System.out.println("  -Old: " + oldElementId);
            System.out.println("  -New: " + newElementId);
            System.out.println();
        }
    }
}
