package com.epam.training.brandon_tapia.task3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloudCalculatorHomePage {

    /**
     * The WebDriver instance used to control the browser.
     */
    private WebDriver driver;

    /**
     * The WebDriverWait instance used to wait for certain conditions to be met before proceeding.
     */
    private WebDriverWait wait;

    @FindBy(xpath = "//button[contains(., 'Add to estimate')]")
    public WebElement buttonAdd;

    @FindBy(className = "d5NbRd-EScbFb-JIbuQc")
    public WebElement computeEngine;

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
        buttonAdd.click();
        wait.until(ExpectedConditions.visibilityOf(computeEngine));
        computeEngine.click();
    }

}
