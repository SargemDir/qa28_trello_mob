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

    public String getTitle() {
return driver.findElement(By.id("text")).getText();
    }

    public boolean isLoginButtonPresent() {
        return isElementPresent(By.id("log_in_buttonn"));
    }

    public boolean isSignUpButtonPresent() {
        return isElementPresent(By.id("sign_up_button"));
    }

    public void swipePageToTheLeft() {
        swipeToTheLeft(By.id("action_bar_root"));
    }

}
