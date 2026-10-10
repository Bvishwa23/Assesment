package Day12.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VacancyPage {
    WebDriver driver;
    public VacancyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Vacancy Name
    @FindBy(xpath = "//label[text()='Vacancy Name']/../following-sibling::div//input")
    public WebElement vacName;

    // Job Title dropdown
    @FindBy(xpath = "//label[text()='Job Title']/../following-sibling::div//div[contains(@class,'oxd-select-text')]")
    public WebElement jobTitle;

    // Job Title option
    @FindBy(xpath = "//div[@role='option']//span[text()='Finance Manager']")
    public WebElement financeManager;

    // Description
    @FindBy(xpath = "//textarea[@placeholder='Type description here']")
    public WebElement desc;

    // Hiring Manager
    @FindBy(xpath = "//label[text()='Hiring Manager']/../following-sibling::div//input[@placeholder='Type for hints...']")
    public WebElement hiringMgr;

    // Hiring Manager option
    @FindBy(xpath = "(//div[@role='option']//span[contains(text(),'Rahul')])[1]")
    public WebElement hiringManagerOption;

    // Number of Positions
    @FindBy(xpath = "//label[text()='Number of Positions']/../following-sibling::div//input")
    public WebElement noOfPos;
    // Save button
    @FindBy(xpath = "//button[normalize-space()='Save']")
    public WebElement save;


    // Getter for Vacancy Name
    public void getVacName(String value) {
        vacName.sendKeys(value);
    }
    // Getter for Job Title dropdown
    public void getJobTitle() {
        jobTitle.click();
    }
    // Select Job Title
    public void selectJobTitle() {
        financeManager.click();
    }
    // Getter for Description
    public void getDesc(String value) {
        desc.sendKeys(value);
    }
    // Getter for Hiring Manager
    public void getHiringMgr(String value) {
        hiringMgr.sendKeys(value);
    }
    // Select Hiring Manager
    public void selectHiringManager() {
        hiringManagerOption.click();
    }
    // Getter for Number of Positions
    public void getNoOfPos(String value) {
        noOfPos.sendKeys(value);
    }
    // Getter for Save
    public void getSave() {
        save.click();
    }
}