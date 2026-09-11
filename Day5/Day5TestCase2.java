//Testcase 2 
//1.Navigate to orange Hrm application
//2.Enter the username password and click on login buuton
//by redaing the data from excel file.

package assessments;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Day5TestCase2 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("./src/test/resources/DDT/selnmpra.xlsx");
		Workbook wb =  WorkbookFactory.create(fis);
		
		String browser = wb.getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
		System.out.println(browser);
		String url = wb.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
		System.out.println(url);
		String username = wb.getSheet("Sheet1").getRow(2).getCell(2).getStringCellValue();
		System.out.println(username);
		String password = wb.getSheet("Sheet1").getRow(2).getCell(3).getStringCellValue();
		System.out.println(password);
		
		WebDriver driver=null;
		if(browser.equals("chrome"))
			driver=new ChromeDriver();
		if(browser.equals("Edge"))
			driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.cssSelector("[name='username']")).sendKeys(username);	
		driver.findElement(By.cssSelector("[name='password']")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[type='submit']")).click();
		
	}

}
