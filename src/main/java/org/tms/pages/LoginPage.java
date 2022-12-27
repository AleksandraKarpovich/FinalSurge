package org.tms.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//input[@id='login_name']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='login_password']")
    private WebElement password;

    @FindBy (xpath = "//button[contains(text(),'Login')]")
    private WebElement loginButton;

    @Step("Step #0: Open Start Page")
    public LoginPage openPage(String url){
        driver.get(url);
        return this;
    }
    @Step("Step #1: Fill 'Username' field")
    public LoginPage fillInUsername(String userName){
        username.clear();
        username.sendKeys(userName);
        return this;
    }
    @Step("Step #2: Fill 'Password' field")
    public LoginPage fillInPassword(String keyPassword){
        password.clear();
        password.sendKeys(keyPassword);
        return this;
    }
    @Step("Step #3: Click 'Login' button")
    public void clickLoginButton(){
        loginButton.click();
    }

}
