package assessments;
//Test- case  1 
//1.Navigate to DemoWebshop application 
//2.Click on login link .
//3.Enter email and password and click on login button by reading the data from property file.package assessments;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day5TestTase1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/DDT/common_data.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url=p.getProperty("url");
		String username =p.getProperty("username");
		String password = p.getProperty("password");
		
		
		//Automation Testing
		
		WebDriver driver = null;
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		if(browser.equals("firefox")) {
			driver = new FirefoxDriver();	
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.id("Email")).sendKeys("mallikarjun@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("mallu@123");
		driver.findElement(By.cssSelector("[value='Log in']")).click();
	}

}
