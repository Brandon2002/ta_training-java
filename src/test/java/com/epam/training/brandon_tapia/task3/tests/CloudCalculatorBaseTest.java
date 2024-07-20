package com.epam.training.brandon_tapia.task3.tests;

import com.epam.training.brandon_tapia.task3.driver.DriverBase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloudCalculatorBaseTest {

    protected static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = DriverBase.getDriver();
    }

    @AfterClass
    public static void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
