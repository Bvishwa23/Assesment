package cart;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Reporter;
import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.PropertyUtility;

public class CartTest extends BaseClass {

    // =========================================================
    // LOGIN BEFORE EVERY CART TEST
    // =========================================================

    @BeforeMethod(alwaysRun = true)
    public void loginBeforeCartTest() throws IOException, InterruptedException {

        String username = PropertyUtility.getData("username");
        String password = PropertyUtility.getData("password");

        loginPage.getUserName(username);
        loginPage.getPwd(password);
        loginPage.getLoginBtn();

        Thread.sleep(1500);
    }

    // =========================================================
    // TC-CART-01
    // Verify added product is visible in Cart Page
    // =========================================================

    @Test(groups = {"functional", "smoke"})
    public void verifyAddedProductVisible() throws IOException, InterruptedException {
        String productName = ExcelUtility.getData("CartData", 1, 1);

        productPage.addBackpackToCart();
        productPage.clickCartLogo();
        Assert.assertEquals(cartPage.getPageTitle(), "Your Cart", "Cart Page is not displayed");

        Assert.assertTrue(cartPage.isProductDisplayed(productName), productName + " is not displayed in Cart");
        Reporter.log("TC-CART-01 Passed", true);
    }

    // =========================================================
    // TC-CART-02
    // Verify Remove, Checkout and Continue Shopping controls
    // =========================================================

    @Test(groups = {"functional"})
    public void verifyCartControls() throws IOException, InterruptedException {

        String productName = ExcelUtility.getData("CartData", 2, 1);
        productPage.addBackpackToCart();
        productPage.clickCartLogo();
        Assert.assertTrue(cartPage.backpackRemove.isDisplayed(), "Remove button is not displayed");
        Assert.assertTrue(cartPage.checkoutBtn.isDisplayed(), "Checkout button is not displayed");
        Assert.assertTrue(cartPage.continueShoppingBtn.isDisplayed(), "Continue Shopping button is not displayed");
        Assert.assertTrue(cartPage.isProductDisplayed(productName), productName + " is not displayed");
        Reporter.log("TC-CART-02 Passed", true);
    }

    // =========================================================
    // TC-CART-03
    // Verify Cart Page to Checkout Page
    // =========================================================

    @Test(groups = {"integration"})
    public void verifyCartToCheckout() throws IOException, InterruptedException {

        String productName = ExcelUtility.getData("CartData", 3, 1);
        productPage.addBackpackToCart();
        productPage.clickCartLogo();
        Assert.assertTrue(cartPage.isProductDisplayed(productName), productName + " is not displayed in Cart");
        cartPage.clickCheckout();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"), "Checkout Information page is not displayed");
        Reporter.log("TC-CART-03 Passed", true);
    }

    // =========================================================
    // TC-CART-04
    // Verify empty cart does not show selected product
    // =========================================================

    @Test(groups = {"functional"})
    public void verifyEmptyCart() throws IOException, InterruptedException {

        String productName = ExcelUtility.getData("CartData", 4, 1);
        productPage.clickCartLogo();
        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Cart should be empty");

        /*
         * TC-CART-04 does not require a product name.
         * The Excel cell is intentionally blank.
         */

        Assert.assertFalse(cartPage.isProductDisplayed(productName), "Product is displayed in empty Cart");
        Reporter.log("TC-CART-04 Passed", true);
    }

    // =========================================================
    // TC-CART-05
    // Verify removed product is not displayed
    // =========================================================

    @Test(groups = {"functional"})
    public void verifyRemovedProductNotDisplayed() throws IOException, InterruptedException {

        String productName = ExcelUtility.getData("CartData", 5, 1);

        productPage.addBackpackToCart();
        productPage.clickCartLogo();
        cartPage.removeBackpack();
        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Removed product is still present in Cart");
        Assert.assertFalse(cartPage.isProductDisplayed(productName), "Removed product is still displayed");
        Reporter.log("TC-CART-05 Passed", true);
    }

    // =========================================================
    // TC-CART-06
    // Cart Page smoke test
    // =========================================================

    @Test(groups = {"smoke"})
    public void cartPageSmokeTest() throws IOException, InterruptedException {

        String productName = ExcelUtility.getData("CartData", 6, 1);
        productPage.addBackpackToCart();
        productPage.clickCartLogo();
        Assert.assertTrue(cartPage.isProductDisplayed(productName), productName + " is not displayed in Cart");
        Assert.assertTrue(cartPage.checkoutBtn.isDisplayed(), "Checkout button is not displayed");
        Reporter.log("TC-CART-06 Passed", true);
    }

    // =========================================================
    // TC-CART-07
    // Continue Shopping smoke test
    // =========================================================

    @Test(groups = {"integration"})
    public void continueShoppingSmokeTest() throws IOException, InterruptedException {

        String productName = ExcelUtility.getData("CartData", 7, 1);
        productPage.addBackpackToCart();
        productPage.clickCartLogo();
        Assert.assertTrue(cartPage.isProductDisplayed(productName), productName + " is not displayed");
        cartPage.clickContinueShopping();
        Assert.assertEquals(productPage.getPageTitle(), "Products", "User did not return to Product Page");
        Reporter.log("TC-CART-07 Passed", true);
    }

    // =========================================================
    // TC-CART-08
    // Verify cart contents after returning from Product Page
    // =========================================================

    @Test(groups = {"integration"})
    public void verifyCartAfterReturningFromProductPage() throws IOException, InterruptedException {

        String productName = ExcelUtility.getData("CartData", 8, 1);
        productPage.addBackpackToCart();
        productPage.clickCartLogo();
        cartPage.clickContinueShopping();
        Assert.assertEquals(productPage.getPageTitle(), "Products", "User did not return to Product Page");
        productPage.clickCartLogo();
        Assert.assertTrue(cartPage.isProductDisplayed(productName), "Previously added product is not retained in Cart");
        Reporter.log("TC-CART-08 Passed", true);
    }

    // =========================================================
    // TC-CART-09
    // Verify Remove action after returning to Cart
    // =========================================================

    @Test(groups = {"regression"})
    public void verifyRemoveAfterReturningToCart() throws IOException, InterruptedException {

        String productName = ExcelUtility.getData("CartData", 9, 1);
        productPage.addBackpackToCart();
        productPage.clickCartLogo();
        cartPage.clickContinueShopping();
        productPage.clickCartLogo();
        Assert.assertTrue(cartPage.isProductDisplayed(productName), productName + " is not displayed");
        cartPage.removeBackpack();
        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Product was not removed from Cart");
        Reporter.log("TC-CART-09 Passed", true);
    }

    // =========================================================
    // TC-CART-10
    // BVA - 0 -> 1 -> 0
    // =========================================================

    @Test(groups = {"regression"})
    public void verifyCartQuantityBoundary() throws IOException, InterruptedException {

        String productName = ExcelUtility.getData("CartData", 10, 1);
        // Boundary 0
        productPage.clickCartLogo();

        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Initial Cart quantity is not 0");
        cartPage.clickContinueShopping();

        // Boundary 1
        productPage.addBackpackToCart();
        Assert.assertEquals(productPage.getCartQuantity(), "1", "Cart quantity is not 1 after adding product");
        productPage.clickCartLogo();
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Cart should contain 1 product");
        Assert.assertTrue(cartPage.isProductDisplayed(productName), productName + " is not displayed");

        // Boundary 0 again
        cartPage.removeBackpack();
        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Cart did not return to 0 after removing product");
        Reporter.log("TC-CART-10 Passed", true);
    }
}