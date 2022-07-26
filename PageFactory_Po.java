package Pageobject;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactory_Po {

    @FindBy (id = "txtUsername")
    WebElement usernamebox;
    @FindBy(id = "txtPassword")
    WebElement passwordbox;
    @FindBy(id = "btnLogin")
    WebElement submitbtn;
    WebDriver driver;

    public PageFactory_Po(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void loginpage(String userid , String userpass){
        usernamebox.sendKeys(userid);
        passwordbox.sendKeys(userpass);
        submitbtn.click();
    }
}
