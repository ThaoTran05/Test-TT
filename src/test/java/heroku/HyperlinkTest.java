package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HyperlinkTest {
    /**TC04: Hyper link : Hyperlink - link text
     Open browser
     Navigate to https://the-internet.herokuapp.com/status_codes
     Click on "200"
     Then "200 status code" page appear
     Click on "go here"
     Click on "301"
     Then "301 status code" page appear
     Click on "go here"
     Click on "404"
     Then "404 status code" page appear
     Click on "go here"
     Click on "500"
     Then "500 status code" page appear
     Click on "go here"
     **/

    @Test
    void TC04(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/status_codes");

        // Click on "200"
        driver.findElement(By.linkText("200")).click();
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains("This page returned a 200 status code"));
        driver.findElement(By.linkText("here")).click();

        // Click on "301"
        driver.findElement(By.linkText("301")).click();
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains("This page returned a 301 status code"));
        driver.findElement(By.linkText("here")).click();

        // Click on "404"
        driver.findElement(By.linkText("404")).click();
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains("This page returned a 404 status code"));
        driver.findElement(By.linkText("here")).click();

        // Click on "500"
        driver.findElement(By.linkText("500")).click();
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains("This page returned a 500 status code"));
        driver.findElement(By.linkText("here")).click();

        // Verify we are back to the status codes page
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes");

        driver.quit();

    }
}
