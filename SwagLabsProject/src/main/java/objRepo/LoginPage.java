package objRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Username
    @FindBy(id = "user-name")
    public WebElement userName;

    // Password
    @FindBy(id = "password")
    public WebElement passWord;

    // Login button
    @FindBy(id = "login-button")
    public WebElement loginBtn;

    // Login error message
    @FindBy(css = "[data-test='error']")
    public WebElement errorMessage;


    // Enter username
    public void getUserName(String value) throws InterruptedException {
        userName.clear();
        userName.sendKeys(value);
        Thread.sleep(1000);
    }

    // Enter password
    public void getPwd(String value) throws InterruptedException {
        passWord.clear();
        passWord.sendKeys(value);
        Thread.sleep(1000);
    }

    // Click Login
    public void getLoginBtn() throws InterruptedException {
        loginBtn.click();
        Thread.sleep(2000);
    }

    // Complete login
    public void login(String username, String password) throws InterruptedException {
        getUserName(username);
        getPwd(password);
        getLoginBtn();
    }

    // Get error message
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}