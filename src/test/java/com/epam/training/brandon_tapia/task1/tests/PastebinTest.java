package com.epam.training.brandon_tapia.task1.tests;

import com.epam.training.brandon_tapia.task1.pages.PastebinPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class contains tests for posting on Pastebin.
 */
public class PastebinTest {
    private static WebDriver driver;
    private static PastebinPage pastebinPage;

    /**
     * Sets up the browser before all tests.
     * Initializes a new instance of ChromeDriver and maximizes the window.
     */
    @BeforeClass
    public static void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * Tests posting a new paste on Pastebin.
     * This test opens Pastebin, enters code, selects expiration time, and enters a paste name.
     */
    @Test
    public void testPostOnPastebin() {
        pastebinPage = new PastebinPage();
        pastebinPage.setUpBrowser(driver);
        pastebinPage.code("Hello from Webdriver");
        pastebinPage.expiration();
        pastebinPage.pastebinName("helloweb");

    }

    /**
     * Tears down the browser after all tests are finished.
     * Closes the browser window.
     */
    @AfterClass
    public static void tearDown() {
        if(driver!=null){
            driver.quit();
        }
    }
}
