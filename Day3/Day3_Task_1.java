package webdrivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
//Test Case 1

//1.Navigate EaseMyTrip and handle the notification popup.
//2.Select One Way.
//3.Enter any state  in the From field and select a valid suggestion.
//4.Enter another state  in the To field and select a valid suggestion.
//  5.Click the Departure Date field.
//6.Select any available future date from the calendar.
// 7.Click Traveller & Class.
//8.Select 2 Adults and keep the class as Economy.
// 9.Click Search.
// 10.Verify that the flight-results page is displayed.


public class Day3_Task_1 {
    public static void main(String[] args) throws InterruptedException, AWTException {ChromeOptions option=new ChromeOptions();
        option.addArguments("--disable-notifications");
        WebDriver driver=new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.easemytrip.com/");

        driver.findElement(By.id("oway")).click();
        WebElement state=driver.findElement(By.id("FromSector_show"));
        state.click();
        driver.findElement(By.id("spn2")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("ptt"));
        driver.findElement(By.id("a_Editbox13_show")).sendKeys("kolkata");
        driver.findElement(By.id("spnKolkata")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("ddate"));
        driver.findElement(By.id("trd_6_19/09/2026")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("spnTraveller")).click();
        driver.findElement(By.id("add")).click();
        driver.findElement(By.cssSelector("[value='Search']")).click();
        String result= driver.getTitle();
        if(result.contains("EaseMyTrip.com Lowest Airfare, Flight Tickets, Cheap Air Tickets – EaseMyTrip.com")) {
            System.out.println("flight result is displayed");
        }
        else
        {
            System.out.println("flight result is not displayed");
        }



    }
}
