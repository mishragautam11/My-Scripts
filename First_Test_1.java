package TestNG_Pakage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class First_Test_1 {
WebDriver driver;
   @BeforeMethod
    public void launchbrowser(){

       WebDriverManager.chromedriver().setup();
       driver= new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.get("http://omayo.blogspot.com/");

   }

   @Test(priority = 1)
   public void testomayo(){

       driver.findElement(By.id("alert1")).click();
       String text = driver.switchTo().alert().getText();
       System.out.println(text);
       driver.switchTo().alert().accept();
   }
   @Test(priority = 0,dependsOnMethods ="testomayo")
   public void testpromtalert(){
       driver.findElement(By.id("prompt")).click();
       driver.switchTo().alert().sendKeys("Gautam");
   }


@AfterMethod
    public void teardown(){
       driver.quit();
}


    public static class Omayo_test {
        WebDriver driver;

        @Test
        @Parameters({"txt"})
        public void test(String txt){

            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://omayo.blogspot.com/");

            driver.findElement(By.id("ta1")).sendKeys(txt);
            String test = driver.findElement(By.xpath("//h2[text()=\"Text Area Field\"]")).getText();
            Assert.assertEquals(test,"Text Area Field");
            driver.quit();

        }
    }
}