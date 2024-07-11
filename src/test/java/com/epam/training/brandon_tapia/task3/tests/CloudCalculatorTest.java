package com.epam.training.brandon_tapia.task3.tests;

import com.epam.training.brandon_tapia.task3.pages.CloudCalculatorPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloudCalculatorTest {
    public static WebDriver driver;
    public int numInstances = 4;
    public String operatingSystem = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
    public String provisionalModel = "Regular";
    public String machineType = "n1-standard-8, vCPUs: 8, RAM: 30 GB";
    public String gpuType = "NVIDIA V100";
    public String numOfGpus = "1";
    public String localSsd = "2x375 GB";
    public String region = "Netherlands (europe-west4)";

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testCloud() throws InterruptedException {
        CloudCalculatorPage cloudCalculator = new CloudCalculatorPage();
        cloudCalculator.openPage(driver);
        cloudCalculator.addEstimate();
        cloudCalculator.followingData( 3);
        cloudCalculator.followingData2();
        cloudCalculator.switchWindow();

        boolean areValuesValid = cloudCalculator.validateSummaryValues(
                numInstances,
                operatingSystem,
                provisionalModel,
                machineType,
                gpuType,
                numOfGpus,
                localSsd,
                region
        );
        Assert.assertTrue("Summary values are not as expected", areValuesValid);
    }

    @AfterClass
    public static void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
