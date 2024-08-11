package com.epam.training.brandon_tapia.task3.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


/**
 * CloudCalculatorPricingPage represents the pricing configuration page of the Google Cloud Platform Pricing Calculator.
 * It provides methods to interact with the page elements, such as selecting machine type, GPU, SSD, and region,
 * as well as finalizing and sharing the estimate.
 */
public class CloudCalculatorPricingPage {
    /**
     * The WebDriver instance used to control the browser.
     */
    private WebDriver driver;

    private WebDriverWait wait;

    @FindBy(id = "c13")
    public WebElement instancesInput;

    @FindBy(xpath = "//div[@jsname='kgDJk']")
    public WebElement machineType;

    @FindBy(xpath = "//li[@data-value='n1-standard-8']")
    public WebElement selectMachineType;

    @FindBy(xpath = "//button[@aria-label='Add GPUs']")
    public WebElement addGpuButton;

    @FindBy(xpath = "//*[@id=\"ow5\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[23]/div/div[1]/div/div/div/div[1]")
    public WebElement gpuModel;

    @FindBy(xpath = "//li[@data-value=\"nvidia-tesla-v100\"]")
    public WebElement selectGpuModel;

    @FindBy(xpath = "//*[@id=\"ow5\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[27]/div/div[1]/div/div/div/div[1]")
    public WebElement ssd;

    @FindBy(xpath = "//*[@id=\"ow5\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[27]/div/div[1]/div/div/div/div[2]/ul/li[3]")
    public WebElement selectSsd;

    @FindBy(xpath = "//div[@aria-controls='c46']")
    public WebElement region;

    @FindBy(css = "li[data-value='europe-west4']")
    public WebElement selectRegion;

    @FindBy(xpath = "//button[@aria-label='Open Share Estimate dialog']")
    public WebElement buttonShare;

    @FindBy(css = "a[track-name='open estimate summary']")
    public WebElement summit;

    /**
     * Initializes the web elements on the pricing page.
     *
     * @param driver WebDriver instance to use
     */
    public void initializeElements(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }
    /**
     * Performs actions to select machine type and configuration on the calculator page.
     */
    public void followingData() throws InterruptedException{

        // Wait until the instances input field is visible
        wait.until(ExpectedConditions.visibilityOf(instancesInput));

        // Clear the instances input field and set the number of instances to 4
        instancesInput.click();
        instancesInput.sendKeys(Keys.CONTROL + "a");
        instancesInput.sendKeys(Keys.BACK_SPACE);
        instancesInput.sendKeys("4");

        // Scroll down the page
        scroll(700);

        // Wait until the machine type element is visible and select it
        wait.until(ExpectedConditions.visibilityOf(machineType));
        machineType.click();
        selectMachineType.click();

        // Scroll down the page
        scroll(750);

        // Add GPU and select the GPU model
        addGpuButton.click();
        scroll(350);
        wait.until(ExpectedConditions.visibilityOf(gpuModel));
        wait.until(ExpectedConditions.elementToBeClickable(gpuModel));
        gpuModel.click();
        selectGpuModel.click();

        // Select SSD
        ssd.click();
        wait.until(ExpectedConditions.visibilityOf(selectSsd));
        wait.until(ExpectedConditions.elementToBeClickable(selectSsd));
        selectSsd.click();

        // Select region
        wait.until(ExpectedConditions.visibilityOf(region));
        region.click();
        wait.until(ExpectedConditions.visibilityOf(selectRegion));
        selectRegion.click();

        // Scroll down the page
        scroll(350);

        // Wait and click on the share and submit buttons
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(buttonShare));
        buttonShare.click();
        wait.until(ExpectedConditions.visibilityOf(summit));
        summit.click();
    }

//    /**
//     * Performs actions to select GPU, SSD, region, and finalize the estimate on the calculator page.
//     * @throws InterruptedException If interrupted during thread sleep
//     */
////    public void followingData2() throws InterruptedException {
////
////    }

    /**
     * Scrolls the page vertically by a specified number of pixels.
     * @param pix Number of pixels to scroll by
     */
    public void scroll(int pix){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pix + ")");
    }
}