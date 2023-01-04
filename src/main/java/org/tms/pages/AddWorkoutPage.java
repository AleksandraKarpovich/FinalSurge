package org.tms.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tms.utils.Waiter;

@Log4j2
public class AddWorkoutPage extends BasePage{
    public Waiter waiter = new Waiter();

    @FindBy (xpath = "//*[@id='blog_accordion_left']/div[1]/div[1]/a/i")
    private WebElement runActivityType;
    @FindBy (xpath = "//a[contains(text(),'Long Run')]")
    private WebElement runSubType;
    @FindBy (xpath = "//input[@id='WorkoutTime']")
    private WebElement timeOfDay;
    @FindBy (xpath = "//input[@id='Name']")
    private WebElement workoutName;
    @FindBy(xpath = "//textarea[@id='Desc']")
    private WebElement description;
    @FindBy (xpath = "//input[@id='Distance']")
    private WebElement distance;
    @FindBy (xpath = "//input[@id='Duration']")
    private WebElement duration;
    @FindBy (xpath = "//input[@id='hf_good']")
    private WebElement howIFelt;
    @FindBy (xpath = "//input[@id='kCal']")
    private WebElement kCal;
    @FindBy (xpath = "//input[@id='saveButton']")
    private WebElement addWorkoutButton;
    @FindBy(xpath = "//*[@id='EditProfile']/div/div[1]/div/div[3]")
    private WebElement nameOfAddedWorkout;

    @Step("Step #1: Select Activity type")
    public AddWorkoutPage selectActivityType() {
        log.info("Select Activity Type");
        runActivityType.click();
        waiter.waitVisibilityOf(runSubType);
        runSubType.click();
        return this;
    }
    @Step("Step #2: Add Time Of Day for Workout")
    public AddWorkoutPage addTimeOfDay(String TIME_OF_DAY){
        log.info("Add Time Of Day for Workout");
        waiter.waitVisibilityOf(timeOfDay);
        timeOfDay.clear();
        timeOfDay.sendKeys(TIME_OF_DAY);
        return this;
    }
    @Step("Step #3: Add Name of Workout")
    public AddWorkoutPage addWorkoutName(String WORKOUT_NAME){
        log.info("Add Name of Workout");
        workoutName.clear();
        workoutName.sendKeys(WORKOUT_NAME);
        return this;
    }
    @Step("Step #4: Add Description of Workout")
    public AddWorkoutPage addDescription(String DESCRIPTION){
        log.info("Add Description of Workout");
        description.clear();
        description.sendKeys(DESCRIPTION);
        return this;
    }
    @Step("Step #5: Add Distance of Workout")
    public AddWorkoutPage addDistance(String DISTANCE){
        log.info("Add Distance of Workout");
        distance.clear();
        distance.sendKeys(DISTANCE);
        return this;
    }
    @Step("Step #6: Add Duration")
    public AddWorkoutPage addDuration(String DURATION){
        log.info("Add Duration");
        duration.clear();
        duration.sendKeys(DURATION);
        return this;
    }
    @Step("Step #7: Choose 'How I felt' option")
    public AddWorkoutPage chooseHowIFelt(){
        log.info("Choose 'How I felt' option");
        howIFelt.click();
        return this;
    }
    @Step ("Step #8: Add Burned Calories")
    public AddWorkoutPage addkCal(String KCAL){
        log.info("Add Burned Calories");
        kCal.clear();
        kCal.sendKeys(KCAL);
        return this;
    }
    @Step("Step #9: Click on the 'Add Workout' button")
    public void addWorkout(){
        log.info("Click on the 'Add Workout' button");
        addWorkoutButton.click();
    }
    @Step("Step #10: Received actual result")
    public String nameOfAddedWorkout(){
        log.info("Received actual result");
        return nameOfAddedWorkout.getText();
    }
}
