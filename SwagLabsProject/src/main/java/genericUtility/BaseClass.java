package genericUtility;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import objRepo.CartPage;
import objRepo.CheckOutPage;
import objRepo.HamburgerMenuPage;
import objRepo.LoginPage;
import objRepo.ProductPage;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
public class BaseClass {
    protected WebDriver driver;

    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected CartPage cartPage;
    protected CheckOutPage checkOutPage;
    protected HamburgerMenuPage hamburgerMenuPage;

    // =========================================================
    // Before every test
    // =========================================================
    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("") String browserName) throws IOException {
        ChromeOptions options = new ChromeOptions();
        // Disable Chrome password manager warning
        options.setExperimentalOption("prefs", java.util.Map.of(
                        "credentials_enable_service", false,
                        "profile.password_manager_leak_detection", false)
        );

        String browser = browserName.isEmpty() ? PropertyUtility.getData("browser") : browserName;
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }
        driver.manage().window().maximize();
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Test Execution Started");
        System.out.println("Browser Launched");

        // Open application
        driver.get(PropertyUtility.getData("url"));

        // Initialize Page Objects
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        hamburgerMenuPage = new HamburgerMenuPage(driver);
    }

    // =========================================================
    // After every test
    // =========================================================
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        System.out.println("Browser Closed");
        System.out.println("--------------------------------");
    }
}