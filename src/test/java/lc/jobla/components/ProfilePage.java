package lc.jobla.components;

import lc.jobla.PageObject;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class ProfilePage extends PageObject {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="div > h3")
    private WebElement header;

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div/div[1]/div/div/span/span/div")
    private WebElement switcher;

    @FindBy(css=" .driver-clearfix.driver-popover-footer > button")
    private WebElement skipTourButton;

    public void pressButtonPublish(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", switcher);
    }

    public void pressButtonSkip(){
        skipTourButton.click();
    }

    public boolean isInitialized(){
        return header.isDisplayed();
    }

    public String confirmationHeader(){
        return header.getText();
    }
}
