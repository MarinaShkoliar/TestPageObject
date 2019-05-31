package lc.jobla.components;


import lc.jobla.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends PageObject {

    @FindBy(css="#__BVID__57")
    private WebElement email;

    @FindBy(css="#__BVID__58")
    private WebElement password;

    @FindBy(css=".job-login-component__btn > button")
    private WebElement submit;

    @FindBy(css="div.col-sm-2 > div > button")
    private WebElement cookie;

    public Login(WebDriver driver){
        super(driver);
    }

    public void enterEmail(String email){
        this.email.clear();
        this.email.sendKeys(email);
    }

    public void enterPassword(String password){
        this.password.clear();
        this.password.sendKeys(password);
    }

    public ProfilePage pressButtonSubmit(){
        submit.click();
        return new ProfilePage(driver);
    }

    public void pressButtonCookie(){
        cookie.click();
    }

    @FindBy(css="div.job-login-component__title")
    private WebElement header;

    public boolean isInitialized(){
        return header.isDisplayed();
    }




}
