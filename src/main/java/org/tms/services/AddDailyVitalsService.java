package org.tms.services;

import org.checkerframework.checker.units.qual.A;
import org.tms.pages.AddDailyVitalsPage;
import org.tms.pages.CalendarPage;

public class AddDailyVitalsService {
    CalendarPage calendarPage = new CalendarPage();
    AddDailyVitalsPage addDailyVitalsPage = new AddDailyVitalsPage();
    public AddDailyVitalsPage addDailyVitals(){
        calendarPage.openDailyVitalsPage();
        addDailyVitalsPage.openAddAndViewVitalsPage();
        addDailyVitalsPage
                .fillDateField()
                .fillStepsField()
                .fillCaloriesField()
                .fillWeightField()
                .addVitals()
                .checkRowWithAddedVitals();

        return new AddDailyVitalsPage();
    }
    public String currentDate(){
        return addDailyVitalsPage.countСurrentDate();
    }
}
