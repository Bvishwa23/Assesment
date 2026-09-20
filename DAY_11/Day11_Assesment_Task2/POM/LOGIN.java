package Day11_Assesment_Task2.POM;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LOGIN {

    WebDriver driver;

    private By username =
            By.name("username");

    private By password =
            By.name("password");

    private By loginButton =
            By.xpath("//button[@type='submit']");


    public LOGIN(WebDriver driver) {

        this.driver = driver;
    }


    public void enterUsername(String username) {

        driver.findElement(this.username)
                .sendKeys(username);
    }


    public void enterPassword(String password) {

        driver.findElement(this.password)
                .sendKeys(password);
    }


    public void clickLogin() {

        driver.findElement(loginButton)
                .click();
    }


    public void login(
            String username,
            String password) {

        enterUsername(username);

        enterPassword(password);

        clickLogin();
    }
}