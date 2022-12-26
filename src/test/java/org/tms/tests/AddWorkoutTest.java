package org.tms.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.AddWorkoutPage;
import org.tms.pages.CalendarPage;
import org.tms.services.LoginPageService;

public class AddWorkoutTest extends BaseTest {

    public CalendarPage calendarPage;
    public AddWorkoutPage addWorkoutPage;

    @BeforeClass
    public void loginPage() {
        LoginPageService loginPageService = new LoginPageService();
        calendarPage = new CalendarPage();
        User user = new User();
        loginPageService.login(user);
    }
    @Test (enabled = true)
    @Description ("Добавление воркаута")
    @Step("Метод: с ожидаемым результатом")
    public void addWorkout(){
        calendarPage.openAddWorkoutPage();
        addWorkoutPage = new AddWorkoutPage();
        addWorkoutPage.addWorkout();
        String expectedNameOfWorkout = "Daily Running1";
        Assert.assertEquals(addWorkoutPage.nameOfAddedWorkout(),expectedNameOfWorkout,
                "The actual text of the page does not match expected");
    }
}
