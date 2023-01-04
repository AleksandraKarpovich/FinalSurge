package org.tms.utils;

import org.openqa.selenium.WebDriver;
import org.tms.driver.DriverSingleton;
import java.util.Set;


public class Switcher {

    protected WebDriver driver = DriverSingleton.getInstance().getDriver();

    public void switcherToTab() {
        String currentHandle = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();
        for (String handle : allHandles) {
            if (!handle.equals(currentHandle)) driver.switchTo().window(handle);
        }
    }
}
