package com.epam.training.brandon_tapia.task1.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinPage {
    // WebDriver instance
    public WebDriver driver;

    // Locator for the input field where the code will be pasted
    @FindBy(id="postform-text")
    public WebElement code;

    // Locator for the dropdown to select expiration time
    @FindBy(id="select2-postform-expiration-container")
    public WebElement select;

    // Locator for the "10 Minutes" option in the expiration time dropdown
    @FindBy(xpath="//li[contains(text(), \"10 Minutes\")]")
    public WebElement minutes;

    // Locator for the input field where the name of the pastebin will be entered
    @FindBy(id="postform-name")
    public WebElement name;
    public WebDriverWait wait;

    // Constructor to initialize the PageFactory elements and open the web page
    public void setUpBrowser(WebDriver driver){
        driver.get("https://pastebin.com/");
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver = driver;

    }

    /**
     * This method does enter the given text into the code input field.
     *
     * @param text the text to enter into the code field
     */
    public void code(String text){

        code.sendKeys(text);
    }

    /**
     * This method does select the expiration time for the pastebin to "10 Minutes".
     */
    public void expiration(){
        select.click();
        scroll();
        minutes.click();
    }

    /**
     * This method does enter the given project name into the pastebin name input field.
     *
     * @param projectName the name to enter into the pastebin name field
     */
    public void pastebinName(String projectName){
        name.sendKeys(projectName);
    }

    /**
     * Scrolls down the webpage by 500 pixels.
     */
    public void scroll(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

}
