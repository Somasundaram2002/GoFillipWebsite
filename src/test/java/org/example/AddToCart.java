package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AddToCart extends BaseClass {

    private WebDriverWait wait() {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private void waitForPageReady() {
        wait().until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    @Test
    public void add_to_cart() {
        // Wait for home loaded and open Sign In
        waitForPageReady();
        wait().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space(.)='Sign In']"))).click();

        // Email step
        WebElement email = wait().until(ExpectedConditions.visibilityOfElementLocated(By.id("identifier-field")));
        email.clear();
        email.sendKeys("tsksomu11@gmail.com");
        wait().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space(.)='Continue']"))).click();

        // Password step
        WebElement pwd = wait().until(ExpectedConditions.visibilityOfElementLocated(By.id("password-field")));
        pwd.clear();
        pwd.sendKeys("SomuAbcd@123");
        wait().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space(.)='Continue']"))).click();

        // Assert user avatar visible
        wait().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//img[@title='Somasundaram N']")));

        // Navigate to Services
        wait().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space(.)='Services']"))).click();
        waitForPageReady();

        // Scroll target card into view
        WebElement targetCard = wait().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h3[normalize-space(.)='Static Standard Website']")));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior:'instant',block:'center'});", targetCard);

        // Read product names
        String prod1 = driver.findElement(By.xpath("//h3[normalize-space(.)='Static Standard Website']")).getText();
        String prod2 = driver.findElement(By.xpath("//h3[normalize-space(.)='Static Premium Website']")).getText();
        String prod3 = driver.findElement(By.xpath("//h3[normalize-space(.)='Hybrid Minimal Application']")).getText();

        // Add up to 3 items to cart
        List<WebElement> addButtons = wait().until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//button[normalize-space(.)='Add to Cart']"), 2));

        for (int i = 0; i < Math.min(addButtons.size(), 3); i++) {
            addButtons.get(i).click();
        }

        // Open cart
        WebElement cart = wait().until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'/cart') or contains(text(),'Cart')]")));
        cart.click();
        waitForPageReady();

        // Verify items present in cart
        assert driver.findElement(By.xpath("//*[normalize-space(text())='" + prod1 + "']")).isDisplayed();
        assert driver.findElement(By.xpath("//*[normalize-space(text())='" + prod2 + "']")).isDisplayed();
        assert driver.findElement(By.xpath("//*[normalize-space(text())='" + prod3 + "']")).isDisplayed();

        System.out.println("✅ Passed: All products are visible in the cart");
    }
}
