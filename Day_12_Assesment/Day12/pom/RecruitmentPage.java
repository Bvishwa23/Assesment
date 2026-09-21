package Day12.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {
    WebDriver driver;
    public RecruitmentPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()='Recruitment']")
    public WebElement recruitment;
    @FindBy(xpath = "//a[text()='Vacancies']")
    public WebElement vacancy;
    @FindBy(xpath = "//button[contains(.,' Add ')]")
    // Here below is the html code for above add button
    //    <button ...>
    //    <i class="oxd-icon bi-plus oxd-button-icon"></i>
    //    " Add "
    //</button>
    // Here //button[contains(text(),' Add ')] not works bcz <button> whose direct text node contains exactly the characters Add.
// But . ->Look at all the text/content inside the button, including text associated with its child elements.
    public WebElement add;

    public void getRecruitment(){
        recruitment.click();
    }
    public void getVacancy(){
        vacancy.click();
    }
    public void getAdd(){
        add.click();
    }

}