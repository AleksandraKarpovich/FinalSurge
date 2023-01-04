package org.tms.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Log4j2
public class LogoutPage extends BasePage{
    @FindBy(xpath = "//strong[contains(text(), 'You have been successfully logged out of the system.')]")
    private WebElement textOfLogout;
    @Step("Step #2: Received actual result")
    public String getTextOfLogout(){
        log.info("Received actual result");
        return textOfLogout.getText();
    }
}
