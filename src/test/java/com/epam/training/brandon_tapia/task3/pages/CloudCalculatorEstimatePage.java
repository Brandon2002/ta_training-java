package com.epam.training.brandon_tapia.task3.pages;

import com.epam.training.brandon_tapia.task3.model.CloudCalculatorDataModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class CloudCalculatorEstimatePage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//div//span//span//span[contains(text(), '4')]")
    public WebElement instance;

    @FindBy(xpath = "//div//span//span//span[contains(text(), 'Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)')]")
    public WebElement system;

    @FindBy(xpath = "//div//span//span//span[contains(text(), 'Regular')]")
    public WebElement model;

    @FindBy(xpath = "//div//span//span//span[contains(text(), 'n1-standard-8, vCPUs: 8, RAM: 30 GB')]")
    public WebElement machineTypeText;

    @FindBy(xpath = "//div//span//span//span[contains(text(), 'NVIDIA V100')]")
    public WebElement gpuType;

    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[4]/span[3]/span[1]/span[2]")
    public WebElement numOfGpus;

    @FindBy(xpath = "//div//span//span//span[contains(text(), '2x375 GB')]")
    public WebElement localSsd;

    @FindBy(xpath = "//div//span//span//span[contains(text(), 'Netherlands (europe-west4)')]")
    public WebElement regionText;

    public void initializeElementsEstimate(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Switches to the new window/tab opened after clicking "Submit" and retrieves the instance text.
     */
    public void switchWindow() {
        Set<String> handles = driver.getWindowHandles();
        String originalHandle = driver.getWindowHandle();

        for (String handle : handles) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

    }

//    public boolean validateSummaryValues(int expectedInstances, String expectedOS, String expectedProvisionalModel, String expectedMachineType, String expectedGpuType, int expectedNumOfGpus, String expectedLocalSsd, String expectedRegion){
//        wait.until(ExpectedConditions.visibilityOf(gpuType));
//        int instances = Integer.parseInt(instance.getText());
//        String operatingSystem = system.getText();
//        String provisionalModel = model.getText();
//        String machineType = machineTypeText.getText();
//        String gpuTypeText = gpuType.getText();
//        int numberOfGpus = Integer.parseInt(numOfGpus.getText());
//        System.out.println(numberOfGpus);
//        String localSsdText = localSsd.getText();
//        String region = regionText.getText();
//
//        return expectedInstances == instances && expectedOS.equals(operatingSystem) &&
//                expectedProvisionalModel.equals(provisionalModel) &&
//                expectedMachineType.equals(machineType) &&
//                expectedGpuType.equals(gpuTypeText) &&
//                expectedNumOfGpus == numberOfGpus &&
//                expectedLocalSsd.equals(localSsdText) &&
//                expectedRegion.equals(region);
//    }

    public boolean validateSummaryValues(CloudCalculatorDataModel data){
        wait.until(ExpectedConditions.visibilityOf(gpuType));
        int instances = Integer.parseInt(instance.getText());
        String operatingSystem = system.getText();
        String provisionalModel = model.getText();
        String machineType = machineTypeText.getText();
        String gpuTypeText = gpuType.getText();
        int numberOfGpus = Integer.parseInt(numOfGpus.getText());
        String localSsdText = localSsd.getText();
        String region = regionText.getText();

        return  instances == data.getNumInstances() && operatingSystem.equals(data.getOperatingSystem()) &&
                provisionalModel.equals(data.getProvisionalModel()) &&
                machineType.equals(data.getMachineType()) &&
                gpuTypeText.equals(data.getGpuType()) &&
                numberOfGpus == data.getNumOfGpus() &&
                localSsdText.equals(data.getLocalSsd()) &&
                region.equals(data.getRegion());
    }
}
