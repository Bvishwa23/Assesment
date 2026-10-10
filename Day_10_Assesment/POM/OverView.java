package Day_10_Assesment.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverView {

    WebDriver driver;

    public OverView(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Checkout: Overview']")
    private WebElement overview;

    @FindBy(id = "finish")
    private WebElement finish_btn;

    public boolean overviewDisplay() {
        return overview.isDisplayed();
    }

    public void finish() {
        finish_btn.click();
    }
}