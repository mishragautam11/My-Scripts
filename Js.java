import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Js {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.path2usa.com/travel-companions");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div/span/div/div[2]/div/div/div[2]")).click();

        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("document.getElementById('travel_date').value='17/03/2033'");




    }
}
