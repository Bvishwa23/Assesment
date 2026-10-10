package Day_10_Assesment;

import Day_10_Assesment.POM.*;
import Day_10_Assesment.Utility.Excel;
import Day_10_Assesment.Utility.commanProp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SauceDemoTest {

    WebDriver driver;
    Login login;
    Product_page products;
    CartPage cart;
    Checkout_page checkout;
    Thankspage thanks;
    OverView overView;

    @BeforeClass
    public void setup() throws IOException, InterruptedException {

        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();

        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(10)
        );

        driver.get(commanProp.getData("url"));

        Thread.sleep(2000);

        login = new Login(driver);
        products = new Product_page(driver);
        cart = new CartPage(driver);
        checkout = new Checkout_page(driver);
        overView = new OverView(driver);
        thanks = new Thankspage(driver);

        System.out.println("SauceDemo application opened");
    }

    @Test
    public void loginTest() throws IOException, InterruptedException {

        login.userName(
                commanProp.getData("username")
        );

        Thread.sleep(1000);

        login.pass(
                commanProp.getData("password")
        );

        Thread.sleep(1000);

        login.login();

        Thread.sleep(2000);
//        Assert.assertTrue(
//                products.productDisplay(),
//                "Products page is NOT displayed"
//        );

        if (products.productDisplay()) {
            System.out.println("Products page is displayed");
        } else {
            System.out.println("Products page is NOT displayed");
        }
    }

    @Test(dependsOnMethods = "loginTest")
    public void oderPalcementTest()
            throws IOException, InterruptedException {

        products.Addcart();

        Thread.sleep(2000);

        System.out.println(
                "Sauce Labs Backpack added to cart"
        );

        if (products.getcartcount().equals("1")) {
            System.out.println(
                    "Cart contains 1 item"
            );

        } else {
            System.out.println(
                    "Cart does not contain 1 item"
            );
        }

        Thread.sleep(2000);

        products.cart_button();

        Thread.sleep(2000);

        if (cart.backpackDisplay()) {

            System.out.println("Sauce Labs Backpack is displayed in cart"
            );
        } else {

            System.out.println(
                    "Sauce Labs Backpack is NOT displayed in cart"
            );
        }

        Thread.sleep(2000);

        cart.chechout_clic();

        Thread.sleep(2000);

        String firstName = Excel.getData(1, 0);
        String lastName = Excel.getData(1, 1);
        String postalCode = Excel.getData(1, 2);

        checkout.setFirstname(firstName);

        Thread.sleep(1000);

        checkout.last_name(lastName);

        Thread.sleep(1000);

        checkout.Zipcode(postalCode);

        Thread.sleep(1000);

        checkout.checkout_click();

        Thread.sleep(2000);

        if (overView.overviewDisplay()) {

            System.out.println(
                    "Checkout: Overview page is displayed"
            );

        } else {

            System.out.println(
                    "Checkout: Overview page is NOT displayed"
            );
        }

        Thread.sleep(2000);

        overView.finish();

        Thread.sleep(2000);

        if (thanks.Thanks()) {

            if (thanks.getThankMessage()
                    .equals("Thank you for your order!")) {

                System.out.println(
                        "Thank you for your order!"
                );

            } else {

                System.out.println(
                        "Thank you message text is incorrect"
                );
            }

        } else {

            System.out.println(
                    "Thank you for your order message is NOT displayed"
            );
        }

        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);

        if (driver != null) {

            driver.quit();

            System.out.println("Browser closed");
        }
    }
}