package org.tms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class AddWorkoutPage extends BasePage{

    private static final String TIME_OF_DAY = "06:45 AM";
    private static final String WORKOUT_NAME = "Daily Running";
    private static final String DISTANCE = "5";
    private static final String DURATION = "00:45:00";

    @FindBy (xpath = "//*[@id='blog_accordion_left']/div[1]/div[1]/a/i")
    private WebElement runActivityType;
    @FindBy (xpath = "//input[@id='WorkoutTime']")
    private WebElement timeOfDay;
    @FindBy (xpath = "//input[@id='Name']")
    private WebElement workoutName;
    @FindBy (xpath = "//input[@id='Distance']")
    private WebElement distance;
    @FindBy (xpath = "//input[@id='Duration']")
    private WebElement duration;
    @FindBy (xpath = "//input[@id='hf_good']")
    private WebElement howIFelt;
    @FindBy (xpath = "//input[@id='saveButton']")
    private WebElement addWorkoutButton;
    @FindBy (xpath = "//div[@id='PublicBox']")
    private WebElement workoutDetails;

    @FindBy(xpath = "//*[@id='EditProfile']/div/div[1]/div/div[3]")
    private WebElement nameOfAddedWorkout;

    public void addWorkout(){
        runActivityType.click();
        waitTimeOfDayIsLoaded();
        timeOfDay.clear();
        timeOfDay.click();
        timeOfDay.sendKeys(TIME_OF_DAY);
        workoutName.clear();
        workoutName.click();
        workoutName.sendKeys(WORKOUT_NAME);
        distance.clear();
        distance.click();
        distance.sendKeys(DISTANCE);
        duration.clear();
        duration.click();
        duration.sendKeys(DURATION);
        howIFelt.click();
        addWorkoutButton.click();
    }
    public AddWorkoutPage waitTimeOfDayIsLoaded() {
        waitVisibilityOf(timeOfDay);
        return this;
    }
    public String nameOfAddedWorkout(){
        return nameOfAddedWorkout.getText();
    }
}
