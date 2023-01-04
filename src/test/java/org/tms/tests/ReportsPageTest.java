package org.tms.tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.services.LoginPageService;
import org.tms.services.ReportsPageService;

public class ReportsPageTest extends BaseTest {

    private CalendarPage calendarPage;
    private static final String START_DATE = "12/01/2022";
    private static final String END_DATE = "12/31/2022";

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }

    @Test (enabled = true)
    @TmsLink("FS-9")
    @Description("Test #8 -> Functionality: Login to account")
    public void createWorkoutReportTest(){
        ReportsPageService reportsPageService = new ReportsPageService();
        String actualText = reportsPageService.createReport(START_DATE,END_DATE).tableOfWorkoutsIsDisplayed();
        String expectedText = "DECEMBER 2022";
        Assert.assertEquals(actualText,expectedText,
                "The actual text of the page does not match expected");
    }

}
