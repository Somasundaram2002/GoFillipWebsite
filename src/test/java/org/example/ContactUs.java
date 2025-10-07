package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ContactUs extends BaseClass{

    @Test
    public void send_message() throws InterruptedException {

        driver.findElement(By.xpath("(//a[text()=\"Contact\"])[1]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[text()='contact@gofillip.com']"));

        driver.findElement(By.id("name")).sendKeys("Somasundaram");
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("tsksomu11@gmail.com");
        driver.findElement(By.xpath("//input[@name=\"phoneNo\"]")).sendKeys("9176636750");
        driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys("Testing Purpose");

        driver.findElement(By.xpath("//button[text()=\"Send Message\"]")).click();
        Thread.sleep(3000);


        try {
            driver.findElement(By.xpath("//button[text()=\"Send Message\"]")).click();
            System.out.println("BUG - Send message element is still visible after sending message");
        } catch (Exception e) {
            System.out.println("Passed - Send message element is not visible after sending message");
        }

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000); // keep as-is to match current style

        String[][] cases = {
                {"", "tsksomu11@gmail.com", "9176636750", "Testing Purpose github", "name"},            // empty name
                {"Somasundaram", "", "9176636750", "Testing Purpose github", "email"},                   // empty email
                {"Somasundaram", "invalidgmail.com", "9176636750", "Testing Purpose github", "email"},   // invalid email (missing @)
                {"Somasundaram", "tsksomu11@gmail.com", "", "Testing Purpose github", "phoneNo"},        // empty phone
                {"Somasundaram", "tsksomu11@gmail.com", "9176636750", "", "mssage"}              // empty message
        };

        for (String[] tc : cases) {
            // Fill the form
            driver.findElement(By.id("name")).clear();
            driver.findElement(By.id("name")).sendKeys(tc[0]);

            WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
            email.clear(); email.sendKeys(tc[1]);

            WebElement phone = driver.findElement(By.xpath("//input[@name='phoneNo']"));
            phone.clear(); phone.sendKeys(tc[2]);

            WebElement msg = driver.findElement(By.xpath("//textarea[@name='message']"));
            msg.clear(); msg.sendKeys(tc[3]);

            // Submit
            driver.findElement(By.xpath("//button[normalize-space(.)='Send Message']")).click();

            // Pick the field to check
            WebElement field;

            switch (tc[4]) {
                case "name":
                    field = driver.findElement(By.id("name"));
                    break;
                case "email":
                    field = email;
                    break;
                case "phoneNo":
                    field = phone;
                    break;
                case "message":
                    field = msg;
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected field name: " + tc[4]);
            }


            // Force HTML5 validation to show and then read the message
            String builtInMsg = (String)((JavascriptExecutor)driver).executeScript(
                    "arguments[0].reportValidity(); return arguments[0].validationMessage;", field
            ); // validationMessage is the browser’s tooltip text

            System.out.println("Case for " + tc[4] + " => " + builtInMsg);

            // Reset for next case
            Thread.sleep(2000);
            driver.navigate().refresh();
            Thread.sleep(2000);
        }




    }
}
