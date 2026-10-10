package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomLogin {

    WebDriver driver;

    public PomLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement un;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement pwd;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement lgbutton;

    public void getUn(String value) {
        un.sendKeys(value);
    }

    public void getPwd(String value) {
        pwd.sendKeys(value);
    }

    public void getLgbutton() {
        lgbutton.click();
    }
}