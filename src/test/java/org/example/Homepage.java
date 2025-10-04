package org.example;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Homepage extends BaseClass {

    @Test
    public void homepageLoad() {
        try {
            driver.findElement(By.xpath("//a[text()=\"Home\"]"));
            driver.findElement(By.xpath("//a[text()=\"Services\"]"));
            driver.findElement(By.xpath("//a[text()=\"Pricing\"]"));
            driver.findElement(By.xpath("//a[text()=\"Blog\"]"));

            // Corrected XPath with parentheses for proper indexing
            driver.findElement(By.xpath("(//a[text()=\"Contact\"])[1]")); // button

            driver.findElement(By.xpath("//a[text()=\"About\"]"));
            driver.findElement(By.xpath("//div[@class=\"relative w-7 h-7 cursor-pointer bg-amber-300 flex justify-center items-center rounded-full\"]"));            driver.findElement(By.xpath("//div[@class=\" w-7 h-7 overflow-hidden bg-amber-300 flex justify-center items-center rounded-full\"]"));
            driver.findElement(By.xpath("//button[text()=\"Sign In\"]"));

            System.out.println("Gofillip Page Opened Successfully");

        } catch (Exception e) {
            System.err.println("Test failed: Homepage did not load as expected.");
            System.err.println("Error details: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test
    public void homepageLoadClick() throws InterruptedException {

        try {
            driver.findElement(By.xpath("//a[text()=\"Home\"]"));
            Thread.sleep(1000);

            driver.findElement(By.xpath("//a[text()=\"Services\"]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//h2[text()='Service Provide']"));

            driver.findElement(By.xpath("//a[text()=\"Pricing\"]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//p[text()='Scalable services. Transparent pricing. Choose what works best for you.']"));


            driver.findElement(By.xpath("//a[text()=\"Blog\"]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//h2[text()='Built To Serve']"));

            // Corrected XPath with parentheses for proper indexing
            driver.findElement(By.xpath("(//a[text()=\"Contact\"])[1]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[text()='contact@gofillip.com']"));



            driver.findElement(By.xpath("//a[text()=\"About\"]")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("about-heading"));

            driver.findElement(By.xpath("//div[@class=\"relative w-7 h-7 cursor-pointer bg-amber-300 flex justify-center items-center rounded-full\"]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//h2[@class=\"text-4xl text-gray-700 font-semibold \"]"));


            driver.findElement(By.xpath("//div[@class=\" w-7 h-7 overflow-hidden bg-amber-300 flex justify-center items-center rounded-full\"]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//h2[text()=\"View Your Orders\"]"));

            driver.findElement(By.xpath("//button[text()=\"Sign In\"]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//h1[text()=\"Sign in to Gofillip\"]"));


            System.out.println("All main menu's are available ");

        } catch (Exception e) {
            System.err.println("Test failed: Main menu's did not load as expected.");
            System.err.println("Error details: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

   // @Test
    public void SignUp() throws InterruptedException {

        driver.findElement(By.id("identifier-field")).sendKeys("anjaansomu11@gmail.com");
        driver.findElement(By.xpath("//span[text()=\"Continue\"]")).click();
        Thread.sleep(2000);

        String errorMessage = driver.findElement(By.id("error-identifier")).getText();
        System.err.println(errorMessage);

        driver.findElement(By.id("identifier-field")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("identifier-field")).sendKeys("tsksomu11@gmail.com");
        driver.findElement(By.xpath("//span[text()=\"Continue\"]")).click();
        Thread.sleep(1000);


        driver.findElement(By.id("password-field")).sendKeys("SomuAbcd@123");
        driver.findElement(By.xpath("//span[text()=\"Continue\"]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//img[@title=\"Somasundaram N\"]"));


    }

}
