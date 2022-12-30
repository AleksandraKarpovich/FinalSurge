package org.tms.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
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
        log.info("Fill 'Start Date' field");
        startDate.clear();
        startDate.sendKeys(START_DATE);
    }
    @Step("Step #2: Fill 'End Date' field")
    public void inputEndDate(){
        log.info("Fill 'End Date' field");
        endDate.clear();
        endDate.sendKeys(END_DATE);
    }
    @Step("Step #3: Choose 'Report View' option")
    public void chooseReportView(){
        log.info("Choose 'Report View' option");
        radioButton.click();
    }
    @Step("Step #4: Click 'Report' button")
    public void clickViewReportButton(){
        log.info("Click 'Report' button");
        viewReportButton.click();
    }
    public String tableOfWorkoutsIsDisplayed(){
       return tableOfWorkouts.getText();
    }
}
