package org.tms.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CalendarPage extends BasePage{

    @FindBy(xpath = "//strong[contains(., 'Aleksandra')]")
    private WebElement nameOfUser;
    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    private WebElement logoutButton;
    @FindBy(xpath = "//i[@class='icsw16-graph']")
    private WebElement reportPageButton;

    @FindBy (xpath = "//i[@class='icsw16-printer']")
    private WebElement printWorkoutsButton;

    @FindBy (xpath = "//i[@class='icsw16-calculator']")
    private WebElement workoutsCalculatorButton;

    @FindBy (xpath = "//*[@id='mobile-nav']/li[1]/a")
    private WebElement workoutsOption;

    @FindBy (xpath = "//*[@id='mobile-nav']/li[1]/ul/li[1]/a")
    private WebElement addWorkoutOption;

    @FindBy (xpath = "//ul[@id='mobile-nav']/li[2]/a[contains(text(),'Daily Vitals')]")
    private WebElement dailyVitalsOption;

    @FindBy (xpath = "//a[contains(text(),'View & Add Vitals')]")
    private WebElement addDailyVitalsOption;

    @FindBy(xpath = "//a[contains(text(),'Gear & Routes')]")
    private WebElement gearOption;
    @FindBy (xpath = "//*[@id='mobile-nav']/li[3]/ul/li[1]/a")
    private WebElement addNewShoeOption;

    @FindBy(xpath = "//*[@id='mobile-nav']/li[3]/ul/li[2]/a")
    private WebElement addNewBikeOption;

    @FindBy(xpath = "/html/body/div[1]/header/div/div/div[3]/div/div/div/ul/li[1]/a")
    private WebElement settingButton;

    public String getTextOfNameOfUser(){
        return nameOfUser.getText();
    }

    @Step("Step #1: Click 'Logout' button")
    public void clickLogoutButton(){
        logoutButton.click();
    }
    @Step("Step #0: Open 'Report' Page")
    public void clickReportPageButton(){
        reportPageButton.click();
    }
    @Step("Step #0: Open 'Create Workouts Report' Page")
    public void clickPrintWorkoutsButton(){
        printWorkoutsButton.click();
    }

    @Step("Step #0: Open 'Add Workout' Page")
    public void openAddWorkoutPage() {
        Actions action = new Actions(driver);
        action.moveToElement(workoutsOption);
        action.perform();
        addWorkoutOption.click();
    }
    @Step("Step #0: Open 'Workouts Calculator' Page")
    public void clickWorkoutsCalculatorButton(){
        workoutsCalculatorButton.click();
    }

    @Step("Step #0: Open 'View and Add Vitals' Page")
    public void openDailyVitalsPage(){
        Actions action = new Actions(driver);
        action.moveToElement(dailyVitalsOption);
        action.perform();
        waitOptionIsLoaded();
        addDailyVitalsOption.click();
    }
    @Step("Step #0: Open 'Add New Shoe' Page")
    public void openAddNewShoe() {
        Actions action = new Actions(driver);
        action.moveToElement(gearOption);
        action.perform();
        addNewShoeOption.click();
    }
    @Step("Step #0: Open 'Add New Bike' Page")
    public void openAddNewBike(){
        Actions action = new Actions(driver);
        action.moveToElement(gearOption);
        action.perform();
        addNewBikeOption.click();
    }
    @Step("Step #0: Open 'Settings' Page")
    public void clickSettingsButton(){
        settingButton.click();
    }

    public CalendarPage waitOptionIsLoaded() {
        waitVisibilityOf(addDailyVitalsOption);
        return this;
    }
}

