package com.alten.selenium1.pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

import static com.relevantcodes.extentreports.LogStatus.*;

public class MultipleWindowsPage {

    WebElement clickHereButton;

    public boolean isNewWindowDisplayed (WebDriver driver, ExtentTest test) {
        String originalHandle = driver.getWindowHandle();
        try {
            clickHereButton = driver.findElement(By.cssSelector("a[href='/windows/new']"));
            System.out.println("Click here button found");
        } catch (NoSuchElementException e) {
            System.out.println("Click here button not found");
            test.log(FAIL, "Click here button not found");
            throw e;
        }
        try {
            clickHereButton.click();
            System.out.println("Click here button was clicked");
        } catch (ElementNotInteractableException e) {
            System.out.println("Couldn't interact with click here button");
            test.log(FAIL, "Couldn't interact with click here button");
        }
        WebDriver newTab;
        for(String tabHandle : driver.getWindowHandles()){
            if(!originalHandle.contentEquals(tabHandle)) {
                try {
                    newTab = driver.switchTo().window(tabHandle);
                    System.out.println("Changed tabs successfully");
                } catch (Throwable e) {
                    System.out.println("Couldn't change tabs");
                    test.log(FAIL, "Couldn't change tabs");
                    throw e;
                }
                break;
            }
        }
        WebElement textDisplayed;
        try {
            textDisplayed = driver.findElement(By.className("example"));
            System.out.println("Text found");
        } catch (NoSuchElementException e) {
            System.out.println("Text not found");
            test.log(FAIL, "Text not found");
            throw e;
        }
        return "New Window".equals(textDisplayed.getText());
    }
}
