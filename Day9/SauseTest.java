package Day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SauseTest {
    WebDriver driver;
    public void lanuchBroswer()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void openUrl()
    {
        driver.get("https://www.saucedemo.com/");
    }
    public void un()
    {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }
    public void pass()
    {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }
    public void login()
    {
        driver.findElement(By.id("login-button")).click();
    }
    public void close()
    {
        driver.quit();
    }
}
