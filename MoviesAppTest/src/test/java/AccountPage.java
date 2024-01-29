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
public class AccountPage {
    public WebDriver driver;
    LoginPageUsingPageFactory loginPageUsingPageFactory;
    HeaderSectionUsingPageFactory headerSection;
    AccountPageUsingPageFactory accountPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        System.setProperty("Webdriver.chrome.Driver", "C:\\Users\\Nani's Rupa\\Downloads\\chromedriver-win32\\chromedriver-win32");
        loginPageUsingPageFactory = new LoginPageUsingPageFactory(driver);
        accountPage=new AccountPageUsingPageFactory(driver);
        headerSection=new HeaderSectionUsingPageFactory(driver);
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPageUsingPageFactory.loginToApplications("rahul","rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/", "Url does not match");
        headerSection.navigateAccountPage();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
    @Test(priority = 1)
    public void TestAccountPageUI(){
        Assert.assertEquals(accountPage.getHeadOfAccPage(),"Account","Heading not matched");
        System.out.println(accountPage.getMemberShipDetails());
        System.out.println(accountPage.getPlanDetails());
    }
    @Test(priority = 2)
    public void LogoutFunctionality(){
        accountPage.ClickOnLogout();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/login","logout function failed");
    }
}
