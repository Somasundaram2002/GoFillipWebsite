package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Clickmenu {

    private WebDriver driver;
    public Clickmenu(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement menu(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = null;
        int attempts = 0;

        while (attempts < 3) { // retry 3 times in case of stale element
            try {
                element = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'" + text + "')]")
                ));
                break; // success
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        return element;
    }



}