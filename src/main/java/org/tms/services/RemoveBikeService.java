package org.tms.services;

import org.tms.pages.CalendarPage;
import org.tms.pages.RemoveBikePage;

public class RemoveBikeService {
    CalendarPage calendarPage = new CalendarPage();
    RemoveBikePage removeBikePage = new RemoveBikePage();

    public RemoveBikePage removeBike(String NAME_BIKE, String BRAND_BIKE,
                                     String MODEL_BIKE,String COST_BIKE,String DATE_BIKE){

        calendarPage.openAddNewBike();
        removeBikePage.addNewBike(NAME_BIKE,BRAND_BIKE,MODEL_BIKE,COST_BIKE,DATE_BIKE)
                .removeNewBike();
        return new RemoveBikePage();
    }
}
