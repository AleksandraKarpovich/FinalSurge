package org.tms.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.services.LoginPageService;

public class LoginPageTest extends BaseTest{

    @Test (enabled = false)
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
