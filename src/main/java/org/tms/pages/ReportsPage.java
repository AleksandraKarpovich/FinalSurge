package org.tms.pages;

import io.qameta.allure.Step;
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
    @Step("Step #1: Fill 'Start Date' field")
    public void inputStartDate(){
        startDate.clear();
        startDate.click();
        startDate.sendKeys(START_DATE);
    }
    @Step("Step #2: Fill 'End Date' field")
    public void inputEndDate(){
        endDate.clear();
        endDate.click();
        endDate.sendKeys(END_DATE);
    }
    @Step("Step #3: Choose 'Report View' option")
    public void chooseReportView(){
        radioButton.click();
    }
    @Step("Step #4: Click 'Report' button")
    public void clickViewReportButton(){
        viewReportButton.click();
    }
    public String tableOfWorkoutsIsDisplayed(){
       return tableOfWorkouts.getText();
    }
}
