package gui;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.BrowserActions;
import org.openqa.selenium.By;


public class LandingPage {
    //Variables
    private SHAFT.GUI.WebDriver driver;
    private final String url = "http://www.uitestingplayground.com/";

    //Constructor
    public LandingPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    //Locators
    public static By sampleAppLink(){
        return By.xpath("//a[@href='/sampleapp']");
    }
    public static By textInputLink(){
        return By.xpath("//a[@href='/textinput']");
    }
    public static By ajaxDataLink(){
        return By.xpath("//a[@href='/ajax']");
    }

    //Operations
    public void navigate(){
        BrowserActions.navigateToURL(driver.getDriver(),url);
    }

    public SampleAppPage clickOnSampleAppLink(){
        driver.element().scrollToElement(sampleAppLink())
                .click(sampleAppLink());
        return new SampleAppPage(driver);
    }
    public TextInputPage clickOnTextInputLink(){
        driver.element().click(textInputLink());
        return new TextInputPage(driver);
    }
    public AJAXDataPaga clickOnAjaxDataLink(){
        driver.element().click(ajaxDataLink());
        return new AJAXDataPaga(driver);
    }

}
