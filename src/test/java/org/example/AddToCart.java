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

text
private WebDriverWait wait() {
    return new WebDriverWait(driver, Duration.ofSeconds(20));
}

private void waitForPageReady() {
    wait().until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
}

@Test
public void add_to_cart() {
    // Wait for home loaded and open Sign In
    waitForPageReady(); // ensure initial DOM is ready[3][4]
    wait().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(.)='Sign In']"))).click(); // robust text match[2][5]

    // Email step
    WebElement email = wait().until(ExpectedConditions.visibilityOfElementLocated(By.id("identifier-field")));
    email.clear();
    email.sendKeys("tsksomu11@gmail.com");
    wait().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(.)='Continue']"))).click(); // stable click[6][2]

    // Password step
    WebElement pwd = wait().until(ExpectedConditions.visibilityOfElementLocated(By.id("password-field")));
    pwd.sendKeys("SomuAbcd@123");
    wait().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(.)='Continue']"))).click();

    // Assert user avatar visible
    wait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='Somasundaram N']")));

    // Navigate to Services
    wait().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(.)='Services']"))).click();
    waitForPageReady();

    // Scroll target card into view
    WebElement targetCard = wait().until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//h3[normalize-space(.)='Static Standard Website']")));
    ((JavascriptExecutor) driver).executeScript("arguments.scrollIntoView({behavior:'instant',block:'center'});", targetCard); // JS scroll[7][8]

    // Read product names
    String prod1 = wait().until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//h3[normalize-space(.)='Static Standard Website']"))).getText();
    String prod2 = wait().until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//h3[normalize-space(.)='Static Premium Website']"))).getText();
    String prod3 = wait().until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//h3[normalize-space(.)='Hybrid Minimal Application']"))).getText();

    // Add three items to cart with guard
    List<WebElement> addButtons = wait().until(ExpectedConditions.numberOfElementsToBeMoreThan(
            By.xpath("//button[normalize-space(.)='Add to Cart']"), 2)); // ensure at least 3[9][10]
    addButtons.get(0).click();
    addButtons.get(1).click();
    addButtons.get(2).click();

    // Open cart
    WebElement cart = wait().until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[@rel='canonical' and contains(@href,'/Cart')]")));
    cart.click();
    waitForPageReady();

    // Verify items present in cart
    wait().until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[normalize-space(text())='" + prod1 + "']")));
    wait().until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[normalize-space(text())='" + prod2 + "']")));
    wait().until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[normalize-space(text())='" + prod3 + "']")));
    System.out.println("Passed: Added product matches in cart");
}
}

