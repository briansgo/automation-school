package tests;

import org.testng.annotations.Test;
import pages.GamePage;
import settings.BaseTest;


public class ExerciseTests extends BaseTest{

    @Test
    public void goToGamePage(){
        String game_name = "ARK: Survival Evolved";
        navBar.writeGameIntoSearchInput(game_name);
        GamePage gamePage = navBar.clickSuggestedGame(game_name);
        gamePage.getGameTitle(game_name);
    }
}
