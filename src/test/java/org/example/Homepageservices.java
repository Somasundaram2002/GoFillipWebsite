package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homepageservices extends BaseClass{

    @Test
    public void homepage() throws InterruptedException {

        WebElement healthcare = driver.findElement(By.xpath("//a[@href=\"/sector-Healthcare\"]"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", healthcare
        );
        Thread.sleep(1000);
        healthcare.click();
        Thread.sleep(3000);

        try {
            driver.findElement(By.xpath("//p[text()=\"Build Your Digital Health Platform\"]"));
            System.out.println("Services redirected correctly to healthcare");
        } catch (Exception e) {
            System.out.println("BUG - Services not redirected to healthcare");
            throw new RuntimeException(e);
        }

        driver.navigate().back();
        Thread.sleep(2000);

        WebElement Ecommerce = driver.findElement(By.xpath("//a[@href=\"/sector-E-commerces\"]"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", Ecommerce
        );
        Thread.sleep(1000);
        Ecommerce.click();
        Thread.sleep(3000);

        try {
            driver.findElement(By.xpath("//button[text()=\"Launch My eCommerce Platform\"]"));
            System.out.println("Services redirected correctly to E-Commerce");
        } catch (Exception e) {
            System.out.println("BUG - Services not redirected to E-Commerce");
            throw new RuntimeException(e);
        }

        driver.navigate().back();
        Thread.sleep(2000);

        WebElement Enterprise = driver.findElement(By.xpath("//a[@href=\"/sector-Enterprise-Software\"]"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", Enterprise
        );
        Thread.sleep(1000);
        Enterprise.click();
        Thread.sleep(3000);

        try {
            driver.findElement(By.xpath("//h2[text()=\"Empower Your Enterprise\"]"));
            System.out.println("Services redirected correctly to Enterprise");
        } catch (Exception e) {
            System.out.println("BUG - Services not redirected to Enterprise");
            throw new RuntimeException(e);
        }

        driver.navigate().back();
        Thread.sleep(2000);

        WebElement Business = driver.findElement(By.xpath("//a[@href=\"/sector-Business\"]"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", Business
        );
        Thread.sleep(1000);
        Business.click();
        Thread.sleep(3000);

        try {
            driver.findElement(By.xpath("//p[text()=\"Start Your Startup Journey\"]"));
            System.out.println("Services redirected correctly to Business");
        } catch (Exception e) {
            System.out.println("BUG - Services not redirected to Business");
            throw new RuntimeException(e);
        }

        driver.navigate().back();
        Thread.sleep(2000);  //

        WebElement school = driver.findElement(By.xpath("//a[@href=\"/sector-Schools\"]"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", school
        );
        Thread.sleep(1000);
        school.click();
        Thread.sleep(3000);

        try {
            driver.findElement(By.xpath("//h2[text()=\"Education Solutions — Smarter Learning with Our Dashboards\"]"));
            System.out.println("Services redirected correctly to school");
        } catch (Exception e) {
            System.out.println("BUG - Services not redirected to school");
            throw new RuntimeException(e);
        }

        driver.navigate().back();
        Thread.sleep(2000);

        WebElement Media = driver.findElement(By.xpath("//a[@href=\"/sector-Media-Industry\"]"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", Media
        );
        Thread.sleep(1000);
        Media.click();
        Thread.sleep(3000);

        try {
            driver.findElement(By.xpath("//h2[text()=\"Powering the Future of Entertainment & Media\"]"));
            System.out.println("Services redirected correctly to Media");
        } catch (Exception e) {
            System.out.println("BUG - Services not redirected to Media");
            throw new RuntimeException(e);
        }

        driver.navigate().back();
        Thread.sleep(2000);

        WebElement Fintech = driver.findElement(By.xpath("//a[@href=\"/sector-Finance-FinTech-Software\"]"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", Fintech
        );
        Thread.sleep(1000);
        Fintech.click();
        Thread.sleep(3000);

        try {
            driver.findElement(By.xpath("//h2[text()=\"FinTech Software That Moves Money & Markets\"]"));
            System.out.println("Services redirected correctly to Fintech");
        } catch (Exception e) {
            System.out.println("BUG - Services not redirected to Fintech");
            throw new RuntimeException(e);
        }

        driver.navigate().back();
        Thread.sleep(2000);

        WebElement Manufacturing = driver.findElement(By.xpath("//a[@href=\"/sector-Industrial-Manufacturing\"]"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", Manufacturing
        );
        Thread.sleep(1000);
        Manufacturing.click();
        Thread.sleep(3000);

        try {
            driver.findElement(By.xpath("//h2[text()=\"Digitize Your Factory Floor with Smart Industrial Software\"]"));
            System.out.println("Services redirected correctly to Manufacturing");
        } catch (Exception e) {
            System.out.println("BUG - Services not redirected to Manufacturing");
            throw new RuntimeException(e);
        }

        driver.navigate().back();
        Thread.sleep(2000);

        WebElement Security = driver.findElement(By.xpath("//a[@href=\"/sector-Security-Surveillance\"]"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", Security
        );
        Thread.sleep(1000);
        Security.click();
        Thread.sleep(3000);

        try {
            driver.findElement(By.xpath("//h2[text()=\"Smart, AI-Driven SecuritySoftware for Real-Time Threat Response\"]"));
            System.out.println("Services redirected correctly to Security");
        } catch (Exception e) {
            System.out.println("BUG - Services not redirected to Security");
            throw new RuntimeException(e);
        }

        driver.navigate().back();
        Thread.sleep(2000);






    }

}
