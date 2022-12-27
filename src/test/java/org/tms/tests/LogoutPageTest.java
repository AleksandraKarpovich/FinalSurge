package org.tms.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.pages.LogoutPage;
import org.tms.services.LoginPageService;

public class LogoutPageTest extends BaseTest {
    public CalendarPage calendarPage;
    public LogoutPage logoutPage;

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }
    @Test (enabled = false)
    @Description("Test #5 -> Functionality: Logout from account")
    public void logoutTest(){
        calendarPage.clickLogoutButton();
        logoutPage = new LogoutPage();
        String expectedText = "You have been successfully logged out of the system.";
        Assert.assertEquals(logoutPage.getTextOfLogout(),expectedText,
                "The actual text of the page does not match expected");
    }
}
