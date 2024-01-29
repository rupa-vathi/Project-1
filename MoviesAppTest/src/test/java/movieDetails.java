import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
@Listeners(MovieAppReport.class)
public class movieDetails {
    public WebDriver driver;
    LoginPageUsingPageFactory loginPageUsingPageFactory;
    HeaderSectionUsingPageFactory headerSection;
    movieDetailsUsingPageFactory movieDetails;
    HomePageUsingPageFactory homePage;
    PopularPageUsingPageFactory popularPage;
    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        System.setProperty("Webdriver.chrome.Driver", "C:\\Users\\Nani's Rupa\\Downloads\\chromedriver-win32\\chromedriver-win32");
        loginPageUsingPageFactory = new LoginPageUsingPageFactory(driver);
         movieDetails=new movieDetailsUsingPageFactory(driver);
         headerSection=new HeaderSectionUsingPageFactory(driver);
         homePage=new HomePageUsingPageFactory(driver);
         popularPage=new PopularPageUsingPageFactory(driver);
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPageUsingPageFactory.loginToApplications("rahul","rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/", "Url does not match");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
    @Test(priority = 1)
    public void TestMovieDetailsPageOnHome(){
        Assert.assertEquals(homePage.checkDisplayImages(),20,"Images are missed");
        homePage.clickOnImage(3);
        System.out.println(movieDetails.getTitleOfMovie());
        System.out.println(movieDetails.getOverViewOfMovie());
        System.out.println(movieDetails.movieReviewContainer());
        Assert.assertTrue(movieDetails.checkPlayBtn(),"play button not displayed");
        System.out.println(movieDetails.genreOfMovie());
        System.out.println(movieDetails.audioOptionsInMovie());
        System.out.println(movieDetails.getRatingHeading(0)+" : "+movieDetails.getRatingText(0));
        System.out.println(movieDetails.getRatingHeading(1)+" : "+movieDetails.getRatingText(1));
        System.out.println(movieDetails.getBudgetHeading(0)+" : "+movieDetails.getBudgetText(0));
        System.out.println(movieDetails.getBudgetHeading(1)+" : "+movieDetails.getBudgetText(1));
    }
    @Test(priority = 2)
    public void TestMovieDetailsPageOnPopular(){
        headerSection.NavigateToPopular();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/popular","Navigate to papular page failed");
        popularPage.checkMoviesDisplay(2);
        popularPage.clickOnImage(2);
        System.out.println(movieDetails.getTitleOfMovie());
        System.out.println(movieDetails.getOverViewOfMovie());
        System.out.println(movieDetails.movieReviewContainer());
        Assert.assertTrue(movieDetails.checkPlayBtn(),"play button not displayed");
        System.out.println(movieDetails.genreOfMovie());
        System.out.println(movieDetails.audioOptionsInMovie());
        System.out.println(movieDetails.getRatingHeading(0)+" : "+movieDetails.getRatingText(0));
        System.out.println(movieDetails.getRatingHeading(1)+" : "+movieDetails.getRatingText(1));
        System.out.println(movieDetails.getBudgetHeading(0)+" : "+movieDetails.getBudgetText(0));
        System.out.println(movieDetails.getBudgetHeading(1)+" : "+movieDetails.getBudgetText(1));
    }
}
