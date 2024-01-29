package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PopularPageUsingPageFactory {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(className = "movie-image")
    List<WebElement> MovieImage;
    public PopularPageUsingPageFactory(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    public boolean checkMoviesDisplay(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-image")));
        return MovieImage.get(index).isDisplayed();
    }
    public void clickOnImage(int index){
        MovieImage.get(index).click();
    }
}
