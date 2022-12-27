package org.tms.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.AddNewShoePage;
import org.tms.pages.CalendarPage;
import org.tms.services.LoginPageService;

public class AddNewShoeTest extends BaseTest{
    public CalendarPage calendarPage;
    public AddNewShoePage addNewShoePage;

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }
    @Test (enabled = false)
    @Description("Test #3 -> Functionality: To Add New Shoe")
    public void addNewShoe(){
        calendarPage.openAddNewShoe();
        addNewShoePage = new AddNewShoePage();
        addNewShoePage.addNameShoe();
        addNewShoePage.selectBrandShoe();
        addNewShoePage.addModelShoe();
        addNewShoePage.addCostShoe();
        addNewShoePage.addDateShoe();
        addNewShoePage.addAlertShoe();
        addNewShoePage.clickAddShoe();
        boolean expectedResult = true;
        addNewShoePage.waitAddedShoeIsLoaded();
        Assert.assertEquals(addNewShoePage.currentShoesIsDisplayed(),expectedResult,
                "The actual text of the page does not match expected");
    }
}
