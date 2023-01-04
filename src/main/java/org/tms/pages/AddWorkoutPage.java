package org.tms.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tms.utils.Waiter;

@Log4j2
public class AddWorkoutPage extends BasePage{

    private static final String TIME_OF_DAY = "06:45 AM";
    private static final String WORKOUT_NAME = "Daily Running";
    private static final String DESCRIPTION = "Daily Long Run Workout at 6:45 AM -- 5 mi";
    private static final String DISTANCE = "5";
    private static final String DURATION = "00:45:00";
    private static final String KCAL = "252";

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
    public void selectActivityType() {
        log.info("Select Activity Type");
        runActivityType.click();
        waiter.waitVisibilityOf(runSubType);
        runSubType.click();
    }
    @Step("Step #2: Add Time Of Day for Workout")
    public void addTimeOfDay(){
        log.info("Add Time Of Day for Workout");
        waiter.waitVisibilityOf(timeOfDay);
        timeOfDay.clear();
        timeOfDay.sendKeys(TIME_OF_DAY);
    }
    @Step("Step #3: Add Name of Workout")
    public void addWorkoutName(){
        log.info("Add Name of Workout");
        workoutName.clear();
        workoutName.sendKeys(WORKOUT_NAME);
    }
    @Step("Step #4: Add Description of Workout")
    public void addDescription(){
        log.info("Add Description of Workout");
        description.clear();
        description.sendKeys(DESCRIPTION);
    }
    @Step("Step #5: Add Distance of Workout")
    public void addDistance(){
        log.info("Add Distance of Workout");
        distance.clear();
        distance.sendKeys(DISTANCE);
    }
    @Step("Step #6: Add Duration")
    public void addDuration(){
        log.info("Add Duration");
        duration.clear();
        duration.sendKeys(DURATION);
    }
    @Step("Step #7: Choose 'How I felt' option")
    public void chooseHowIFelt(){
        log.info("Choose 'How I felt' option");
        howIFelt.click();
    }
    @Step ("Step #8: Add Burned Calories")
    public void addkCal(){
        log.info("Add Burned Calories");
        kCal.clear();
        kCal.sendKeys(KCAL);
    }
    @Step("Step #9: Click on the 'Add Workout' button")
    public void addWorkout(){
        log.info("Click on the 'Add Workout' button");
        addWorkoutButton.click();
    }
    public String nameOfAddedWorkout(){
        return nameOfAddedWorkout.getText();
    }
}
