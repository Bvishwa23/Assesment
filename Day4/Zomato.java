package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zomato {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.zomato.com/bangalore/delivery");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	
		
		WebElement frame1 = driver.findElement(By.id("auth-login-ui"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys("9937465345");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		
		String text=driver.findElement(By.xpath("(//div[text()='Dining Out'])")).getText();
		if(text.equals("Dining Out")) {
		System.out.println("Back to Main page");	
		}
		else {
			System.out.println("No");
		}
		
		
		
	}

}
