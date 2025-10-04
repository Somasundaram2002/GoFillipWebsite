package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class Categories1 extends BaseClass {

    /// @Test
    public void clickAllMenus() throws InterruptedException {

        String[] menus = {"Website", "Mobile", "E-Commerce", "UX/UI", "Desktop", "Cross-Platform"};

        for (String menu : menus) {
            driver.findElement(By.xpath("//button[text()='" + menu + "']")).click();
            sleep(3000);
            System.out.println(menu + " menu clicked");
        }
    }


}
