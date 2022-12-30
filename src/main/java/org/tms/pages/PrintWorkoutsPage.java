package org.tms.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Set;
@Log4j2
public class PrintWorkoutsPage extends BasePage{

    private static final String STARTING_DATE = "12/01/2022";
    private static final String ENDING_DATE = "12/31/2022";
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
    public void switchToFrame() {
        driver.switchTo().frame(frameId);
    }
    @Step("Step #1: Input Starting Date")
    public void inputStartingDate(){
        log.info("Input Starting Date");
        printStartingDate.clear();
        printStartingDate.click();
        printStartingDate.sendKeys(STARTING_DATE);
    }
    @Step("Step #2: Input Ending Date")
    public void inputEndingDate(){
        log.info("Input Ending Date");
        printEndingDate.clear();
        printEndingDate.click();
        printEndingDate.sendKeys(ENDING_DATE);
    }
    @Step("Step #3: Click 'Print Workouts' button")
    public void clickPrintWorkoutsButton(){
        log.info("Click 'Print Workouts' button");
        printWorkoutsButton.click();
    }
    @Step("Step #4: Open Workouts Report")
    public void switchToTab(){
        log.info("Open Workouts Report");
        String currentHandle = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();
        for (String handle : allHandles) {
            if (!handle.equals(currentHandle)) driver.switchTo().window(handle);
        }
    }
    public PrintWorkoutsPage waitPrintLinkIsLoaded() {
        waitVisibilityOf(printLink);
        return this;
    }
    public boolean printLinkIsDisplayed(){
        return printLink.isDisplayed();
    }
}
