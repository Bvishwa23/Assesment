package DAY11_Assesment.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LOGIN {

    WebDriver driver;

    public LOGIN(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement pass;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement Loginbtn;


    public void setUsername(String value) {

        username.sendKeys(value);
    }


    public void setPass(String value) {

        pass.sendKeys(value);
    }


    public void setLoginbtn() {

        Loginbtn.click();
    }
}