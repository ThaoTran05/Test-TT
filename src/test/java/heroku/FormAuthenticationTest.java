package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.heroku.FormAuthenticationPage;

import static utils.Browser.*;

public class FormAuthenticationTest {
    /**
     * TC01: Form Authentication : Login successful with valid credentials
     * Open browser
     * Navigate to https://the-internet.herokuapp.com/login
     * Fill in username with tomsmith
     * Fill in the password with SuperSecretPassword!
     * Click on Login button
     * And the home page is appear
     */
    FormAuthenticationPage formAuthenticationPage;
    @BeforeMethod
    void setup() {
        openBrowser("chrome");
        formAuthenticationPage = new FormAuthenticationPage();
    }

    @Parameters({"browser"})
    @Test
    void TC01(String browser) {
        formAuthenticationPage.open();
        formAuthenticationPage.login("tomsmith", "SuperSecretPassword!");

        Assert.assertEquals(getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(formAuthenticationPage.getWelcomeMessage().contains("Welcome to the Secure Area. When you are done click logout below."));

    }

    @AfterMethod
    void tearDown() {
        quit();
    }

}
