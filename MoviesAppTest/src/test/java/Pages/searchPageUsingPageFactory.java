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

public class searchPageUsingPageFactory {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(className = "search-empty-button")
    WebElement searchBox;
    @FindBy(className = "search-button")
            WebElement searchBtn;
    @FindBy(id = "search")
    WebElement searchInput;
    @FindBy(className = "movie-image")
    List<WebElement> listOfMovies;
    public searchPageUsingPageFactory(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    public void searchMovies(String name){
        searchInput.sendKeys(name);
    }
    public void clearSearch(){
        searchInput.clear();
    }
    public void clickOnSearchPage(){
        searchBox.click();
    }
    public void clickOnSearchBtn(){
        searchBtn.click();
    }
    public int countMovies(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-image")));
        return listOfMovies.size();
    }
}
