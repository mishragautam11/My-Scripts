package Demo;

import Page_Objects.ContactUs;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TryPO {
    static WebDriver driver = null;
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://9yardstechnology.ca/demo/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.linkText("CONTACT US")).click();

        ContactUs contact = new ContactUs(driver);

        contact.fillform("testing" ,"sdfsdg@sfkgks.com" , "1234567890");

        WebElement PhoneNumber = driver.findElement(By.name("country-code"));
        Select select = new Select(PhoneNumber);
        select.selectByIndex(1);

        WebElement dropdown = driver.findElement(By.name("considering-for"));
        Select select1 = new Select(dropdown);
        select1.selectByIndex(2);

        Thread.sleep(2000);
        driver.quit();

    }
}
