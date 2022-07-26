package StepDefinations;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeCrmTest {
    WebDriver driver;
    @Given("User should have to open the url")
    public void user_should_have_to_open_the_url() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().getPageLoadTimeout();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

    }

    @When("^User should provide (.*) and (.*)$")
    public void user_should_provide_admin_and_admin123(String username , String password) {
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);

    }

    @Then("User need to click login button")
    public void user_need_to_click_login_button() {

        driver.findElement(By.id("btnLogin")).click();

    }

    @Then("User will wait till page loads")
    public void user_will_wait_till_page_loads() {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()=\"Dashboard\"]")));


    }

    @Then("User validate succesfull login")
    public void user_validate_succesfull_login() {
        String expectedtxt= "Dashboard";
        String actualtext=  driver.findElement(By.xpath("//h1[text()=\"Dashboard\"]")).getText();
        Assert.assertEquals(expectedtxt, actualtext);

    }

    @Then("User quit the browser")
    public void user_quit_the_browser() {
        driver.quit();

    }
}
