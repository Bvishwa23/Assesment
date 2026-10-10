package webdrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.time.Duration;

//Testcase 2

//1.Navigate to facebook application
//2.capture the location of create new account button.
// 3.Capture the Dom Attribute and dom property for email address textfield before and after entering email address
//4.click on create new account capture the size of submit button
//5.capture the css properties of submit button (minimum 3).


public class Assesment_2_Task_2{
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/");
        WebElement createAccount=driver.findElement(By.xpath("//span[text()='Create new account']"));
        System.out.println("X="+createAccount.getLocation().getX());
        System.out.println("Y="+createAccount.getLocation().getY());
        createAccount.click();
        WebElement email = driver.findElement(By.id("_R_6ad8p4jikacppb6amH1_"));

        System.out.println("Before entering email");

        System.out.println("Attribute = " + email.getAttribute("value"));
        System.out.println("Property = " + email.getDomProperty("value"));

        email.sendKeys("test@gmail.com");

        System.out.println("After entering email");

        System.out.println("Attribute = " + email.getAttribute("value"));
        System.out.println("Property = " + email.getDomProperty("value"));
        WebElement submit = driver.findElement(By.xpath("//span[text()='Submit']"));
        System.out.println("Submit Button size"+submit.getSize());
        System.out.println("Button Text Family "+submit.getCssValue("color"));
        System.out.println("Button font size "+submit.getCssValue("font-size"));
        System.out.println("Button Background-color "+submit.getCssValue("background-color"));



    }
}