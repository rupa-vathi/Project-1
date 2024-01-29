import Pages.HeaderSectionUsingPageFactory;
import Pages.LoginPageUsingPageFactory;
import Pages.PopularPageUsingPageFactory;
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
public class PopularPage {
    public WebDriver driver;
    LoginPageUsingPageFactory loginPageUsingPageFactory;
    HeaderSectionUsingPageFactory headerSection;
    PopularPageUsingPageFactory popularPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        System.setProperty("Webdriver.chrome.Driver", "C:\\Users\\Nani's Rupa\\Downloads\\chromedriver-win32\\chromedriver-win32");
        loginPageUsingPageFactory = new LoginPageUsingPageFactory(driver);
        headerSection=new HeaderSectionUsingPageFactory(driver);
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
    @Test
    public void TestPopularPageUI(){
        headerSection.NavigateToPopular();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/popular","Navigate to papular page failed");
        int count=0;
        for(int i=0;i<30;i++){
            if(popularPage.checkMoviesDisplay(i))
                count+=1;
            else
                break;
        }
        if(count==30) System.out.println("all movies are displayed in popular page");
    }
}
