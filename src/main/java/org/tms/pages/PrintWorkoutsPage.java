package org.tms.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tms.utils.Switcher;
import org.tms.utils.Waiter;

@Log4j2
public class PrintWorkoutsPage extends BasePage{
    public Waiter waiter = new Waiter();

    @FindBy(xpath = "//iframe[@id='PrintWorkoutsiFrame']")
    private WebElement frameId;
    @FindBy(xpath = "//input[@id='PrintStartDate']")
    private WebElement printStartingDate;
    @FindBy (xpath = "//input[@id='PrintEndDate']")
    private WebElement printEndingDate;
    @FindBy (xpath = "//input[@id='saveButtonPrint']")
    private WebElement printWorkoutsButton;
    @FindBy (xpath = "//a[@id='printlink']")
    private WebElement printLink;

    public PrintWorkoutsPage switchToFrame() {
        driver.switchTo().frame(frameId);
        return this;
    }
    @Step("Step #1: Input Starting Date")
    public PrintWorkoutsPage inputStartingDate(String STARTING_DATE){
        log.info("Input Starting Date");
        printStartingDate.clear();
        printStartingDate.click();
        printStartingDate.sendKeys(STARTING_DATE);
        return this;
    }
    @Step("Step #2: Input Ending Date")
    public PrintWorkoutsPage inputEndingDate(String ENDING_DATE){
        log.info("Input Ending Date");
        printEndingDate.clear();
        printEndingDate.click();
        printEndingDate.sendKeys(ENDING_DATE);
        return this;
    }
    @Step("Step #3: Click 'Print Workouts' button")
    public PrintWorkoutsPage clickPrintWorkoutsButton(){
        log.info("Click 'Print Workouts' button");
        printWorkoutsButton.click();
        return this;
    }
    @Step("Step #4: Open Workouts Report")
    public PrintWorkoutsPage switchToTab(){
        log.info("Open Workouts Report");
        Switcher switcher = new Switcher();
        switcher.switcherToTab();
        waiter.waitVisibilityOf(printLink);
        return this;
    }
    @Step("Step #5: Received actual result")
    public boolean printLinkIsDisplayed(){
        log.info("Received actual result");
        return printLink.isDisplayed();
    }
}
