package Day12.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "username")
    public WebElement userName;
    @FindBy(name = "password")
    public WebElement passWord;
    @FindBy(xpath = "//button[text()=' Login ']")
    public WebElement loginBtn;
    @FindBy(className = "oxd-userdropdown-tab")
    public WebElement profile;
    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logout;

    public void getUserName(String value){
        userName.sendKeys(value);
    }
    public void getPwd(String value){
        passWord.sendKeys(value);
    }
    public void getLoginBtn(){
        loginBtn.click();
    }
    public void getLogOut(){
        profile.click();
        logout.click();
    }

}