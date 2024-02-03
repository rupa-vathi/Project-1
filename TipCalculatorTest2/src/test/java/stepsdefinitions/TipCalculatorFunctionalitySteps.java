package stepsdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TipCalculatorFunctionalitySteps {
    WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("Webdriver.chrome.Driver", "C:\\Users\\Nani's Rupa\\Downloads\\chromedriver-win32\\chromedriver-win32");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("I login to the page")
    public void loginPage(){
        driver.get("https://qatipcalc.ccbp.tech/");
    }

    @When("I clear the tip Input element")
    public void clearTipInput(){
        driver.findElement(By.id("percentageTip")).clear();
    }

    @When("I click on calculate button")
    public void btn(){
        driver.findElement(By.id("calculateButton")).click();
    }

    @Then("I verify the error text")
    public void errorText(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorMessage")));

        WebElement errorEl= driver.findElement(By.id("errorMessage"));
        Assert.assertEquals(errorEl.getText(),"Please Enter a Valid Input.");
    }
    @When("I enter the tip percentage")
    public void enterTip(){
        driver.findElement(By.id("percentageTip")).sendKeys("10f");
    }
    @When("I enter bill and percentage")
    public void enterDetails(){
        driver.findElement(By.id("billAmount")).sendKeys("1000");
        driver.findElement(By.id("percentageTip")).sendKeys("15");
    }
    @Then("I verify tip and total amount")
    public void verifyAmount(){
        WebElement tipAmount= driver.findElement(By.id("tipAmount"));
        WebElement totalAmount=driver.findElement(By.id("totalAmount"));
        Assert.assertEquals(tipAmount.getText(),"150.00");
        Assert.assertEquals(totalAmount.getText(),"1150.00");
    }
}
