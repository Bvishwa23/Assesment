package objRepo;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    WebDriver driver;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Product Page title
    @FindBy(className = "title")
    public WebElement pageTitle;

    // All Product Cards
    @FindBy(className = "inventory_item")
    public List<WebElement> productCards;

    // All Product Names
    @FindBy(className = "inventory_item_name")
    public List<WebElement> productNames; //Here className is common for all 6 products

    // All Product Prices
    @FindBy(className = "inventory_item_price")
    public List<WebElement> productPrices;

    // Sauce Labs Backpack - Add to Cart
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement backpackAddToCart;

    // Sauce Labs Backpack - Remove
    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement backpackRemove;

    // Cart Logo
    @FindBy(className = "shopping_cart_link")
    public WebElement cartLogo;

    // Cart Quantity
    @FindBy(className = "shopping_cart_badge")
    public WebElement cartBadge;

    // Filter / Sort Dropdown
    @FindBy(className = "product_sort_container")
    public WebElement filter;

    // Get Product Page Title
    public String getPageTitle() {
        return pageTitle.getText();
    }

    // Add Backpack to Cart
    public void addBackpackToCart() throws InterruptedException {
        backpackAddToCart.click();
        Thread.sleep(1500);
    }

    // Remove Backpack
    public void removeBackpack() throws InterruptedException {
        backpackRemove.click();
        Thread.sleep(1500);
    }

    // Click Cart Logo
    public void clickCartLogo() throws InterruptedException {
        cartLogo.click();
        Thread.sleep(1500);
    }

    // Get Cart Quantity
    public String getCartQuantity() {
        return cartBadge.getText();
    }

    // Select Filter
    public void selectFilter(String value) throws InterruptedException {
        Select select = new Select(filter);
        select.selectByValue(value);
        Thread.sleep(1500);
    }
    public boolean isProductDisplayed(String productName) {
        for (WebElement product : productNames) {
            if (product.getText().equals(productName)) {
                return true;
            }
        }
        return false;
    }
}
