package objRepo;

import java.util.List;

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

    // Cart Page Title
    @FindBy(className = "title")
    public WebElement pageTitle;

    // All Cart Items
    @FindBy(className = "cart_item")
    public List<WebElement> cartItems;

    // Product Names in Cart
    @FindBy(className = "inventory_item_name")
    public List<WebElement> cartProductNames;

    // Checkout Button
    @FindBy(id = "checkout")
    public WebElement checkoutBtn;

    // Continue Shopping Button
    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingBtn;

    // All Remove Buttons
    @FindBy(css = "button[id^='remove']")
    public List<WebElement> removeButtons;

    // Sauce Labs Backpack - Remove Button
    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement backpackRemove;

    // Get Cart Page Title
    public String getPageTitle() {
        return pageTitle.getText();
    }

    // Click Checkout
    public void clickCheckout() throws InterruptedException {
        checkoutBtn.click();
        Thread.sleep(1500);
    }

    // Click Continue Shopping
    public void clickContinueShopping() throws InterruptedException {
        continueShoppingBtn.click();
        Thread.sleep(1500);
    }

    // Remove Backpack
    public void removeBackpack() throws InterruptedException {
        backpackRemove.click();
        Thread.sleep(1500);
    }

    // Get Number of Cart Items
    public int getCartItemCount() {
        return cartItems.size();
    }

    // Verify Product Exists in Cart
    public boolean isProductDisplayed(String productName) {
        for (WebElement product : cartProductNames) {
            if (product.getText().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    // Print Products in Cart
    public void printCartProducts() {
        for (WebElement product : cartProductNames) {
            System.out.println(product.getText());
        }
    }
}
