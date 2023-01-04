package org.tms.tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.pages.WorkoutCalculatorsPage;
import org.tms.services.LoginPageService;

public class WorkoutCalculatorsTest extends BaseTest{
    private CalendarPage calendarPage;

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }

    @Test (enabled = false)
    @TmsLink("FS-11")
    @Description("Test #10 -> Functionality: Pace Calculation")
    public void createWorkoutReportTest(){
        calendarPage.clickWorkoutsCalculatorButton();
        WorkoutCalculatorsPage workoutCalculatorsPage = new WorkoutCalculatorsPage();
        workoutCalculatorsPage.switchToFrame();
        workoutCalculatorsPage.openTab();
        workoutCalculatorsPage.fillDistance();
        workoutCalculatorsPage.fillTime();
        workoutCalculatorsPage.executionCalculations();
        boolean expectedResult = true;
        Assert.assertEquals(workoutCalculatorsPage.isDisplayed(),expectedResult,
                "The actual text of the page does not match expected");
    }
}
