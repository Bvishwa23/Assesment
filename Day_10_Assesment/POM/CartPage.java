package Day_10_Assesment.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    private WebElement backpack;

    @FindBy(id = "checkout")
    private WebElement checkout_click;

    public boolean backpackDisplay() {
        return backpack.isDisplayed();
    }

    public void chechout_clic() {
        checkout_click.click();
    }
}