package org.example.Assesment;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//TestCase-2
// 1.Navigate to myntra application
//2.Search for any product
//3.Add the product to the wishlist
//4.Verify whether it is added or not
public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.myntra.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.className("desktop-searchBar"));

        Thread.sleep(2000);

        element.sendKeys("shoes", Keys.ENTER);

        WebElement ref3 = driver.findElement(
                By.xpath("(//span[@class='product-wishlistFlex product-actionsButton product-wishlist '])[1]")
        );

        JavascriptExecutor js1 = (JavascriptExecutor) driver;

        js1.executeScript("arguments[0].click()", ref3);

        Thread.sleep(4000);

        String url1 = driver.getCurrentUrl();

        System.out.println(url1);

        if (url1.equals("https://www.myntra.com/login?referer=https://www.myntra.com/shoes?rawQuery=shoes")) {
            System.out.println("product added wishlist");
        } else {
            System.out.println("product is not added to the cart");
        }


        }

}
