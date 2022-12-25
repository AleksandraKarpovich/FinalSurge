package org.tms.pages;

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

    public void addNewShoe() {
        waitNameOfShoeIsLoaded();
        nameShoe.clear();
        nameShoe.click();
        nameShoe.sendKeys(NAME_SHOE);
        fieldBrand.click();
        brandShoe.clear();
        brandShoe.sendKeys(BRAND_SHOE);
        brandShoe.sendKeys(Keys.ENTER);
        modelShoe.clear();
        modelShoe.click();
        modelShoe.sendKeys(MODEL_SHOE);
        costShoe.clear();
        costShoe.click();
        costShoe.sendKeys(COST_SHOE);
        dateShoe.clear();
        dateShoe.click();
        dateShoe.sendKeys(DATE_SHOE);
        alertShoe.clear();
        alertShoe.click();
        alertShoe.sendKeys(ALERT_SHOE);
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
