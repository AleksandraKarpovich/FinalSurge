package org.tms.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.pages.WorkoutCalculatorsPage;
import org.tms.services.LoginPageService;

public class WorkoutCalculatorsTest extends BaseTest{
    public CalendarPage calendarPage;
    public WorkoutCalculatorsPage workoutCalculatorsPage;

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }

    @Test (enabled = true)
    @Description("Test #10 -> Functionality: Pace Calculation")
    public void createWorkoutReportTest(){
        calendarPage.clickWorkoutsCalculatorButton();
        workoutCalculatorsPage = new WorkoutCalculatorsPage();
        workoutCalculatorsPage.waitFrame();
        workoutCalculatorsPage.switchToFrame();
        workoutCalculatorsPage.openTab();
        workoutCalculatorsPage.fillDistance();
        workoutCalculatorsPage.fillTime();
        workoutCalculatorsPage.executionCalculations();
        workoutCalculatorsPage.waitPaceChart();

        boolean expectedResult = true;
        Assert.assertEquals(workoutCalculatorsPage.isDisplayed(),expectedResult,
                "The actual text of the page does not match expected");
    }
}
