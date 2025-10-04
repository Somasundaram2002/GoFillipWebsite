package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AddToCart extends BaseClass{


    @Test
    public void add_to_cart() throws InterruptedException {

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
        String prod2 = driver.findElement(By.xpath("//h3[text()=\"Static Premium Website\"]")).getText();
        String prod3 = driver.findElement(By.xpath("//h3[text()=\"Hybrid Minimal Application\"]")).getText();


         // WebElement el = driver.findElement(By.xpath("//*[normalize-space(text())='" + text + "']"));

        List<WebElement> addtocart = driver.findElements(By.xpath("//button[text()=\"Add to Cart\"]"));
        addtocart.get(0).click();
        addtocart.get(1).click();
        addtocart.get(2).click();

        Thread.sleep(3000);


        WebElement cart = driver.findElement(By.xpath("//a[@rel='canonical' and contains(@href,'/Cart')]"));
        cart.click();

        try {
             driver.findElement(By.xpath("//*[normalize-space(text())='" + prod1 + "']"));
             driver.findElement(By.xpath("//*[normalize-space(text())='" + prod2 + "']"));
             driver.findElement(By.xpath("//*[normalize-space(text())='" + prod3 + "']"));
             System.out.println("Passed: Added product matches in cart");
        } catch (Exception e) {
            System.out.println("Failed: Added products not matches");
            System.out.println(e);
        }







    }
}
