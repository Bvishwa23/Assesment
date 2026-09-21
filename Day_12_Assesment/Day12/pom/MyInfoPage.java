package Day12.pom;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {
    WebDriver driver;

    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[text()='My Info']")
    public WebElement myInfo;
    @FindBy(name = "firstName")
    public WebElement firstName;
    @FindBy(name = "lastName")
    public WebElement lastName;
    // Employee ID
    @FindBy(xpath = "//label[text()='Employee Id']/../following-sibling::div//input")
    public WebElement employeeId;
    @FindBy(xpath = "(//button[text()=' Save '])[1]")
    public WebElement save;

    public void getMyInfo(){
        myInfo.click();
    }
    public void getFirstName(String value){
        firstName.click();
        firstName.sendKeys(Keys.CONTROL,"a");
        firstName.sendKeys(Keys.BACK_SPACE);
        firstName.sendKeys(value);
    }
    public void getLastName(String value){
        lastName.click();
        lastName.sendKeys(Keys.CONTROL,"a");
        lastName.sendKeys(Keys.BACK_SPACE);
        lastName.sendKeys(value);
    }
    public void getEmpId(String value){
        employeeId.click();
        employeeId.sendKeys(Keys.CONTROL,"a");
        employeeId.sendKeys(Keys.BACK_SPACE);
        employeeId.sendKeys(value);
    }
    public void getSave() throws InterruptedException {
        Thread.sleep(2000);
        save.click();
    }

    // Get First Name for verification
    public String verifyFirstName() {
        return firstName.getAttribute("value");
    }

    // Get Last Name for verification
    public String verifyLastName() {
        return lastName.getAttribute("value");
    }

    // Get Employee ID for verification
    public String verifyEmployeeId() {
        return employeeId.getAttribute("value");
    }

}



