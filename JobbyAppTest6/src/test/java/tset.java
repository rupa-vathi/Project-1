import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class tset {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.Driver", "C:\\Users\\Nani's Rupa\\Downloads\\chromedriver-win32\\chromedriver-win32");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
        driver.manage().window().maximize();

        WebElement userName=driver.findElement(By.id("userNameInput"));
        userName.sendKeys("rahul");
        WebElement password= driver.findElement(By.id("passwordInput"));
        password.sendKeys("rahul@2021");

        WebElement loginBtn= driver.findElement(By.className("login-button"));
        loginBtn.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));

        TakesScreenshot screenshotTaker=(TakesScreenshot) driver;
        File screenshot=screenshotTaker.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenshot,new File("destination/screen.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }

        driver.quit();
    }
}

