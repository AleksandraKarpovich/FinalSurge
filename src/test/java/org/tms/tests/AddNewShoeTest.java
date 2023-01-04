package org.tms.tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.services.AddNewShoeService;
import org.tms.services.LoginPageService;

public class AddNewShoeTest extends BaseTest{
    private CalendarPage calendarPage;

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }
    @Test (enabled = false)
    @TmsLink("FS-2")
    @Description("Test #3 -> Functionality: To Add New Shoe")
    public void addNewShoe(){
        AddNewShoeService addNewShoeService = new AddNewShoeService();
        boolean actualResult = addNewShoeService.addNewShoe().currentShoesIsDisplayed();
        boolean expectedResult = true;
        Assert.assertEquals(actualResult,expectedResult,
                "The actual text of the page does not match expected");
    }
}
