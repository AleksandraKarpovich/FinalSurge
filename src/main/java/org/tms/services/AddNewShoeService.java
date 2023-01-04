package org.tms.services;

import org.tms.pages.AddNewShoePage;
import org.tms.pages.CalendarPage;

public class AddNewShoeService {
    CalendarPage calendarPage = new CalendarPage();
    AddNewShoePage addNewShoePage = new AddNewShoePage();

    public AddNewShoePage addNewShoe(String NAME_SHOE,String BRAND_SHOE,String MODEL_SHOE,
                                     String COST_SHOE, String DATE_SHOE, String ALERT_SHOE){
        calendarPage.openAddNewShoe();
        addNewShoePage.addNameShoe(NAME_SHOE)
                .selectBrandShoe(BRAND_SHOE)
                .addModelShoe(MODEL_SHOE)
                .addCostShoe(COST_SHOE)
                .addDateShoe(DATE_SHOE)
                .addAlertShoe(ALERT_SHOE);
        addNewShoePage.clickAddShoe();

        return new AddNewShoePage();
    }

}
