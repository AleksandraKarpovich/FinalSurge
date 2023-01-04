package org.tms.services;

import org.tms.pages.AddNewShoePage;
import org.tms.pages.CalendarPage;

public class AddNewShoeService {
    CalendarPage calendarPage = new CalendarPage();
    AddNewShoePage addNewShoePage = new AddNewShoePage();

    public AddNewShoePage addNewShoe(){
        calendarPage.openAddNewShoe();
        addNewShoePage.addNameShoe()
                .selectBrandShoe()
                .addModelShoe()
                .addCostShoe()
                .addDateShoe()
                .addAlertShoe();
        addNewShoePage.clickAddShoe();

        return new AddNewShoePage();
    }
    public boolean ShoesIsDisplayed(){
        return addNewShoePage.currentShoesIsDisplayed();
    }
}
