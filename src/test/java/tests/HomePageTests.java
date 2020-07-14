package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import settings.BaseTest;

import java.util.ArrayList;

public class HomePageTests extends BaseTest {

    @Test
    public void openAllNavBarTabs(){
        navBar.openYourStoreTab();
        navBar.openGamesTab();
    }

    @Test
    public void testSuggestedGames(){
        String game_name = "Age";
        navBar.writeGameIntoSearchInput(game_name);
        ArrayList<String> games = navBar.getSuggestedGames();
        Assert.assertTrue(games.size() == 5, "The number of suggested games is not correct");
        for(String game: games){
            Assert.assertTrue(game.indexOf("Age") >= 0, "The game " + game + " is not correct. It does not contain Search String " + game_name);
        }
    }

}
