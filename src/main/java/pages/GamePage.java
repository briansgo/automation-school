package pages;

import settings.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GamePage extends BasePage{

    @FindBy(xpath = "//div[@class='apphub_AppName']")
    private WebElement gameTitle;

    public GamePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void getGameTitle(String game_name){
        String title = gameTitle.getText();
        boolean titleMatches = title.equalsIgnoreCase(game_name);
        Assert.assertTrue(titleMatches, "Title "+gameTitle+" does not match the game "+game_name);
    }
}
