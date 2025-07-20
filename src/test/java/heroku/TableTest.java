package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TableTest {
    /**
     * TC05: Web Table: Validate largest due person from a table
     * Open browser
     * Navigate to https://the-internet.herokuapp.com/tables
     * Focus on table 1
     * The person who has largest due is "Doe Jacson"
     */

    @Test
    void TC05(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<Double> dueList = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .map(cell -> Double.valueOf(cell.getText().replace("$","")))
                .toList();

        double maxDue = Collections.max(dueList);
        int rowIndex = dueList.indexOf(maxDue) + 1; // +1 because xpath is 1-based index

        String lastName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[1]", rowIndex))).getText();
        String firstName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[2]", rowIndex))).getText();

        Assert.assertEquals(String.format("%s %s", firstName, lastName), "Jason Doe");
        driver.quit();
    }

    @Test
    void TC06(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<Person> personList = new ArrayList<>();

        driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"))
                .forEach(row -> {
                    String lastName = row.findElement(By.xpath(".//td[1]")).getText();
                    String firstName = row.findElement(By.xpath(".//td[2]")).getText();
                    double due = Double.parseDouble(row.findElement(By.xpath(".//td[4]")).getText().replace("$", ""));
                    personList.add(new Person(firstName, lastName, due));
                });
        double maxDue = personList.stream().max(Comparator.comparing(Person::getDue)).get().getDue();
        List<String> ListPersonHaveMaxDue = personList.stream()
                        .filter(person -> person.getDue() == maxDue)
                                .map(Person::getFullName)
                                        .toList();
        Assert.assertEquals(ListPersonHaveMaxDue, List.of("Jason Doe"));
        driver.quit();
    }
}
