package com.epam.training.brandon_tapia.task3.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * OtherCalculatorPage represents a page in the cloud calculator with additional options.
 * This class extends CloudCalculatorPricingPage and provides methods to interact with the page elements
 * and perform specific actions on this page.
 */
public class OtherCalculatorPage extends CloudCalculatorPricingPage{
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//li[@data-value='n1-standard-2']")
    public WebElement selectOtherMachineType;

    /**
     * Initializes the page elements and sets up explicit wait time.
     *
     * @param driver the WebDriver instance used to interact with the page.
     */
    public void initialize (WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    /**
     * Performs a series of actions on the page, including selecting machine type,
     * GPU model, SSD, and region, as well as sharing and submitting the configuration.
     *
     * @throws InterruptedException if an interruption occurs during the sleep.
     */
    public void actions () throws InterruptedException{

        // Wait until the instances input field is visible
        wait.until(ExpectedConditions.visibilityOf(instancesInput));

        // Clear the instances input field and set the number of instances to 4
        instancesInput.click();
        instancesInput.sendKeys(Keys.CONTROL + "a");
        instancesInput.sendKeys(Keys.BACK_SPACE);
        instancesInput.sendKeys("2");

        // Scroll down the page
        scroll(700);

        // Wait until the machine type element is visible and select it
        wait.until(ExpectedConditions.visibilityOf(machineType));
        machineType.click();
        selectOtherMachineType.click();

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
//        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(buttonShare));
        buttonShare.click();
        wait.until(ExpectedConditions.visibilityOf(summit));
        summit.click();
    }


    public void scroll(int pix){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pix + ")");
    }
}
