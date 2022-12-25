package org.tms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportsPage extends BasePage{

    private static final String START_DATE = "12/01/2022";
    private static final String END_DATE = "12/31/2022";

    @FindBy(xpath = "//input[@id='WorkoutDate']")
    private WebElement startDate;
    @FindBy (xpath = "//input[@id='WorkoutDateEnd']")
    private WebElement endDate;
    @FindBy(xpath = "//input[@id='groupBy3']")
    private WebElement radioButton;
    @FindBy (xpath = "//input[@id='saveButton']")
    private WebElement viewReportButton;
    @FindBy (xpath = "//h4[contains(text(),'December 2022')]")
    private WebElement tableOfWorkouts;

    public void inputStartDate(){
        startDate.clear();
        startDate.click();
        startDate.sendKeys(START_DATE);
    }

    public void inputEndDate(){
        endDate.clear();
        endDate.click();
        endDate.sendKeys(END_DATE);
    }

    public void chooseReportView(){
        radioButton.click();
    }
    public void clickViewReportButton(){
        viewReportButton.click();
    }
    public String tableOfWorkoutsIsDisplayed(){
       return tableOfWorkouts.getText();
    }


}
