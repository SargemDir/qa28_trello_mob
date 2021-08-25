package com.elena.mob.framework;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationManager {
    AppiumDriver driver;
    DesiredCapabilities capabilities;
    WelcomePage welcomeActivity;
    LoginPage loginActivity;

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "qa_26");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "com.trello");
        capabilities.setCapability("appActivity", ".home.HomeActivity");
        capabilities.setCapability("app", "C:/Users/Elena/Documents/GitHub/qa28_trello_mob/apk/Trello_new.apk");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        welcomeActivity = new WelcomePage(driver);
        loginActivity = new LoginPage(driver);
    }

    public WelcomePage welcomeActivity() {
        return welcomeActivity;
    }

    public LoginPage loginActivity() {
        return loginActivity;
    }

    public void stop() {
        driver.quit();
    }
}
