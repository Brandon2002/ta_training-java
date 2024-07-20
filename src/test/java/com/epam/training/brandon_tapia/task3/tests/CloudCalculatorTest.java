package com.epam.training.brandon_tapia.task3.tests;

import com.epam.training.brandon_tapia.task3.model.CloudCalculatorDataModel;
import com.epam.training.brandon_tapia.task3.pages.CloudCalculatorEstimatePage;
import com.epam.training.brandon_tapia.task3.pages.CloudCalculatorHomePage;
import com.epam.training.brandon_tapia.task3.pages.CloudCalculatorPricingPage;
import com.epam.training.brandon_tapia.task3.services.CloudCalculatorDataCreator;
import org.junit.*;
import org.openqa.selenium.WebDriver;

public class CloudCalculatorTest extends CloudCalculatorBaseTest{
    private static WebDriver driver;

    @Test
    public void testCloud() throws InterruptedException {
        this.driver = CloudCalculatorBaseTest.driver;
        CloudCalculatorDataModel calculatorData = CloudCalculatorDataCreator.withCredentialsFromProperty();
        CloudCalculatorHomePage cloudCalculatorHome = new CloudCalculatorHomePage();
        CloudCalculatorPricingPage cloudCalculator = new CloudCalculatorPricingPage();
        CloudCalculatorEstimatePage estimate = new CloudCalculatorEstimatePage();

        cloudCalculatorHome.openPage(driver);
        cloudCalculatorHome.addEstimate();
        cloudCalculator.initializeElements(driver);
        cloudCalculator.followingData();
        cloudCalculator.followingData2();
        estimate.initializeElementsEstimate(driver);
        estimate.switchWindow();

        boolean areValuesValid = estimate.validateSummaryValues(calculatorData);
        Assert.assertTrue("Summary values are not as expected", areValuesValid);

    }
}
