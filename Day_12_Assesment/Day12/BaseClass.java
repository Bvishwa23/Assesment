package Day12;

import Day12.pom.LoginPage;
import Day12.pom.MyInfoPage;
import Day12.pom.RecruitmentPage;
import Day12.pom.VacancyPage;
import Day12.utilities.PropertyUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public class BaseClass {
    WebDriver driver;
    LoginPage loginPage;
    RecruitmentPage recruitmentPage;
    VacancyPage vacancyPage;
    MyInfoPage myInfoPage;

    @BeforeClass
    public void beforeClass() throws IOException {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(PropertyUtility.getData("url"));
        System.out.println("Test Execution Started");
        System.out.println("Browser Launched");

    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {

        loginPage=new LoginPage(driver);
        recruitmentPage=new RecruitmentPage(driver);
        vacancyPage=new VacancyPage(driver);
        myInfoPage=new MyInfoPage(driver);

        loginPage.getUserName(PropertyUtility.getData("username"));
        loginPage.getPwd(PropertyUtility.getData("password"));
        loginPage.getLoginBtn();

        System.out.println("Login Successful");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        loginPage.getLogOut();
        Thread.sleep(1000);
        System.out.println("Logout Successfully");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        System.out.println("Browser Closed");
        System.out.println("Test Execution Completed");
    }
}