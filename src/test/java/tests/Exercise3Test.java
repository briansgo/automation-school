package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GamePage;
import settings.BaseTest;


public class Exercise3Test extends BaseTest{

    @Test
    public void goToGamePageTest(){
        String game_name = "Age of Empires II: Definitive Edition";
        navBar.writeGameIntoSearchInput(game_name);
        GamePage gamePage = navBar.clickSuggestedGame(game_name);
        gamePage.getGameTitle(game_name);

        String game_title = "Age of Empires II: Definitive Edition";
        String game_genre = "Estrategia Strategy";
        String game_developer = "Forgotten Empires, Tantalus Media, Wicked Witch";
        String game_publisher = "Xbox Game Studios";
        String game_franchise = "Age of Empires";

        String xtitle = gamePage.getGameDetailsTitle();
        String xgenre = gamePage.getGameDetailsGenre();
        String xdeveloper = "";
        boolean multiple = false;
        for (String e : gamePage.getGameDetailsDeveloper()){
            if (multiple) xdeveloper+=", ";
            xdeveloper+=e;
            multiple = true;
        }
        String xpublisher = gamePage.getGameDetailsPublisher();
        String xfranchise = gamePage.getGameDetailsFranchise();

        Assert.assertTrue(xtitle.indexOf(game_title) >=0, "Title " +xtitle+ " does not match " +game_title);
        Assert.assertTrue(game_genre.indexOf(xgenre) >=0, "Genre " +xgenre+ " does not match " +game_genre);
        Assert.assertTrue(game_developer.indexOf(xdeveloper) >=0, "Developer " +xdeveloper+ " does not match " +game_developer);
        Assert.assertTrue(game_publisher.indexOf(xpublisher) >=0, "Publisher "+xpublisher+ " does not match " +game_publisher);
        Assert.assertTrue(game_franchise.indexOf(xfranchise) >=0, "Franchise "+xfranchise+ " does not match " +game_franchise);

    }

}
