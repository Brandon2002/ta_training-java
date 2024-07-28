package com.epam.training.brandon_tapia.task3.tests;

import com.epam.training.brandon_tapia.task3.model.CloudCalculatorDataModel;
import com.epam.training.brandon_tapia.task3.pages.CloudCalculatorEstimatePage;
import com.epam.training.brandon_tapia.task3.pages.CloudCalculatorHomePage;
import com.epam.training.brandon_tapia.task3.pages.OtherCalculatorPage;
import com.epam.training.brandon_tapia.task3.services.CloudCalculatorDataCreator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CloudCalculatorTest2 extends CloudCalculatorBaseTest{

    @Test
    public void openNewPage() throws InterruptedException{
        WebDriver driver = CloudCalculatorBaseTest.driver;
        CloudCalculatorDataModel calculatorData = CloudCalculatorDataCreator.withCredentialsFromProperty();
        CloudCalculatorHomePage home = new CloudCalculatorHomePage();
        OtherCalculatorPage other = new OtherCalculatorPage();
        CloudCalculatorEstimatePage estimate = new CloudCalculatorEstimatePage();

        home.openPage(driver);
        home.addEstimate();
        other.initialize(driver);
        other.actions();
        estimate.initializeElementsEstimate(driver);
        estimate.switchWindow();

        boolean areValuesValid = estimate.validateSummaryValues(calculatorData);
        Assert.assertTrue(areValuesValid, "Summary values are not as expected");



    }
}
