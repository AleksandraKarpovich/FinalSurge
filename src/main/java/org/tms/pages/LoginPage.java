package org.tms.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPage extends BasePage{
    @FindBy(xpath = "//input[@id='login_name']")
    private WebElement username;
    @FindBy(xpath = "//input[@id='login_password']")
    private WebElement password;
    @FindBy (xpath = "//button[contains(text(),'Login')]")
    private WebElement loginButton;

    @Step("Step #0: Open Start page")
    public LoginPage openPage(String url){
        log.info("Open Start page");
        driver.get(url);
        return this;
    }
    @Step("Step #1: Fill 'Username' field")
    public LoginPage fillInUsername(String userName){
        log.info("Fill 'Username' field");
        username.clear();
        username.sendKeys(userName);
        return this;
    }
    @Step("Step #2: Fill 'Password' field")
    public LoginPage fillInPassword(String keyPassword){
        log.info("Fill 'Password' field");
        password.clear();
        password.sendKeys(keyPassword);
        return this;
    }
    @Step("Step #3: Click 'Login' button")
    public void clickLoginButton(){
        log.info("Click 'Login' button");
        loginButton.click();
    }

}
