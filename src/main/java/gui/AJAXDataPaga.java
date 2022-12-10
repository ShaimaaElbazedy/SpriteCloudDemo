package gui;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class AJAXDataPaga {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public AJAXDataPaga(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    //Locators
    public  By spinLoader(){
        return By.id("spinner");
    }
    public  By ajaxButton(){
        return By.id("ajaxButton");
    }
    public  By ajaxData1(){
        return By.xpath("//*[@id='content']/*[1]");
    }
    public  By ajaxData2(){
        return By.xpath("//*[@id='content']/*[2]");
    }
    public  By ajaxData3(){
        return By.xpath("//*[@id='content']/*[3]");
    }


    //Operations
    public void clickOnAjaxButton(){
        ElementActions.click(driver.getDriver(), ajaxButton());
    }
}



