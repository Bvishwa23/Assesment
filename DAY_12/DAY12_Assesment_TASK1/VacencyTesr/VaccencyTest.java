package DAY11_Assesment.VacencyTesr;
import DAY11_Assesment.POM.LOGIN;
import DAY11.POM.Requrment;
import DAY11_Assesment.POM.Vacency_page;
import DAY11_Assesment.UTILITY.ExcelUtility;
import DAY11_Assesment.UTILITY.ReadConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class VaccencyTest {

    WebDriver driver;

    LOGIN login;

    Requrment recruitment;

    Vacency_page vacancy;


    @BeforeClass
    public void setUp() throws IOException {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get(
                ReadConfig.getData("url")
        );


        login = new LOGIN(driver);

        recruitment = new Requrment(driver);

        vacancy = new Vacency_page(driver);


        System.out.println("Browser Launched");
    }



    @Test
    public void vacancyTest()
            throws IOException, InterruptedException {


        // =========================
        // LOGIN
        // =========================

        login.setUsername(
                ReadConfig.getData("username")
        );

        login.setPass(
                ReadConfig.getData("password")
        );

        login.setLoginbtn();

        System.out.println(
                "Login Successful"
        );

        Thread.sleep(2000);



        // =========================
        // RECRUITMENT
        // =========================

        recruitment.setRequre();

        Thread.sleep(2000);

        recruitment.clickVacancies();

        Thread.sleep(2000);

        recruitment.clickAdd();

        Thread.sleep(2000);



        // =========================
        // VACANCY DETAILS
        // =========================

        // Vacancy Name

        vacancy.setVacancyName(
                ExcelUtility.getData(1, 0)
        );


        // Job Title

        vacancy.setJobTitle(
                ExcelUtility.getData(1, 1)
        );


        // Description

        vacancy.setDescription(
                ExcelUtility.getData(1, 2)
        );


        // Hiring Manager

        vacancy.setHiringManager(
                ExcelUtility.getData(1, 3)
        );


        // Number Of Positions

        vacancy.setNumberOfPositions(
                ExcelUtility.getData(1, 4)
        );


        Thread.sleep(2000);



        // =========================
        // SAVE
        // =========================

        vacancy.clickSave();

        Thread.sleep(2000);

        System.out.println(
                "Vacancy is Added Successfully"
        );
    }



    @AfterClass
    public void tearDown() {

        if (driver != null) {

            driver.quit();
        }

        System.out.println(
                "Browser Closed"
        );
    }
}