package lc.jobla.components;


import lc.jobla.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.beans.Visibility;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProfilePage extends PageObject {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    private Actions actions = new Actions(driver);

    WebDriverWait wait = new WebDriverWait(driver, 30);

    @FindBy(css="div > h3")
    private WebElement header;

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/div/div[1]/div/div/span/span/div")
    private WebElement switcher;

    @FindBy(xpath="//*[@id=\"__BVID__205___BV_modal_footer_\"]/button[1]")
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

    @FindBy(css = "body > div.flatpickr-calendar.animate.showTimeInput.open.arrowTop > div.flatpickr-months > div > div > div > input")
    private WebElement year;

    @FindBy(css = "body > div.flatpickr-calendar.animate.showTimeInput.arrowTop.open > div.flatpickr-months > div > div > select")
    private WebElement month;

    @FindBy(css = "body > div.flatpickr-calendar.animate.showTimeInput.arrowTop.open > div.flatpickr-months > span.flatpickr-next-month")
    private WebElement arrow;

    @FindBy(className = "flatpickr-day")
    private List<WebElement> days;

    @FindBy(xpath = "//form/div/div[1]/div[5]//div[1]/input")
    private WebElement tel;

    @FindBy(xpath = "//form//div[1]/div[7]//div[1]/input")
    private WebElement skype;

    @FindBy(xpath = "//*[@id=\"change-image\"]")
    private WebElement img;





    public void pressButtonPublish(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", switcher);
    }

    public void pressButtonSkip(){
        wait.until(ExpectedConditions.visibilityOf(skipTourButton));
        skipTourButton.click();
    }

    public boolean isInitialized(){
        return header.isDisplayed();
    }

    public String confirmationHeader(){
        return header.getText();
    }

    public void enterFirstName(String name){
        actions.moveToElement(firstName).build().perform();
        this.firstName.clear();
        this.firstName.sendKeys(name);
    }

    public void enterLastName(String lastname){
        actions.moveToElement(lastName).build().perform();
        this.lastName.clear();
        this.lastName.sendKeys(lastname);
    }

    public void selectCountry(String countryName){
        actions.moveToElement(country).build().perform();
        this.country.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        this.country.sendKeys(countryName);
        listOfCountries.get(0).click();
    }

    public void selectCity(String cityName){
        actions.moveToElement(city).build().perform();
        this.city.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        this.city.sendKeys(cityName);
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfCities));
        listOfCities.get(0).click();
        actions.moveToElement(firstName).click().build().perform();
    }

    private void findMonth(String monthDate){
        Select drpMonth = new Select(month);
        drpMonth.selectByVisibleText(monthDate);
    }

    private void findDay(String dayDate){
        for (WebElement a:days){
            String b = a.getText();
            if (b.equals(dayDate)){
                actions.moveToElement(a).click().build().perform();
                break;
            }
        }
    }

    public void selectDate(String yearDate, String monthDate, String dayDate){
        actions.moveToElement(calendar).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(year));
        actions.moveToElement(year).click().build().perform();
        //this.year.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        this.year.clear();
        this.year.sendKeys(yearDate);
        findMonth(monthDate);
        findDay(dayDate);
    }

    public void enterPhone(String phone){
        actions.moveToElement(tel).build().perform();
        this.tel.clear();
        this.tel.sendKeys(phone);
    }

    public void enterSkype(String nick){
        actions.moveToElement(skype).build().perform();
        this.skype.clear();
        this.skype.sendKeys(nick);
    }

    public static void setClipboardData(String string){
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public void uploadPhoto() throws IOException {
//        actions.moveToElement(img).click().build().perform();
//        driver.switchTo().activeElement().sendKeys(url);
        //img.sendKeys(url);
        File file = new File("C:\\Users\\marina.shkoliar\\Desktop\\285.jpg");
        img.click();
        //img.sendKeys("C:\\Users\\marina.shkoliar\\Desktop\\285.jpg");
        String[] commands = new String[]{};
        commands = new String[]{"C:\\Users\\marina.shkoliar\\Desktop\\new.exe"};
        Runtime.getRuntime().exec(commands);


    }



//    public void successPopup(){
//        String alertText = " ";
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOf(popup));
//        alertText = popup.getText();
//        System.out.println(alertText);
//    }


}
