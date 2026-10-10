package webdrivers;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;


import java.io.File;
import java.time.Duration;
//Testcase 3

//1.Navigate to demowebshop
//2.Identify the webelement(14.1-inch laptop)-->identify add to cart button capture the size and them click on the buuton.
// 3.Click on shopping cart link.
//4.verify remove check box is selected or not and capture the complete information using getRect().
//  5.Verify Alert message is displayed or not before and after clicking on Apply coupon button
//6.Take screenshot of image(Laptop).
public class Assesment_2_Task_3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://demowebshop.tricentis.com/");
        WebElement addToCart= driver.findElement(By.xpath("//a[text()='14.1-inch Laptop']/../..//input[@value='Add to cart']"));
        System.out.println(addToCart.getSize()); //Capture the Add to cart size
        addToCart.click();

        driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
        WebElement removeCheckBox= driver.findElement(By.xpath("//input[@type='checkbox' and @name='removefromcart']"));
        System.out.println(removeCheckBox.isSelected());
        Rectangle rect=removeCheckBox.getRect();
        System.out.println(rect.getX());
        System.out.println(rect.getY());
        System.out.println(rect.getWidth());
        System.out.println(rect.getHeight());
        //Before clicking apply coupon
        System.out.println("Before Applying coupon");
        if(driver.findElements(By.className("message")).size()>0) {
            WebElement message=driver.findElement(By.className("message"));
            System.out.println(message.isDisplayed());
        }
        else {
            System.out.println("Alert msg is not displayed");
        }

        WebElement coupon=driver.findElement(By.name("applydiscountcouponcode"));
        coupon.click();
        Thread.sleep(2000);

        System.out.println("After Applying coupon");
        if(driver.findElements(By.className("message")).size()>0) {
            WebElement message=driver.findElement(By.className("message"));
            System.out.println(message.isDisplayed());
            System.out.println(message.getText());
        }
        else {
            System.out.println("Alert msg is not displayed");
        }

        driver.get("https://demowebshop.tricentis.com/");
        Thread.sleep(2000);
        TakesScreenshot tks=(TakesScreenshot) driver;
        File src=tks.getScreenshotAs(OutputType.FILE);
        File dest=new File("./Screenshots/window.png");
        FileHandler.copy(src, dest);



    }
}
