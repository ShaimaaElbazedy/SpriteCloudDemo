package gui;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TextInputPage {
    //Variables
    private SHAFT.GUI.WebDriver driver;
    //Constructor
    public TextInputPage( SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    //Locators
    public static By updateTextBTN(){
        return By.id("updatingButton");
    }
    public static By updateTextField(){
        return By.id("newButtonName");
    }
    //Operations
    public void typeText(String text){
        driver.element().type(updateTextField(),text);
    }
    public void clickOnUpdateTextButton(){
        ElementActions.click(driver.getDriver(), updateTextBTN());
    }
    public String getButtonSize(){
        return driver.element().getSize(driver.getDriver(),updateTextBTN());
    }

    public void appendingToExistingText(String newText){
        driver.element().typeAppend(updateTextField(),newText);

    }

}
