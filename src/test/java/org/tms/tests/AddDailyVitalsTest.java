package org.tms.tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.AddDailyVitalsPage;
import org.tms.pages.CalendarPage;
import org.tms.services.AddDailyVitalsService;
import org.tms.services.LoginPageService;

public class AddDailyVitalsTest extends BaseTest{
    private CalendarPage calendarPage;

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }
    @Test (enabled = false)
    @TmsLink("FS-4")
    @Description ("Test #1 -> Functionality: Add New Vitals")
    public void addDailyVitals() {
        AddDailyVitalsService addDailyVitalsService = new AddDailyVitalsService();
        String actualText = addDailyVitalsService.addDailyVitals().checkRow();
        String expectedText = addDailyVitalsService.currentDate() + " 21500 165 lbs 252 kCal";
        Assert.assertEquals(actualText,expectedText,
                "The actual text of the page does not match expected");
    }
}
