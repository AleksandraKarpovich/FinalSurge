package org.tms.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.tms.utils.Waiter;

@Log4j2
public class CalendarPage extends BasePage{
    public Waiter waiter = new Waiter();

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
        log.info("Click 'Logout' button");
        logoutButton.click();
    }
    @Step("Step #0: Open 'Report' page")
    public void clickReportPageButton(){
        log.info("Open 'Report' page");
        reportPageButton.click();
    }
    @Step("Step #0: Open 'Create Workouts Report' page")
    public void clickPrintWorkoutsButton(){
        log.info("Open 'Create Workouts Report' page");
        printWorkoutsButton.click();
    }

    @Step("Step #0: Open 'Add Workout' page")
    public void openAddWorkoutPage() {
        log.info("Open 'Add Workout' page");
        Actions action = new Actions(driver);
        action.moveToElement(workoutsOption);
        action.perform();
        addWorkoutOption.click();
    }
    @Step("Step #0: Open 'Workouts Calculator' page")
    public void clickWorkoutsCalculatorButton(){
        log.info("Open 'Workouts Calculator' page");
        workoutsCalculatorButton.click();
    }

    @Step("Step #0: Open 'View and Add Vitals' page")
    public void openDailyVitalsPage(){
        log.info("Open 'View and Add Vitals' page");
        Actions action = new Actions(driver);
        action.moveToElement(dailyVitalsOption);
        action.perform();
        waiter.waitVisibilityOf(addDailyVitalsOption);
        addDailyVitalsOption.click();
    }
    @Step("Step #0: Open 'Add New Shoe' page")
    public void openAddNewShoe() {
        log.info("Open 'Add New Shoe' page");
        Actions action = new Actions(driver);
        action.moveToElement(gearOption);
        action.perform();
        addNewShoeOption.click();
    }
    @Step("Step #0: Open 'Add New Bike' page")
    public void openAddNewBike(){
        log.info("Open 'Add New Bike' page");
        Actions action = new Actions(driver);
        action.moveToElement(gearOption);
        action.perform();
        addNewBikeOption.click();
    }
    @Step("Step #0: Open 'Settings' page")
    public void clickSettingsButton(){
        log.info("Open 'Settings' page");
        settingButton.click();
    }
}

