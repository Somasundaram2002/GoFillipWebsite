package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class SocialMedia extends BaseClass{

    @Test
    public void social_media_check() throws InterruptedException {

        sleep(2000);

        driver.findElement(By.xpath("//button[@aria-label=\"Close offer popup\"]")).click();

        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        sleep(5000);

        SocialMediaLinks link = new SocialMediaLinks(driver);

        link.linkedin().click();
        sleep(4000);

        String title = driver.getTitle();
        Assert.assertNotNull(title);
        if(title.contains("Gofillip")){
            System.out.println("Gofillip linkedin page opened");
        } else {
            System.out.println("Gofillip linkedin page not opened");
        }

        String parentWindow = driver.getWindowHandle();

        driver.switchTo().window(parentWindow);

        sleep(2000);

        link.X().click();
        sleep(5000);

        String xtitle = driver.getTitle();
        Assert.assertNotNull(title);
        if(xtitle.contains("Gofillip")){
            System.out.println("Gofillip X page opened");
        } else {
            System.out.println("Gofillip X page not opened");
        }

        driver.switchTo().window(parentWindow);
        sleep(2000);

        link.FaceBook().click();
        sleep(4000);

        String FBtitle = driver.getTitle();
        Assert.assertNotNull(title);
        if(FBtitle.contains("Gofillip")){
            System.out.println("Gofillip FaceBook page opened");
        } else {
            System.out.println("Gofillip FaceBook page not opened");
        }

        driver.switchTo().window(parentWindow);
        sleep(2000);

        link.Instagram().click();
        sleep(4000);

        String Instatitle = driver.getTitle();
        Assert.assertNotNull(title);
        if(Instatitle.contains("Gofillip")){
            System.out.println("Gofillip Instagram page opened");
        } else {
            System.out.println("Gofillip Instagram page not opened");
        }

        driver.switchTo().window(parentWindow);
        sleep(2000);

        link.Youtube().click();
        sleep(4000);

        String Youtube = driver.getTitle();
        Assert.assertNotNull(title);
        if(Youtube.contains("Gofillip")){
            System.out.println("Gofillip Youtube page opened");
        } else {
            System.out.println("Gofillip Youtube page not opened");
        }

        driver.switchTo().window(parentWindow);
        sleep(3000);



    }
}
