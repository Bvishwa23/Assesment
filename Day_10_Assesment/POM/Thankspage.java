package Day_10_Assesment.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Thankspage {

    WebDriver driver;

    public Thankspage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "complete-header")
    private WebElement thankspage;

    public boolean Thanks() {
        return thankspage.isDisplayed();
    }

    public String getThankMessage() {
        return thankspage.getText();
    }
}