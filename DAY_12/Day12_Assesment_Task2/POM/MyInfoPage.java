package Day11_Assesment_Task2.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyInfoPage {

    WebDriver driver;

    // My Info
    private By myInfo =
            By.xpath("//span[text()='My Info']");

    // First Name
    private By firstName =
            By.cssSelector("input.orangehrm-firstname");

    // Last Name
    private By lastName =
            By.cssSelector("input.orangehrm-lastname");

    // Employee ID
    private By employeeId =
            By.xpath("//label[text()='Employee Id']/following::input[1]");

    // Save button
    private By saveButton =
            By.xpath("//h6[text()='Personal Details']" +
                    "/ancestor::div[contains(@class,'orangehrm-card-container')]" +
                    "//button[contains(.,'Save')]");


    // Constructor
    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
    }


    // Click My Info
    public void clickMyInfo() throws InterruptedException {

        driver.findElement(myInfo).click();

        Thread.sleep(2000);
    }


    // Change First Name
    public void changeFirstName(String value)
            throws InterruptedException {

        Thread.sleep(2000);

        WebElement element =
                driver.findElement(firstName);

        element.click();

        element.sendKeys(Keys.CONTROL, "a");

        element.sendKeys(value);
    }


    // Change Last Name
    public void changeLastName(String value)
            throws InterruptedException {

        Thread.sleep(1000);

        WebElement element =
                driver.findElement(lastName);

        element.click();

        element.sendKeys(Keys.CONTROL, "a");

        element.sendKeys(value);
    }


    // Change Employee ID
    public void changeEmployeeId(String value)
            throws InterruptedException {

        Thread.sleep(1000);

        WebElement element =
                driver.findElement(employeeId);

        element.click();

        element.sendKeys(Keys.CONTROL, "a");

        element.sendKeys(value);
    }


    // Click Save
    public void clickSave()
            throws InterruptedException {

        Thread.sleep(1000);

        driver.findElement(saveButton).click();

        Thread.sleep(2000);
    }


    // Get First Name
    public String getFirstName() {

        return driver.findElement(firstName)
                .getAttribute("value");
    }


    // Get Last Name
    public String getLastName() {

        return driver.findElement(lastName)
                .getAttribute("value");
    }


    // Get Employee ID
    public String getEmployeeId() {

        return driver.findElement(employeeId)
                .getAttribute("value");
    }
}