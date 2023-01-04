package org.tms.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tms.utils.Waiter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Log4j2
public class AddDailyVitalsPage extends BasePage{
    public Waiter waiter = new Waiter();

    @FindBy(xpath = "//*[@id='breadcrumbs']/div/button")
    private WebElement viewAddVitalsButton;
    @FindBy(xpath = "//input[@id='VitalsDate']")
    private WebElement dateField;
    @FindBy(xpath = "//input[@id='Steps']")
    private WebElement stepsField;
    @FindBy(xpath = "//input[@id='Calories']")
    private WebElement caloriesField;
    @FindBy(xpath = "//input[@id='Weight']")
    private WebElement weightField;
    @FindBy(xpath = "//input[@id='saveButton']")
    private WebElement addVitalsButton;
    @FindBy (xpath = "//a[contains(text(),'Custom View')]")
    private WebElement customView;
    @FindBy (xpath = "//input[@id='CDateStart']")
    private WebElement startDate;
    @FindBy (xpath = "//input[@id='CDateEnd']")
    private WebElement endDate;
    @FindBy (xpath = "//input[@id='viewButton']")
    private WebElement viewButton;
    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div[2]/div[2]/table/tbody/tr[1]")
    private WebElement rowNow;

    @Step ("Step #1: Open 'Add Vitals' page")
    public void openAddAndViewVitalsPage(){
        log.info("Click on 'View&Add Vitals' button");
        viewAddVitalsButton.click();
    }
    @Step ("Step #2: Fill the 'Date' field")
    public AddDailyVitalsPage fillDateField(){
        log.info("Fill the 'Date' field");
        waiter.waitVisibilityOf(dateField);
        dateField.clear();
        dateField.sendKeys(countСurrentDate());
        return this;
    }
    @Step ("Step #3: Fill the 'Steps' field")
    public AddDailyVitalsPage fillStepsField(String STEPS){
        log.info("Fill the 'Steps' field");
        stepsField.clear();
        stepsField.sendKeys(STEPS);
        return this;
    }
    @Step ("Step #4: Fill the 'Calories' field")
    public AddDailyVitalsPage fillCaloriesField(String CALORIES){
        log.info("Fill the 'Calories' field");
        caloriesField.clear();
        caloriesField.sendKeys(CALORIES);
        return this;
    }
    @Step ("Step #5: Fill the 'Weight' field")
    public AddDailyVitalsPage fillWeightField(String WEIGHT){
        log.info("Fill the 'Weight' field");
        weightField.clear();
        weightField.click();
        weightField.sendKeys(WEIGHT);
        return this;
    }
    @Step ("Step #6: Click the 'Add Vitals' button")
    public AddDailyVitalsPage addVitals() {
        log.info("Click the 'Add Vitals' button");
        addVitalsButton.click();
        return this;
    }
    @Step ("Step #7: Checked added Vitals")
    public AddDailyVitalsPage checkRowWithAddedVitals() {
        log.info("Click the 'Custom View' button");
        customView.click();
        log.info("Fill the 'Start Date' field");
        startDate.clear();
        startDate.sendKeys(countСurrentDate());
        log.info("Fill the 'End Date' field");
        endDate.clear();
        endDate.sendKeys(countСurrentDate());
        log.info("Click the 'View' button");
        viewButton.click();
        return this;
    }
    @Step ("Step #8: Received actual result")
    public String checkRow(){
        log.info("Received actual result");
        return rowNow.getText();
    }
    public String countСurrentDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        String formatDateTime = now.format(formatter);
        return formatDateTime;
    }
}
