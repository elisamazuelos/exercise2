package com.alten.selenium1.pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.bson.assertions.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.relevantcodes.extentreports.LogStatus.*;

import java.util.List;
import java.util.NoSuchElementException;

public class CheckboxesPage {

    WebElement checkBoxForm;
    List<WebElement> allCheckBoxes;

    public void checkTheBoxes(WebDriver driver, ExtentTest test) {
        try {
            checkBoxForm = driver.findElement(By.id("checkboxes"));
            allCheckBoxes = checkBoxForm.findElements(By.tagName("input"));
            System.out.println("The checkboxes were found");
        } catch (NoSuchElementException e) {
            System.out.println("The checkboxes weren't found");
            test.log(FAIL, "The checkboxes weren't found");
            throw e;
        }
            for (WebElement checkBox : allCheckBoxes) {
                if (!checkBox.isSelected()) {
                    try {
                        checkBox.click();
                        System.out.println("Boxes were checked correctly");
                        test.log(PASS, "Boxes were checked correctly");
                    } catch (ElementNotInteractableException e) {
                        System.out.println("Couldn't interact with boxes");
                        test.log(FAIL, "Couldn't interact with boxes");
                    }
                }

            }
    }
}
