package webdrivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Assesment_2_Task_1 {

    public static void main(String[] args) {

        WebDriver  d= new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        d.get("https://www.facebook.com/");
        d.findElement(By.xpath("//span[text()='Create new account']")).click();

        WebElement Fname = d.findElement(By.id("R_1cl2p4jikacppb6amH1"));
        WebElement Surname = d.findElement(By.id("R_1kl2p4jikacppb6amH1"));
        int fLoc=Fname.getLocation().getY();
        int surnameLoc=Surname.getLocation().getY();
        if(fLoc==surnameLoc)
            System.out.println("Both are aligned in same line");
        else
            System.out.println("Not aligned in same line");

    }
}