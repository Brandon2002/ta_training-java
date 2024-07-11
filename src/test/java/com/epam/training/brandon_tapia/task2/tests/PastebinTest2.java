package com.epam.training.brandon_tapia.task2.tests;

import com.epam.training.brandon_tapia.task2.pages.PastebinPage2;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PastebinTest2 {
    // Variables
    public static WebDriver driver;
    final String codePastebin = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force\n";
    final String title = "how to gain dominance among developers";
    final String sin = "Bash";
    final String second = "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")";

    /**
     * Sets up the WebDriver instance before all tests.
     * Initializes ChromeDriver and maximizes the window.
     */
    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * Executes tests to verify Pastebin posting functionality.
     * It sets up the browser, enters code, selects syntax highlighting,
     * sets expiration time, enters title, and submits the paste.
     * Asserts the correctness of title, syntax highlight, and text content.
     */
    @Test
    public void pastebinTests(){
        PastebinPage2 pastebinHome2 = new PastebinPage2();

        pastebinHome2.setUpBrowser(driver);
        pastebinHome2.textCode(codePastebin);
        pastebinHome2.setSpanBash();
        pastebinHome2.setSpanMinutes();
        pastebinHome2.textTitle(title);
        pastebinHome2.createNewPaste();

        boolean areValuesValid = pastebinHome2.checkPaste(
                title,
                sin,
                second
        );
        Assert.assertTrue("Summary values are not as expected", areValuesValid);
    }

    /**
     * Tears down the WebDriver instance after all tests are executed.
     * Closes the browser window.
     */
    @AfterClass
    public static void tearDown(){
        if(driver!=null) {
            driver.quit();
        }
    }
}
