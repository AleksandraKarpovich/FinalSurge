package org.tms.tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.pages.ReportsPage;
import org.tms.services.LoginPageService;

public class ReportsPageTest extends BaseTest {

    private CalendarPage calendarPage;

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }

    @Test (enabled = false)
    @TmsLink("FS-9")
    @Description("Test #8 -> Functionality: Login to account")
    public void createWorkoutReportTest(){
        calendarPage.clickReportPageButton();
        ReportsPage reportsPage = new ReportsPage();
        reportsPage.inputStartDate();
        reportsPage.inputEndDate();
        reportsPage.chooseReportView();
        reportsPage.clickViewReportButton();
        String expectedText = "DECEMBER 2022";
        Assert.assertEquals(reportsPage.tableOfWorkoutsIsDisplayed(),expectedText,
                "The actual text of the page does not match expected");
    }

}
