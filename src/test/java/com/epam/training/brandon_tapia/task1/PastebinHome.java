package com.epam.training.brandon_tapia.task1;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinHome {

    //Variables
    private WebDriver driver;
    //Input of the code.
    @FindBy(id="postform-text")
    public WebElement code;
    //Select minutes
    @FindBy(id="select2-postform-expiration-container")
    public WebElement sel;
    //10 minutes
    @FindBy(xpath="//li[contains(text(), \"10 Minutes\")]")
    public WebElement ten;
    //Input text of the new pastebin
    @FindBy(id="postform-name")
    public WebElement name;
    //Open the webpage
    //Initialize driver
    //Sendkeys of the code.
    public void txt(String text, WebDriver driver){
        this.driver = driver;
        driver.get("https://pastebin.com/");
        PageFactory.initElements(driver, this);
        code.sendKeys(text);
    }

    //Find the select, click them and select 10 minutes
    public void expiration(){
        sel.click();
        scroll();
        ten.click();
    }


    //Find the input Paste Name / Title and put a string
    public void pastebinName(String projectName){
        name.sendKeys(projectName);
    }

    //Scroll down in the webpage
    public void scroll(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

}
