package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AddtoCartPrice extends BaseClass{

    @Test
    public void cart_price() throws InterruptedException {

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

        String priceText = driver.findElement(By.xpath("//p[text()=\"7,599\"]")).getText(); // "7,599"
        int price = Integer.parseInt(priceText.replaceAll("[^\\d]", "")); // 7599
        int total = price * 5; // 37995
        System.out.println(total);


        List<WebElement> addtocart = driver.findElements(By.xpath("//button[text()=\"Add to Cart\"]"));
        addtocart.get(0).click();

        Thread.sleep(3000);

        WebElement cart = driver.findElement(By.xpath("//a[@rel='canonical' and contains(@href,'/Cart')]"));
        cart.click();

        // Locate the Add item (plus) button using the aria-label
        By addItemBtn = By.cssSelector("button[aria-label='add item button']");

// Wait until the button is visible and enabled (not disabled)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement plusBtn = wait.until(ExpectedConditions.elementToBeClickable(addItemBtn));

// Sometimes pointer-events or overlays can block click, so scroll into view
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'});", plusBtn);

// Click the button (try normal click first)
        try {
            plusBtn.click();
        } catch (Exception e) {
            // Fallback to JS click if necessary
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", plusBtn);
        }



    }
}
