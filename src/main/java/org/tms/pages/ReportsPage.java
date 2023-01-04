package org.tms.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class ReportsPage extends BasePage{

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
    public ReportsPage inputStartDate(String START_DATE){
        log.info("Fill 'Start Date' field");
        startDate.clear();
        startDate.sendKeys(START_DATE);
        return this;
    }
    @Step("Step #2: Fill 'End Date' field")
    public ReportsPage inputEndDate(String END_DATE){
        log.info("Fill 'End Date' field");
        endDate.clear();
        endDate.sendKeys(END_DATE);
        return this;
    }
    @Step("Step #3: Choose 'Report View' option")
    public ReportsPage chooseReportView(){
        log.info("Choose 'Report View' option");
        radioButton.click();
        return this;
    }
    @Step("Step #4: Click 'Report' button")
    public ReportsPage clickViewReportButton(){
        log.info("Click 'Report' button");
        viewReportButton.click();
        return this;
    }
    @Step("Step #6: Received actual result")
    public String tableOfWorkoutsIsDisplayed(){
        log.info("Received actual result");
       return tableOfWorkouts.getText();
    }
}
