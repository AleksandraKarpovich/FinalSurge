package org.tms.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class SettingsPage extends BasePage{
    @FindBy (xpath = "//*[@id='ProfileEditLink']/div/span")
    private WebElement editButton;
    @FindBy(xpath = "//*[@id='Weight']")
    private WebElement fieldWeight;
    @FindBy(xpath = "//*[@id='saveButtonProfile']")
    private WebElement saveChangesButton;
    @FindBy(xpath = "//*[@id='EditProfile']/div/div[2]/p[5]")
    private WebElement weightRow;

    @Step("Step #1: Click 'Edit' button")
    public SettingsPage editButton(){
        log.info("Click 'Edit' button");
        editButton.click();
        return this;
    }
    @Step("Step #2: Update Weight")
    public SettingsPage updateWeight(String WEIGHT){
        log.info("Update Weight");
        fieldWeight.clear();
        fieldWeight.sendKeys(WEIGHT);
        return this;
    }
    @Step("Step #3: Click 'Save' button")
    public void clickSaveButton(){
        log.info("Click 'Save' button");
        saveChangesButton.click();
    }
    @Step("Step #4: Received actual result")
    public String weightIsDisplayed(){
        log.info("Received actual result");
        return weightRow.getText();
    }

}
