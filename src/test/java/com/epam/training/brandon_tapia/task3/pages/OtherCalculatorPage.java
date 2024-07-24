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

public class OtherCalculatorPage extends CloudCalculatorPricingPage{
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//li[@data-value='n1-standard-2']")
    public WebElement selectOtherMachineType;

    public void initialize (WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void actions () throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOf(instancesInput));
        instancesInput.click();

        instancesInput.sendKeys(Keys.CONTROL + "a");

        instancesInput.sendKeys(Keys.BACK_SPACE);

        instancesInput.sendKeys("2");

        scroll(700);

        machineType.click();

        selectOtherMachineType.click();

        scroll(750);

        addGpuButton.click();

        scroll(350);
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


    public void scroll(int pix){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pix + ")");
    }
}
