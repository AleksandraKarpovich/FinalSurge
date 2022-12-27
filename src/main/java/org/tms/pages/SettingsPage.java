package org.tms.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage{
    @FindBy (xpath = "//*[@id='ProfileEditLink']/div/span")
    private WebElement editButton;
    @FindBy(xpath = "//*[@id='Weight']")
    private WebElement fieldWeight;
    @FindBy(xpath = "//*[@id='saveButtonProfile']")
    private WebElement saveChangesButton;
    @FindBy(xpath = "//*[@id='EditProfile']/div/div[2]/p[5]")
    private WebElement weightRow;
    private static final String WEIGHT = "55";
    @Step("Step #1: Click 'Edit' button")
    public void editButton(){
        editButton.click();
    }
    @Step("Step #2: Update Weight")
    public void updateWeight(){
        fieldWeight.clear();
        fieldWeight.sendKeys(WEIGHT);
    }
    @Step("Step #3: Click 'Save' button")
    public void clickSaveButton(){
        saveChangesButton.click();
    }

    public String weightIsDisplayed(){
        return weightRow.getText();
    }

}
