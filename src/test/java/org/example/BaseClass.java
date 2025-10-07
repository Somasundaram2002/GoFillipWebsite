package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseClass {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Read config from system properties with safe defaults
        String baseUrl = System.getProperty("baseUrl", "https://gofillip.in/");
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        String extraOpts = System.getProperty("chrome.options", "--no-sandbox --disable-dev-shm-usage --window-size=1920,1080");

        // Resolve ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Build ChromeOptions
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless=new");
        }
        // Split extra options by space while keeping quoted args intact (simple split for now)
        List<String> opts = new ArrayList<>();
        if (extraOpts != null && !extraOpts.isBlank()) {
            opts.addAll(Arrays.asList(extraOpts.split("\\s+")));
        }
        options.addArguments(opts);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));

        driver.navigate().to(baseUrl);
        System.out.println("Opened: " + driver.getTitle());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception ignored) { }
        }
    }
}
