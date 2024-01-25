package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ClickCounterFunctionalitySteps {
    WebDriver driver;
    int expectedCounter;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "PATH_TO_CHROMEDRIVER");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I am on the click counter page with initial count as 0")
    public void iAmOnClickCounterPageWithInitialCountAs0() {
        driver.get("https://qaclickcounter.ccbp.tech/");
        expectedCounter = 0;
    }

    @When("I click the 'Click Me!' button 5 times")
    public void iClickOnClickMeButtonRepeatedly() {
        for(int i = 0; i < 5; i++) {
            driver.findElement(By.className("button")).click();
            expectedCounter++;
        }
    }

    @Then("the counter should show the count of the clicks")
    public void counterDisplayCountOfClicks() {
        String counterText = driver.findElement(By.className("counter-value")).getText();
        int actualCounter = Integer.parseInt(counterText);
        Assert.assertEquals(actualCounter, expectedCounter);
    }
}