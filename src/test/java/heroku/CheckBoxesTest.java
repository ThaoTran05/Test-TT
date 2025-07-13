package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxesTest {
    /**
     * TC02: Checkboxes : Check to a box
     * Open browser
     * Navigate to https://the-internet.herokuapp.com/checkboxes
     * Check on checkbox1
     * Verify checkbox1 is checked
     * Check on checkbox2
     * Verify checkbox2 is checked
     */

    @Test
    void TC02(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        // Check checkbox1
        if(!driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected()){
            driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).click();
        }
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected());
        // Check checkbox2
        if(!driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).isSelected()){
            driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).click();
        }
        Assert.assertTrue(driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).isSelected());
        driver.quit();

    }

    @Test
    void ableUncheckAllTextBoxes(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
        // Uncheck all checkboxes
        driver.findElement(By.xpath("//button[@data-test='uncheck-all-button']")).click();
        // Verify all checkboxes are unchecked
        Assert.assertFalse(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox1']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox2']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox3']")).isSelected());
        driver.quit();
    }

    @Test
    void ableCheckAllCheckBoxes(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
        // Check all checkboxes
        driver.findElement(By.xpath("//button[@data-test='check-all-button']")).click();
        // Verify all checkboxes are checked
        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox1']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox2']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-test='checkbox-checkbox3']")).isSelected());
        driver.quit();
    }
}
