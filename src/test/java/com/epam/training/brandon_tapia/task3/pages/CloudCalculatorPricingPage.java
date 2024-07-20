package com.epam.training.brandon_tapia.task3.pages;

import com.epam.training.brandon_tapia.task3.model.CloudCalculatorDataModel;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloudCalculatorPricingPage {
    /**
     * The WebDriver instance used to control the browser.
     */
    private WebDriver driver;

    /**
     * The WebDriverWait instance used to wait for certain conditions to be met before proceeding.
     */
    private WebDriverWait wait;

    // WebElements annotated with @FindBy for easy identification and interaction
//    @FindBy(xpath = "//button[contains(., 'Add to estimate')]")
//    public WebElement buttonAdd;
//
//    @FindBy(className = "d5NbRd-EScbFb-JIbuQc")
//    public WebElement computeEngine;

    @FindBy(id = "c13")
    public WebElement instancesInput;

    @FindBy(xpath = "//div[@jsname='kgDJk']")
    public WebElement machineType;

    @FindBy(xpath = "//li[@data-value='n1-standard-8']")
    public WebElement selectMachineType;

    @FindBy(xpath = "//button[@aria-label='Add GPUs']")
    public WebElement addGpuButton;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[23]/div/div[1]/div/div")
    public WebElement gpuModel;

    @FindBy(xpath = "//li[@data-value='nvidia-tesla-v100']")
    public WebElement selectGpuModel;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[27]/div/div[1]/div/div/div/div[1]")
    public WebElement ssd;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[27]/div/div[1]/div/div/div/div[2]/ul/li[3]")
    public WebElement selectSsd;

    @FindBy(xpath = "//div[@aria-controls='c46']")
    public WebElement region;

    @FindBy(css = "li[data-value='europe-west4']")
    public WebElement selectRegion;

    @FindBy(xpath = "//button[@aria-label='Open Share Estimate dialog']")
    public WebElement buttonShare;

    @FindBy(css = "a[track-name='open estimate summary']")
    public WebElement summit;

//    @FindBy(xpath = "//div//span//span//span[contains(text(), '4')]")
//    public WebElement instance;
//
//    @FindBy(xpath = "//div//span//span//span[contains(text(), 'Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)')]")
//    public WebElement system;
//
//    @FindBy(xpath = "//div//span//span//span[contains(text(), 'Regular')]")
//    public WebElement model;
//
//    @FindBy(xpath = "//div//span//span//span[contains(text(), 'n1-standard-8, vCPUs: 8, RAM: 30 GB')]")
//    public WebElement machineTypeText;
//
//    @FindBy(xpath = "//div//span//span//span[contains(text(), 'NVIDIA V100')]")
//    public WebElement gpuType;
//
//    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz[1]/div/div/div/div/div[2]/div[2]/div[1]/div[2]/div[4]/span[3]/span[1]/span[2]")
//    public WebElement numOfGpus;
//
//    @FindBy(xpath = "//div//span//span//span[contains(text(), '2x375 GB')]")
//    public WebElement localSsd;
//
//    @FindBy(xpath = "//div//span//span//span[contains(text(), 'Netherlands (europe-west4)')]")
//    public WebElement regionText;

//    /**
//     * Opens the Google Cloud Platform Pricing Calculator page in the browser.
//     * Initializes the PageFactory and WebDriverWait.
//     * @param driver WebDriver instance to use
//     */
//    public void openPage(WebDriver driver){
//        driver.get("https://cloud.google.com/products/calculator/?hl=en");
//        PageFactory.initElements(driver, this);
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        this.driver = driver;
//    }

//    /**
//     * Clicks the "Add to estimate" button on the calculator page.
//     * Waits for the compute engine option to be visible and clicks it.
//     */
//    public void addEstimate(){
//        clickElement(buttonAdd);
//        wait.until(ExpectedConditions.visibilityOf(computeEngine));
//        clickElement(computeEngine);
//    }

    public void initializeElements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    /**
     * Performs actions to select machine type and configuration on the calculator page.
     */
    public void followingData(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(instancesInput));

        instancesInput.click();
        instancesInput.sendKeys(Keys.CONTROL + "a");
        instancesInput.sendKeys(Keys.BACK_SPACE);
        instancesInput.sendKeys("4");
        scroll(700);

        wait.until(ExpectedConditions.visibilityOf(machineType));
        machineType.click();

        selectMachineType.click();
    }

    /**
     * Performs actions to select GPU, SSD, region, and finalize the estimate on the calculator page.
     * @throws InterruptedException If interrupted during thread sleep
     */
    public void followingData2() throws InterruptedException {
        scroll(750);
        addGpuButton.click();

        scroll(350);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(gpuModel));
        wait.until(ExpectedConditions.elementToBeClickable(gpuModel));
        gpuModel.click();
        selectGpuModel.click();

        ssd.click();

        wait.until(ExpectedConditions.visibilityOf(selectSsd));
        wait.until(ExpectedConditions.elementToBeClickable(selectSsd));
        selectSsd.click();
        wait.until(ExpectedConditions.visibilityOf(region));
        region.click();

        wait.until(ExpectedConditions.visibilityOf(selectRegion));
        selectRegion.click();
        scroll(350);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(buttonShare));
        buttonShare.click();
        wait.until(ExpectedConditions.visibilityOf(summit));
        summit.click();
    }

//    /**
//     * Switches to the new window/tab opened after clicking "Submit" and retrieves the instance text.
//     */
//    public void switchWindow() {
//        Set<String> handles = driver.getWindowHandles();
//        String originalHandle = driver.getWindowHandle();
//
//        for (String handle : handles) {
//            if (!handle.equals(originalHandle)) {
//                driver.switchTo().window(handle);
//                break;
//            }
//        }
//
//    }
//
//    public boolean validateSummaryValues(int expectedInstances, String expectedOS, String expectedProvisionalModel, String expectedMachineType, String expectedGpuType, String expectedNumOfGpus, String expectedLocalSsd, String expectedRegion){
//        wait.until(ExpectedConditions.visibilityOf(gpuType));
//        int instances = Integer.parseInt(instance.getText());
//        String operatingSystem = system.getText();
//        String provisionalModel = model.getText();
//        String machineType = machineTypeText.getText();
//        String gpuTypeText = gpuType.getText();
//        String numberOfGpus = numOfGpus.getText();
//        System.out.println(numberOfGpus);
//        String localSsdText = localSsd.getText();
//        String region = regionText.getText();
//
//        return expectedInstances == instances && expectedOS.equals(operatingSystem) &&
//                expectedProvisionalModel.equals(provisionalModel) &&
//                expectedMachineType.equals(machineType) &&
//                expectedGpuType.equals(gpuTypeText) &&
//                expectedNumOfGpus.equals(numberOfGpus) &&
//                expectedLocalSsd.equals(localSsdText) &&
//                expectedRegion.equals(region);
//    }

    /**
     * Scrolls the page vertically by a specified number of pixels.
     * @param pix Number of pixels to scroll by
     */
    public void scroll(int pix){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pix + ")");
    }
}