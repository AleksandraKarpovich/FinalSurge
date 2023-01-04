package org.tms.services;

import org.tms.pages.AddDailyVitalsPage;
import org.tms.pages.CalendarPage;

public class AddDailyVitalsService {
    CalendarPage calendarPage = new CalendarPage();
    AddDailyVitalsPage addDailyVitalsPage = new AddDailyVitalsPage();
    public AddDailyVitalsPage addDailyVitals(String STEPS, String CALORIES, String WEIGHT){
        calendarPage.openDailyVitalsPage();
        addDailyVitalsPage.openAddAndViewVitalsPage();
        addDailyVitalsPage
                .fillDateField()
                .fillStepsField(STEPS)
                .fillCaloriesField(CALORIES)
                .fillWeightField(WEIGHT)
                .addVitals()
                .checkRowWithAddedVitals();

        return new AddDailyVitalsPage();
    }
    public String currentDate(){
        return addDailyVitalsPage.countСurrentDate();
    }
}
