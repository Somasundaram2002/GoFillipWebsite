package org.example;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SignUp extends BaseClass{

    @Test
    public void Sign_Up() throws InterruptedException {

        driver.findElement(By.xpath("//button[text()=\"Sign In\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h1[text()=\"Sign in to Gofillip\"]"));

        driver.findElement(By.id("identifier-field")).sendKeys("context@gmail.com");
        driver.findElement(By.xpath("//span[text()=\"Continue\"]")).click();
        Thread.sleep(2000);

    try {
        String errorMessage = driver.findElement(By.id("error-identifier")).getText();
        System.err.println(errorMessage);
        System.out.println("Passed : Unregistered email address cant Sign in");
    } catch (Exception e) {
    System.out.println("BUG : Unregistered email address signed in");
    }

    Thread.sleep(2000);

    driver.navigate().refresh();
    System.out.println("Page refreshed");

    Thread.sleep(2000);

        driver.findElement(By.id("identifier-field")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("identifier-field")).sendKeys("tsksomu11@gmail.com");
        driver.findElement(By.xpath("//span[text()=\"Continue\"]")).click();
        Thread.sleep(1000);


        driver.findElement(By.id("password-field")).sendKeys("SomuAbcd@123");
        driver.findElement(By.xpath("//span[text()=\"Continue\"]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//img[@title=\"Somasundaram N\"]"));
        System.out.println("Registered user signed in");
        Thread.sleep(2000);

    }


}
