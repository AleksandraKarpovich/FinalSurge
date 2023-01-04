package org.tms.services;

import org.tms.pages.CalendarPage;
import org.tms.pages.PrintWorkoutsPage;

public class PrintWorkoutsService {
    CalendarPage calendarPage = new CalendarPage();
    PrintWorkoutsPage printWorkoutsPage = new PrintWorkoutsPage();

    public PrintWorkoutsPage printWorkouts(String STARTING_DATE, String ENDING_DATE){
            calendarPage.clickPrintWorkoutsButton();

            printWorkoutsPage.switchToFrame()
                    .inputStartingDate(STARTING_DATE)
                    .inputEndingDate(ENDING_DATE)
                    .clickPrintWorkoutsButton()
                    .switchToTab();

        return new PrintWorkoutsPage();
    }
}
