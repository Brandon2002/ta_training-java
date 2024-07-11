package com.epam.training.brandon_tapia.task2.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(xpath = "//button[contains(text(), 'Create New Paste')]")
    public WebElement button;

    // Locator of the name of the paste.
    @FindBy(className = "info-top")
    public WebElement headTitle;

    // Locator to identify the sintax "Bash".
    @FindBy(xpath = "//a[contains(text(), \"Bash\")]")
    public WebElement sintax;

    // Locator to find the second line of code.
    @FindBy(xpath = "(//div[contains(@class, 'de1')])[2]")
    public WebElement secondText;

    /**
     * Sets up the WebDriver and initializes the page elements.
     *
     * @param driver The WebDriver instance to be used.
     */
    public void setUpBrowser(WebDriver driver) {
        this.driver = driver;
        driver.get("https://pastebin.com/");
        PageFactory.initElements(driver, this);
    }

    /**
     * Enters text into the "Code" input field.
     *
     * @param text The text to be entered.
     */
    public void textCode(String text) {
        code.sendKeys(text);
    }

    /**
     * Scrolls and selects Bash syntax in the format dropdown.
     */
    public void setSpanBash() {
        scroll(500);
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
    public void createNewPaste() {
        scroll(200);
        button.click();
    }

    /**
     * Checks if the given parameters match the current values of corresponding text fields.
     *
     * @param contain           The content to compare with the main title.
     * @param sintax1           The syntax to compare with the current syntax.
     * @param secondTextOfCode  The second code text to compare with the current second text.
     * @return                  true if all parameters match the current text field values, false otherwise.
     */
    public boolean checkPaste(String contain, String sintax1, String secondTextOfCode) {
        String headTitle1 = headTitle.getText();
        String bash = sintax.getText();
        String secondText1 = secondText.getText();
        return contain.equals(headTitle1) && sintax1.equals(bash) && secondTextOfCode.equals(secondText1);
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
