package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePageUsingPageFactory {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(className = "home-movie-heading")
            @CacheLookup
    WebElement homeMovieHead;
    @FindBy(className = "home-movie-play-button")
    WebElement playBtn;
    @FindBy(className = "movies-list-heading")
            @CacheLookup
    List<WebElement> moviesListHeading;
    @FindBy(className = "poster")
            @CacheLookup
    List<WebElement> listOfMovies;
    @FindBy(css = "svg[class *='google']")
            WebElement googleIcon;
    @FindBy(css = "svg[class *='twitter']")
    WebElement twitterIcon;
    @FindBy(css = "svg[class *='instagram']")
    WebElement instagramIcon;
    @FindBy(css = "svg[class *='youtube']")
    WebElement youtubeIcon;
    @FindBy(css = "p[class *='contact']")
            WebElement contactUsText;

    public HomePageUsingPageFactory(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }
    public String checkMovieHead(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-movie-heading")));
        return homeMovieHead.getText();
    }
    public String checkListHead(int index){
        return moviesListHeading.get(index).getText();
    }
    public boolean checkPlayBtn(){
        return playBtn.isDisplayed();
    }
    public int checkDisplayImages(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("poster")));
        return listOfMovies.size();
    }
    public void clickOnImage(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("poster")));
        listOfMovies.get(index).click();
    }
    public boolean checkFooterSection1(){
       return googleIcon.isDisplayed();
    }
    public boolean checkFooterSection2(){ return instagramIcon.isDisplayed();}
    public boolean checkFooterSection3(){return twitterIcon.isDisplayed();}
    public boolean checkFooterSection4(){  return youtubeIcon.isDisplayed();}
    public String getTextOfContactUs(){
        return contactUsText.getText();
    }

}
