package com.epam.training.brandon_tapia.task3.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * DriverBase is a utility class that provides a singleton instance of WebDriver.
 * It supports Chrome, Firefox, and Edge browsers. The browser type is specified
 * through the system property "browser". If the property is not set, Chrome is used by default.
 */
public class DriverSingleton {
    // The WebDriver instance is kept as a singleton.
    private static WebDriver driver;

    // Private constructor to prevent instantiation.
    private DriverSingleton() {}

    /**
     * Returns the singleton instance of WebDriver. If the WebDriver is not initialized,
     * it sets up the WebDriver based on the specified browser type.
     *
     * @return the singleton instance of WebDriver
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            // Get the browser type from the system property "browser"
            String browser = System.getProperty("browser", "");

            // Setup WebDriver based on the browser type
            switch (browser.toLowerCase()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            // Maximize the browser window
            driver.manage().window().maximize();
        }
        return driver;
    }

}
