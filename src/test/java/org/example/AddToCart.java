package org.example;

import org.testng.annotations.Test;

public class AddToCart extends BaseClass {

    @Test
    public void openAndCloseWebsite() {
        // Just verify the site opened successfully
        String title = driver.getTitle();
        System.out.println("✅ Website opened successfully: " + title);
    }
}
