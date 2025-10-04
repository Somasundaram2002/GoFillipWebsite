package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ClickHelper {

    /**
     * Clicks the first element that contains the given visible text.
     *
     * @param driver      WebDriver instance
     * @param visibleText The text of the element to click
     */
    public static void clickByVisibleText(WebDriver driver, String visibleText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Find all elements containing the visible text
        By locator = By.xpath("//*[contains(normalize-space(.),'" + visibleText + "')]");
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

        if (elements.isEmpty()) {
            throw new RuntimeException("No element found with text: " + visibleText);
        }

        WebElement elementToClick = elements.get(0); // pick first match
        wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
        elementToClick.click();
    }

    /**
     * Clicks the Nth occurrence of an element with the given visible text.
     *
     * @param driver          WebDriver instance
     * @param visibleText     The text of the element to click
     * @param occurrenceIndex Zero-based index of the occurrence (0 = first, 1 = second, etc.)
     */
    public static void clickByVisibleText(WebDriver driver, String visibleText, int occurrenceIndex) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        By locator = By.xpath("//*[contains(normalize-space(.),'" + visibleText + "')]");
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

        if (occurrenceIndex >= elements.size()) {
            throw new RuntimeException("Only found " + elements.size() +
                    " elements with text '" + visibleText + "', but requested index " + occurrenceIndex);
        }

        WebElement elementToClick = elements.get(occurrenceIndex);
        wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
        elementToClick.click();
    }

    public static List<WebElement> findElementsByVisibleText(WebDriver driver, String visibleText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        By locator = By.xpath("//*[contains(normalize-space(.),'" + visibleText + "')]");

        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    /**
     * Finds the Nth occurrence of an element containing the given visible text.
     *
     * @param driver          WebDriver instance
     * @param visibleText     Text to match
     * @param occurrenceIndex Zero-based index (0 = first)
     * @return WebElement at the requested index
     */
    public static WebElement findElementByVisibleText(WebDriver driver, String visibleText, int occurrenceIndex) {
        List<WebElement> elements = findElementsByVisibleText(driver, visibleText);

        if (occurrenceIndex >= elements.size()) {
            throw new RuntimeException("Only found " + elements.size() +
                    " elements with text '" + visibleText + "', but requested index " + occurrenceIndex);
        }

        return elements.get(occurrenceIndex);
    }
}
