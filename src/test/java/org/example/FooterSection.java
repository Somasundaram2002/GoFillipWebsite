package org.example;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utils.ScrollUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FooterSection extends BaseClass{

    @Test
    public void scroll() throws InterruptedException {


        WebElement offer = driver.findElement(By.xpath("//button[@aria-label=\"Close offer popup\"]"));
        offer.click();

        ScrollUtils.scrollToEndOfPage(driver);

        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[text()=\"Cookie Policy\"]")).click();
        try {
            ClickHelper.findElementByVisibleText(driver, "1. What Are Cookies?", 0);
        } catch (Exception e) {
            System.out.println("page not found");
            throw new RuntimeException(e);
        }

        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);


        driver.findElement(By.xpath("//a[text()=\"Refund & Cancellation Policy\"]")).click();
        try {
            driver.findElement(By.xpath("//h1[text()=\"Refund & Cancellation Policy\"]"));
        } catch (Exception e) {
            System.out.println("page not found");
            throw new RuntimeException(e);
        }

        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[text()=\"About Us\"]")).click();
        try {
            driver.findElement(By.xpath("//h1[text()=\"About Us\"]"));
        } catch (Exception e) {
            System.out.println("page not found");
            throw new RuntimeException(e);
        }

        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);

        // Sitemap
        driver.findElement(By.xpath("//a[text()=\"Sitemap\"]")).click();
        try {
            driver.findElement(By.xpath("//h2[text()=\"Sitemap Overview\"]"));
        } catch (Exception e) {
            System.out.println("page not found");
            throw new RuntimeException(e);
        }

        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);

        // FAQs
        driver.findElement(By.xpath("//a[text()=\"FAQs\"]")).click();
        try {
            driver.findElement(By.xpath("//p[text()=\"Find answers to common questions about our services and process.\"]"));
        } catch (Exception e) {
            System.out.println("page not found");
            throw new RuntimeException(e);
        }

        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);


        //  support
        driver.findElement(By.xpath("//a[text()=\"Support\"]")).click();
        try {
            driver.findElement(By.xpath("//p[text()=\"+91 7010766306\"]"));
            driver.findElement(By.xpath("//p[text()=\"contact@gofillip.com\"]"));
        } catch (Exception e) {
            System.out.println("page not found");
            throw new RuntimeException(e);
        }

        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);

        // contact
        driver.findElement(By.xpath("//a[text()=\"Contact\"][1]")).click();
        try {
            driver.findElement(By.xpath("//h1[text()=\"Get In Touch With Us\"]"));
            driver.findElement(By.xpath("//a[text()=\"contact@gofillip.com\"]"));
        } catch (Exception e) {
            System.out.println("page not found");
            throw new RuntimeException(e);
        }

        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//address[text()='No: 85 Babu Street, Teynampet, Chennai- 600086.']")).click();
        Thread.sleep(3000);

       // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> tabs = new ArrayList<>(windowHandles);

        driver.switchTo().window(tabs.get(tabs.size() - 1));

        String title = driver.getTitle();

        if (title.contains("WENTRITE")) {
            System.out.println("Map opened");
        } else {
            System.out.println("Map not opened");
        }

        driver.close();

        }
}
