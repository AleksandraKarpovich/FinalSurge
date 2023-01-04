package org.tms.tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.services.LoginPageService;
import org.tms.services.WorkoutCalculatorsService;

public class WorkoutCalculatorsTest extends BaseTest{
    private CalendarPage calendarPage;
    private static final String DISTANCE = "5";
    private static final String TIME_OF_MINUTES = "30";

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }

    @Test (enabled = true)
    @TmsLink("FS-11")
    @Description("Test #10 -> Functionality: Pace Calculation")
    public void createWorkoutReportTest(){
        WorkoutCalculatorsService workoutCalculatorsService = new WorkoutCalculatorsService();
        boolean actualResult = workoutCalculatorsService.workoutCalculation(DISTANCE,TIME_OF_MINUTES).isDisplayed();
        boolean expectedResult = true;
        Assert.assertEquals(actualResult, expectedResult,
                "The actual text of the page does not match expected");
    }
}
