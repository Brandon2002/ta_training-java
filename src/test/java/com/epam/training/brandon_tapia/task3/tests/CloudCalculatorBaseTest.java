package com.epam.training.brandon_tapia.task3.tests;

import com.epam.training.brandon_tapia.task3.driver.DriverSingleton;
import com.epam.training.brandon_tapia.util.TestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CloudCalculatorBaseTest {

    protected static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = DriverSingleton.getDriver();
    }

    @AfterClass
    public static void tearDown(){
        DriverSingleton.tearDown();
    }
}
