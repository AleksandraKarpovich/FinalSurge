package org.tms.tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
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

    @Test (enabled = false)
    @TmsLink("FS-10")
    @Description("Test #9 -> Functionality: Update Weight of User on Settings Page")
    public void updateWeight(){
        calendarPage.clickSettingsButton();
        settingsPage = new SettingsPage();
        settingsPage.editButton();
        settingsPage.updateWeight();
        settingsPage.clickSaveButton();
        String expectedResult = "Weight: 55.00 kg";
        Assert.assertEquals(settingsPage.weightIsDisplayed(),expectedResult,
                "The actual text of the page does not match expected");
    }
}
