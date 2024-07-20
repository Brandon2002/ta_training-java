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

/**
 * CloudCalculatorEstimatePage represents the estimate summary page in the Cloud Calculator application.
 * It provides methods to interact with the page elements and validate the estimate summary values.
 */
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

    /**
     * Initializes the elements on the estimate page using PageFactory and sets up an explicit wait.
     *
     * @param driver the WebDriver instance used to interact with the page.
     */
    public void initializeElementsEstimate(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    /**
     * Switches to the new window/tab opened after clicking "Submit".
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

    /**
     * Validates the values in the estimate summary page against the provided CloudCalculatorDataModel.
     *
     * @param data the CloudCalculatorDataModel containing the expected values
     * @return true if the values in the estimate summary match the expected values; false otherwise
     */
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
