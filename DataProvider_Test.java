package TestNG_Pakage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Iterator;

public class DataProvider_Test {


    WebDriver driver;
    @BeforeMethod
    public void preconditions(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().getPageLoadTimeout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://formsmarts.com/html-form-example");


    }
    @AfterMethod
    public void postcondition(){
        driver.quit();
    }




    @Test(dataProvider = "get_data")
    public void Testcase(String fname, String lname,String email, String enquiry ){
        driver.findElement(By.id("u_DAN_4607")).sendKeys(fname);
        driver.findElement(By.id("u_DAN_338354")).sendKeys(lname);
        driver.findElement(By.id("u_DAN_4608")).sendKeys(email);

        WebElement dropdownlist = driver.findElement(By.id("u_DAN_338367"));
        Select select = new Select(dropdownlist);
        select.selectByValue("Support Inquiry");

        driver.findElement(By.id("u_DAN_4609")).sendKeys(enquiry);


    }
}
