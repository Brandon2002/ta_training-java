package com.epam.training.brandon_tapia.task3.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class CloudCalculatorPage {
    /**
     * The WebDriver instance used to control the browser.
     */
    private WebDriver driver;

    /**
     * The WebDriverWait instance used to wait for certain conditions to be met before proceeding.
     */
    private WebDriverWait wait;

    // WebElements annotated with @FindBy for easy identification and interaction
    @FindBy(xpath = "//button[contains(., 'Add to estimate')]")
    public WebElement buttonAdd;

    @FindBy(className = "d5NbRd-EScbFb-JIbuQc")
    public WebElement computeEngine;

    @FindBy(xpath = "/html/body/c-wiz[1]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[2]/div/div/div/div/div[2]/div[1]/div[3]/div[3]/button/div")
    public WebElement instances;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div[1]/div[3]/div/div/div/div[1]")
    public WebElement machineType;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div[1]/div[3]/div/div/div/div[2]/ul/li[7]")
    public WebElement selectMachineType;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[21]/div/div/div[1]/div/div/span/div/button")
    public WebElement addGpu;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[23]/div/div[1]/div/div/div/div[1]")
    public WebElement gpuModel;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[23]/div/div[1]/div/div/div/div[2]/ul/li[2]")
    public WebElement selectGpuModel;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[27]/div/div[1]/div/div/div/div[1]")
    public WebElement ssd;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[27]/div/div[1]/div/div/div/div[2]/ul/li[3]")
    public WebElement selectSsd;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[29]/div/div[1]/div/div/div/div[1]")
    public WebElement region;

    @FindBy(css = "li[data-value='europe-west4']")
    public WebElement selectRegion;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[2]/div[1]/div/div[4]/div[2]/div[2]/div/button")
    public WebElement buttonShare;

    @FindBy(css = "a[track-name='open estimate summary']")
    public WebElement summit;

    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[7]/span/span[1]/span[2]")
    public WebElement instance2;

    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[8]/span/span[1]/span[2]")
    public WebElement system;

    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[9]/span/span[1]/span[2]")
    public WebElement model;

    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[3]/span[2]/span[1]/span[2]")
    public WebElement machineTypeText;

    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[4]/span[2]/span[1]/span[2]")
    public WebElement gpuType;

    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[4]/span[3]/span[1]/span[2]")
    public WebElement numOfGpus;

    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[5]/span/span[1]/span[2]")
    public WebElement localSsd;

    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[15]/span/span[1]/span[2]")
    public WebElement regionText;

    /**
     * Opens the Google Cloud Platform Pricing Calculator page in the browser.
     * Initializes the PageFactory and WebDriverWait.
     * @param driver WebDriver instance to use
     */
    public void openPage(WebDriver driver){
        driver.get("https://cloud.google.com/products/calculator/?hl=en");
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver = driver;
    }

    /**
     * Clicks the "Add to estimate" button on the calculator page.
     * Waits for the compute engine option to be visible and clicks it.
     */
    public void addEstimate(){
        clickElement(buttonAdd);
        wait.until(ExpectedConditions.visibilityOf(computeEngine));
        clickElement(computeEngine);
    }

    /**
     * Performs actions to select machine type and configuration on the calculator page.
     * @param numClicks Number of times to click the instances dropdown
     */
    public void followingData(int numClicks){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(instances));

        for (int i = 0; i < numClicks; i++) {
            clickElement(instances);
        }
        scroll(700);

        wait.until(ExpectedConditions.visibilityOf(machineType));
        clickElement(machineType);

        clickElement(selectMachineType);
    }

    /**
     * Performs actions to select GPU, SSD, region, and finalize the estimate on the calculator page.
     * @throws InterruptedException If interrupted during thread sleep
     */
    public void followingData2() throws InterruptedException {
        scroll(350);
        clickElement(addGpu);

        clickElement(gpuModel);
        scroll(350);

        clickElement(selectGpuModel);

        clickElement(ssd);

        clickElement(selectSsd);

        clickElement(region);

        wait.until(ExpectedConditions.visibilityOf(selectRegion));
        clickElement(selectRegion);
        scroll(350);
        Thread.sleep(1000);

        clickElement(buttonShare);

        clickElement(summit);
    }

    /**
     * Switches to the new window/tab opened after clicking "Submit" and retrieves the instance text.
     * @return The text content of the instance information
     * @throws InterruptedException If interrupted during thread sleep
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

    public boolean validateSummaryValues(int expectedInstances, String expectedOS, String expectedProvisionalModel, String expectedMachineType, String expectedGpuType, String expectedNumOfGpus, String expectedLocalSsd, String expectedRegion){
        int instances = Integer.parseInt(instance2.getText());
        String operatingSystem = system.getText();
        String provisionalModel = model.getText();
        String machineType = machineTypeText.getText();
        String gpuTypeText = gpuType.getText();
        String numberOfGpus = numOfGpus.getText();
        String localSsdText = localSsd.getText();
        String region = regionText.getText();

        return expectedInstances == instances && expectedOS.equals(operatingSystem) &&
                expectedProvisionalModel.equals(provisionalModel) &&
                expectedMachineType.equals(machineType) &&
                expectedGpuType.equals(gpuTypeText) &&
                expectedNumOfGpus.equals(numberOfGpus) &&
                expectedLocalSsd.equals(localSsdText) &&
                expectedRegion.equals(region);
    }

    /**
     * Scrolls the page vertically by a specified number of pixels.
     * @param pix Number of pixels to scroll by
     */
    public void scroll(int pix){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pix + ")");
    }

    // Private method to click on an element after waiting for it to be clickable
    private void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}