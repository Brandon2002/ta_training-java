package com.epam.training.brandon_tapia.task3.tests;

import com.epam.training.brandon_tapia.task3.model.CloudCalculatorDataModel;
import com.epam.training.brandon_tapia.task3.pages.CloudCalculatorEstimatePage;
import com.epam.training.brandon_tapia.task3.pages.CloudCalculatorHomePage;
import com.epam.training.brandon_tapia.task3.pages.CloudCalculatorPricingPage;
import com.epam.training.brandon_tapia.task3.services.CloudCalculatorDataCreator;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

/**
 * CloudCalculatorTest is a test class for verifying the Google Cloud Platform Pricing Calculator.
 * It extends {@link CloudCalculatorBaseTest} and uses TestNG for test execution.
 */
public class CloudCalculatorTest extends CloudCalculatorBaseTest{

    /**
     * Test method that verifies the cloud pricing estimate functionality.
     *
     * @throws InterruptedException If interrupted during thread sleep
     */
    @Test
    public void testCloud() throws InterruptedException {
        WebDriver driver = CloudCalculatorBaseTest.driver;
        CloudCalculatorDataModel calculatorData = CloudCalculatorDataCreator.withCredentialsFromProperty();
        CloudCalculatorHomePage cloudCalculatorHome = new CloudCalculatorHomePage();
        CloudCalculatorPricingPage cloudCalculator = new CloudCalculatorPricingPage();
        CloudCalculatorEstimatePage estimate = new CloudCalculatorEstimatePage();

        cloudCalculatorHome.openPage(driver);
        cloudCalculatorHome.addEstimate();
        cloudCalculator.initializeElements(driver);
        cloudCalculator.followingData();
        estimate.initializeElementsEstimate(driver);
        estimate.switchWindow();

        boolean areValuesValid = estimate.validateSummaryValues(calculatorData);
        Assert.assertTrue(areValuesValid, "Summary values are not as expected");

    }
}
