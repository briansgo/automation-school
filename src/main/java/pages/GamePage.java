package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import settings.BasePage;

import java.util.ArrayList;
import java.util.List;

public class GamePage extends BasePage{

    @FindBy(xpath = "//div[@class='apphub_AppName']")
    private WebElement gameTitle;

    @FindBy(css = "div.game_details .block_content_inner > div:nth-of-type(1)")
    private WebElement gameDetails;

    @FindBy(css = "div.game_details .block_content_inner > div:nth-of-type(1)")
    private WebElement detailsTitle;

    @FindBy(css = "div.game_details .block_content_inner > div:nth-of-type(1) > a")
    private WebElement detailsGenre;

    @FindBy(css = "#developers_list a")
    private List<WebElement> detailsDevelopers;

    @FindBy(css = "div.game_details .details_block > div:nth-of-type(2) > a")
    private WebElement detailsPublisher;

    @FindBy(css = "div.game_details div:nth-of-type(3) > a")
    private WebElement detailsFranchise;

    @FindBy(css = "div.game_details .block_content_inner > div:nth-of-type(1)")
    private WebElement detailsReleaseDate;


    public GamePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void getGameTitle(String game_name){
        String title = gameTitle.getText();
        boolean titleMatches = title.equalsIgnoreCase(game_name);
        Assert.assertTrue(titleMatches, "Title "+gameTitle+" does not match the game "+game_name);
    }

    public String getGameDetailsTitle(){
        return detailsTitle.getText();
    }

    public String getGameDetailsGenre(){
        return detailsGenre.getText();
    }

    public ArrayList<String> getGameDetailsDeveloper(){
        ArrayList<String> developers = new ArrayList<>();

        for (WebElement developer : detailsDevelopers){
            developers.add(developer.getText());
        }
        return developers;
    }

    public String getGameDetailsPublisher(){
        return detailsPublisher.getText();
    }

    public String getGameDetailsFranchise(){
        return detailsFranchise.getText();
    }

    public String getGameDetailsReleaseDate(){
        return detailsReleaseDate.getText();
    }
}
