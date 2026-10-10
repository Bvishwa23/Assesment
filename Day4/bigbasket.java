package practice;



	import java.time.Duration; 

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class bigbasket {
		public static void main(String[] args) throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.bigbasket.com/");
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("yogurt");;
			Thread.sleep(4000);
			WebElement add = driver.findElement(By.xpath("//button[text()='Add']"));
			add.click();
			Thread.sleep(5000);
			WebElement add1 = driver.findElement(By.xpath("(//button[text()='Add'])[5]"));
			add1.click();
			Thread.sleep(2000);
			String text = driver.findElement(By.xpath("//span[@class='sc-fUnMCh cDZjuK']")).getText();
			if(!text.equals(""))
			{
				System.out.println("added to cart");
				System.out.println(text+" products are added to cart");
			}
			else
			{
				System.out.println("not added to cart");
			}
			Thread.sleep(2000);
			driver.quit();
		}
	

}
