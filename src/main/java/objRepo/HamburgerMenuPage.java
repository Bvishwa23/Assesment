package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HamburgerMenuPage {
    WebDriver driver;
    public HamburgerMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // =========================================================
    // HAMBURGER MENU
    // =========================================================

    @FindBy(id = "react-burger-menu-btn")
    public WebElement hamBurger;

    @FindBy(id = "react-burger-cross-btn")
    public WebElement closeMenu;


    // =========================================================
    // MENU OPTIONS
    // =========================================================

    @FindBy(id = "inventory_sidebar_link")
    public WebElement allItems;

    @FindBy(id = "about_sidebar_link")
    public WebElement about;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logout;

    @FindBy(id = "reset_sidebar_link")
    public WebElement resetAppState;


    // =========================================================
    // METHODS
    // =========================================================

    public void openMenu() throws InterruptedException {

        hamBurger.click();
        Thread.sleep(1000);
    }


    public void closeMenu() throws InterruptedException {

        closeMenu.click();
        Thread.sleep(1000);
    }


    public void clickAllItems() throws InterruptedException {

        allItems.click();
        Thread.sleep(1500);
    }


    public void clickAbout() throws InterruptedException {

        about.click();
        Thread.sleep(1500);
    }


    public void clickLogout() throws InterruptedException {

        logout.click();
        Thread.sleep(1500);
    }


    public void clickResetAppState() throws InterruptedException {

        resetAppState.click();
        Thread.sleep(1000);
    }
}