package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest {
    /**
     * TC03: DropDown : Select option
     * Open browser
     * Navigate to https://the-internet.herokuapp.com/dropdown
     * Select "option 1"
     * Validate "option 1" is selected
     */
    @Test
    void TC03(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        // Select "option 1"
        Select select = new Select(driver.findElement(By.id("dropdown")));
        // Validate "option 1" is selected
        select.selectByVisibleText("Option 1");
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Option 1']")).isSelected());

        //select.selectByValue("1");
        //Assert.assertTrue(driver.findElement(By.xpath("//option[@value='1']")).isSelected());

//        select.selectByIndex(1);
//        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='dropdown']/option[2]")).isSelected());

        driver.quit();
    }

    @Test
    void ableSelectMultipleOptions(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");
        // Select multiple options
        Select select = new Select(driver.findElement(By.id("fruits")));


        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");
        select.selectByVisibleText("Orange");
        select.selectByVisibleText("Grape");

        Assert.assertTrue(select.isMultiple());

//        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Banana']")).isSelected());
//        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Apple']")).isSelected());
//        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Orange']")).isSelected());
//        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Grape']")).isSelected());

    }

    @Test
    void verifyTextFieldDisabled() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        Assert.assertFalse(driver.findElement(By.xpath("//form[@id='input-example']/input")).isEnabled());
        // Click on Enable button
        driver.findElement(By.xpath("//form[@id='input-example']/button")).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='input-example']/input")).isEnabled());


    }
}
