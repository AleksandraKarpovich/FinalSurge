package org.tms.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.AddDailyVitalsPage;
import org.tms.pages.CalendarPage;
import org.tms.services.LoginPageService;

public class AddDailyVitalsTest extends BaseTest{
    public CalendarPage calendarPage;
    public AddDailyVitalsPage addDailyVitalsPage;

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }
    @Test
    public void addWorkout() {
        calendarPage.openDailyVitalsPage();
        addDailyVitalsPage = new AddDailyVitalsPage();
        addDailyVitalsPage.addVitals();
        String expectedText = addDailyVitalsPage.currentDate() + " 21500 150 lbs 500 kCal";
        Assert.assertEquals(addDailyVitalsPage.checkRow(),expectedText,
                "The actual text of the page does not match expected");
    }
}
