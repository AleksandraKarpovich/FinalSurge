package org.tms.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.pages.RemoveBikePage;
import org.tms.services.LoginPageService;

public class RemoveBikeTest extends BaseTest {
    public CalendarPage calendarPage;
    public RemoveBikePage removeBikePage;

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }
    @Test (enabled = false)
    public void addWorkout() throws InterruptedException {
        calendarPage.openAddNewBike();
        removeBikePage = new RemoveBikePage();
        removeBikePage.addNewBike();
        removeBikePage.removeNewBike();
        String expectedText = "You have no Current bikes. Add one now by using the Add New Bike form.";
        Assert.assertEquals(removeBikePage.noBikeText(),expectedText,
                "The actual text of the page does not match expected");
    }
}
