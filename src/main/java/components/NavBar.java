package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.GamePage;
import settings.BasePage;

import java.util.ArrayList;
import java.util.List;

public class NavBar extends BasePage {

    @FindBy(id = "foryou_tab")
    private WebElement yourStoreTab;

    @FindBy(id = "genre_tab")
    private WebElement yourGameTab;

    @FindBy(id = "store_nav_search_term")
    private WebElement searchTheStoreInput;

    @FindBy(css = "#search_suggestion_contents > a > .match_name")
    private List<WebElement> suggestedGames;

    public NavBar(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openYourStoreTab(){
        this.openNavBarTab(yourStoreTab);
    }

    public void openGamesTab(){
        this.openNavBarTab(yourGameTab);
    }

    public ArrayList<String> getSuggestedGames(){

        ArrayList<String> suggested_games_names = new ArrayList<String>();

        for (WebElement suggestedGame : suggestedGames){
            suggested_games_names.add(suggestedGame.getText());
        }

        return suggested_games_names;
    }

    public void writeGameIntoSearchInput(String game_name){
        this.writeInInput(searchTheStoreInput, game_name);
    }

    private void openNavBarTab(WebElement tab){
        this.hoverElement(tab);
        String is_active = tab.getAttribute("class");
        Assert.assertTrue(is_active.indexOf("focus") > 0, "The Menu did not open");
    }

    public GamePage clickSuggestedGame(String game_name){
        boolean matchFound = false;
        for (WebElement suggestedGame : suggestedGames){
            if (suggestedGame.getText().indexOf(game_name) >= 0){
                matchFound = true;
                suggestedGame.click();
                break;
            }
        }
        Assert.assertTrue(matchFound, "The game " +game_name+ " was not found");
        return new GamePage(driver);
    }

}