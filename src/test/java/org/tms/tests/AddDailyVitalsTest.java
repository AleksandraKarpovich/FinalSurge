package org.tms.tests;

import io.qameta.allure.Description;
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
    @Test (enabled = false)
    @Description ("Test #1 -> Functionality: Add New Vitals")
    public void addDailyVitals() {
        calendarPage.openDailyVitalsPage();
        addDailyVitalsPage = new AddDailyVitalsPage();
        addDailyVitalsPage.openAddAndViewVitalsPage();
        addDailyVitalsPage.fillDateField();
        addDailyVitalsPage.fillStepsField();
        addDailyVitalsPage.fillCaloriesField();
        addDailyVitalsPage.fillWeightField();
        addDailyVitalsPage.addVitals();
        addDailyVitalsPage.checkRowWithAddedVitals();
        String expectedText = addDailyVitalsPage.currentDate() + " 21500 165 lbs 252 kCal";
        Assert.assertEquals(addDailyVitalsPage.checkRow(),expectedText,
                "The actual text of the page does not match expected");
    }
}
