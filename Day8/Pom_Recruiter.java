package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom_Recruiter {

    WebDriver driver;

    public Pom_Recruiter(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Recruitment']")
    private WebElement recruitment;

    @FindBy(xpath = "//button[contains(.,'Add')]")
    private WebElement addbutton;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement fname;

    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement mname;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lname;

    @FindBy(xpath = "(//input[@placeholder='Type here'])[1]")
    private WebElement email;

    @FindBy(xpath = "(//input[@placeholder='Type here'])[2]")
    private WebElement phno;

    @FindBy(xpath = "//div[contains(@class,'oxd-select-text-input')]")
    private WebElement vacancy;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement resume;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement save;

    public void getRecruitmrnt() {
        recruitment.click();
    }

    public void getAddbutton() {
        addbutton.click();
    }

    public void getFname(String value) {
        fname.sendKeys(value);
    }

    public void getMname(String value) {
        mname.sendKeys(value);
    }

    public void getLname(String value) {
        lname.sendKeys(value);
    }

    public void getEmail(String value) {
        email.sendKeys(value);
    }

    public void getPhno(String value) {
        phno.sendKeys(value);
    }

    public WebElement getVacancy() {
        return vacancy;
    }

    public void getResume(String value) {
        resume.sendKeys(value);
    }

    public void getSave() {
        save.click();
    }
}