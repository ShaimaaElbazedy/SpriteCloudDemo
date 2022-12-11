package gui;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScrollBarsTest {
    SHAFT.GUI.WebDriver driver;
    LandingPage landingPage;
    ScrollBarsPage scrollBarsPage;

    @Test(description = "Scrolling to the hidden button, verifying that it's displayed")
    public void checkOnHiddenButton(){
        landingPage.clickOnScrollBarsLink();
        driver.verifyThat()
                .browser()
                .title()
                .isEqualTo("Scrollbars")
                .perform();
        scrollBarsPage.scrollToHiddenButton();
        driver.verifyThat()
                .element(scrollBarsPage.hiddenButton())
                .isVisible()
                .perform();
        driver.verifyThat()
                .element(scrollBarsPage.hiddenButton())
                .isEnabled()
                .perform();
        scrollBarsPage.clickOnHiddenButton();

    }



    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
        landingPage = new LandingPage(driver);
        scrollBarsPage = new ScrollBarsPage(driver);
        landingPage.navigate();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
