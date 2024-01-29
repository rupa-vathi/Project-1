import Pages.HomePageUsingPageFactory;
import Pages.LoginPageUsingPageFactory;
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
public class HomePageTest {
    public WebDriver driver;
    HomePageUsingPageFactory homePage;
    LoginPageUsingPageFactory loginPageUsingPageFactory;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        System.setProperty("Webdriver.chrome.Driver", "C:\\Users\\Nani's Rupa\\Downloads\\chromedriver-win32\\chromedriver-win32");
        loginPageUsingPageFactory = new LoginPageUsingPageFactory(driver);
        homePage=new HomePageUsingPageFactory(driver);
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
    public void TestHomePage(){
        System.out.println(homePage.checkMovieHead());
        Assert.assertEquals(homePage.checkListHead(0),"Trending Now","Movies List heading 1 not matched");
        Assert.assertEquals(homePage.checkListHead(1),"Originals","Movies List heading 2 not matched");
        Assert.assertTrue(homePage.checkPlayBtn(),"Play button not displayed");
        Assert.assertEquals(homePage.checkDisplayImages(),20,"Images are missed");
    }
    @Test(priority = 2)
    public void ContactUsSection(){
        Assert.assertTrue(homePage.checkFooterSection1(),"Google icon not displayed");
        Assert.assertTrue(homePage.checkFooterSection3(),"twitter icon not displayed");
        Assert.assertTrue(homePage.checkFooterSection2(),"instagram icon not displayed");
        Assert.assertTrue(homePage.checkFooterSection4(),"youtube icon not displayed");

        Assert.assertEquals(homePage.getTextOfContactUs(),"Contact Us","Missing contact us Text");
    }
}
