package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUs {

    WebDriver driver;

    By fullname = By.name("FullName");
    By email = By.name("your-email");
    By mobile = By.name("phone-number");

    public ContactUs(WebDriver driver) {
        this.driver = driver;
    }

    public void fillform(String fname , String mail , String number){
        driver.findElement(fullname).sendKeys(fname);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(mobile).sendKeys(number);




    }

}

