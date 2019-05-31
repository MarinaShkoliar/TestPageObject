package lc.jobla.tests;

import lc.jobla.FunctionalTest;
import lc.jobla.components.Login;
import lc.jobla.components.ProfilePage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends FunctionalTest {

    @Test
    public void login(){

           driver.get("http://jobla.lc/login");

            Login loginPage = new Login(driver);
            assertTrue(loginPage.isInitialized());

            loginPage.pressButtonCookie();

            loginPage.enterEmail("filobokaya@gmail.com");
            loginPage.enterPassword("123qwerty");

            ProfilePage profilePage = loginPage.pressButtonSubmit();
            assertTrue(profilePage.isInitialized());

            assertEquals("Profile", profilePage.confirmationHeader());
        }
}
