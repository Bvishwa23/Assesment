package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebookcounttextfield {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		List<WebElement> textfields = driver.findElements(By.tagName("input"));
		System.out.println(textfields.size());
		for(WebElement ele:textfields) 
		{			
			if(ele.getAttribute("id").equals("_R_1hmkqsqppb6amH1_")) {
			ele.sendKeys("Mallu@123");
			break;
			}
		}
					
	}

}
