package com.alten.selenium.pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

import static com.relevantcodes.extentreports.LogStatus.*;

public class HomePage {

    WebElement checkBoxesButton;
    WebElement dynamicContentButton;
    WebElement horizontalSliderButton;
    WebElement javaScriptAlertsButton;
    WebElement dynamicControlsButton;
    WebElement disappearingElementsButton;
    WebElement challengingDOMButton;
    WebElement multipleWindowsButton;

    public void goToHome (WebDriver driver, ExtentTest test){
        try {
            driver.get("http://the-internet.herokuapp.com/");
        } catch (Throwable e) {
            test.log(FAIL, "Page couldn't be accessed");
            throw e;
        }
        driver.manage().window().maximize();
    }

    // Test 1:
    public void clickOnCheckBoxes (WebDriver driver, ExtentTest test){
        try {
            checkBoxesButton = driver.findElement(By.cssSelector("a[href='/checkboxes']"));
        } catch (NoSuchElementException e) {
            test.log(FAIL, "Link not found");
            throw e;
        }
        try {
            checkBoxesButton.click();
        } catch (ElementNotInteractableException e) {
            test.log(FAIL,"Couldn't interact with link");
            throw e;
        }
    }

    // Test 2:
    public void clickOnDynamicContent (WebDriver driver, ExtentTest test){
        try {
            dynamicContentButton = driver.findElement(By.cssSelector("a[href='/dynamic_content']"));
        } catch (NoSuchElementException e) {
            test.log(FAIL, "Link not found");
            throw e;
        }
        try {
            dynamicContentButton.click();
        } catch (ElementNotInteractableException e) {
            test.log(FAIL, "Couldn't interact with link");
            throw e;
        }
    }

    // Test 3:
    public void clickOnHorizontalSlider (WebDriver driver, ExtentTest test){
        try {
            horizontalSliderButton = driver.findElement(By.cssSelector("a[href='/horizontal_slider']"));
        } catch (NoSuchElementException e) {
            test.log(FAIL, "Link not found");
        }
        try {
            horizontalSliderButton.click();
        } catch (ElementNotInteractableException e) {
            test.log(FAIL, "Couldn't interact with link");
            throw e;
        }
    }

    // Test 4:
    public void clickOnJavaScriptAlerts (WebDriver driver, ExtentTest test){
        try {
            javaScriptAlertsButton = driver.findElement(By.cssSelector("a[href='/javascript_alerts']"));
        } catch (NoSuchElementException e) {
            test.log(FAIL, "Link not found");
        }
        try {
            javaScriptAlertsButton.click();
        } catch (ElementNotInteractableException e) {
            test.log(FAIL, "Couldn't interact with link");
            throw e;
        }
    }

    // Test 5:
    public void clickOnDynamicControls (WebDriver driver, ExtentTest test){
        try {
            dynamicControlsButton = driver.findElement(By.cssSelector("a[href='/dynamic_controls']"));
        } catch (NoSuchElementException e) {
            test.log(FAIL, "Link not found");
            throw e;
        }
        try {
            dynamicControlsButton.click();
        } catch (ElementNotInteractableException e) {
            test.log(FAIL, "Couldn't interact with link");
            throw e;
        }
    }

    // Test 6:
    public void clickOnDisappearingElements (WebDriver driver, ExtentTest test){
        try {
            disappearingElementsButton = driver.findElement(By.cssSelector("a[href='/disappearing_elements']"));
        } catch (NoSuchElementException e) {
            test.log(FAIL, "Link not found");
            throw e;
        }
        try {
            disappearingElementsButton.click();
        } catch (ElementNotInteractableException e) {
            test.log(FAIL, "Couldn't interact with link");
            throw e;
        }
    }

    // Test 7:
    public void clickOnChallengingDOM (WebDriver driver, ExtentTest test){
        try {
            challengingDOMButton = driver.findElement(By.cssSelector("a[href='/challenging_dom']"));
        } catch (NoSuchElementException e) {
            test.log(FAIL, "Link not found");
            throw e;
        }
        try {
            challengingDOMButton.click();
        } catch (ElementNotInteractableException e) {
            test.log(FAIL, "Couldn't interact with link");
            throw e;
        }
    }

    // Test 8:
    public void clickOnMultipleWindows (WebDriver driver, ExtentTest test){
        try {
            multipleWindowsButton = driver.findElement(By.cssSelector("a[href='/windows']"));
        } catch (NoSuchElementException e) {
            test.log(FAIL, "Link not found");
            throw e;
        }
        try {
            multipleWindowsButton.click();
        } catch (ElementNotInteractableException e) {
            test.log(FAIL, "Couldn't interact with link");
            throw e;
        }
    }

}
