package com.alten.selenium1;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.alten.selenium1.pages.*;

import java.util.ArrayList;
import java.util.List;

import static com.relevantcodes.extentreports.LogStatus.*;
import static org.junit.jupiter.api.Assertions.*;

public class RunTest {

    // Extent Report
    static ExtentTest test;
    static ExtentReports report;

    private WebDriver driver;
    HomePage homePage = new HomePage();

    @BeforeAll
    static void setUpTest() {
        WebDriverManager.chromedriver().setup();
        // user.dir needs to be modified in POM
        report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        homePage.goToHome(driver, test);
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterAll
    public static void endTest() {
        report.endTest(test);
        report.flush();
    }

    @Test
    @DisplayName("Test 1: checkboxes")
    void checkBoxesTest() {

        test = report.startTest("checkBoxesTest");

        homePage.clickOnCheckBoxes(driver, test);
        CheckboxesPage checkboxesPage = new CheckboxesPage();

        checkboxesPage.checkTheBoxes(driver, test);

    }

    @Test
    @DisplayName("Test 2: dynamic content")
    void dynamicContentTest() {

        test = report.startTest("dynamicContentTest");

        homePage.clickOnDynamicContent(driver, test);
        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver, test);

        try {
            assertEquals(3, dynamicContentPage.getNumberOfImages(driver));
            test.log(PASS, "There are three images displayed");
        } catch (AssertionError e) {
            test.log(FAIL, "The number of images displayed isn't three");
            throw e;
        }

        try {
            assertTrue((dynamicContentPage.isImageDisplayed(driver)));
            test.log(PASS, "The image appears");
        } catch (AssertionError e) {
            test.log(FAIL, "The image doesn't appear");
        }
    }

    @Test
    @DisplayName("Test 3: horizontal slider")
    void horizontalSliderTest() {

        test = report.startTest("horizontalSliderTest");

        homePage.clickOnHorizontalSlider(driver, test);
        HorizontalSliderPage horizontalSliderPage = new HorizontalSliderPage();

        horizontalSliderPage.moveHorizontalSlider(driver, test);

    }

    @Test
    @DisplayName("Test 4: JavaScript alerts")
    void javaScriptAlertsTest() {

        test = report.startTest("javaScriptAlertsTest");

        homePage.clickOnJavaScriptAlerts(driver, test);
        JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();

        try {
            assertTrue(javaScriptAlertsPage.isResultDisplayed(driver, test, "hola"));
            test.log(PASS, "Text input in alert displayed correctly");
        } catch (AssertionError e) {
            test.log(FAIL, "Text input in alert isn't displayed correctly");
        }

    }

    @Test
    @DisplayName("Test 5: dynamic controls")
    void dynamicControlsTest() {

        test = report.startTest("dynamicControlsTest");

        homePage.clickOnDynamicControls(driver, test);
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();

        dynamicControlsPage.clickOnRemoveButton(driver, test);
        dynamicControlsPage.clickOnAddButton(driver, test);
        dynamicControlsPage.checkTheBox(driver, test);

    }

    @Test
    @DisplayName("Test 6: disappearing elements")
    void disappearingElementsTest() {

        test = report.startTest("disappearingElementsTest");

        homePage.clickOnDisappearingElements(driver, test);
        List<String> clickedButtons = new ArrayList<>();
        DisappearingElementsPage disappearingElementsPage = new DisappearingElementsPage(driver, test);

        while (disappearingElementsPage.hasUnclickedButton(clickedButtons)) {
            disappearingElementsPage.clickFirst(clickedButtons, test);
            homePage.goToHome(driver, test);
            homePage.clickOnDisappearingElements(driver, test);
            disappearingElementsPage = new DisappearingElementsPage(driver, test);
        }
        test.log(PASS, "All buttons were clicked");

    }

    @Test
    @DisplayName("Test 7: challenging DOM")
    void challengingDOMTest() {

        test = report.startTest("challengingDOMTest");

        homePage.clickOnChallengingDOM(driver, test);
        ChallengingDOMPage challengingDOMPage = new ChallengingDOMPage();

        challengingDOMPage.clickFooButton(driver, test);
        challengingDOMPage.goThroughTable(driver, test);

    }

    @Test
    @DisplayName("Test 8: multiple windows")
    void multipleWindowsTest() {

        test = report.startTest("multipleWindowsTest");

        homePage.clickOnMultipleWindows(driver, test);
        MultipleWindowsPage multipleWindowsPage = new MultipleWindowsPage();

        try {
            assertTrue(multipleWindowsPage.isNewWindowDisplayed(driver, test));
            test.log(PASS, "Text matched in new window");
        } catch (AssertionError e) {
            test.log(FAIL, "Text doesn't match in new window");
        }

    }

}
