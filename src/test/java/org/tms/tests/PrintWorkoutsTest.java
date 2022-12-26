package org.tms.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.pages.PrintWorkoutsPage;
import org.tms.services.LoginPageService;
import org.tms.utils.Retry;

public class PrintWorkoutsTest extends BaseTest{

    public CalendarPage calendarPage;
    public PrintWorkoutsPage printWorkoutsPage;

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }

    @Test(retryAnalyzer = Retry.class, enabled = false)
    @Step("Print Workout")
    public void printWorkoutsTest() {
        calendarPage.clickPrintWorkoutsButton();
        printWorkoutsPage = new PrintWorkoutsPage();
        printWorkoutsPage.switchToFrame();
        printWorkoutsPage.inputStartingDate();
        printWorkoutsPage.inputEndingDate();
        printWorkoutsPage.clickPrintWorkoutsButton();
        printWorkoutsPage.switchToTab();
        printWorkoutsPage.waitPrintLinkIsLoaded();
        boolean expectedResult = true;
        Assert.assertEquals(printWorkoutsPage.printLinkIsDisplayed(),expectedResult,
               "The actual text of the page does not match expected");
    }
}
