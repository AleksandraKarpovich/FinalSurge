package org.tms.tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.services.AddWorkoutService;
import org.tms.services.LoginPageService;

public class AddWorkoutTest extends BaseTest {

    private CalendarPage calendarPage;
    private static final String TIME_OF_DAY = "06:45 AM";
    private static final String WORKOUT_NAME = "Daily Running";
    private static final String DESCRIPTION = "Daily Long Run Workout at 6:45 AM -- 5 mi";
    private static final String DISTANCE = "5";
    private static final String DURATION = "00:45:00";
    private static final String KCAL = "252";

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }
    @Test (enabled = true)
    @TmsLink("FS-1")
    @Description ("Test #3 -> Functionality: To Add Run-type Workout")
    public void addWorkout(){
        AddWorkoutService addWorkoutService = new AddWorkoutService();
        String actualName = addWorkoutService.addWorkout(TIME_OF_DAY,
                WORKOUT_NAME,DESCRIPTION,DISTANCE,DURATION,KCAL).nameOfAddedWorkout();
        String expectedNameOfWorkout = "Daily Running";
        Assert.assertEquals(actualName,expectedNameOfWorkout,
                "The actual text of the page does not match expected");
    }
}
