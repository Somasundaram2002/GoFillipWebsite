package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.Thread.sleep;
import static org.testng.AssertJUnit.assertTrue;

public class Search extends BaseClass{

    public static boolean isNoServicesFound(WebDriver driver) {
        try {
            WebElement msg = driver.findElement(By.xpath("//p[contains(text(),'No services found.')]"));
            return msg.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void clearInput(WebElement element) {
        element.click(); // focus
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }


    @Test
    public void search_1() throws InterruptedException {

        driver.findElement(By.xpath("//a[text()=\"Services\"]")).click();
        sleep(2000);

       WebElement searchBox = driver.findElement(By.id("search-input"));
               searchBox.sendKeys("App");
               sleep(2000);

        List<WebElement> results = driver.findElements(By.xpath("//h3[contains(text(),\"App\")]"));

        for (WebElement r : results) {
            System.out.println(r.getText()); // print actual text [web:226][web:227]
        }

        // Example assertion: at least one result contains “App”
        assertTrue("No results with 'App'", !results.isEmpty());

        clearInput(searchBox);
        searchBox.sendKeys("Cross");
        sleep(2000);

        if (isNoServicesFound(driver)) {
            System.out.println("BUG - No services found for Cross");

            clearInput(searchBox);
            searchBox.sendKeys("Platform");
            sleep(2000);

            if (isNoServicesFound(driver)) {
                System.out.println("BUG - No services found for Platform");

                clearInput(searchBox);
                searchBox.sendKeys("Cross-Platform");
                sleep(2000);

                if (isNoServicesFound(driver)) {
                    System.out.println("BUG - No services found for Cross-Platform");
                } else {
                    System.out.println("Service displayed for Cross-Platform");
                }

            } else {
                System.out.println("Service displayed for Platform");
            }

        } else {
            System.out.println("Service displayed for Cross");
        }

        clearInput(searchBox);



    }
}
