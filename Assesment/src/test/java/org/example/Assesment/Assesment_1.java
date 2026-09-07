package org.example.Assesment;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.Duration;

//Day 1: assessment
//
//        TestCase-1
//
//        1. Launch SauceDemo.
//        2.Login using the valid credentials provided on the application.
//        3.On the Products page, use JavaScript Executor to scroll to the bottom of the page.
//        4. Take a screenshot of the page after scrolling.
//        5.Save the screenshot with a meaningful name such as products-page.png.
public class Assesment_1 {
    public static void main(String[] args) throws InterruptedException, IOException {
            WebDriver driver=new ChromeDriver();
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
            driver.findElement(By.id("user-name")).sendKeys("standard_user", Keys.TAB,"secret_sauce",Keys.ENTER);
            Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,500)");
        TakesScreenshot screen=(TakesScreenshot) driver;
        File src=screen.getScreenshotAs(OutputType.FILE);
        File dest=new File("./src/Photos/products-page.png");
        FileHandler.copy(src,dest);
        driver.quit();
        }
}
