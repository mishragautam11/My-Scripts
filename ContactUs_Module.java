package Demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ContactUs_Module {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://9yardstechnology.ca/demo/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.linkText("CONTACT US")).click();
        driver.findElement(By.name("FullName")).sendKeys("Test");
        driver.findElement(By.name("your-email")).sendKeys("Automate@test.com");

            WebElement PhoneNumber = driver.findElement(By.name("country-code"));
            Select select = new Select(PhoneNumber);
            select.selectByIndex(1);

            driver.findElement(By.name("phone-number")).sendKeys("9876598765");

            WebElement dropdown = driver.findElement(By.name("considering-for"));
            Select select1 = new Select(dropdown);
            select1.selectByIndex(2);

            //driver.findElement(By.xpath("//div[@class=\"col-md-12 mb-3\" and @xpath=\"1\"]"))
                    //.sendKeys("This is test automation script");

            //driver.findElement(By.xpath("//form[@class='wpcf7-form invalid']//input[@value='Submit']")).click();

            driver.quit();


        }
    }
