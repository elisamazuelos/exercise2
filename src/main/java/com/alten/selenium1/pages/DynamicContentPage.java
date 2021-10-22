package com.alten.selenium1.pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.relevantcodes.extentreports.LogStatus.FAIL;

public class DynamicContentPage {

    private List<WebElement> imagesDisplayed;

    public DynamicContentPage(WebDriver driver, ExtentTest test) {

        try {
            imagesDisplayed = driver.findElement(By.id("content")).findElements(By.tagName("img"));
            System.out.println("Images were correctly found");
        } catch (NullPointerException e) {
            System.out.println("Images weren't found");
            test.log(FAIL, "Images weren't found");
        }

    }

    public int getNumberOfImages (WebDriver driver) {
        System.out.println("Number of images =" + imagesDisplayed.size());
        return imagesDisplayed.size();
    }

    public boolean isImageDisplayed (WebDriver driver) {
        List<String> srcOfImages = imagesDisplayed.stream().map(i->i.getAttribute("src")).collect(Collectors.toList());
        System.out.println(srcOfImages);
        return srcOfImages.contains("http://the-internet.herokuapp.com/img/avatars/Original-Facebook-Geek-Profile-Avatar-6.jpg");
    }
}