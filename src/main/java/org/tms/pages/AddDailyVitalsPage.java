package org.tms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddDailyVitalsPage extends BasePage{

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

    private static final String STEPS = "21500";
    private static final String CALORIES = "500";
    private static final String WEIGHT = "150";

    public void addVitals() {
        viewAddVitalsButton.click();
        dateField.clear();
        dateField.click();
        dateField.sendKeys(currentDate());
        stepsField.clear();
        stepsField.click();
        stepsField.sendKeys(STEPS);
        caloriesField.clear();
        caloriesField.click();
        caloriesField.sendKeys(CALORIES);
        weightField.clear();
        weightField.click();
        weightField.sendKeys(WEIGHT);
        addVitalsButton.click();
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
