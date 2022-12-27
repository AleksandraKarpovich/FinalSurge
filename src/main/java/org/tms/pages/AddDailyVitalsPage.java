package org.tms.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddDailyVitalsPage extends BasePage{
    private static final String STEPS = "21500";
    private static final String CALORIES = "252";
    private static final String WEIGHT = "165";
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
    @FindBy (xpath = "/html/body/div[1]/div[3]/div/div/div[2]/div[2]/table/tbody")
    private WebElement dailyVitalsTable;
    ////h4[contains(text(), 'Daily Vitals')]
    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[1]")
    private WebElement dailyVitals;
    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[2]")
    private WebElement countOfSteps;
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

    @Step ("Step #1: Open 'Add Vitals' Page")
    public void openAddAndViewVitalsPage(){
        viewAddVitalsButton.click();
    }
    @Step ("Step #2: Fill the 'Date' field")
    public void fillDateField(){
        dateField.clear();
        dateField.sendKeys(currentDate());
    }
    @Step ("Step #3: Fill the 'Steps' field")
    public void fillStepsField(){
        stepsField.clear();
        stepsField.sendKeys(STEPS);
    }
    @Step ("Step #4: Fill the 'Calories' field")
    public void fillCaloriesField(){
        caloriesField.clear();
        caloriesField.sendKeys(CALORIES);
    }
    @Step ("Step #5: Fill the 'Weight' field")
    public void fillWeightField(){
        weightField.clear();
        weightField.click();
        weightField.sendKeys(WEIGHT);
    }
    @Step ("Step #6: Click the 'Add Vitals' button")
    public void addVitals() {
        addVitalsButton.click();
    }
    @Step ("Step #7: Checked added Vitals")
    public void checkRowWithAddedVitals() {
        customView.click();
        startDate.clear();
        startDate.sendKeys(currentDate());
        endDate.clear();
        endDate.sendKeys(currentDate());
        viewButton.click();
    }
    public String checkRow(){
        return rowNow.getText();
    }
    public String currentDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formatDateTime = now.format(formatter);
        //System.out.println("After: " + formatDateTime);
        return formatDateTime;
    }
}
