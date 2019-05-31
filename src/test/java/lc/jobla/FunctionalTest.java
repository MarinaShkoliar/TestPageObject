package lc.jobla;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionalTest {
    protected static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

//    @After
//    public void cleanUp(){
//        if (driver != null){
//        driver.manage().deleteAllCookies();
//        }
//    }

//    @AfterClass
//    public static void tearDown(){
//        if (driver != null) {
//            driver.close();
//        }
//    }
}
