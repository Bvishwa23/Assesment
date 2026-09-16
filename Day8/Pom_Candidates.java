package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom_Candidates {

    WebDriver driver;

    public Pom_Candidates(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Candidates']")
    private WebElement candidate;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text-input')])[1]")
    private WebElement jobdrop;

    @FindBy(xpath = "//div[contains(@class,'oxd-select-dropdown')]//span[text()='Payroll Administrator']")
    private WebElement jobT;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text-input')])[2]")
    private WebElement cvacancydrop;

    @FindBy(xpath = "//div[contains(@class,'oxd-select-dropdown')]//span[text()='Payroll Administrator']")
    private WebElement cvacancy;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text-input')])[3]")
    private WebElement HMDrop;

    @FindBy(xpath = "//div[contains(@class,'oxd-select-dropdown')]//span[text()='manda user']")
    private WebElement hM;

    @FindBy(xpath = "(//div[contains(@class,'oxd-select-text-input')])[4]")
    private WebElement statusdrop;

    @FindBy(xpath = "//div[contains(@class,'oxd-select-dropdown')]//span[text()='Application Initiated']")
    private WebElement status;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement cname;

    @FindBy(xpath = "//input[@placeholder='From']")
    private WebElement caldrop;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement search;

    @FindBy(xpath = "//div[contains(@class,'oxd-table-body')]//div[text()='Sugali Rahul Naik']")
    private WebElement applicant;

    @FindBy(xpath = "//i[contains(@class,'oxd-userdropdown-icon')]")
    private WebElement logdrop;

    @FindBy(xpath = "//a[contains(@class,'oxd-userdropdown-link') and text()='Logout']")
    private WebElement logout;

    public void getCandidate() {
        candidate.click();
    }

    public void getJobDrop() {
        jobdrop.click();
    }

    public void getJobT() {
        jobT.click();
    }

    public void getCvacancyDrop() {
        cvacancydrop.click();
    }

    public void getCvacancy() {
        cvacancy.click();
    }

    public void getHMDrop() {
        HMDrop.click();
    }

    public void gethM() {
        hM.click();
    }

    public void getStatusDrop() {
        statusdrop.click();
    }

    public void getStatus() {
        status.click();
    }

    public void getCName(String value) {
        cname.sendKeys(value);
    }

    public void getdate() {
        caldrop.clear();
        caldrop.sendKeys("2026-09-09");
    }

    public void getSearch() throws InterruptedException {
        search.click();
        Thread.sleep(3000);
    }

    public boolean verifyApplicant() {
        try {
            if (applicant.isDisplayed()) {
                System.out.println("Candidate is added successfully 🥳❤️");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Candidate is not added ❌");
        }

        return false;
    }

    public void logout() {
        logdrop.click();
        logout.click();
    }
}