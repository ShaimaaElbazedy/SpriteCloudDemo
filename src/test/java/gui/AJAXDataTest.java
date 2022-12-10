package gui;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AJAXDataTest {
    SHAFT.GUI.WebDriver driver;
    LandingPage landingPage;
    SHAFT.TestData.JSON testData;
    AJAXDataPaga ajaxDataPage;

    @Test(priority = 1, description = "TC1: Navigating to AJAX data page and verifying that it's loaded")
    public void navigateToAjaxDataPage(){
        landingPage.clickOnAjaxDataLink();
        driver.verifyThat()
                .browser()
                .title()
                .isEqualTo("AJAX Data")
                .perform();
    }

    @Test(priority = 2, description = ("TC2: Verifying on button functionality and spin loader"))
    public void checkButtonAndLoaderBehavior()  {
        driver.assertThat()
                .element(ajaxDataPage.ajaxButton())
                .isEnabled()
                .perform();
        driver.assertThat().element(ajaxDataPage.ajaxData1())
                .doesNotExist()
                .perform();
        ajaxDataPage.clickOnAjaxButton();
        driver.assertThat()
                .element(ajaxDataPage.spinLoader())
                .isVisible()
                .perform();
        driver.assertThat()
                .element(ajaxDataPage.ajaxData1())
                .isVisible()
                .perform();
        driver.assertThat()
                .element(ajaxDataPage.ajaxData1())
                .text()
                .isEqualTo("Data loaded with AJAX get request.")
                .perform();
    }

    @Test(priority = 3,description = "TC3: Checking the behavior when hitting the button twice consecutively")
    public void hittingTheButtonTwice(){
        driver.assertThat().element(ajaxDataPage.ajaxData2())
                .doesNotExist()
                .perform();
        driver.assertThat().element(ajaxDataPage.ajaxData3())
                .doesNotExist()
                .perform();
        ajaxDataPage.clickOnAjaxButton();
        ajaxDataPage.clickOnAjaxButton();
        driver.assertThat()
                .element(ajaxDataPage.ajaxData2())
                .text()
                .isEqualTo("Data loaded with AJAX get request.")
                .perform();
        driver.assertThat()
                .element(ajaxDataPage.ajaxData3())
                .text()
                .isEqualTo("Data loaded with AJAX get request.")
                .perform();
    }


    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("src/test/resources/guiTestDataFiles/testData.json");
        landingPage = new LandingPage(driver);
        landingPage.navigate();
        ajaxDataPage = new AJAXDataPaga(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
