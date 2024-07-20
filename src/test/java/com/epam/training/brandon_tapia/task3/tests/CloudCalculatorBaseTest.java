package com.epam.training.brandon_tapia.task3.tests;

import com.epam.training.brandon_tapia.task3.driver.DriverBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;

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
