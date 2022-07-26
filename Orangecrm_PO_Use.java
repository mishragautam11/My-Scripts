package Testcases;

import Pageobjects.PO_Pagefactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.time.Duration;

public class Orangecrm_PO_Use {

    WebDriver driver=null;
    PO_Pagefactory login;
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("MyExtentReport.html");



    @Test
    public void userlogin() throws InterruptedException {
        ExtentTest test = extent.createTest("Validation of HRM Login").assignAuthor("Gautam")
                .assignCategory("Smoke Test").assignDevice("Chrome");
        test.log(Status.PASS,"User login successfully");
        test.pass("Landed on dashboard");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        boolean loginbtn = driver.findElement(By.id("btnLogin")).isDisplayed();
        Assert.assertTrue(loginbtn);

        login = new PO_Pagefactory(driver);
        login.Loginuser("Admin","admin123");

        String actualurl= driver.getCurrentUrl();
        String expectedurl= "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        Assert.assertEquals(actualurl,expectedurl);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scroll(0,1500)");

        boolean Footer = driver.findElement(By.id("footer")).isDisplayed();
        Assert.assertTrue(Footer);
        Thread.sleep(2000);
        driver.quit();

    }
    @BeforeTest
    public void beforetest(){

        extent.attachReporter(spark);
    }

    @AfterTest
    public void reportgenerator(){
        extent.flush();

    }
}

