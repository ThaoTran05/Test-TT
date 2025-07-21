package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseActionsTest {

    @Test
    void hoverTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");

        Actions action = new Actions(driver);
        WebElement avatar = driver.findElements(By.className("figure")).get(0);

        action.moveToElement(avatar).perform(); // Hover over the first avatar
        Assert.assertTrue(avatar.findElement(By.xpath(".//h5")).isDisplayed());

        driver.quit();
    }
}
