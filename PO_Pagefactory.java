package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PO_Pagefactory {



    @FindBy(how = How.ID,using = "txtUsername")
    WebElement username;

    @FindBy(how=How.ID,using = "txtPassword")
    WebElement password;

    @FindBy(how = How.ID,using = "btnLogin")
    WebElement btn;

    WebDriver driver;


    public PO_Pagefactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void Loginuser(String uid, String pwd){
        username.sendKeys(uid);
        password.sendKeys(pwd);
        btn.click();


    }

    }
