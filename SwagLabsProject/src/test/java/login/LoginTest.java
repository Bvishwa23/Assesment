package login;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {
    // =========================================================
    // TC-LOGIN-01
    // Verify Username, Password and Login controls
    // =========================================================

    @Test(groups = {"functional"})
    public void verifyLoginControls() {

        Assert.assertTrue(loginPage.userName.isDisplayed(), "Username field is not displayed");
        // Here if condition is false then it will stop the test and prints that error msg in console
        // if true then it will continue the execution

        Assert.assertTrue(loginPage.passWord.isDisplayed(), "Password field is not displayed");
        Assert.assertTrue(loginPage.loginBtn.isDisplayed(), "Login button is not displayed");

        // If all 3 assertTrue passes then "TC-LOGIN-01 Passed" will prints
        Reporter.log("TC-LOGIN-01 Passed", true);

        // TC-LOGIN-01
        //       ↓
        // New Browser
        //       ↓
        // Open URL
        //       ↓
        // Test
        //       ↓
        // Close Browser
        //
        // TC-LOGIN-02
        //       ↓
        // New Browser
        //       ↓
        // Open URL
        //       ↓
        // Test
        //       ↓
        // Close Browser
    }

    // =========================================================
    // TC-LOGIN-02
    // Valid Login
    // =========================================================

    @Test(groups = {"functional", "smoke"})
    public void validLoginTest() throws Exception {

        String username = ExcelUtility.getData("LoginData", 2, 1);
        String password = ExcelUtility.getData("LoginData", 2, 2);

        loginPage.getUserName(username);
        loginPage.getPwd(password);
        loginPage.getLoginBtn();

        Assert.assertEquals(productPage.getPageTitle(), "Products", "Product Page is not displayed");
        Reporter.log("TC-LOGIN-02 Passed", true);
    }

    // =========================================================
    // TC-LOGIN-03
    // Login -> Product Page Integration
    // =========================================================

    @Test(groups = {"integration"})
    public void loginToProductIntegrationTest() throws Exception {

        String username = ExcelUtility.getData("LoginData", 3, 1);
        String password = ExcelUtility.getData("LoginData", 3, 2);

        loginPage.getUserName(username);
        loginPage.getPwd(password);
        loginPage.getLoginBtn();

        Assert.assertEquals(productPage.getPageTitle(), "Products", "Product Page is not displayed");
        Reporter.log("TC-LOGIN-03 Passed", true);
    }

    // =========================================================
    // TC-LOGIN-04
    // Invalid Username
    // =========================================================

    @Test(groups = {"functional"})
    public void invalidUsernameTest() throws Exception {

        String username = ExcelUtility.getData("LoginData", 4, 1);
        String password = ExcelUtility.getData("LoginData", 4, 2);

        loginPage.getUserName(username);
        loginPage.getPwd(password);
        loginPage.getLoginBtn();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed");

        Reporter.log("TC-LOGIN-04 Passed", true);
    }

    // =========================================================
    // TC-LOGIN-05
    // Invalid Password
    // =========================================================

    @Test(groups = {"functional"})
    public void invalidPasswordTest() throws Exception {

        String username = ExcelUtility.getData("LoginData", 5, 1);
        String password = ExcelUtility.getData("LoginData", 5, 2);

        loginPage.getUserName(username);
        loginPage.getPwd(password);
        loginPage.getLoginBtn();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Error message is not displayed");

        Reporter.log("TC-LOGIN-05 Passed", true);
    }

    // =========================================================
    // TC-LOGIN-06
    // Blank Username
    // =========================================================

    @Test(groups = {"functional"})
    public void blankUsernameTest() throws Exception {

        String username = ExcelUtility.getData("LoginData", 6, 1);
        String password = ExcelUtility.getData("LoginData", 6, 2);

        loginPage.getUserName(username);
        loginPage.getPwd(password);
        loginPage.getLoginBtn();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Username validation message is not displayed");

        Reporter.log("TC-LOGIN-06 Passed", true);
    }

    // =========================================================
    // TC-LOGIN-07
    // Blank Password
    // =========================================================

    @Test(groups = {"functional"})
    public void blankPasswordTest() throws Exception {

        String username = ExcelUtility.getData("LoginData", 7, 1);
        String password = ExcelUtility.getData("LoginData", 7, 2);

        loginPage.getUserName(username);
        loginPage.getPwd(password);
        loginPage.getLoginBtn();

        Assert.assertTrue(loginPage.errorMessage.isDisplayed(), "Password validation message is not displayed");

        Reporter.log("TC-LOGIN-07 Passed", true);
    }

    // =========================================================
    // TC-LOGIN-08
    // Smoke
    // =========================================================

    @Test(groups = {"smoke"})
    public void loginSmokeTest() throws Exception {

        String username = ExcelUtility.getData("LoginData", 8, 1);
        String password = ExcelUtility.getData("LoginData", 8, 2);

        loginPage.getUserName(username);
        loginPage.getPwd(password);
        loginPage.getLoginBtn();

        Assert.assertEquals(productPage.getPageTitle(), "Products", "Product Page is not displayed");

        Reporter.log("TC-LOGIN-08 Passed", true);
    }

    // =========================================================
    // TC-LOGIN-09
    // Regression
    // =========================================================

    @Test(groups = {"regression"})
    public void loginRegressionTest() throws Exception {
        String username = ExcelUtility.getData("LoginData", 9, 1);
        String password = ExcelUtility.getData("LoginData", 9, 2);
        loginPage.getUserName(username);
        loginPage.getPwd(password);
        loginPage.getLoginBtn();
        Assert.assertEquals(productPage.getPageTitle(), "Products", "Product Page is not displayed");

        Reporter.log("TC-LOGIN-09 Passed", true);
    }

    // =========================================================
    // TC-LOGIN-10
    // BVA
    // =========================================================

    @Test(enabled = false)
    public void loginBoundaryTest() {

        /*
         * Actual minimum and maximum supported
         * username/password lengths are not defined.
         *
         * Therefore this test remains disabled
         * until the actual boundary values are defined.
         */
    }
}