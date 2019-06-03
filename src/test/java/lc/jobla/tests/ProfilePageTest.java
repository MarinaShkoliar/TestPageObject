package lc.jobla.tests;
import lc.jobla.FunctionalTest;
import lc.jobla.components.Login;
import lc.jobla.components.ProfilePage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProfilePageTest extends FunctionalTest {



    @Before
    public void loginToJobla(){
        driver.get("http://jobla.lc/login");

        Login loginPage = new Login(driver);
        assertTrue(loginPage.isInitialized());

        loginPage.pressButtonCookie();

        loginPage.enterEmail("filobokaya@gmail.com");
        loginPage.enterPassword("123qwerty");
        loginPage.pressButtonSubmit();

    }

    @Test
    public void unpublishProfile(){

        ProfilePage profilePage = new ProfilePage(driver);
        assertTrue(profilePage.isInitialized());

        assertEquals("Profile", profilePage.confirmationHeader());

        profilePage.pressButtonSkip();



        //profilePage.successPopup();

        profilePage.enterFirstName("Marina");
        profilePage.enterLastName("Shkoliar");
        profilePage.selectCountry("Ukr");
        profilePage.selectCity("Kyi");
        profilePage.selectDate("1996", "May");

        //profilePage.pressButtonPublish();

        //assertEquals("Close", profilePage.successPopup());


    }

}
