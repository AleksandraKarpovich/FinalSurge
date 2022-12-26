package org.tms.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.pages.ReportsPage;
import org.tms.services.LoginPageService;

public class ReportsPageTest extends BaseTest {

    public CalendarPage calendarPage;
    public ReportsPage reportsPage;

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }

    @Test (enabled = false)
    public void createWorkoutReportTest(){
        calendarPage.clickReportPageButton();
        reportsPage = new ReportsPage();
        reportsPage.inputStartDate();
        reportsPage.inputEndDate();
        reportsPage.chooseReportView();
        reportsPage.clickViewReportButton();
        String expectedText = "DECEMBER 2022";
        Assert.assertEquals(reportsPage.tableOfWorkoutsIsDisplayed(),expectedText,
                "The actual text of the page does not match expected");
    }

}
