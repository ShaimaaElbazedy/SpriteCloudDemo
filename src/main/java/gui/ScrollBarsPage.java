package gui;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ScrollBarsPage {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public  ScrollBarsPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    //Locators
    public By hiddenButton() { return By.id("hidingButton"); }

    //Operations
    public void scrollToHiddenButton(){
        driver.element().scrollToElement(hiddenButton());
    }
    public void clickOnHiddenButton(){
        driver.element().click(hiddenButton());
    }

}
