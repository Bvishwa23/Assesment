package objRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // =========================================================
    // COMMON PAGE TITLE
    // =========================================================

    @FindBy(className = "title")
    public WebElement pageTitle;


    // =========================================================
    // CHECKOUT INFORMATION PAGE
    // =========================================================

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement zipCode;

    @FindBy(id = "continue")
    public WebElement continueBtn;

    @FindBy(id = "cancel")
    public WebElement cancelBtn;


    // Error message
    @FindBy(css = "[data-test='error']")
    public WebElement errorMessage;


    // =========================================================
    // CHECKOUT OVERVIEW PAGE
    // =========================================================

    @FindBy(className = "cart_item")
    public List<WebElement> checkoutProducts;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> checkoutProductNames;

    @FindBy(id = "finish")
    public WebElement finishBtn;

    @FindBy(id = "cancel")
    public WebElement overviewCancelBtn;


    // =========================================================
    // CHECKOUT COMPLETE PAGE
    // =========================================================

    @FindBy(className = "complete-header")
    public WebElement completeHeader;

    @FindBy(id = "back-to-products")
    public WebElement backHomeBtn;


    // =========================================================
    // CHECKOUT INFORMATION METHODS
    // =========================================================

    public void enterFirstName(String value) throws InterruptedException {

        firstName.clear();
        firstName.sendKeys(value);
        Thread.sleep(500);
    }


    public void enterLastName(String value) throws InterruptedException {

        lastName.clear();
        lastName.sendKeys(value);
        Thread.sleep(500);
    }


    public void enterZip(String value) throws InterruptedException {

        zipCode.clear();
        zipCode.sendKeys(value);
        Thread.sleep(500);
    }


    public void clickContinue() throws InterruptedException {

        continueBtn.click();
        Thread.sleep(1500);
    }


    public void clickCancel() throws InterruptedException {

        cancelBtn.click();
        Thread.sleep(1500);
    }


    public void enterCheckoutInformation(
            String firstNameValue,
            String lastNameValue,
            String zipValue)
            throws InterruptedException {

        enterFirstName(firstNameValue);
        enterLastName(lastNameValue);
        enterZip(zipValue);
    }


    // =========================================================
    // CHECKOUT OVERVIEW METHODS
    // =========================================================

    public void clickFinish() throws InterruptedException {

        finishBtn.click();
        Thread.sleep(1500);
    }


    public void clickOverviewCancel() throws InterruptedException {

        overviewCancelBtn.click();
        Thread.sleep(1500);
    }


    public String getCheckoutProductName() {

        return checkoutProductNames.get(0).getText();
    }


    public boolean isProductDisplayed(String productName) {

        for (WebElement product : checkoutProductNames) {

            if (product.getText().equals(productName)) {
                return true;
            }
        }

        return false;
    }


    // =========================================================
    // CHECKOUT COMPLETE METHODS
    // =========================================================

    public String getCompleteMessage() {

        return completeHeader.getText();
    }


    public void clickBackHome() throws InterruptedException {

        backHomeBtn.click();
        Thread.sleep(1500);
    }


    // =========================================================
    // COMMON METHODS
    // =========================================================

    public String getPageTitle() {

        return pageTitle.getText();
    }


    // =========================================================
    // ERROR MESSAGE
    // =========================================================

    public String getErrorMessage() {

        return errorMessage.getText();
    }
}