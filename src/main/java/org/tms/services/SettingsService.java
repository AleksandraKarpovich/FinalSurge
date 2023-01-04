package org.tms.services;

import org.tms.pages.CalendarPage;
import org.tms.pages.SettingsPage;

public class SettingsService {
    CalendarPage calendarPage = new CalendarPage();
    SettingsPage settingsPage = new SettingsPage();

    public SettingsPage updateWeight(String WEIGHT){
        calendarPage.clickSettingsButton();

        settingsPage.editButton()
                .updateWeight(WEIGHT)
                .clickSaveButton();
        return new SettingsPage();
    }
}
