package gui;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class SampleAppTest {
    SHAFT.GUI.WebDriver driver;
    LandingPage landingPage;
    SampleAppPage sampleAppPage;
    SHAFT.TestData.JSON testData;


    @Test(priority = 1, description = "TC1: Navigating to SampleApp page and Asserting on initial login status")
    public void verifyingOnSampleAppScreen() {
        landingPage.clickOnSampleAppLink();
        driver.verifyThat()
                .browser()
                .title()
                .isEqualTo("Sample App")
                .perform();
        driver.assertThat()
                .element(sampleAppPage.loginStatus())
                .text()
                .isEqualTo("User logged out.")
                .perform();
    }

    @Test(priority = 2, description = "TC2: Login with valid credentials then logout")
    public void loginWithValidCredentials() {
            sampleAppPage.typeUsername(testData.getTestData("userName"));
            sampleAppPage.typePassword(testData.getTestData("password"));
            sampleAppPage.clickOnLoginButton();
            driver.assertThat()
                    .element(sampleAppPage.loginStatus())
                    .text()
                    .isEqualTo("Welcome, " + testData.getTestData("userName") + "!")
                    .perform();


            sampleAppPage.clickOnLoginButton();
            driver.assertThat()
                    .element(sampleAppPage.loginStatus())
                    .text()
                    .isEqualTo("User logged out.")
                    .perform();
        }

    @Test(priority = 3, description = "TC3: Testing Home icon functionality")
    public void navigateToHomeScreen(){
            sampleAppPage.clickOnHomeIcon();
            driver.verifyThat()
                    .browser()
                    .title()
                    .isEqualTo("UI Test Automation Playground")
                    .perform();
        }

    @Test(priority = 4, description = "TC4: Login with invalid credentials")
    public void loginWithInvalidCredentials(){
        landingPage.clickOnSampleAppLink();
        sampleAppPage.typeUsername(testData.getTestData("userName"));
        sampleAppPage.typePassword(testData.getTestData("invalidPassword"));
        sampleAppPage.clickOnLoginButton();
        driver.assertThat()
                .element(sampleAppPage.loginStatus())
                .text()
                .isEqualTo("Invalid username/password")
                .perform();
    }

    @Test(priority = 5, description = "TC5: Mimicking ENTER keyboard button instead of clicking on login button")
    public void testingKeyPress(){
        sampleAppPage.typeUsername(testData.getTestData("userName"));
        sampleAppPage.typePassword(testData.getTestData("password"));
        sampleAppPage.keyPress();
        driver.assertThat()
                .element(sampleAppPage.loginStatus())
                .text()
                .isEqualTo("Welcome, " + testData.getTestData("userName")+"!")
                .perform();
    }

    @Test(priority = 6, description = "TC6: Testing resources icon functionality")
    public void navigateToResourcesScreen(){
        sampleAppPage.clickOnResourcesIcon();
        driver.verifyThat()
                .browser()
                .title()
                .isEqualTo("Resources")
                .perform();
    }


    @BeforeClass
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("src/test/resources/guiTestDataFiles/testData.json");
        landingPage = new LandingPage(driver);
        sampleAppPage = new SampleAppPage(driver);
        landingPage.navigate();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}