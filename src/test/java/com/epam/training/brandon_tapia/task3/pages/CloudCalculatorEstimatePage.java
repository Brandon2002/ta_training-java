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
    @FindBy(xpath = "//span[contains(text(), 'Number of Instances')]/following-sibling::span")
    public WebElement numberOfInstances;

    @FindBy(xpath = "//span[contains(text(), 'Operating System / Software')]/following-sibling::span")
    public WebElement operatingSystem;

    @FindBy(xpath = "//span[contains(text(), 'Provisioning Model')]/following-sibling::span")
    public WebElement provisionalModel;

    @FindBy(xpath = "//span[contains(text(), 'Machine type')]/following-sibling::span")
    public WebElement machineTypeText;

    @FindBy(xpath = "//span[contains(text(), 'GPU Model')]/following-sibling::span")
    public WebElement gpuType;

    @FindBy(xpath = "//span[contains(text(), 'Number of GPUs')]/following-sibling::span")
    public WebElement numOfGpus;

    @FindBy(xpath = "//span[contains(text(), 'Local SSD')]/following-sibling::span")
    public WebElement localSsd;

    @FindBy(xpath = "//span[contains(text(), 'Region')]/following-sibling::span")
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

        int instances = Integer.parseInt(numberOfInstances.getText());
        String operatingSystem1 = operatingSystem.getText();
        String provisionalModel1 = provisionalModel.getText();
        String machineType = machineTypeText.getText();
        String gpuTypeText = gpuType.getText();
        int numberOfGpus = Integer.parseInt(numOfGpus.getText());
        String localSsdText = localSsd.getText();
        String region = regionText.getText();

        return  instances == data.getNumInstances() && operatingSystem1.equals(data.getOperatingSystem()) &&
                provisionalModel1.equals(data.getProvisionalModel()) &&
                machineType.equals(data.getMachineType()) &&
                gpuTypeText.equals(data.getGpuType()) &&
                numberOfGpus == data.getNumOfGpus() &&
                localSsdText.equals(data.getLocalSsd()) &&
                region.equals(data.getRegion());
    }
}
