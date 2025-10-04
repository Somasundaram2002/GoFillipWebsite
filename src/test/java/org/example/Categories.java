package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.Thread.sleep;
import static org.example.Search.isNoServicesFound;

public class Categories extends BaseClass {



    @Test
    public void search() throws InterruptedException {


        JavascriptExecutor js = (JavascriptExecutor) driver;


        // Navigate to Services page
        driver.findElement(By.xpath("//a[text()=\"Services\"]")).click();
        sleep(3000);
        System.out.println("Services menu clicked");

        js.executeScript("window.scrollBy(0,200)");

        driver.findElement(By.xpath("//button[text()='Website']")).click();
        sleep(3000);

        driver.findElement(By.xpath("//button[text()='Mobile']")).click();
        sleep(3000);



        driver.findElement(By.xpath("//button[text()='E-Commerce']")).click();
        sleep(3000);

        driver.findElement(By.xpath("//button[text()='UX/UI']")).click();
        sleep(3000);
        driver.findElement(By.xpath("//button[text()='Desktop']")).click();
        sleep(3000);
        driver.findElement(By.xpath("//button[text()='Cross-Platform']")).click();
        sleep(3000);




    }
}
