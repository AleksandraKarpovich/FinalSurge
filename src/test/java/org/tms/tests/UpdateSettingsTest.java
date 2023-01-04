package org.tms.tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.services.LoginPageService;
import org.tms.services.SettingsService;

public class UpdateSettingsTest extends BaseTest{
    private CalendarPage calendarPage;
    private static final String WEIGHT = "55";

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }

    @Test (enabled = true)
    @TmsLink("FS-10")
    @Description("Test #9 -> Functionality: Update Weight of User on Settings Page")
    public void updateWeight(){
        SettingsService settingsService = new SettingsService();
        String actualResult = settingsService.updateWeight(WEIGHT).weightIsDisplayed();
        String expectedResult = "Weight: 55.00 kg";
        Assert.assertEquals(actualResult,expectedResult,
                "The actual text of the page does not match expected");
    }
}
