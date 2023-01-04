package org.tms.services;

import org.tms.pages.CalendarPage;
import org.tms.pages.LogoutPage;

public class LogoutPageService {
    CalendarPage calendarPage = new CalendarPage();
    LogoutPage logoutPage = new LogoutPage();
    public LogoutPage logout(){
        calendarPage.clickLogoutButton();
        logoutPage.getTextOfLogout();
        return new LogoutPage();
    }
}
