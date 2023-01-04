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
    private static final String NAME_SHOE = "New Balance Snickers";
    private static final String BRAND_SHOE = "adidas";
    private static final String MODEL_SHOE = "New Collection: 2022";
    private static final String COST_SHOE = "1500";
    private static final String DATE_SHOE = "06/01/2022";
    private static final String ALERT_SHOE = "120";

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }
    @Test (enabled = true)
    @TmsLink("FS-2")
    @Description("Test #3 -> Functionality: To Add New Shoe")
    public void addNewShoe(){
        AddNewShoeService addNewShoeService = new AddNewShoeService();
        boolean actualResult = addNewShoeService.addNewShoe(NAME_SHOE,
                BRAND_SHOE,MODEL_SHOE,COST_SHOE,DATE_SHOE,ALERT_SHOE).currentShoesIsDisplayed();
        boolean expectedResult = true;
        Assert.assertEquals(actualResult,expectedResult,
                "The actual text of the page does not match expected");
    }
}
