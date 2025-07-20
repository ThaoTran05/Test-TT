package flight;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BookingTest {
    /**
     * open browser
     * navigate to https://www.vietnamairlines.com/vn/vi/Home
     * select 1 chieu
     * select day 7/4/2025
     * verify day selected
     */
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    void setUp() {
   /*     ChromeProfile profile = new ChromeProfile();
        profile.setPreference("permissions.default.geo", 2); // 1 = allow, 2 = deny
        profile.setPreference("permissions.default.desktop-notification", 2); // 1 = allow, 2 = deny
        ChromeOptions options = new ChromeOptions();
        options.setProfile(profile);*/
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Test
    void buyOneWayTicket() throws InterruptedException {
        driver.get("https://www.vietnamairlines.com/vn/vi/Home");
        // todo: accept cookie
        driver.findElement(By.xpath("//button[.='Đồng ý']")).click();
        //todo: select ngay di
        Thread.sleep(2000);
        wait
                .until(
                        ExpectedConditions
                                .visibilityOfElementLocated(By.id("roundtrip-date-depart")))
                .click();
        //todo: select 1 chieu
        driver
                .findElement(By.cssSelector("#bookYourTripType [data-content-title='Một chiều']"))
                .click();
        wait
                .until(
                        ExpectedConditions
                                .visibilityOfElementLocated(By.id("roundtrip-date-depart")))
                .click();
        //todo: select 7/4/2025
        driver.findElements(By.cssSelector(".ui-datepicker-group-first a"))
                .stream()
                .filter(el -> el.getText().equals("7"))
                .findFirst()
                .get()
                .click();
        //todo: verify
        String departDate = wait
                .until(
                        ExpectedConditions
                                .visibilityOfElementLocated(By.id("roundtrip-date-depart")))
                .getDomProperty("value");
        Assert.assertEquals(departDate, "07/04/2025");
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
