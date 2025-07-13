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
}
