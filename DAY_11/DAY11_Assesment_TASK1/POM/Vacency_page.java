package DAY11_Assesment.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vacency_page {

    WebDriver driver;


    public Vacency_page(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    // Vacancy Name

    @FindBy(xpath = "//label[text()='Vacancy Name']/../following-sibling::div//input")
    private WebElement vacancyName;


    // Job Title dropdown

    @FindBy(xpath = "//label[text()='Job Title']/../following-sibling::div//div[contains(@class,'oxd-select-text')]")
    private WebElement jobTitle;


    // Description

    @FindBy(xpath = "//label[text()='Description']/../following-sibling::div//textarea")
    private WebElement description;


    // Hiring Manager

    @FindBy(xpath = "//label[text()='Hiring Manager']/../following-sibling::div//input")
    private WebElement hiringManager;


    // Number Of Positions

    @FindBy(xpath = "//label[text()='Number of Positions']/../following-sibling::div//input")
    private WebElement numberOfPositions;


    // Save button

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;



    // Enter Vacancy Name

    public void setVacancyName(String value) {

        vacancyName.sendKeys(value);
    }



    // Select Job Title

    public void setJobTitle(String value) {

        jobTitle.click();

        WebElement option = driver.findElement(
                By.xpath(
                        "//div[@role='option']//span[text()='"
                                + value +
                                "']"
                )
        );

        option.click();
    }



    // Enter Description

    public void setDescription(String value) {

        description.sendKeys(value);
    }



    // Select Hiring Manager

    public void setHiringManager(String value) {

        hiringManager.sendKeys(value);

        WebElement option = driver.findElement(
                By.xpath(
                        "//div[@role='option']//span[contains(text(),'"
                                + value +
                                "')]"
                )
        );

        option.click();
    }



    // Enter Number Of Positions

    public void setNumberOfPositions(String value) {

        numberOfPositions.sendKeys(value);
    }



    // Click Save

    public void clickSave() {

        saveButton.click();
    }
}