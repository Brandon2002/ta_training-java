package com.epam.training.brandon_tapia.task2.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinPage2 {
    private WebDriver driver;

    // Web elements
    @FindBy(id = "postform-text")
    public WebElement code;

    // Locator for the select postform
    @FindBy(id = "select2-postform-format-container")
    public WebElement span;

    // Locator to select "Bash".
    @FindBy(xpath = "//li[contains(text(), \"Bash\")]")
    public WebElement bash;

    // Locator to set the expiration.
    @FindBy(id = "select2-postform-expiration-container")
    public WebElement select;

    // Locator to set the expiration in minutes.
    @FindBy(xpath = "//li[contains(text(), \"10 Minutes\")]")
    public WebElement minutes;

    // Locator of the input to put the name of the pastebin.
    @FindBy(id = "postform-name")
    public WebElement title;

    // Locator to click the button "Create new paste".
    @FindBy(xpath = "//*[@id=\"w0\"]/div[5]/div[1]/div[10]/button")
    public WebElement button;

    // Locator of the name of the paste.
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/h1")
    public WebElement headTitle;

    // Locator to identify the sintax "Bash".
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/a[1]")
    public WebElement sintax;

    // Locator to find the second line of code.
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div[4]/div[2]/ol/li[2]/div")
    public WebElement secondText;

    /**
     * Sets up the WebDriver and initializes the page elements.
     *
     * @param driver The WebDriver instance to be used.
     */
    public void SetUpBrowser(WebDriver driver) {
        this.driver = driver;
        driver.get("https://pastebin.com/");
        PageFactory.initElements(driver, this);
    }

    /**
     * Enters text into the "Code" input field.
     *
     * @param text The text to be entered.
     */
    public void TextCode(String text) {
        code.sendKeys(text);
    }

    /**
     * Scrolls and selects Bash syntax in the format dropdown.
     *
     * @param pix Pixels to scroll down by.
     */
    public void setSpanBash(int pix) {
        scroll(pix);
        span.click();
        bash.click();
    }

    /**
     * Selects the expiration time as "10 Minutes".
     */
    public void setSpanMinutes() {
        select.click();
        minutes.click();
    }

    /**
     * Enters text into the "Paste Name / Title" input field.
     *
     * @param text The text to be entered.
     */
    public void textTitle(String text) {
        title.sendKeys(text);
    }

    /**
     * Click the button to create a new paste
     */
    public void clickButton() {
        scroll(200);
        button.click();
    }

    /**
     * Retrieves the header title and checks if it contains the specified text.
     *
     * @param contain Text to check for in the header title
     * @return True if the header title contains the specified text, false otherwise
     */
    public boolean getTitle(String contain) {
        return headTitle.getText().contains(contain);
    }

    /**
     * Retrieves the syntax highlight type from the page.
     *
     * @return The text indicating the syntax highlight type
     */
    public String getSintax() {
        return sintax.getText();
    }


    /**
     * Retrieves the second text block content from the page.
     * Waits for the element to be visible before retrieving text.
     * @return The text content of the second text block
     */
    public String getText() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(secondText));
        return secondText.getText();
    }

    /**
     * Scrolls the page by a specified number of pixels.
     * @param pix Pixels to scroll by
     */
    public void scroll(int pix){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pix + ")");
    }
}
