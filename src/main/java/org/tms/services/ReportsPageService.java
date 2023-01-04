package org.tms.services;

import org.tms.pages.CalendarPage;
import org.tms.pages.ReportsPage;

public class ReportsPageService {
    CalendarPage calendarPage = new CalendarPage();
    ReportsPage reportsPage = new ReportsPage();

    public ReportsPage createReport(String START_DATE,String END_DATE){

        calendarPage.clickReportPageButton();

        reportsPage.inputStartDate(START_DATE);
        reportsPage.inputEndDate(END_DATE);
        reportsPage.chooseReportView();
        reportsPage.clickViewReportButton();

        return new ReportsPage();
    }
}
