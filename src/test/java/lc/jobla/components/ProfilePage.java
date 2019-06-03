package lc.jobla.components;


import lc.jobla.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;

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

    @FindBy(className = "fa fa-done")
    private WebElement popup;

    @FindBy(xpath = "//div/form//input")
    private WebElement firstName;

    @FindBy(xpath = "//form//div[2]//div[1]/input")
    private WebElement lastName;

    @FindBy(xpath = "//form//div[3]//input")
    private WebElement country;

    @FindBy(xpath = "//form//div[3]//input")
    private List<WebElement> listOfCountries;

    @FindBy(xpath = "//form//div[4]//input")
    private WebElement city;

    @FindBy(xpath = "//form//div[4]//input")
    private List<WebElement> listOfCities;

    @FindBy(xpath = "//div[1]/input[2]")
    private WebElement calendar;

    @FindBy(css = "body > div.flatpickr-calendar.animate.showTimeInput.arrowTop.open > div.flatpickr-months > div > div > div > input")
    private WebElement year;

    @FindBy(css = "body > div.flatpickr-calendar.animate.showTimeInput.arrowTop.open > div.flatpickr-months > div > div > span")
    private WebElement month;

    @FindBy(css = "body > div.flatpickr-calendar.animate.showTimeInput.arrowTop.open > div.flatpickr-months > span.flatpickr-next-month")
    private WebElement arrow;





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

    public void enterFirstName(String name){
        Actions actions = new Actions(driver);
        actions.moveToElement(firstName).build().perform();
        this.firstName.clear();
        this.firstName.sendKeys(name);
    }

    public void enterLastName(String lastname){
        Actions actions = new Actions(driver);
        actions.moveToElement(lastName).build().perform();
        this.lastName.clear();
        this.lastName.sendKeys(lastname);
    }

    public void selectCountry(String countryName){
        Actions actions = new Actions(driver);
        actions.moveToElement(country).build().perform();
        this.country.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        this.country.sendKeys(countryName);
        listOfCountries.get(0).click();
    }

    public void selectCity(String cityName){
        Actions actions = new Actions(driver);
        actions.moveToElement(city).build().perform();
        this.city.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        this.city.sendKeys(cityName);
        listOfCities.get(0).click();
    }

    public void selectDate(String yearDate, String monthDate){
        Actions action = new Actions(driver);
        action.moveToElement(calendar).click().build().perform();
        action.moveToElement(year).click().build().perform();
        this.year.sendKeys(yearDate);
        String trueMonth = month.getText();
        while (!trueMonth.equals(monthDate)){
            action.moveToElement(arrow).click().build().perform();
            trueMonth=month.getText();
        }
    }



//    public void successPopup(){
//        String alertText = " ";
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOf(popup));
//        alertText = popup.getText();
//        System.out.println(alertText);
//    }


}
