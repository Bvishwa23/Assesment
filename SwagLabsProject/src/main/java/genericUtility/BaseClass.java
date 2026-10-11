
package genericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import objRepo.CartPage;
import objRepo.CheckOutPage;
import objRepo.HamburgerMenuPage;
import objRepo.LoginPage;
import objRepo.ProductPage;

public class BaseClass {

    protected WebDriver driver;

    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected CartPage cartPage;
    protected CheckOutPage checkOutPage;
    protected HamburgerMenuPage hamburgerMenuPage;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("") String browserName)
            throws IOException {

        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("prefs", java.util.Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_leak_detection", false
        ));

        String browser = browserName.isEmpty()
                ? PropertyUtility.getData("browser")
                : browserName;

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException(
                    "Invalid browser: " + browser);
        }

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Test Execution Started");
        System.out.println("Browser Launched");

        driver.get(PropertyUtility.getData("url"));

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        hamburgerMenuPage = new HamburgerMenuPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        try {
            // Automatically capture screenshots for failed tests
            if (result.getStatus() == ITestResult.FAILURE
                    && driver != null) {

                String testName = result.getTestClass()
                        .getRealClass().getSimpleName()
                        + "_"
                        + result.getMethod().getMethodName();

                ScreenshotUtility.captureScreenshot(
                        driver, testName);
            }

        } catch (Exception e) {
            System.err.println(
                    "Screenshot failed: " + e.getMessage());

        } finally {
            if (driver != null) {
                driver.quit();
                driver = null;
            }

            System.out.println("Browser Closed");
            System.out.println("--------------------------------");
        }
    }
}
