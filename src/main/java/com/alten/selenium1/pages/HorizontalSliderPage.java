package com.alten.selenium1.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.relevantcodes.extentreports.LogStatus.*;

public class HorizontalSliderPage {

    WebElement slider;

    public void moveHorizontalSlider (WebDriver driver, ExtentTest test) {

        try {
            slider = driver.findElement(By.className("sliderContainer")).findElement(By.tagName("input"));
            System.out.println("Slider was correctly found");
        } catch (NullPointerException e) {
            System.out.println("Slider wasn't found");
            test.log(FAIL, "Slider wasn't found");
            throw e;
        }
        float sliderWidth = slider.getSize().getWidth();
        try {
            Actions action = new Actions(driver);
            action.clickAndHold(slider);
            // Since the slider's max value is 5, we want to go to 4.5 and clickAndHold starts in the middle of the slider's range:
            action.moveByOffset((int) (0.4 * sliderWidth), 0);
            action.release().perform();
            System.out.println("Slider moved as expected");
            test.log(PASS, "Slider moved as expected");
        } catch (Exception e) {
            System.out.println("Slider didn't move as expected");
            test.log(FAIL, "Slider didn't move as expected");
            throw e;
        }
    }
}
