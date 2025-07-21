package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlertTest {

    @Test
    void verifyClickJSAlert(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text: " + alertText);
        driver.switchTo().alert().accept(); // Accept the alert

        // Verify the result text after accepting the alert
        String resultText = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(resultText.contains("You successfully clicked an alert"));

        driver.quit();
    }
}
