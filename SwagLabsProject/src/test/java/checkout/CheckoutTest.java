package checkout;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.PropertyUtility;

public class CheckoutTest extends BaseClass {

    // =========================================================
    // PRE-CONDITION
    // Login -> Product -> Cart -> Checkout
    // =========================================================

    @BeforeMethod(alwaysRun = true) // pre-condition i.e Cart contains a product and Checkout Information page is open
    public void loginAndAddProduct() throws IOException, InterruptedException {

        String username = PropertyUtility.getData("username");
        String password = PropertyUtility.getData("password");

        loginPage.getUserName(username);
        loginPage.getPwd(password);
        loginPage.getLoginBtn();

        Thread.sleep(1000);

        productPage.addBackpackToCart();
        productPage.clickCartLogo();
        cartPage.clickCheckout();

        Thread.sleep(1000);

        // Login
        // ↓
        // Product Page
        // ↓
        // Add Backpack
        // ↓
        // Cart
        // ↓
        // Checkout Information
    }

    // =========================================================
    // TC-CHK-01
    // Verify Checkout Information fields and controls
    // =========================================================

    @Test(groups = {"functional"})
    public void verifyCheckoutInformationControls() {

        Assert.assertTrue(checkOutPage.firstName.isDisplayed(), "First Name field is not displayed");
        Assert.assertTrue(checkOutPage.lastName.isDisplayed(), "Last Name field is not displayed");
        Assert.assertTrue(checkOutPage.zipCode.isDisplayed(), "Zip Code field is not displayed");
        Assert.assertTrue(checkOutPage.continueBtn.isDisplayed(), "Continue button is not displayed");
        Assert.assertTrue(checkOutPage.cancelBtn.isDisplayed(), "Cancel button is not displayed");

        Reporter.log("TC-CHK-01 Passed", true);
    }

    // =========================================================
    // TC-CHK-02
    // Valid checkout information
    // =========================================================

    @Test(groups = {"functional", "smoke"})
    public void validCheckoutInformationTest() throws IOException, InterruptedException {

        String firstName = ExcelUtility.getData("CheckoutData", 2, 1);
        String lastName = ExcelUtility.getData("CheckoutData", 2, 2);
        String zipCode = ExcelUtility.getData("CheckoutData", 2, 3);

        checkOutPage.enterCheckoutInformation(firstName, lastName, zipCode);
        checkOutPage.clickContinue();

        Assert.assertEquals(checkOutPage.getPageTitle(), "Checkout: Overview", "Checkout Overview page is not displayed");

        Reporter.log("TC-CHK-02 Passed", true);
    }

    // =========================================================
    // TC-CHK-03
    // Verify Checkout Overview
    // =========================================================

    @Test(groups = {"functional"})
    public void verifyCheckoutOverview() throws IOException, InterruptedException {

        String firstName = ExcelUtility.getData("CheckoutData", 3, 1);
        String lastName = ExcelUtility.getData("CheckoutData", 3, 2);
        String zipCode = ExcelUtility.getData("CheckoutData", 3, 3);

        checkOutPage.enterCheckoutInformation(firstName, lastName, zipCode);
        checkOutPage.clickContinue();

        Assert.assertTrue(checkOutPage.isProductDisplayed("Sauce Labs Backpack"), "Sauce Labs Backpack is not displayed in Checkout Overview");
        Assert.assertTrue(checkOutPage.finishBtn.isDisplayed(), "Finish button is not displayed");
        Assert.assertTrue(checkOutPage.overviewCancelBtn.isDisplayed(), "Cancel button is not displayed");

        Reporter.log("TC-CHK-03 Passed", true);
    }

    // =========================================================
    // TC-CHK-04
    // Verify Complete page and Back Home
    // =========================================================

    @Test(groups = {"integration"})
    public void verifyCheckoutCompleteAndBackHome() throws IOException, InterruptedException {

        String firstName = ExcelUtility.getData("CheckoutData", 4, 1);
        String lastName = ExcelUtility.getData("CheckoutData", 4, 2);
        String zipCode = ExcelUtility.getData("CheckoutData", 4, 3);

        checkOutPage.enterCheckoutInformation(firstName, lastName, zipCode);
        checkOutPage.clickContinue();
        checkOutPage.clickFinish();

        Assert.assertEquals(checkOutPage.getCompleteMessage(), "Thank you for your order!", "Order completion message is not displayed");

        checkOutPage.clickBackHome();

        Assert.assertEquals(productPage.getPageTitle(), "Products", "Product Page is not displayed after Back Home");

        Reporter.log("TC-CHK-04 Passed", true);
    }

    // =========================================================
    // TC-CHK-05
    // Information -> Overview integration
    // =========================================================

    @Test(groups = {"integration"})
    public void checkoutInformationToOverviewIntegration() throws IOException, InterruptedException {

        String firstName = ExcelUtility.getData("CheckoutData", 5, 1);
        String lastName = ExcelUtility.getData("CheckoutData", 5, 2);
        String zipCode = ExcelUtility.getData("CheckoutData", 5, 3);

        checkOutPage.enterCheckoutInformation(firstName, lastName, zipCode);
        checkOutPage.clickContinue();

        Assert.assertEquals(checkOutPage.getPageTitle(), "Checkout: Overview", "Checkout Overview did not open");
        Assert.assertTrue(checkOutPage.isProductDisplayed("Sauce Labs Backpack"), "Selected product was not preserved");

        Reporter.log("TC-CHK-05 Passed", true);
    }

    // =========================================================
    // TC-CHK-06
    // Overview -> Complete integration
    // =========================================================

    @Test(groups = {"integration"})
    public void checkoutOverviewToCompleteIntegration() throws IOException, InterruptedException {

        String firstName = ExcelUtility.getData("CheckoutData", 6, 1);
        String lastName = ExcelUtility.getData("CheckoutData", 6, 2);
        String zipCode = ExcelUtility.getData("CheckoutData", 6, 3);

        checkOutPage.enterCheckoutInformation(firstName, lastName, zipCode);
        checkOutPage.clickContinue();
        checkOutPage.clickFinish();

        Assert.assertEquals(checkOutPage.getCompleteMessage(), "Thank you for your order!", "Checkout Complete message is not displayed");

        Reporter.log("TC-CHK-06 Passed", true);
    }

    // =========================================================
    // TC-CHK-07
    // Complete -> Home integration
    // =========================================================

    @Test(groups = {"integration"})
    public void checkoutCompleteToHomeIntegration() throws IOException, InterruptedException {

        String firstName = ExcelUtility.getData("CheckoutData", 7, 1);
        String lastName = ExcelUtility.getData("CheckoutData", 7, 2);
        String zipCode = ExcelUtility.getData("CheckoutData", 7, 3);

        checkOutPage.enterCheckoutInformation(firstName, lastName, zipCode);
        checkOutPage.clickContinue();
        checkOutPage.clickFinish();
        checkOutPage.clickBackHome();

        Assert.assertEquals(productPage.getPageTitle(), "Products", "User is not returned to Product Page");

        Reporter.log("TC-CHK-07 Passed", true);
    }

    // =========================================================
    // TC-CHK-08
    // Blank First Name
    // =========================================================

    @Test(groups = {"functional"})
    public void blankFirstNameTest() throws IOException, InterruptedException {

        String firstName = ExcelUtility.getData("CheckoutData", 8, 1);
        String lastName = ExcelUtility.getData("CheckoutData", 8, 2);
        String zipCode = ExcelUtility.getData("CheckoutData", 8, 3);

        checkOutPage.enterFirstName(firstName);
        checkOutPage.enterLastName(lastName);
        checkOutPage.enterZip(zipCode);
        checkOutPage.clickContinue();

        Assert.assertTrue(checkOutPage.errorMessage.isDisplayed(), "First Name validation error is not displayed");

        Reporter.log("TC-CHK-08 Passed", true);
    }

    // =========================================================
    // TC-CHK-09
    // Blank Last Name
    // =========================================================

    @Test(groups = {"functional"})
    public void blankLastNameTest() throws IOException, InterruptedException {

        String firstName = ExcelUtility.getData("CheckoutData", 9, 1);
        String lastName = ExcelUtility.getData("CheckoutData", 9, 2);
        String zipCode = ExcelUtility.getData("CheckoutData", 9, 3);

        checkOutPage.enterFirstName(firstName);
        checkOutPage.enterLastName(lastName);
        checkOutPage.enterZip(zipCode);
        checkOutPage.clickContinue();

        Assert.assertTrue(checkOutPage.errorMessage.isDisplayed(), "Last Name validation error is not displayed");

        Reporter.log("TC-CHK-09 Passed", true);
    }

    // =========================================================
    // TC-CHK-10
    // Blank ZIP
    // =========================================================

    @Test(groups = {"functional"})
    public void invalidZipTest() throws IOException, InterruptedException {

        String firstName = ExcelUtility.getData("CheckoutData", 10, 1);
        String lastName = ExcelUtility.getData("CheckoutData", 10, 2);
        String zipCode = ExcelUtility.getData("CheckoutData", 10, 3);

        checkOutPage.enterFirstName(firstName);
        checkOutPage.enterLastName(lastName);
        checkOutPage.enterZip(zipCode);
        checkOutPage.clickContinue();

        Assert.assertTrue(checkOutPage.errorMessage.isDisplayed(), "ZIP validation error is not displayed");

        Reporter.log("TC-CHK-10 Passed", true);
    }

    // =========================================================
    // TC-CHK-11
    // Regression
    // =========================================================

    @Test(groups = {"regression"})
    public void checkoutRegressionTest() throws IOException, InterruptedException {

        String firstName = ExcelUtility.getData("CheckoutData", 11, 1);
        String lastName = ExcelUtility.getData("CheckoutData", 11, 2);
        String zipCode = ExcelUtility.getData("CheckoutData", 11, 3);

        checkOutPage.enterCheckoutInformation(firstName, lastName, zipCode);
        checkOutPage.clickContinue();

        Assert.assertTrue(checkOutPage.isProductDisplayed("Sauce Labs Backpack"), "Product is not displayed in Overview");

        checkOutPage.clickFinish();

        Assert.assertEquals(checkOutPage.getCompleteMessage(), "Thank you for your order!", "Checkout regression flow failed");

        Reporter.log("TC-CHK-11 Passed", true);
    }

    // =========================================================
    // TC-CHK-12
    // Complete system purchase flow
    // =========================================================

    @Test(groups = {"system"})
    public void completeSystemPurchaseFlow() throws IOException, InterruptedException {

        String firstName = ExcelUtility.getData("CheckoutData", 12, 1);
        String lastName = ExcelUtility.getData("CheckoutData", 12, 2);
        String zipCode = ExcelUtility.getData("CheckoutData", 12, 3);

        checkOutPage.enterCheckoutInformation(firstName, lastName, zipCode);
        checkOutPage.clickContinue();

        Assert.assertEquals(checkOutPage.getPageTitle(), "Checkout: Overview", "Checkout Overview is not displayed");

        checkOutPage.clickFinish();

        Assert.assertEquals(checkOutPage.getCompleteMessage(), "Thank you for your order!", "Order was not completed");

        Reporter.log("TC-CHK-12 Passed", true);
    }

    // =========================================================
    // TC-CHK-13
    // Boundary Value Analysis
    // =========================================================

    @Test(enabled = false)
    public void checkoutBoundaryTest() {

        /*
         * Actual minimum and maximum supported
         * field lengths are not defined.
         *
         * Therefore this test remains disabled.
         */
    }
}