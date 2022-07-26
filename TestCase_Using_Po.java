package StepDefinations;

import Pageobject.PageFactory_Po;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_Using_Po {

    WebDriver driver=null;
    PageFactory_Po login;

    @Given("Verify that Url open up")
    public void verify_that_url_open_up() {

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    }
    @When("Land on the provided link")
    public void land_on_the_provided_link() {
        driver.findElement(By.id("btnLogin")).isDisplayed();
    }
    @And("Input the valid id and password")
    public void input_the_valid_id_and_password() {

    login.loginpage("Admin","admin123");

    }

    @Then("Shut down browser")
    public void shut_down_browser() {
       driver.quit();

    }

}
