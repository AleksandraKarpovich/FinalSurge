package org.tms.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkoutCalculatorsPage extends BasePage{

    private static final String DISTANCE = "5";
    private static final String TIME_OF_MINUTES = "30";
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

    public void openTab(){
        tabName.click();
    }
    public void switchToFrame() {
        driver.switchTo().frame(frameId);
    }
    public void fillFields(){
        distance.clear();
        distance.click();
        distance.sendKeys(DISTANCE);
        timeOfMinutes.clear();
        timeOfMinutes.click();
        timeOfMinutes.sendKeys(TIME_OF_MINUTES);
        timeOfMinutes.sendKeys(Keys.ENTER); //тут по path было два элемента и я применила интер в поле, чтобы отобразить результат
        waitPaceChart();
    }
    public boolean paceChartSectionIsDisplayed(){
        return paceChartSection.isDisplayed();
    }
    public boolean paceSplitsSectionIsDisplayed(){
        return paceSplitsSection.isDisplayed();
    }

    public boolean isDisplayed(){
        if(paceChartSection.isDisplayed() && paceSplitsSection.isDisplayed()) {
        return true;
        }else return false;
    }

    public WorkoutCalculatorsPage waitPaceChart() {
        waitVisibilityOf(paceChartSection);
        return this;
    }
    public WorkoutCalculatorsPage waitFrame() {
        waitVisibilityOf(frameId);
        return this;
    }

}
