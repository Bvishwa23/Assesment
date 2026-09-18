package Day_10_Assesment.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement un;

    @FindBy(id = "password")
    private WebElement pwd;

    @FindBy(id = "login-button")
    private WebElement lgbutton;

    public void userName(String value) {
        un.sendKeys(value);
    }

    public void pass(String value) {
        pwd.sendKeys(value);
    }

    public void login() {
        lgbutton.click();
    }
}