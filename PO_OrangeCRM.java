package StepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PO_OrangeCRM {
    WebDriver driver;
  By uid = By.id("txtUsername");
  By pwd = By.id("txtPassword");
  By loginbtn = By.id("btnLogin");


    public PO_OrangeCRM(WebDriver driver) {
        this.driver = driver;
    }
    public void setid(String username){

        driver.findElement(uid).sendKeys(username);
    }
    public void setpass(String pass){
    driver.findElement(pwd).sendKeys(pass);

}
public void clicklogin(){
    driver.findElement(loginbtn).click();
}
}

