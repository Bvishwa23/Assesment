package DAY11.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Requrment {

    WebDriver driver;

    public Requrment(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[text()='Recruitment']")
    private WebElement Requre;


    @FindBy(xpath = "//a[text()='Vacancies']")
    private WebElement vacancies;


    @FindBy(xpath = "//button[contains(.,'Add')]")
    private WebElement addButton;


    public void setRequre() {

        Requre.click();
    }


    public void clickVacancies() {

        vacancies.click();
    }


    public void clickAdd() {

        addButton.click();
    }
}