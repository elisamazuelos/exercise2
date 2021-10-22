package com.alten.selenium.pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static com.relevantcodes.extentreports.LogStatus.*;

public class DynamicControlsPage {

    WebElement removeButton;
    WebElement addButton;
    WebElement box;

    public void clickOnRemoveButton (WebDriver driver, ExtentTest test) {

        try{
            removeButton = driver.findElement(By.xpath("//button[normalize-space()='Remove']"));
            System.out.println("Remove button found correctly");
        } catch (NoSuchElementException e) {
            System.out.println("Remove button not found");
            test.log(FAIL, "Remove button not found");
            throw e;
        }
        try {
            removeButton.click();
            System.out.println("Remove button clicked");
        } catch (ElementNotInteractableException e) {
            System.out.println("Couldn't interact with remove button");
            test.log(FAIL, "Couldn't interact with remove button");
            throw e;
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void clickOnAddButton (WebDriver driver, ExtentTest test) {
        try {
            addButton = driver.findElement(By.xpath("//button[normalize-space()='Add']"));
            System.out.println("Add button found correctly");
        } catch (NoSuchElementException e) {
            System.out.println("Add button not found");
            test.log(FAIL, "Add button not found");
            throw e;
        }
        try {
            addButton.click();
            System.out.println("Add button clicked");
        } catch (ElementNotInteractableException e) {
            System.out.println("Couldn't interact with add button");
            test.log(FAIL, "Couldn't interact with add button");
            throw e;
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void checkTheBox (WebDriver driver, ExtentTest test) {
        try {
            box = driver.findElement(By.id("checkbox"));
            System.out.println("Checkbox found correctly");
        } catch (NoSuchElementException e) {
            System.out.println("Checkbox wasn't found");
            test.log(FAIL, "Checkbox wasn't found");
            throw e;
        }
        try {
            box.click();
            test.log(PASS, "The box was checked");
        } catch (ElementNotInteractableException e) {
            System.out.println("Couldn't interact with checkbox");
            test.log(FAIL, "Couldn't interact with checkbox");
        }
    }

}
