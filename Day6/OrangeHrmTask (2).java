package Assessments.Day6.java;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.poi.ss.usermodel.DataFormatter;
public class OrangeHrmTask {
    public static void main(String[] args) throws IOException, InterruptedException {
//        Login to orangeHrm application -> Click on PIM link -> click on +Add button ->enter firstname , middlename, lastname , employeeId ->
//                click on Create Login Details toggle button -> enter username , password and confirm password -> click on save button->
//                click on Admin link -> enter username , select role ,enter employee name and select status -> click on search button
//                ->verify whether the emplyoee is added from the records found section and logout.
//        Note: store the common data in property file and testscript data in excel file.

        FileInputStream fis = new FileInputStream("src/test/java/Assessments/Day6/resources/common_data.properties");
        //step 2
        Properties p = new Properties();
        p.load(fis);
        FileInputStream excel = new FileInputStream("src/test/java/Assessments/Day6/resources/Book1.xlsx");
        Workbook wb = WorkbookFactory.create(excel);

        DataFormatter df = new DataFormatter();

        String firstName = df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(0));
        String middleName = df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(1));
        String lastName = df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(2));
        String employeeId = df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(3));
        String newUsername = df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(4));
        String newPassword = df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(5));
        String confirmPassword = df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(6));
        String role = df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(7));
        String employeeName = df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(8));
        String status = df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(9));

        String Browser = p.getProperty("browser");
        String URL = p.getProperty("url");
        String username = p.getProperty("username");
        String password = p.getProperty("password");
        WebDriver driver = null;

        if (Browser.equals("chrome")) {
            ChromeOptions option = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.password_manager_leak_detection", false);
            option.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(option);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open OrangeHRM
        driver.get(URL);

        // Login
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[type='submit']")).click();

        //pim section
        driver.findElement(By.cssSelector("[href='/web/index.php/pim/viewPimModule']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();

        driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("middleName")).sendKeys(middleName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);

        WebElement empId = driver.findElement(By.xpath("//label[text()='Employee Id']/following::input[1]"));
        empId.click();
        empId.sendKeys(Keys.CONTROL, "a");
        empId.sendKeys(Keys.BACK_SPACE);
        empId.sendKeys(employeeId);

        driver.findElement(By.cssSelector("span.oxd-switch-input")).click();
        driver.findElement(By.xpath("//label[text()='Username']/../following-sibling::div//input"))
                .sendKeys(newUsername);

        WebElement passwordField = driver.findElement(By.xpath("//label[text()='Password']/../following-sibling::div//input"));
        WebElement confirmPasswordField = driver.findElement(By.xpath("//label[text()='Confirm Password']/../following-sibling::div//input"));
        passwordField.clear();
        confirmPasswordField.clear();

        passwordField.sendKeys(newPassword);
        confirmPasswordField.sendKeys(confirmPassword);

        driver.findElement(By.cssSelector("[type='submit']")).click();
        Thread.sleep(3000);

        //admin section
        driver.findElement(By.cssSelector("[href='/web/index.php/admin/viewAdminModule']")).click();
        driver.findElement(By.xpath("//label[text()='Username']/following::input[1]")).sendKeys(newUsername);
        driver.findElement(By.xpath("//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")).click();
        driver.findElement(By.xpath("//div[@role='option']//span[text()='" + role + "']")).click();

        WebElement empName = driver.findElement(By.xpath("//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input"));
        empName.sendKeys(employeeName);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@role='option']//span[contains(text(),'Appu N Nayak')]")).click();
        driver.findElement(By.xpath("//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]")).click();
        driver.findElement(By.xpath("//div[@role='option']//span[text()='" + status + "']")).click();
        driver.findElement(By.cssSelector("[type='submit']")).click();
        Thread.sleep(2000);

        //verify
        WebElement employeeRecord = driver.findElement(
                By.xpath("//div[@role='row']//div[text()='" + newUsername + "']")
        );

        if (employeeRecord.isDisplayed()) {
            System.out.println("Employee is successfully added and displayed in Records Found");
        } else {
            System.out.println("Employee is NOT displayed in Records Found");
        }

        //logout
        driver.findElement(By.className("oxd-userdropdown-name")).click();

        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        driver.quit();

    }
}
