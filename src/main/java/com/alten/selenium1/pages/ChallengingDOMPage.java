package com.alten.selenium1.pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

import static com.relevantcodes.extentreports.LogStatus.*;

public class ChallengingDOMPage {

    List<WebElement> pageButtons;
    WebElement table;

    public void clickFooButton (WebDriver driver, ExtentTest test) {
        try {
            pageButtons = driver.findElement(By.cssSelector(".large-2.columns")).findElements(By.tagName("a"));
            System.out.println("Buttons were found");
        } catch (NoSuchElementException e) {
            System.out.println("Buttons weren't found");
            test.log(FAIL, "Buttons weren't found");
            throw e;
        }
        boolean isFooClicked = false;
        for(WebElement button : pageButtons) {
            if("foo".equals(button.getText())) {
                try {
                    button.click();
                    System.out.println("Foo button was clicked");
                } catch (ElementNotInteractableException e) {
                    System.out.println("Couldn't interact with foo button");
                    test.log(FAIL, "Couldn't interact with foo button");
                    throw e;
                }
                isFooClicked = true;
                break;
            }
        }
        if (!isFooClicked){
            for(WebElement button : pageButtons) {
                if("baz".equals(button.getText())){
                    try {
                        button.click();
                        System.out.println("Baz button was clicked");
                    } catch (ElementNotInteractableException e) {
                        System.out.println("Couldn't interact with baz button");
                        test.log(FAIL, "Couldn't interact with baz button");
                        throw e;
                    }
                    break;
                }
            }
        }
    }

    public void goThroughTable (WebDriver driver, ExtentTest test){
        try {
            table = driver.findElement(By.tagName("table"));
            System.out.println("The table was found");
        } catch (NoSuchElementException e) {
            System.out.println("The table wasn't found");
            test.log(FAIL, "The table wasn't found");
            throw e;
        }
        for(WebElement row : table.findElements(By.tagName("tr"))){
            System.out.println(row.getText());
        }
        test.log(PASS, "The table was printed");
    }

}
