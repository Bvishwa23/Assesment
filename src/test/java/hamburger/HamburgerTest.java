package hamburger;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.PropertyUtility;

public class HamburgerTest extends BaseClass {

    // =========================================================
    // LOGIN BEFORE EVERY TEST
    // =========================================================

    @BeforeMethod(alwaysRun = true)
    public void loginBeforeHamburgerTest() throws IOException, InterruptedException {

        String username = PropertyUtility.getData("username");
        String password = PropertyUtility.getData("password");

        loginPage.getUserName(username);
        loginPage.getPwd(password);
        loginPage.getLoginBtn();

        Thread.sleep(1000);
    }

    // =========================================================
    // TC-HAM-01
    // Verify Hamburger menu options
    // =========================================================

    @Test(groups = {"functional"})
    public void verifyHamburgerMenuOptions() throws InterruptedException {

        hamburgerMenuPage.openMenu();

        Assert.assertTrue(hamburgerMenuPage.allItems.isDisplayed(), "All Items option is not displayed");
        Assert.assertTrue(hamburgerMenuPage.logout.isDisplayed(), "Logout option is not displayed");
        Assert.assertTrue(hamburgerMenuPage.resetAppState.isDisplayed(), "Reset App State option is not displayed");

        Reporter.log("TC-HAM-01 Passed", true);
    }

    // =========================================================
    // TC-HAM-02
    // Reset App State removes product
    // =========================================================

    @Test(groups = {"functional"})
    public void verifyResetAppStateRemovesProduct() throws IOException, InterruptedException {

        String productName = ExcelUtility.getData("HamburgerData", 2, 1);

        productPage.addBackpackToCart();
        Assert.assertEquals(productPage.getCartQuantity(), "1", "Product was not added to cart");

        hamburgerMenuPage.openMenu();
        hamburgerMenuPage.clickResetAppState();

        productPage.clickCartLogo();
        Assert.assertEquals(cartPage.getCartItemCount(), 0, productName + " was not removed by Reset App State");

        Reporter.log("TC-HAM-02 Passed", true);
    }

    // =========================================================
    // TC-HAM-03
    // Logout
    // =========================================================

    @Test(groups = {"functional", "smoke"})
    public void verifyLogout() throws InterruptedException {

        hamburgerMenuPage.openMenu();
        hamburgerMenuPage.clickLogout();

        Assert.assertTrue(loginPage.userName.isDisplayed(), "Login Page is not displayed after Logout");
        Assert.assertTrue(loginPage.passWord.isDisplayed(), "Password field is not displayed after Logout");
        Assert.assertTrue(loginPage.loginBtn.isDisplayed(), "Login button is not displayed after Logout");

        Reporter.log("TC-HAM-03 Passed", true);
    }

    // =========================================================
    // TC-HAM-04
    // Reset App State with empty cart
    // =========================================================

    @Test(groups = {"functional"})
    public void verifyResetAppStateWithEmptyCart() throws InterruptedException {

        productPage.clickCartLogo();
        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Cart is not initially empty");

        cartPage.clickContinueShopping();
        hamburgerMenuPage.openMenu();
        hamburgerMenuPage.clickResetAppState();

        productPage.clickCartLogo();
        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Cart should remain empty");

        Reporter.log("TC-HAM-04 Passed", true);
    }

    // =========================================================
    // TC-HAM-05
    // Verify menu after Logout
    // =========================================================

    @Test(groups = {"functional"})
    public void verifyMenuAfterLogout() throws InterruptedException, IOException {

        hamburgerMenuPage.openMenu();
        hamburgerMenuPage.clickLogout();

        Assert.assertTrue(loginPage.userName.isDisplayed(), "Login Page is not displayed");
        Assert.assertEquals(driver.getCurrentUrl(), PropertyUtility.getData("url"), "User is not on Login Page after Logout");

        Reporter.log("TC-HAM-05 Passed", true);
    }

    // =========================================================
    // TC-HAM-06
    // Hamburger smoke test
    // =========================================================

    @Test(groups = {"smoke"})
    public void hamburgerSmokeTest() throws InterruptedException {

        hamburgerMenuPage.openMenu();

        Assert.assertTrue(hamburgerMenuPage.allItems.isDisplayed(), "All Items is not displayed");
        Assert.assertTrue(hamburgerMenuPage.logout.isDisplayed(), "Logout is not displayed");
        Assert.assertTrue(hamburgerMenuPage.resetAppState.isDisplayed(), "Reset App State is not displayed");

        hamburgerMenuPage.closeMenu();

        Reporter.log("TC-HAM-06 Passed", true);
    }

    // =========================================================
    // TC-HAM-07
    // Reset App State smoke test
    // =========================================================

    @Test(groups = {"regression"})
    public void resetAppStateSmokeTest() throws IOException, InterruptedException {

        String productName = ExcelUtility.getData("HamburgerData", 7, 1);

        productPage.addBackpackToCart();
        Assert.assertEquals(productPage.getCartQuantity(), "1", productName + " was not added");

        hamburgerMenuPage.openMenu();
        hamburgerMenuPage.clickResetAppState();

        productPage.clickCartLogo();
        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Reset App State did not clear cart");

        Reporter.log("TC-HAM-07 Passed", true);
    }

    // =========================================================
    // TC-HAM-08
    // Logout after Product/Cart navigation
    // =========================================================

    @Test(groups = {"integration"})
    public void logoutAfterProductAndCartNavigation() throws InterruptedException {

        Assert.assertEquals(productPage.getPageTitle(), "Products", "Product Page is not displayed");

        productPage.clickCartLogo();
        Assert.assertEquals(cartPage.getPageTitle(), "Your Cart", "Cart Page is not displayed");

        cartPage.clickContinueShopping();
        Assert.assertEquals(productPage.getPageTitle(), "Products", "Product Page is not displayed");

        hamburgerMenuPage.openMenu();
        hamburgerMenuPage.clickLogout();

        Assert.assertTrue(loginPage.loginBtn.isDisplayed(), "Login Page is not displayed after Logout");

        Reporter.log("TC-HAM-08 Passed", true);
    }

    // =========================================================
    // TC-HAM-09
    // Reset after add/remove/add
    // =========================================================

    @Test(groups = {"regression"})
    public void resetAfterAddRemoveAdd() throws IOException, InterruptedException {

        String productName = ExcelUtility.getData("HamburgerData", 9, 1);

        productPage.addBackpackToCart();
        Assert.assertEquals(productPage.getCartQuantity(), "1", "First product was not added");

        productPage.clickCartLogo();
        cartPage.removeBackpack();
        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Product was not removed");

        cartPage.clickContinueShopping();
        productPage.addBackpackToCart();
        Assert.assertEquals(productPage.getCartQuantity(), "1", productName + " was not added again");

        hamburgerMenuPage.openMenu();
        hamburgerMenuPage.clickResetAppState();

        productPage.clickCartLogo();
        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Reset App State did not clear cart");

        Reporter.log("TC-HAM-09 Passed", true);
    }

    // =========================================================
    // TC-HAM-10
    // Reset App State boundary states
    // =========================================================

    @Test(groups = {"regression"})
    public void resetAppStateBoundaryTest() throws IOException, InterruptedException {

        String productName = ExcelUtility.getData("HamburgerData", 10, 1);

        // Boundary 0
        productPage.clickCartLogo();
        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Cart should initially contain 0 items");

        cartPage.clickContinueShopping();

        // Boundary 1
        productPage.addBackpackToCart();
        Assert.assertEquals(productPage.getCartQuantity(), "1", productName + " was not added");

        hamburgerMenuPage.openMenu();
        hamburgerMenuPage.clickResetAppState();

        // Back to 0
        productPage.clickCartLogo();
        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Cart should return to 0 after Reset App State");

        Reporter.log("TC-HAM-10 Passed", true);
    }

    // =========================================================
    // TC-HAM-11
    // Complete Hamburger workflow
    // =========================================================

    @Test(groups = {"integration", "system"})
    public void completeHamburgerWorkflow() throws IOException, InterruptedException {

        String productName = ExcelUtility.getData("HamburgerData", 11, 1);

        productPage.addBackpackToCart();
        Assert.assertEquals(productPage.getCartQuantity(), "1", productName + " was not added");

        hamburgerMenuPage.openMenu();

        Assert.assertTrue(hamburgerMenuPage.allItems.isDisplayed(), "All Items is not displayed");
        Assert.assertTrue(hamburgerMenuPage.logout.isDisplayed(), "Logout is not displayed");
        Assert.assertTrue(hamburgerMenuPage.resetAppState.isDisplayed(), "Reset App State is not displayed");

        hamburgerMenuPage.clickResetAppState();

        productPage.clickCartLogo();
        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Cart was not cleared");

        cartPage.clickContinueShopping();
        hamburgerMenuPage.openMenu();
        hamburgerMenuPage.clickLogout();

        Assert.assertTrue(loginPage.loginBtn.isDisplayed(), "Login Page is not displayed after Logout");

        Reporter.log("TC-HAM-11 Passed", true);
    }
}