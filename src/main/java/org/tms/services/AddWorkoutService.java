package org.tms.services;

import org.tms.pages.AddWorkoutPage;
import org.tms.pages.CalendarPage;

public class AddWorkoutService {
    CalendarPage calendarPage = new CalendarPage();
    AddWorkoutPage addWorkoutPage = new AddWorkoutPage();

    public AddWorkoutPage addWorkout(String TIME_OF_DAY, String WORKOUT_NAME,
                                     String DESCRIPTION,String DISTANCE,String DURATION,String KCAL){
        calendarPage.openAddWorkoutPage();

        addWorkoutPage.selectActivityType()
                .addTimeOfDay(TIME_OF_DAY)
                .addWorkoutName(WORKOUT_NAME)
                .addDescription(DESCRIPTION)
                .addDistance(DISTANCE)
                .addDuration(DURATION)
                .chooseHowIFelt()
                .addkCal(KCAL)
                .addWorkout();

        return new AddWorkoutPage();
    }
}
