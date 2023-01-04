package org.tms.tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.services.LoginPageService;

public class LoginPageTest extends BaseTest{

    @Test (enabled = false)
    @TmsLink("FS-5")
    @Description("Test #4 -> Functionality: Login to account")
    public void loginTest(){
    LoginPageService loginPageService = new LoginPageService();
    User user = new User();
    String actualTextOfUserName = loginPageService.login(user)
            .getTextOfNameOfUser();
    String expectedTextOfUserName = "Aleksandra";
    Assert.assertEquals(actualTextOfUserName,expectedTextOfUserName,
            "The actual text of the page does not match expected");
    }
}
