package org.tms.tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.pages.PrintWorkoutsPage;
import org.tms.services.LoginPageService;
import org.tms.utils.Retry;

public class PrintWorkoutsTest extends BaseTest{

    private CalendarPage calendarPage;

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }

    @Test(retryAnalyzer = Retry.class, enabled = false)
    @TmsLink("FS-7")
    @Description ("Test #6 -> Functionality: To Create And To Print List Of Workouts")
    public void printWorkoutsTest() {
        calendarPage.clickPrintWorkoutsButton();
        PrintWorkoutsPage printWorkoutsPage = new PrintWorkoutsPage();
        printWorkoutsPage.switchToFrame();
        printWorkoutsPage.inputStartingDate();
        printWorkoutsPage.inputEndingDate();
        printWorkoutsPage.clickPrintWorkoutsButton();
        printWorkoutsPage.switchToTab();
        boolean expectedResult = true;
        Assert.assertEquals(printWorkoutsPage.printLinkIsDisplayed(),expectedResult,
               "The actual text of the page does not match expected");
    }
}
