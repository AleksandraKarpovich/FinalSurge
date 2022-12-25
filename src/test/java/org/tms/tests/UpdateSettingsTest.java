package org.tms.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.pages.SettingsPage;
import org.tms.services.LoginPageService;

public class UpdateSettingsTest extends BaseTest{
    public CalendarPage calendarPage;
    public SettingsPage settingsPage;

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }
    @Test
    public void updateWeight(){
        calendarPage.clickSettingsButton();
        settingsPage = new SettingsPage();
        settingsPage.updateWeight();
        String expectedResult = "Weight: 55.00 kg";
        Assert.assertEquals(settingsPage.weightIsDisplayed(),expectedResult,
                "The actual text of the page does not match expected");
    }
}
