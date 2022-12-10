package gui;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SampleAppPage {
    //Variables
    private SHAFT.GUI.WebDriver driver;
    //Constructor
    public SampleAppPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    //Locators
    public static By loginStatus(){
        return By.id("loginstatus");
    }
    public static By userNameTextBox(){
        return By.name("UserName");
    }
    public static By passwordTextBox(){
        return By.name("Password");
    }
    public static By loginButton(){
        return By.id("login");
    }
    public static By homeIcon(){
        return By.xpath("//a[@href='/home']");
    }
    public static By resourcesIcon(){
        return By.xpath("//a[@href='/resources']");
    }

    //Operations

    public void typeUsername(String username){
        driver.element().type(userNameTextBox(), username);
    }
    public void typePassword(String password){
        driver.element().type(passwordTextBox(), password);
    }
    public void clickOnLoginButton(){
        driver.element().click(loginButton());
    }
   /* public By getLoginStatus(){
       return driver.element().getText(loginStatus());
    }*/

    public void keyPress(){
        driver.element().keyPress(loginButton(), Keys.ENTER);
    }

    public LandingPage clickOnHomeIcon(){
        driver.element().click(homeIcon());
        return new LandingPage(driver);
    }
    public ResourcesPage clickOnResourcesIcon(){
        driver.element().click(resourcesIcon());
        return new ResourcesPage(driver);
    }

}




