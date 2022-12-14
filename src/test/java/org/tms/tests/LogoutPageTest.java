package org.tms.tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.services.LoginPageService;
import org.tms.services.LogoutPageService;

public class LogoutPageTest extends BaseTest {
    private CalendarPage calendarPage;

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }
    @Test (enabled = true)
    @TmsLink("FS-6")
    @Description("Test #5 -> Functionality: Logout from account")
    public void logoutTest(){
        LogoutPageService logoutPageService = new LogoutPageService();
        String actualText = logoutPageService.logout().getTextOfLogout();
        String expectedText = "You have been successfully logged out of the system.";
        Assert.assertEquals(actualText,expectedText,
                "The actual text of the page does not match expected");
    }
}
