package org.tms.services;

import org.tms.pages.CalendarPage;
import org.tms.pages.WorkoutCalculatorsPage;

public class WorkoutCalculatorsService {
    CalendarPage calendarPage = new CalendarPage();
    WorkoutCalculatorsPage workoutCalculatorsPage = new WorkoutCalculatorsPage();

    public WorkoutCalculatorsPage workoutCalculation(String DISTANCE,String TIME_OF_MINUTES){
        calendarPage.clickWorkoutsCalculatorButton();

        workoutCalculatorsPage.switchToFrame()
                .openTab()
                .fillDistance(DISTANCE)
                .fillTime(TIME_OF_MINUTES)
                .executionCalculations();

        return new WorkoutCalculatorsPage();
    }
}
