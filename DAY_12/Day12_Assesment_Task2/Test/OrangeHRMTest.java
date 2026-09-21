package Day11_Assesment_Task2.Test;

import Day11_Assesment_Task2.POM.HeaderPage;
import Day11_Assesment_Task2.POM.LOGIN;
import Day11_Assesment_Task2.POM.MyInfoPage;
import Day11_Assesment_Task2.Utility.ExcelUtility;
import Day11_Assesment_Task2.Utility.PropertyUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class OrangeHRMTest {

    @Test
    public void updateEmployeeDetails()
            throws IOException, InterruptedException {

        // Launch browser
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));


        // Read URL
        String url =
                PropertyUtility.getData("url");

        driver.get(url);


        // Create POM objects
        LOGIN login =
                new LOGIN(driver);

        MyInfoPage myInfo =
                new MyInfoPage(driver);

        HeaderPage header =
                new HeaderPage(driver);


        // Read username and password
        String username =
                PropertyUtility.getData("username");

        String password =
                PropertyUtility.getData("password");


        // Read data from Excel
        String firstName =
                ExcelUtility.getData(1, 0);

        String lastName =
                ExcelUtility.getData(1, 1);

        String employeeId =
                ExcelUtility.getData(1, 2);


        System.out.println("First Name from Excel = " + firstName);
        System.out.println("Last Name from Excel = " + lastName);
        System.out.println("Employee ID from Excel = " + employeeId);


        // 1. Login
        login.login(username, password);


        // 2. Click My Info
        myInfo.clickMyInfo();


        // 3. Change First Name
        myInfo.changeFirstName(firstName);


        // 4. Change Last Name
        myInfo.changeLastName(lastName);


        // 5. Change Employee ID
        myInfo.changeEmployeeId(employeeId);


        // 6. Save
        myInfo.clickSave();


        // 7. Logout
        header.logout();


        // 8. Login again
        login.login(username, password);


        // 9. Click My Info again
        myInfo.clickMyInfo();


        // 10. Read updated values
        String actualFirstName =
                myInfo.getFirstName();

        String actualLastName =
                myInfo.getLastName();

        String actualEmployeeId =
                myInfo.getEmployeeId();


        System.out.println(
                "Updated First Name = " + actualFirstName
        );

        System.out.println(
                "Updated Last Name = " + actualLastName
        );

        System.out.println(
                "Updated Employee ID = " + actualEmployeeId
        );


        // 11. Verify
        Assert.assertEquals(
                actualFirstName,
                firstName,
                "First Name is not updated"
        );

        Assert.assertEquals(
                actualLastName,
                lastName,
                "Last Name is not updated"
        );

        Assert.assertEquals(
                actualEmployeeId,
                employeeId,
                "Employee ID is not updated"
        );


        // 12. Final logout
        header.logout();


        // 13. Close browser
        driver.quit();
    }
}