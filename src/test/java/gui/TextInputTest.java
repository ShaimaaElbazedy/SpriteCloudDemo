package gui;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextInputTest {
    SHAFT.GUI.WebDriver driver;
    LandingPage landingPage;
    SHAFT.TestData.JSON testData;
    TextInputPage textInputPage;
    String initialBTNtSize;
    String updatedBTNSize;
    String finalBTNSize;

    @Test(priority = 1, description = "TC1: Navigating to Text input page and verifying that it's loaded")

    public void textInputScreenNavigation() {
        landingPage.clickOnTextInputLink();
        driver.verifyThat()
                .browser()
                .title()
                .isEqualTo("Text Input")
                .perform();
    }


    @Test(priority = 2, description = "TC2: Verifying on the displayed button size and text")
    public void checkingTheDisplayedElements(){
        driver.assertThat()
                .element(textInputPage.updateTextBTN())
                .isVisible()
                .perform();
        driver.assertThat()
                .element(textInputPage.updateTextBTN())
                .text()
                .isEqualTo("Button That Should Change it's Name Based on Input Value")
                .perform();
    }

    @Test(priority = 3, description = "TC3: Checking The button size, text and its functionality before and after")
    public void checkButtonSizeAndFunctionality(){
        initialBTNtSize = textInputPage.getButtonSize();
        ElementActions.isElementClickable(driver.getDriver(), textInputPage.updateTextBTN());
        textInputPage.typeText(testData.getTestData("firstInputText"));
        textInputPage.clickOnUpdateTextButton();
        updatedBTNSize = textInputPage.getButtonSize();
        driver.assertThat()
                .element(textInputPage.updateTextBTN())
                .text()
                .isEqualTo(testData.getTestData("firstInputText"))
                .perform();
        Assert.assertNotEquals(initialBTNtSize,updatedBTNSize);
    }

    @Test(priority = 4, description = "TC4: Checking the Appending to the existing text in the text field")
    public void appendToExistingText(){
        textInputPage.appendingToExistingText(testData.getTestData("secondInputText"));
        textInputPage.clickOnUpdateTextButton();
        finalBTNSize = textInputPage.getButtonSize();
        driver.assertThat()
                .element(textInputPage.updateTextBTN())
                .text()
                .isEqualTo(testData.getTestData("firstInputText")+ testData.getTestData("secondInputText"))
                .perform();
        Assert.assertNotEquals(updatedBTNSize,finalBTNSize);
    }


    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("src/test/resources/guiTestDataFiles/testData.json");
        landingPage = new LandingPage(driver);
        landingPage.navigate();
        textInputPage = new TextInputPage(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
