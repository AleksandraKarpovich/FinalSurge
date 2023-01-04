package org.tms.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tms.utils.Waiter;

@Log4j2
public class RemoveBikePage extends BasePage{
    public Waiter waiter = new Waiter();
    @FindBy(xpath = "//input[@id='ShoeName']")
    private WebElement nameBike;
    @FindBy(xpath = "//*[@id='s2id_ShoeBrand']/a")
    private WebElement fieldBrand;
    @FindBy(xpath = "/html/body/div[19]/div/input")
    private WebElement brandBike;
    @FindBy(xpath = "//*[@id='ShoeModel']")
    private WebElement modelBike;
    @FindBy(xpath = "//*[@id='ShoeCost']")
    private WebElement costBike;
    @FindBy(xpath = "//*[@id='ShoeDate']")
    private WebElement dateBike;
    @FindBy(xpath = "//*[@id='saveButton']")
    private WebElement addBikeButton;
    @FindBy(xpath = "//a[contains(text(),'My new bike')]")
    private WebElement addedBike;
    @FindBy(xpath = "//a[@id='del-bike']")
    private WebElement removeButton;
    @FindBy(xpath = "/html/body/div[20]")
    private WebElement frameId;
    @FindBy(xpath = "//a[contains(text(),'OK')]")
    private WebElement ok;
    @FindBy(xpath = "//p[contains(text(),'You have no Current bikes. Add one now by using the Add New Bike form.')]")
    private WebElement noBikeSection;

    @Step("Step #1: Add Bike")
    public RemoveBikePage addNewBike(String NAME_BIKE,String BRAND_BIKE,
                                     String MODEL_BIKE,String COST_BIKE,String DATE_BIKE){
        log.info("Fill fields and Click 'Add Bike' button");
        nameBike.clear();
        nameBike.click();
        nameBike.sendKeys(NAME_BIKE);
        fieldBrand.click();
        brandBike.clear();
        brandBike.sendKeys(BRAND_BIKE);
        brandBike.sendKeys(Keys.ENTER);
        modelBike.clear();
        modelBike.click();
        modelBike.sendKeys(MODEL_BIKE);
        costBike.clear();
        costBike.click();
        costBike.sendKeys(COST_BIKE);
        dateBike.clear();
        dateBike.click();
        dateBike.sendKeys(DATE_BIKE);
        addBikeButton.click();
        return this;
    }
    @Step("Step #2: Remove Bike")
    public RemoveBikePage removeNewBike(){
        log.info("Remove Bike");
        addedBike.click();
        removeButton.click();
        waiter.waitVisibilityOf(ok);
        ok.click();
        return this;
    }
    @Step("Step #3: Received actual result")
    public String noBikeText(){
        log.info("Received actual result");
        return noBikeSection.getText();
    }
}
