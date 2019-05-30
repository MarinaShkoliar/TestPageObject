package lc.jobla;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageObject{

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="div > h3")
    private WebElement header;

    public boolean isInitialized(){
        return header.isDisplayed();
    }

    public String confirmationHeader(){
        return header.getText();
    }
}
