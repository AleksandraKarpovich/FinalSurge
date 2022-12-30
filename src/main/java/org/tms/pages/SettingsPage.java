package org.tms.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class SettingsPage extends BasePage{

    private static final String WEIGHT = "55";
    @FindBy (xpath = "//*[@id='ProfileEditLink']/div/span")
    private WebElement editButton;
    @FindBy(xpath = "//*[@id='Weight']")
    private WebElement fieldWeight;
    @FindBy(xpath = "//*[@id='saveButtonProfile']")
    private WebElement saveChangesButton;
    @FindBy(xpath = "//*[@id='EditProfile']/div/div[2]/p[5]")
    private WebElement weightRow;

    @Step("Step #1: Click 'Edit' button")
    public void editButton(){
        log.info("Click 'Edit' button");
        editButton.click();
    }
    @Step("Step #2: Update Weight")
    public void updateWeight(){
        log.info("Update Weight");
        fieldWeight.clear();
        fieldWeight.sendKeys(WEIGHT);
    }
    @Step("Step #3: Click 'Save' button")
    public void clickSaveButton(){
        log.info("Click 'Save' button");
        saveChangesButton.click();
    }

    public String weightIsDisplayed(){
        return weightRow.getText();
    }

}
