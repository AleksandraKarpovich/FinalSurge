package org.tms.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class RemoveBikePage extends BasePage{
    private static final String NAME_BIKE = "My new bike";
    private static final String BRAND_BIKE = "Felt";
    private static final String MODEL_BIKE = "for Man";
    private static final String COST_BIKE = "1500";
    private static final String DATE_BIKE = "12/06/2022";
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
    public void addNewBike(){
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
    }
    @Step("Step #2: Remove Bike")
    public void removeNewBike(){
        log.info("Remove Bike");
        addedBike.click();
        removeButton.click();
        waitOkIsLoaded();
        ok.click();
    }
    public RemoveBikePage waitOkIsLoaded() {
        waitVisibilityOf(ok);
        return this;
    }
    public String noBikeText(){
        return noBikeSection.getText();
    }
}
