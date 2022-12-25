package org.tms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage{
    @FindBy(xpath = "//strong[contains(text(), 'You have been successfully logged out of the system.')]")
    private WebElement textOfLogout;

    public String getTextOfLogout(){
        return textOfLogout.getText();
    }
}
