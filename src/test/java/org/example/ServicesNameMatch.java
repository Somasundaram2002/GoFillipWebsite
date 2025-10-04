package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ServicesNameMatch extends BaseClass{

    @Test
    public void service() throws InterruptedException {

        driver.findElement(By.xpath("//button[text()=\"Sign In\"]")).click();
        Thread.sleep(2000);

        Thread.sleep(2000);

        driver.findElement(By.id("identifier-field")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("identifier-field")).sendKeys("tsksomu11@gmail.com");
        driver.findElement(By.xpath("//span[text()=\"Continue\"]")).click();
        Thread.sleep(2000);


        driver.findElement(By.id("password-field")).sendKeys("SomuAbcd@123");
        driver.findElement(By.xpath("//span[text()=\"Continue\"]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//img[@title=\"Somasundaram N\"]"));
        System.out.println("Registered user signed in");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[text()=\"Services\"]")).click();
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//h3[text()=\"Static Standard Website\"]"));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element
        );

        String prod1 = driver.findElement(By.xpath("//h3[text()=\"Static Standard Website\"]")).getText();
        List<WebElement> buttons = driver.findElements(By.xpath("//button[text()='Read More']"));
        buttons.get(0).click();
        Thread.sleep(1000);
        String prod1desc = driver.findElement(By.xpath("//h2[text()=\"Static Standard Website\"]")).getText();
        if(prod1.equalsIgnoreCase(prod1desc)) {
            System.out.println("Product name matches");
        } else {
            System.out.println("Product name not matches");
        }

        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);

        String prod2 = driver.findElement(By.xpath("//h3[text()=\"Static Premium Website\"]")).getText();
        buttons = driver.findElements(By.xpath("//button[text()='Read More']"));
        buttons.get(1).click();
        Thread.sleep(1000);
        String prod2desc = driver.findElement(By.xpath("//h2[text()=\"Static Premium Website\"]")).getText();
        if(prod2.equalsIgnoreCase(prod2desc)) {
            System.out.println("Product name matches");
        } else {
            System.out.println("Product name not matches");
        }

        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);

        String prod3 = driver.findElement(By.xpath("//h3[text()=\"Hybrid Minimal Application\"]")).getText();
        buttons = driver.findElements(By.xpath("//button[text()='Read More']"));
        buttons.get(2).click();
        Thread.sleep(1000);
        String prod3desc = driver.findElement(By.xpath("//h2[text()=\"Hybrid Minimal Application\"]")).getText();
        if(prod3.equalsIgnoreCase(prod3desc)) {
            System.out.println("Product name matches");
        } else {
            System.out.println("Product name not matches");
        }

        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);

    }
}
