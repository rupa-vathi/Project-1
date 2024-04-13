import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class test {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.Driver", "C:\\Users\\Nani's Rupa\\Downloads\\chromedriver-win32\\chromedriver-win32");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qamyprojects.ccbp.tech/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        //first project

        WebElement click1=driver.findElement(By.cssSelector("p[class *=description] ~ div:first-of-type >:first-child"));
        click1.click();

        WebElement heading1= driver.findElement(By.cssSelector("div[class *=card]>:first-child"));
        System.out.println(heading1.getText());

        WebElement desc1= driver.findElement(By.cssSelector("div[class *=card]>:nth-child(2)"));
        System.out.println(desc1.getText());

        WebElement btn1= driver.findElement(By.cssSelector("div[class *=card]>button:last-of-type"));
        btn1.click();

        //second project

        WebElement click2=driver.findElement(By.cssSelector("p[class *=description] ~ div:first-of-type >:last-child"));
        click2.click();

        List<WebElement> heading2= driver.findElements(By.cssSelector("div[class *=card]>:nth-child(2)"));
        for (WebElement h:heading2){
            System.out.println(h.getText());
        }

        List<WebElement> desc2= driver.findElements(By.cssSelector("div[class *=card]>:last-child"));
        for (WebElement d:desc2){
            System.out.println(d.getText());
        }

        List<WebElement> names=driver.findElements(By.cssSelector("div[class *=card]>:nth-child(n+2)"));
        int i=0;
        for (WebElement w:names){
            if(i%2==0){
            System.out.print("The price of "+w.getText()+" is: ");}
            else{
                System.out.println(w.getText());
            }
            i++;
        }
        WebElement btn2= driver.findElement(By.cssSelector("div[class *=bottom]>:last-child"));
        btn2.click();


        //third project

        WebElement click3=driver.findElement(By.cssSelector("p[class *=description] ~ div:last-of-type >:first-child"));
        click3.click();

        WebElement heading3= driver.findElement(By.cssSelector("div[class *=card]>:first-child"));
        System.out.println(heading3.getText());

        WebElement desc3= driver.findElement(By.cssSelector("div[class *=card]>:nth-child(2)"));
        System.out.println(desc3.getText());

        WebElement btn3= driver.findElement(By.cssSelector("div[class *=card]>button:last-of-type"));
        btn3.click();

        //fourth project

        WebElement click4=driver.findElement(By.cssSelector("p[class *=description] ~ div:last-of-type >:last-child"));
        click4.click();

        WebElement heading4= driver.findElement(By.cssSelector("div[class *=card]>:first-child"));
        System.out.println(heading4.getText());

        WebElement desc4= driver.findElement(By.cssSelector("div[class *=card]>:nth-child(2)"));
        System.out.println(desc4.getText());

        WebElement btn4= driver.findElement(By.cssSelector("div[class *=card]>button:last-of-type"));
        btn4.click();

        driver.quit();
    }

}
