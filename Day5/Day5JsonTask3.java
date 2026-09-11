package assessments;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Day5JsonTask3 {
	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		FileReader fir = new FileReader("./src/test/resources/DDT/data.json");
		JSONParser jsonparser = new JSONParser();
		Object obj = jsonparser.parse(fir);
		JSONObject j =(JSONObject)obj;
		
		String browser = j.get("browser").toString();
		String url = j.get("url").toString();
		String username = j.get("User Name").toString();
		String fullname = j.get("Full Name").toString();
		String email = j.get("Email").toString();
		String password = j.get("password").toString();
		
		//Autmation
		WebDriver driver = null;
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);	
		driver.findElement(By.id("fullname")).sendKeys(fullname);	
		driver.findElement(By.id("email")).sendKeys(email);	
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
	}

}
