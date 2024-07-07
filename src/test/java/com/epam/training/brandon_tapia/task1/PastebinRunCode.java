package com.epam.training.brandon_tapia.task1;

import com.epam.training.brandon_tapia.task1.PastebinHome;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PastebinRunCode {
    private WebDriver driver;
    private PastebinHome pastebinHome;

    //Initialize a new instance of "ChromeDriver"
    //Maximize the window
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //Initializate the methods to test posting on Pastebin
    @Test
    public void testPostOnPastebin() throws InterruptedException {
        pastebinHome = new PastebinHome();
        pastebinHome.txt("Hello from WebDriver", driver);
        pastebinHome.expiration();
        pastebinHome.pastebinName("helloweb");
    }

    //Close the window when the all the test finished
    @After
    public void tearDown() {
        driver.quit();
    }
}
