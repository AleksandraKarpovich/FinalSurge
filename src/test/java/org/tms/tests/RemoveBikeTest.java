package org.tms.tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.pages.RemoveBikePage;
import org.tms.services.LoginPageService;

public class RemoveBikeTest extends BaseTest {
    private CalendarPage calendarPage;

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }
    @Test (enabled = false)
    @TmsLink("FS-8")
    @Description("Test #7 -> Functionality: Add and then Remove Bike")
    public void addWorkout(){
        calendarPage.openAddNewBike();
        RemoveBikePage removeBikePage = new RemoveBikePage();
        removeBikePage.addNewBike();
        removeBikePage.removeNewBike();
        String expectedText = "You have no Current bikes. Add one now by using the Add New Bike form.";
        Assert.assertEquals(removeBikePage.noBikeText(),expectedText,
                "The actual text of the page does not match expected");
    }
}
