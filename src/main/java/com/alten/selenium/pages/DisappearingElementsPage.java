package com.alten.selenium.pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

import static com.relevantcodes.extentreports.LogStatus.*;

public class DisappearingElementsPage {

    List<WebElement> buttons;

    public DisappearingElementsPage(WebDriver driver, ExtentTest test) {
        try {
            buttons = driver.findElement(By.tagName("ul")).findElements(By.tagName("a"));
            System.out.println("Buttons were found correctly");
        } catch (NoSuchElementException e) {
            System.out.println("Buttons weren't found");
            test.log(FAIL, "Buttons weren't found");
            throw e;
        }
    }

    public boolean hasUnclickedButton(List<String> clickedButtons) {
        return buttons.stream().map(WebElement::getText).anyMatch(b -> !clickedButtons.contains(b));
    }

    public void clickFirst(List<String> clickedButtons, ExtentTest test) {
        WebElement firstUnclickedButton = buttons.stream().filter(b -> !clickedButtons.contains(b.getText())).findFirst().orElse(null);
        if (firstUnclickedButton != null){
            clickedButtons.add(firstUnclickedButton.getText());
            try {
                firstUnclickedButton.click();
                System.out.println("The button was clicked");
            } catch (ElementNotInteractableException e) {
                System.out.println("Couldn't interact with button");
                test.log(FAIL, "Couldn't interact with button");
                throw e;
            }
        }
    }
}
