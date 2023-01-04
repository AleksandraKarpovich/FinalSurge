package org.tms.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tms.utils.Waiter;

@Log4j2
public class AddNewShoePage extends BasePage{
    public Waiter waiter = new Waiter();

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
    @FindBy (xpath = "//a[contains(text(),'New Balance Snickers')]")
    private WebElement addedShoe;

    @Step("Step #1: Add Name Of Shoe")
    public AddNewShoePage addNameShoe(String NAME_SHOE){
        waiter.waitVisibilityOf(nameShoe);
        log.info("Add Name Of Shoe");
        nameShoe.clear();
        nameShoe.sendKeys(NAME_SHOE);
        return this;
    }
    @Step("Step #2: Select Brand Of Shoe")
    public AddNewShoePage selectBrandShoe(String BRAND_SHOE){
        log.info("Select Brand Of Shoe");
        fieldBrand.click();
        brandShoe.clear();
        brandShoe.sendKeys(BRAND_SHOE);
        brandShoe.sendKeys(Keys.ENTER);
        return this;
    }
    @Step("Step #3: Add Model Of Shoe")
    public AddNewShoePage addModelShoe(String MODEL_SHOE){
        log.info("Add Model Of Shoe");
        modelShoe.clear();
        modelShoe.sendKeys(MODEL_SHOE);
        return this;
    }
    @Step("Step #4: Add Cost Of Shoe")
    public AddNewShoePage addCostShoe(String COST_SHOE){
        log.info("Add Cost Of Shoe");
        costShoe.clear();
        costShoe.sendKeys(COST_SHOE);
        return this;
    }
    @Step("Step #5: Add Date Purchased Of Shoe")
    public AddNewShoePage addDateShoe(String DATE_SHOE){
        log.info("Add Date Purchased Of Shoe");
        dateShoe.clear();
        dateShoe.sendKeys(DATE_SHOE);
        return this;
    }
    @Step("Step #6: Add Distance Alert Of Shoe")
    public AddNewShoePage addAlertShoe(String ALERT_SHOE){
        log.info("Add Distance Alert Of Shoe");
        alertShoe.clear();
        alertShoe.sendKeys(ALERT_SHOE);
        return this;
    }
    @Step("Step #7: Click 'Add Shoe' button")
    public void clickAddShoe() {
        log.info("Click 'Add Shoe' button");
        addShoeButton.click();
        waiter.waitVisibilityOf(addedShoe);
    }
    @Step("Step #8: Received actual result")
    public boolean currentShoesIsDisplayed(){
        log.info("Received actual result");
        return addedShoe.isDisplayed();
    }

}
