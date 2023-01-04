package org.tms.services;

import org.tms.pages.CalendarPage;
import org.tms.pages.LogoutPage;

public class LogoutPageService {
    CalendarPage calendarPage = new CalendarPage();

    public LogoutPage logout(){
        calendarPage.clickLogoutButton();
        return new LogoutPage();
    }
}
