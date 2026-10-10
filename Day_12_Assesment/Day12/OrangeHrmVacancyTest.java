package Day12;
import Day12.utilities.ExcelUtility;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrangeHrmVacancyTest extends BaseClass {

    @Test(priority=1)
    public void vacancyCreationTest() throws IOException, InterruptedException {
        recruitmentPage.getRecruitment();
        Thread.sleep(2000);
        recruitmentPage.getVacancy();
        recruitmentPage.getAdd();
        Thread.sleep(2000);

        vacancyPage.getVacName(ExcelUtility.getData(1,0));
        vacancyPage.getJobTitle();
        vacancyPage.selectJobTitle();
        vacancyPage.getDesc(ExcelUtility.getData(1,2));
        vacancyPage.getHiringMgr(ExcelUtility.getData(1,3));
        vacancyPage.selectHiringManager();
        vacancyPage.getNoOfPos(ExcelUtility.getData(1,4));

        Thread.sleep(2000);
        vacancyPage.getSave();
        Thread.sleep(2000);

        System.out.println("Vacancy is Added");
    }

    @Test(priority=2)
    public void myInfoTest() throws IOException, InterruptedException {
        myInfoPage.getMyInfo();
        Thread.sleep(2000);

        String firstName=ExcelUtility.getMyInfoData(1,0);
        String lastName=ExcelUtility.getMyInfoData(1,1);
        String employeeId=ExcelUtility.getMyInfoData(1,2);

        myInfoPage.getFirstName(firstName);
        myInfoPage.getLastName(lastName);
        myInfoPage.getEmpId(employeeId);
        myInfoPage.getSave();

        Thread.sleep(2000);

        loginPage.getLogOut();
        Thread.sleep(2000);

        loginPage.getUserName("Admin");
        loginPage.getPwd("admin123");
        loginPage.getLoginBtn();
        Thread.sleep(2000);

        System.out.println("Login again Successful");

        myInfoPage.getMyInfo();
        Thread.sleep(2000);

        if(myInfoPage.verifyFirstName().equals(firstName))
            System.out.println("First Name is updated");
        else
            System.out.println("First Name is NOT updated");

        if(myInfoPage.verifyLastName().equals(lastName))
            System.out.println("Last Name is updated");
        else
            System.out.println("Last Name is NOT updated");

        if(myInfoPage.verifyEmployeeId().equals(employeeId))
            System.out.println("Employee ID is updated");
        else
            System.out.println("Employee ID is NOT updated");
    }
}