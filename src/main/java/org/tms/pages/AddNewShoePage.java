package org.tms.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewShoePage extends BasePage{
    private static final String NAME_SHOE = "New Balance Snickers";
    private static final String BRAND_SHOE = "adidas";
    private static final String MODEL_SHOE = "New Collection: 2022";
    private static final String COST_SHOE = "1500";
    private static final String DATE_SHOE = "06/01/2022";
    private static final String ALERT_SHOE = "120";

    @FindBy(xpath = "//input[@id='ShoeName']")
    private WebElement nameShoe;
    @FindBy(xpath = "//span[contains(text(),'Select Brand...')]")
    private WebElement fieldBrand;
    @FindBy(xpath = "/html/body/div[19]/div/input")
    private WebElement brandShoe;
    @FindBy(xpath = "//input[@id='ShoeModel']")
    private WebElement modelShoe;
    @FindBy(xpath = "//input[@id='ShoeCost']")
    private WebElement costShoe;
    @FindBy(xpath = "//input[@id='ShoeDate']")
    private WebElement dateShoe;
    @FindBy(xpath = "//input[@id='DistAlert']")
    private WebElement alertShoe;
    @FindBy (xpath = "//input[@id='saveButton']")
    private WebElement addShoeButton;
    @FindBy (xpath = "/html/body/div[1]/div[3]/div/div/div/div[2]/div/div[2]/table")
    private WebElement tableOfShoes;
    @FindBy (xpath = "//a[contains(text(),'New Balance Snickers')]")
    private WebElement addedShoe;

    @Step("Step #1: Add Name Of Shoe")
    public void addNameShoe(){
        waitNameOfShoeIsLoaded();
        nameShoe.clear();
        nameShoe.sendKeys(NAME_SHOE);
    }
    @Step("Step #2: Select Brand Of Shoe")
    public void selectBrandShoe(){
        fieldBrand.click();
        brandShoe.clear();
        brandShoe.sendKeys(BRAND_SHOE);
        brandShoe.sendKeys(Keys.ENTER);
    }
    @Step("Step #3: Add Model Of Shoe")
    public void addModelShoe(){
        modelShoe.clear();
        modelShoe.sendKeys(MODEL_SHOE);
    }
    @Step("Step #4: Add Cost Of Shoe")
    public void addCostShoe(){
        costShoe.clear();
        costShoe.sendKeys(COST_SHOE);
    }
    @Step("Step #5: Add Date Purchased Of Shoe")
    public void addDateShoe(){
        dateShoe.clear();
        dateShoe.sendKeys(DATE_SHOE);
    }
    @Step("Step #6: Add Distance Alert Of Shoe")
    public void addAlertShoe(){
        alertShoe.clear();
        alertShoe.click();
        alertShoe.sendKeys(ALERT_SHOE);
    }
    @Step("Step #7: Click 'Add Shoe' button")
    public void clickAddShoe() {
        addShoeButton.click();
    }
    public boolean currentShoesIsDisplayed(){
        return addedShoe.isDisplayed();
    }
    public AddNewShoePage waitNameOfShoeIsLoaded() {
        waitVisibilityOf(nameShoe);
        return this;
    }
    public AddNewShoePage waitAddedShoeIsLoaded() {
        waitVisibilityOf(addedShoe);
        return this;
    }
}
