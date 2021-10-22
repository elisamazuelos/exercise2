package com.alten.selenium.pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.*;

import static com.relevantcodes.extentreports.LogStatus.FAIL;

public class JavaScriptAlertsPage {

    WebElement jsPromptButton;

    public boolean isResultDisplayed (WebDriver driver, ExtentTest test, String text) {
        try {
            jsPromptButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
            System.out.println("button was found correctly");
        } catch (NullPointerException e) {
            System.out.println("Button wasn't found");
            test.log(FAIL, "Button wasn't found");
            throw e;
        }
        jsPromptButton.click();
        Alert popUp;
        try {
            popUp = driver.switchTo().alert();
            System.out.println("Pop-up present");
        } catch (NoAlertPresentException e) {
            System.out.println("Pop-up not present");
            test.log(FAIL, "Pop-up not present");
            throw e;
        }
        try {
            popUp.sendKeys(text);
            popUp.accept();
            System.out.println("Keys sent");
        } catch (Throwable e) {
            System.out.println("Keys couldn't be sent");
            test.log(FAIL, "Keys couldn't be sent");
            throw e;
        }
        WebElement result;
        try {
            result = driver.findElement(By.id("result"));
            System.out.println("Result field appears");
        } catch (NullPointerException e) {
            System.out.println("Result field doesn't appear");
            test.log(FAIL,"Result field doesn't appear");
            throw e;
        }
        return result.getText().contains(text);
    }
}
