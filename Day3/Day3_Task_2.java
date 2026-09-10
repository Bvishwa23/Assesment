package webdrivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day3_Task_2 {
    public static void main(String[] args) {
       WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
		driver.findElement(By.cssSelector("[type='text']")).click(); //click on calender
		driver.findElement(By.cssSelector("[aria-label='Next Month']")).click(); //For selecting next month
		driver.findElement(By.cssSelector("[aria-label='Choose Tuesday, October 6th, 2026']")).click(); //For selecting date
		WebElement result=  driver.findElement(By.cssSelector("[type='text']"));  
		result.getDomAttribute("value");
		if(result.getDomAttribute("value").contains("06/10/2026")) {
			System.out.println("Date is displayed Correctly");
			
		}else {
			System.out.println("Date is not displayed Correctly");
		}


    }
}
