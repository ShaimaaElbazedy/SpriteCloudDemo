package gui;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LandingPageTest {

    SHAFT.GUI.WebDriver driver;
    LandingPage landingPage ;

    @Test
    public void verifyOnWebsiteTitle(){
        driver.verifyThat().browser().title().isEqualTo("UI Test Automation Playground").perform();
    }

    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
       landingPage = new LandingPage(driver);
       landingPage.navigate();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
