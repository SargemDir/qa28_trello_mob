package com.elena.mob.framework;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePage extends  HelperBase{
    public WelcomePage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isHelloPresent() {
        return isElementPresent(By.xpath("//*[@text='Hello Trello!']"));
    }

    public void initLogin(){
        click(By.id("log_in_button"));
    }
}
