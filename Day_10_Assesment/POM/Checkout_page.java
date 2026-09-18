package Day_10_Assesment.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_page {

    WebDriver driver;

    public Checkout_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    private WebElement firstname;

    @FindBy(id = "last-name")
    private WebElement lastname;

    @FindBy(id = "postal-code")
    private WebElement postelcode;

    @FindBy(id = "continue")
    private WebElement continue_check;

    public void setFirstname(String value) {
        firstname.sendKeys(value);
    }

    public void last_name(String value) {
        lastname.sendKeys(value);
    }

    public void Zipcode(String value) {
        postelcode.sendKeys(value);
    }

    public void checkout_click() {
        continue_check.click();
    }
}