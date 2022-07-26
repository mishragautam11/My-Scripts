package Testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class File_Upload {
    @Test
    public void uploadfile(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tus.io/demo.html");

        // Input of file will only be done if the element is input type and the type=File.

        driver.findElement(By.id("js-file-input")).sendKeys("C:\\Users\\Dell\\Desktop\\Leaves.png");
        boolean uploaded=driver.findElement(By.xpath("//*[@id=\"js-upload-container\"]/div")).isDisplayed();
        Assert.assertTrue(uploaded);
        driver.quit();
    }
}
