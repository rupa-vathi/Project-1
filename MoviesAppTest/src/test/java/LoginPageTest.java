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
public class LoginPageTest {
    public WebDriver driver;
    LoginPageUsingPageFactory loginPageUsingPageFactory;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        System.setProperty("Webdriver.chrome.Driver", "C:\\Users\\Nani's Rupa\\Downloads\\chromedriver-win32\\chromedriver-win32");
        loginPageUsingPageFactory = new LoginPageUsingPageFactory(driver);
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test(priority = 1)
    public void TestLoginPageUI() {
        Assert.assertTrue(loginPageUsingPageFactory.checkImageIsDisplayed(), "App logo is not displayed");
        Assert.assertEquals(loginPageUsingPageFactory.getHeadingText(), "Login", "Heading text not matched");
        Assert.assertEquals(loginPageUsingPageFactory.getTextContentOfLabel(0), "USERNAME", "Username label text does not match");
        Assert.assertEquals(loginPageUsingPageFactory.getTextContentOfLabel(1), "PASSWORD", "Password label text does not match");
        Assert.assertTrue(loginPageUsingPageFactory.checkLoginButtonIsDisplayed(), "Login button not displayed");
    }

    @Test(priority = 2)
    public void testLoginWithEmptyInputs() {
        loginPageUsingPageFactory.clickONLoginBtn();
        Assert.assertEquals(loginPageUsingPageFactory.getErrorMsg(), "*Username or password is invalid", "Error text with empty input fields does not match");
    }

    @Test(priority = 3)
    public void testLoginWithEmptyUsername() {
        loginPageUsingPageFactory.enterPassword("rahul@2021");
        loginPageUsingPageFactory.clickONLoginBtn();
        Assert.assertEquals(loginPageUsingPageFactory.getErrorMsg(), "*Username or password is invalid", "Error text with empty input fields does not match");
    }

    @Test(priority = 4)
    public void testLoginWithEmptyPassword() {
        loginPageUsingPageFactory.enterUserName("rahul");
        loginPageUsingPageFactory.clickONLoginBtn();
        Assert.assertEquals(loginPageUsingPageFactory.getErrorMsg(), "*Username or password is invalid", "Error text with empty input fields does not match");

    }

    @Test(priority = 5)
    public void testLoginWithInvalidCreds() {
        loginPageUsingPageFactory.loginToApplications("rahul", "rahul");
        Assert.assertEquals(loginPageUsingPageFactory.getErrorMsg(), "*username and password didn't match", "Error text with empty input fields does not match");

    }

    @Test(priority = 6)
    public void testLoginWithValidCreds() {
        loginPageUsingPageFactory.loginToApplications("rahul", "rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/", "Url does not match");
    }
}
