package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SocialMediaLinks {

   private WebDriver driver;
    public SocialMediaLinks(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement linkedin() {
        return driver.findElement(By.xpath("//a[@aria-label=\"Visit our LinkedIn page\"]"));
    }

    public WebElement X() {
        return driver.findElement(By.xpath("//a[@aria-label=\"Visit our Twitter/X page\"]"));
    }

    public WebElement FaceBook() {
        return driver.findElement(By.xpath("//a[@aria-label=\"Visit our Facebook page\"]"));
    }

    public WebElement Instagram() {
        return driver.findElement(By.xpath("//a[@aria-label=\"Visit our Instagram profile\"]"));
    }

    public WebElement Youtube() {
        return driver.findElement(By.xpath("//a[@aria-label=\"Visit our YouTube channel\"]"));
    }





}
