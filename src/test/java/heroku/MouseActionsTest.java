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

    @Test
    void dragAndDropTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        Actions action = new Actions(driver);
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        action.dragAndDrop(source, target).perform();

        // Verify the text has been swapped
        Assert.assertTrue(source.getText().contains("B"));
        Assert.assertTrue(target.getText().contains("A"));

        driver.quit();
    }

    @Test
    void horizontalSliderTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        Actions action = new Actions(driver);
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

        System.out.println(slider.getSize().getWidth());

        // Move the slider to the right by 50 pixels
        action.clickAndHold(slider).moveByOffset(slider.getSize().getWidth(), 0).release().perform();

        // Verify the value of the slider
        String value = slider.getAttribute("value");
        Assert.assertEquals(value, "5"); // Adjust based on the slider's range

        driver.quit();
    }

    @Test
    void infiniteScrollTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

       Actions action = new Actions(driver);
        // Scroll down to the bottom of the page (5 times)
        for (int i = 0; i < 5; i++) {
            action.scrollByAmount(0, 100).perform();
            Thread.sleep(1000); // Wait for new content to load
        }

        driver.quit();
    }
}
