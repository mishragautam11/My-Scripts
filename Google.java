package StepDefinations;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {
    WebDriver driver;

    @Given("User available on the URL")
    public void user_available_on_the_url() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.co.in/");


    }
    @When("User verify logo is available")
    public void user_verify_logo_is_available() {

        String logo = driver.findElement(By.xpath("//img[@src=\"/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png\"]"))
                .getAttribute("srcset");
        System.out.println(logo);
    }
    @Then("User close the browser")
    public void user_close_the_browser() {

        driver.close();
    }
}
