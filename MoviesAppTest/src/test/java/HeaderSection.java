import Pages.HeaderSectionUsingPageFactory;
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
public class HeaderSection {
    public WebDriver driver;
    HeaderSectionUsingPageFactory headerSection;
    LoginPageUsingPageFactory loginPageUsingPageFactory;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        System.setProperty("Webdriver.chrome.Driver", "C:\\Users\\Nani's Rupa\\Downloads\\chromedriver-win32\\chromedriver-win32");
        loginPageUsingPageFactory = new LoginPageUsingPageFactory(driver);
        headerSection=new HeaderSectionUsingPageFactory(driver);
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
    public void testHeader(){
        Assert.assertTrue(headerSection.checkWebsiteLogo(),"Website logo not found");
        Assert.assertEquals(headerSection.checkNavElements(0),"Home","Home Nav link not found");
        Assert.assertEquals(headerSection.checkNavElements(1),"Popular","Popular Nav link not found");
    }
    @Test(priority = 2)
    public void testHeaderSectionFunctionalities(){
        headerSection.NavigateToPopular();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/popular","Navigate to papular page failed");
        headerSection.NavigateToHome();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/","Navigate to home page failed");
        headerSection.navigateAccountPage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/account","Navigate to account page failed");
    }
}
