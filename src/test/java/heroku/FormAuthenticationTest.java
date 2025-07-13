package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

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
    @Test
    void TC01(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        // Fill in username and password
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        // Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().contains("Welcome to the Secure Area. When you are done click logout below."));
        driver.quit();
    }

}
