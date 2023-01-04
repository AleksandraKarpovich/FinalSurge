package org.tms.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tms.utils.Waiter;

@Log4j2
public class WorkoutCalculatorsPage extends BasePage{

    public Waiter waiter = new Waiter();
    @FindBy(xpath = "//iframe[@id='OtherCalciFrame']")
    private WebElement frameId;
    @FindBy(xpath = "//a[contains(text(),'Pace Calculator')]")
    private WebElement tabName;
    @FindBy(xpath = "//input[@id='RunDist']")
    private WebElement distance;
    @FindBy (xpath = "//input[@id='TimeMM']")
    private WebElement timeOfMinutes;
    @FindBy (xpath = "//h4[contains(text(),'Pace Chart')]")
    private WebElement paceChartSection;
    @FindBy (xpath = "//h4[contains(text(),'Pace Splits')]")
    private WebElement paceSplitsSection;

    public WorkoutCalculatorsPage openTab(){
        tabName.click();
        return this;
    }
    public WorkoutCalculatorsPage switchToFrame() {
        waiter.waitVisibilityOf(frameId);
        driver.switchTo().frame(frameId);
        return this;
    }
    @Step("Step #1: Fill 'Distance' field")
    public WorkoutCalculatorsPage fillDistance(String DISTANCE){
        log.info("Fill 'Distance' field");
        distance.clear();
        distance.sendKeys(DISTANCE);
        return this;
    }
    @Step("Step #2: Fill 'Time of minutes' field")
    public WorkoutCalculatorsPage fillTime(String TIME_OF_MINUTES){
        log.info("Fill 'Time of minutes' field");
        timeOfMinutes.clear();
        timeOfMinutes.sendKeys(TIME_OF_MINUTES);
        return this;
    }

    @Step("Step #3: Execution Calculations")
    public WorkoutCalculatorsPage executionCalculations(){
        log.info("Execution Calculations");
        timeOfMinutes.sendKeys(Keys.ENTER);
        waiter.waitVisibilityOf(paceChartSection);
        return this;
        //тут по path было два элемента и я применила интер в поле, чтобы отобразить результат
    }
    @Step("Step #4: Received actual result")
    public boolean isDisplayed(){
        log.info("Received actual result");
        if(paceChartSection.isDisplayed() && paceSplitsSection.isDisplayed()) {
        return true;
        } else return false;
    }
}
