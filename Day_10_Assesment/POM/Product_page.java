package Day_10_Assesment.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_page {

    WebDriver driver;

    public Product_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Products']")
    private WebElement products;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement productbag;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartbutton;

    @FindBy(className = "shopping_cart_badge")
    private WebElement verifyElementcount;

    public boolean productDisplay() {
        return products.isDisplayed();
    }

    public void Addcart() {
        productbag.click();
    }

    public String getcartcount() {
        return verifyElementcount.getText();
    }

    public void cart_button() {
        cartbutton.click();
    }
}