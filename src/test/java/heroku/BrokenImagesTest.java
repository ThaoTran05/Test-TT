package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImagesTest {
    @Test
    void verifyBrokenImages(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='example']/img"));

        // naturalWidth or naturalHeight (this field in tag Properties) will return 0 for broken images
        Assert.assertEquals(images.get(0).getDomProperty("naturalWidth"), "0");
        Assert.assertEquals(images.get(1).getDomProperty("naturalWidth"), "0");

        driver.quit();

    }
}
