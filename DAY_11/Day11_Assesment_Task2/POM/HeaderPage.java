package Day11_Assesment_Task2.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {

    WebDriver driver;


    private By profileMenu =
            By.xpath(
                    "//span[contains(@class,'oxd-userdropdown-tab')]"
            );


    private By logout =
            By.xpath(
                    "//a[text()='Logout']"
            );


    public HeaderPage(WebDriver driver) {

        this.driver = driver;
    }


    public void clickProfileMenu() {

        driver.findElement(profileMenu)
                .click();
    }


    public void clickLogout() {

        driver.findElement(logout)
                .click();
    }


    public void logout() {

        clickProfileMenu();

        clickLogout();
    }
}