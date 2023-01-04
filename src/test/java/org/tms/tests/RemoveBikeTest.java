package org.tms.tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.services.LoginPageService;
import org.tms.services.RemoveBikeService;

public class RemoveBikeTest extends BaseTest {
    private CalendarPage calendarPage;
    private static final String NAME_BIKE = "My new bike";
    private static final String BRAND_BIKE = "Felt";
    private static final String MODEL_BIKE = "for Man";
    private static final String COST_BIKE = "1500";
    private static final String DATE_BIKE = "12/06/2022";
    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }
    @Test (enabled = true)
    @TmsLink("FS-8")
    @Description("Test #7 -> Functionality: Add and then Remove Bike")
    public void addWorkout(){
        RemoveBikeService removeBikeService = new RemoveBikeService();
        String actualText = removeBikeService.removeBike(NAME_BIKE,
                BRAND_BIKE,MODEL_BIKE,COST_BIKE,DATE_BIKE).noBikeText();
        String expectedText = "You have no Current bikes. Add one now by using the Add New Bike form.";
        Assert.assertEquals(actualText,expectedText,
                "The actual text of the page does not match expected");
    }
}
