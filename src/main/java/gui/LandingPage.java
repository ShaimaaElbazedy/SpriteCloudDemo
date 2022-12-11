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
    public  By sampleAppLink(){
        return By.xpath("//a[@href='/sampleapp']");
    }
    public  By textInputLink(){
        return By.xpath("//a[@href='/textinput']");
    }
    public  By ajaxDataLink(){
        return By.xpath("//a[@href='/ajax']");
    }
    public By scrollBarsLink() { return By.xpath("//a[@href='/scrollbars']"); }



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
    public ScrollBarsPage clickOnScrollBarsLink() {
        driver.element().scrollToElement(scrollBarsLink())
                .click(scrollBarsLink());
        return new ScrollBarsPage(driver);
    }

}
