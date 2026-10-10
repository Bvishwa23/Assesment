package POM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_1 {

    public static void main(String[] args)
            throws IOException, InterruptedException, AWTException {

        // =========================
        // PROPERTY FILE
        // =========================

        FileInputStream fis = new FileInputStream(
                "C:\\Users\\DELL\\Downloads\\demo\\Day_8\\src\\main\\resources\\commondata.properties");

        Properties p = new Properties();
        p.load(fis);

        String BROWSER = p.getProperty("browser");
        String URL = p.getProperty("url");
        String USERNAME = p.getProperty("username");
        String PASSWORD = p.getProperty("password");

        fis.close();

        // =========================
        // EXCEL FILE
        // =========================

        FileInputStream fis1 = new FileInputStream(
                "src/main/resources/day8.xlsx");

        Workbook wb = WorkbookFactory.create(fis1);

        String FirstName = wb.getSheet("Sheet1")
                .getRow(1)
                .getCell(0)
                .getStringCellValue();

        String MiddleName = wb.getSheet("Sheet1")
                .getRow(1)
                .getCell(1)
                .getStringCellValue();

        String LastName = wb.getSheet("Sheet1")
                .getRow(1)
                .getCell(2)
                .getStringCellValue();

        String Email = wb.getSheet("Sheet1")
                .getRow(1)
                .getCell(3)
                .getStringCellValue();

        String CName = wb.getSheet("Sheet1")
                .getRow(1)
                .getCell(5)
                .getStringCellValue();

        wb.close();
        fis1.close();

        // =========================
        // BROWSER
        // =========================

        WebDriver driver = null;

        if (BROWSER.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();

        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);

        // =========================
        // LOGIN
        // =========================

        PomLogin p1 = new PomLogin(driver);

        p1.getUn(USERNAME);
        p1.getPwd(PASSWORD);
        p1.getLgbutton();

        Thread.sleep(3000);

        // =========================
        // RECRUITMENT
        // =========================

        Pom_Recruiter p2 = new Pom_Recruiter(driver);

        p2.getRecruitmrnt();

        Thread.sleep(2000);

        p2.getAddbutton();

        Thread.sleep(2000);

        // First Name
        p2.getFname(FirstName);

        // Middle Name
        p2.getMname(MiddleName);

        // Last Name
        p2.getLname(LastName);

        // Email
        p2.getEmail(Email);

        // =========================
        // VACANCY
        // =========================

        p2.getVacancy().click();

        Thread.sleep(2000);

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(2000);

        // =========================
        // RESUME
        // =========================

        p2.getResume(
                "C:\\Users\\DELL\\Downloads\\B Vishwanath Resume.pdf");

        Thread.sleep(2000);

        // SAVE CANDIDATE
        p2.getSave();

        Thread.sleep(5000);

        // =========================
        // CANDIDATES
        // =========================

        Pom_Candidates p3 = new Pom_Candidates(driver);

        p3.getCandidate();

        Thread.sleep(3000);

        // =========================
        // JOB TITLE
        // =========================

        p3.getJobDrop();

        Thread.sleep(1000);

        p3.getJobT();

        Thread.sleep(2000);

        // =========================
        // VACANCY
        // =========================

        p3.getCvacancyDrop();

        Thread.sleep(1000);

        p3.getCvacancy();

        Thread.sleep(2000);

        // =========================
        // HIRING MANAGER
        // =========================

        p3.getHMDrop();

        Thread.sleep(1000);

        p3.gethM();

        Thread.sleep(2000);

        // =========================
        // STATUS
        // =========================

        p3.getStatusDrop();

        Thread.sleep(1000);

        p3.getStatus();

        Thread.sleep(2000);

        // =========================
        // CANDIDATE NAME
        // =========================

        p3.getCName(CName);

        Thread.sleep(2000);

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(2000);

        // =========================
        // APPLICATION DATE
        // =========================

        p3.getdate();

        Thread.sleep(1000);

        // =========================
        // SEARCH
        // =========================

        p3.getSearch();

        Thread.sleep(3000);

        // =========================
        // VERIFY
        // =========================

        boolean result = p3.verifyApplicant();

        if (result) {
            System.out.println("TEST CASE PASSED ✅");
            p3.logout();
        } else {
            System.out.println("TEST CASE FAILED ❌");
        }

        Thread.sleep(3000);

        // =========================
        // CLOSE BROWSER
        // =========================

        driver.quit();
    }
}