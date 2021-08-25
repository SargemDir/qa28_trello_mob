package com.elena.mob.framework;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class HelperBase {
    AppiumDriver driver;

    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }
    public void waitForElementAndClick(By locator, int time) {
        new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(locator)).click();
       // wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if(text!=null){
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void openTabAndSwitchToIt() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.open()");

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.navigate().to("https://google.com");
        Thread.sleep(10000);
    }

    public void attachFile(By locator, File file) {
       // if(file.!=null){
            driver.findElement(locator).sendKeys(file.getAbsolutePath());
     //   }
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean isElementDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public boolean waitForElementPresent(By locator, int timeOut) {
        return new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)).size() > 0;
    }

    public boolean waitForElementPresentTryCatch(By locator, int timeOut) {
        try {
            waitForElement(locator, timeOut);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public void waitForElement(By locator, int timeOut) {
        new WebDriverWait(driver, timeOut)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickOnPlusButton() {
        click(By.xpath("//*[@data-test-id='header-create-menu-button']"));
    }

    public void returnToHomePage() {
        waitForElement(By.cssSelector("[data-test-id*=header-home]"), 30);
        click(By.cssSelector("[data-test-id*=header-home]"));
    }

    public void confirmAction() {
        click(By.cssSelector(".js-confirm"));
    }

    public void selectFromDropDownByIndex(By locator, int index){
        new Select(driver.findElement(locator)).selectByIndex(index);

    }

    public void selectFromDropDownByText(By locator, String text){
        new Select(driver.findElement(locator)).selectByVisibleText(text);
    }

}
