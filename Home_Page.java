package Demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Home_Page {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://9yardstechnology.ca/demo/");
        driver.manage().timeouts().getPageLoadTimeout();


        Actions actions = new Actions(driver);
        WebElement ServiceMenu = driver.findElement(By.xpath("//a[normalize-space()='Services']"));
        WebElement option1 = driver.findElement(By.xpath("//ul[@class='nav-dropdown nav-submenu']//a[contains(text(),'Web Development')]"));

        actions.moveToElement(ServiceMenu).click(option1).build().perform();
        String page1 = driver.findElement(By.linkText("Angular Js")).getText();
        System.out.println(page1);


        Thread.sleep(2000);
        driver.navigate().back();
        WebElement option2 = driver.findElement(By.xpath("//ul[@class='nav-dropdown nav-submenu']//a[contains(text(),'App Development')]"));
        actions.moveToElement(ServiceMenu).click(option2).build().perform();
        String page2 = driver.findElement(By.linkText("Android App Development")).getText();
        System.out.println(page2);

        Thread.sleep(2000);
        driver.navigate().back();
        WebElement option3 = driver.findElement(By.linkText("Quality Assurance"));
        actions.moveToElement(ServiceMenu).click(option3).build().perform();
        String page3 = driver.findElement(By.linkText("Funcational Testing")).getText();
        System.out.println(page3);

        Thread.sleep(2000);
        driver.navigate().back();
        try {
            WebElement option4 = driver.findElement(By.xpath("//ul[@class='nav-dropdown nav-submenu']//a[contains(text(),'IT Staffing')]"));
            actions.moveToElement(ServiceMenu).click(option4).build().perform();
            String page4 = driver.findElement(By.linkText("Staff Augmentation")).getText();
            System.out.println(page4);
        } catch (Exception e) {


            driver.quit();


        }

    }}