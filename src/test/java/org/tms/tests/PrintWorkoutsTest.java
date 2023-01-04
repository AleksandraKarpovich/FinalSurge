package org.tms.tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.services.LoginPageService;
import org.tms.services.PrintWorkoutsService;
import org.tms.utils.Retry;

public class PrintWorkoutsTest extends BaseTest{

    private CalendarPage calendarPage;
    private static final String STARTING_DATE = "12/01/2022";
    private static final String ENDING_DATE = "12/31/2022";

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }

    @Test(retryAnalyzer = Retry.class, enabled = true)
    @TmsLink("FS-7")
    @Description ("Test #6 -> Functionality: To Create And To Print List Of Workouts")
    public void printWorkoutsTest() {
        PrintWorkoutsService printWorkoutsService = new PrintWorkoutsService();
        boolean actualResult = printWorkoutsService.printWorkouts(STARTING_DATE,ENDING_DATE).printLinkIsDisplayed();
        boolean expectedResult = true;
        Assert.assertEquals(actualResult,expectedResult,
               "The actual text of the page does not match expected");
    }
}
