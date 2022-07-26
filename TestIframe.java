package StepDefinations;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestIframe {
    WebDriver driver;
    @When("Open Url")
    public void open_url() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.co.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    @Then("switch to iframe")
    public void switch_to_iframe() {
        WebElement Frame = driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[3]/iframe"));
        driver.switchTo().frame(Frame);

    }
    @And("click No Thanks")
    public void click_no_thanks() {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label=\"No thanks\"]"))).click();


    }
    @Then("Close the browser")
    public void close_the_browser() {
        driver.close();

    }


}
