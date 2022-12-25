package org.tms.pages;

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

    public void updateWeight(){
        editButton.click();
        fieldWeight.clear();
        fieldWeight.click();
        fieldWeight.sendKeys(WEIGHT);
        saveChangesButton.click();
    }

    public String weightIsDisplayed(){
        return weightRow.getText();
    }

}
