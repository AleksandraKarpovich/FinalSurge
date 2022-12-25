package org.tms.services;

import org.tms.model.User;
import org.tms.pages.CalendarPage;
import org.tms.pages.LoginPage;


public class LoginPageService {

    private static final String PAGE_URL= "https://log.finalsurge.com/login.cshtml";
    protected LoginPage loginPage = new LoginPage();

    public CalendarPage login(User user){
        loginPage.openPage(PAGE_URL)
                .fillInUsername(user.getLogin())
                .fillInPassword(user.getPassword())
                .clickLoginButton();
        return new CalendarPage();
    }
}
