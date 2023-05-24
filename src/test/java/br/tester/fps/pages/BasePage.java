package br.tester.fps.pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    public WebDriver driver;
    //private static String TEST_URL = "https://www.saucedemo.com/";
    private static String PATH_DRIVER = "drivers/chromedriver-v1130567263";
    private Actions action;
    private WebDriverWait wait; // classe para fazer o Selenium esperar
    private Select select;

    public BasePage() {
        System.setProperty("webdriver.chrome.driver", PATH_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
    }


    public void openPage(String url){
        this.driver.get(url);
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }

    @After
    public void quitDriver(){
        this.driver.quit();
    }

    public WebElement searchElement(By locator){
        return this.driver.findElement(locator);
    }

    public void write(String input, By locator ){
        this.driver.findElement(locator).sendKeys(input);
    }



    public Boolean isDisplayed(By locator){
        try {
            return this.driver.findElement(locator).isDisplayed();

        } catch (NoSuchElementException e){
            return false;

        }
    }

    public void click(By locator){
        this.driver.findElement(locator).click();
    }

    public String getText(By locator){
       return this.driver.findElement(locator).getText();
    }

    public void actionMoveToElementPerform(By locator){
        if (this.action == null){
            this.action = new Actions(this.driver);
        }

        WebElement element = this.driver.findElement(locator);
        action.moveToElement(element).perform();
    }

    public void actionMoveToElementClickPerform(By locator){
        if (this.action == null){
            this.action = new Actions(this.driver);
        }

        WebElement element = this.driver.findElement(locator);
        action.moveToElement(element).click().build().perform();
    }


    // métodos wait
    public WebElement waitVisibilityOfElementLocated(By locator, long time ){
        wait = new WebDriverWait(driver, time);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitVisibilityOfElementLocated(By locator){
        wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public Boolean isContainedInPageSource(String message){
        return driver.getPageSource().contains(message);
    }

    public void selectByValue(By locator, String value){
        select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }

    public void clear(By locator){
        this.driver.findElement(locator).clear();
    }



}
