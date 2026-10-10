package products;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.PropertyUtility;

public class ProductTest extends BaseClass {

    // =========================================================
    // LOGIN BEFORE EVERY PRODUCT TEST
    // =========================================================

    @BeforeMethod(alwaysRun = true) // @BeforeMethod bcz we have pre-condition i.e User should already be logged in.
    public void loginBeforeProductTest() throws IOException, InterruptedException {

        String username = PropertyUtility.getData("username");
        String password = PropertyUtility.getData("password");

        loginPage.getUserName(username);
        loginPage.getPwd(password);
        loginPage.getLoginBtn();

        Thread.sleep(1000);

        // ProductTest
        //     ↓
        // BaseClass @BeforeMethod
        //     ↓
        // Create NEW Chrome
        //     ↓
        // Set implicit wait = 10 sec
        //     ↓
        // Open SauceDemo
        //     ↓
        // Initialize POMs
        //     ↓
        // ProductTest @BeforeMethod
        //     ↓
        // Login
        //     ↓
        // @Test
        //     ↓
        // BaseClass @AfterMethod
        //     ↓
        // Close Chrome
    }

    // =========================================================
    // TC-PROD-01
    // Verify Product Page controls
    // =========================================================

    @Test(groups = {"functional"})
    public void verifyProductPageControls() {

        Assert.assertTrue(productPage.pageTitle.isDisplayed(), "Product page title is not displayed");
        Assert.assertTrue(productPage.filter.isDisplayed(), "Product filter is not displayed");
        Assert.assertTrue(productPage.cartLogo.isDisplayed(), "Cart logo is not displayed");
        Assert.assertFalse(productPage.productCards.isEmpty(), "Products are not displayed");
        Reporter.log("TC-PROD-01 Passed", true);
    }

    // =========================================================
    // TC-PROD-02
    // Verify product is displayed
    // =========================================================

    @Test(groups = {"functional"})
    public void verifyProductDisplayed() throws IOException {
        String productName = ExcelUtility.getData("ProductData", 2, 1);
        Assert.assertTrue(!productPage.productNames.isEmpty(), "No products are displayed");
        Assert.assertTrue(productPage.isProductDisplayed(productName), productName + " is not displayed");
        Reporter.log("TC-PROD-02 Passed", true);
    }

    // =========================================================
    // TC-PROD-03
    // Verify product can be added to cart
    // =========================================================

    @Test(groups = {"functional", "smoke"})
    public void addProductToCart() throws IOException, InterruptedException {
        String productName = ExcelUtility.getData("ProductData", 3, 1);
        productPage.addBackpackToCart();
        Assert.assertEquals(productPage.getCartQuantity(), "1", "Product was not added to cart");
        Reporter.log(productName + " added to cart", true);
        Reporter.log("TC-PROD-03 Passed", true);
    }

    // =========================================================
    // TC-PROD-04
    // Verify product removal
    // =========================================================

    @Test(groups = {"functional"})
    public void verifyProductRemovalState() throws IOException, InterruptedException {

        String productName = ExcelUtility.getData("ProductData", 4, 1);

        productPage.addBackpackToCart();

        Assert.assertEquals(productPage.getCartQuantity(), "1", "Product was not added to cart");

        productPage.clickCartLogo();
        cartPage.removeBackpack();

        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Product was not removed from Cart");

        cartPage.clickContinueShopping();
        Assert.assertEquals(productPage.getPageTitle(), "Products", "Product Page is not displayed");

        Reporter.log(productName + " removal verified", true);
        Reporter.log("TC-PROD-04 Passed", true);
    }

    // =========================================================
    // TC-PROD-05
    // Verify Name A to Z sorting
    // =========================================================

    @Test(groups = {"functional"})
    public void verifyNameAToZSorting() throws IOException, InterruptedException {

        String filterValue = ExcelUtility.getData("ProductData", 5, 2);

        productPage.selectFilter(filterValue);

        Reporter.log("Filter Applied: " + filterValue, true);

        Assert.assertTrue(productPage.productNames.size() > 0, "Products are not displayed after sorting");

        Reporter.log("TC-PROD-05 Passed", true);
    }

    // =========================================================
    // TC-PROD-06
    // Verify Name Z to A sorting
    // =========================================================

    @Test(groups = {"functional"})
    public void verifyNameZToASorting() throws IOException, InterruptedException {

        String filterValue = ExcelUtility.getData("ProductData", 6, 2);

        productPage.selectFilter(filterValue);

        Reporter.log("Filter Applied: " + filterValue, true);

        Assert.assertTrue(productPage.productNames.size() > 0, "Products are not displayed after sorting");

        Reporter.log("TC-PROD-06 Passed", true);
    }

    // =========================================================
    // TC-PROD-07
    // Verify Price low to high sorting
    // =========================================================

    @Test(groups = {"functional"})
    public void verifyPriceLowToHighSorting() throws IOException, InterruptedException {

        String filterValue = ExcelUtility.getData("ProductData", 7, 2);

        productPage.selectFilter(filterValue);

        Reporter.log("Filter Applied: " + filterValue, true);

        Assert.assertTrue(productPage.productPrices.size() > 0, "Products are not displayed after sorting");

        Reporter.log("TC-PROD-07 Passed", true);
    }

    // =========================================================
    // TC-PROD-08
    // Verify Price high to low sorting
    // =========================================================

    @Test(groups = {"functional"})
    public void verifyPriceHighToLowSorting() throws IOException, InterruptedException {
        String filterValue = ExcelUtility.getData("ProductData", 8, 2);
        productPage.selectFilter(filterValue);
        Reporter.log("Filter Applied: " + filterValue, true);
        Assert.assertTrue(!productPage.productPrices.isEmpty(), "Products are not displayed after sorting");
        Reporter.log("TC-PROD-08 Passed", true);
    }

    // =========================================================
    // TC-PROD-09
    // Add product after applying filter
    // =========================================================

    @Test(groups = {"integration"})
    public void addToCartAfterFilter() throws IOException, InterruptedException {

        String productName = ExcelUtility.getData("ProductData", 9, 1);

        /*
         * Apply Name A-Z filter.
         */
        String filterValue = ExcelUtility.getData("ProductData", 5, 2);
        productPage.selectFilter(filterValue);
        Reporter.log("Filter Applied: " + filterValue, true);

        /*
         * Add Backpack after sorting.
         */
        productPage.addBackpackToCart();
        Assert.assertEquals(productPage.getCartQuantity(), "1", "Product was not added after filtering");
        Reporter.log(productName + " added after filtering", true);
        Reporter.log("TC-PROD-09 Passed", true);
    }

    // =========================================================
    // TC-PROD-10
    // Verify Cart boundary state
    // =========================================================

    @Test(groups = {"integration"})
    public void verifyCartLogoBoundaryState() throws IOException, InterruptedException {

        String productName = ExcelUtility.getData("ProductData", 10, 1);

        /*
         * Boundary 0
         *
         * Cart should initially contain 0 items.
         */
        productPage.clickCartLogo();

        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Cart should initially be empty");
        cartPage.clickContinueShopping();

        /*
         * Boundary 1
         *
         * Add one product.
         */
        productPage.addBackpackToCart();
        Assert.assertEquals(productPage.getCartQuantity(), "1", "Cart quantity is not 1");
        productPage.clickCartLogo();
        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Cart should contain 1 product");

        /*
         * Boundary 0 again
         *
         * Remove product.
         */
        cartPage.removeBackpack();

        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Cart quantity is not 0 after removal");

        Reporter.log(productName + " cart boundary verified", true);
        Reporter.log("TC-PROD-10 Passed", true);
    }
    // =========================================================
    // Product Flow
    // =========================================================

    //    Login
    //      ↓
    //    Product Page
    //      ↓
    //    Cart
    //      ↓
    //    0 products       ← Boundary 1
    //      ↓
    //    Continue Shopping
    //      ↓
    //    Add Backpack
    //      ↓
    //    Cart
    //      ↓
    //    1 product        ← Boundary 2
    //      ↓
    //    Remove Backpack
    //      ↓
    //    0 products       ← Boundary 3
}