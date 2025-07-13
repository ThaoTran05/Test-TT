package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ChromeTest {
    @Test
    void OpenWithDefaultMode(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();
    }

    @Test
    void openBrowserWithHeadlessMode(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();
    }
}
