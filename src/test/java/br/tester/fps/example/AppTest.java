package br.tester.fps.example;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AppTest {

    // trazendo o webdriver
    public WebDriver driver;
    private static final String TEST_URL = "https://www.saucedemo.com/";
    private static final String PATH_DRIVER = "drivers/chromedriver-v1130567263";
    //http://automationpractice.com/index.php


    @Test
    public void environmentTest(){
        // informando onde está o driver
        System.setProperty("webdriver.chrome.driver", PATH_DRIVER);
        driver = new ChromeDriver();

        // config de navegador
        driver.manage().window().setSize(new Dimension(1200, 765));

        // buscando a página de teste
        driver.get(TEST_URL);

        // assertiva
        String currentUrl = driver.getCurrentUrl();
        String urlExpected = "https://www.saucedemo.com/";
        assertEquals(urlExpected, currentUrl);

        // fechando o browser
        driver.quit();

    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }


    //
//    @Test
//    public void TC01_shouldReturnErrorMessageWithEmptyUsernameAndPasswordFields(){
//
//
//
//        WebElement inputUsername = driver.findElement(By.id("user-name"));
//        inputUsername.sendKeys("");
//
//        WebElement inputPassword = driver.findElement(By.id("password"));
//        inputPassword.sendKeys("");
//
//        WebElement buttonLogin = driver.findElement(By.id("login-button"));
//        buttonLogin.click();
//
//        String messageError = driver.findElement(By.cssSelector("div.error-message-container>h3")).getText();
//        String messageExpected = "Epic sadface: Username is required";
//        assertEquals(messageExpected, messageError);
//    }
//
//    @Test
//    public void TC02_shouldReturnErrorMessageWithEmptyPasswordField(){
//        WebElement inputUsername = driver.findElement(By.id("user-name"));
//        inputUsername.sendKeys("standard_user");
//        WebElement inputPassword = driver.findElement(By.id("password"));
//        inputPassword.sendKeys("");
//
//        WebElement buttonLogin = driver.findElement(By.id("login-button"));
//        buttonLogin.click();
//
//        String messageError = driver.findElement(By.cssSelector("div.error-message-container>h3")).getText();
//        String messageExpected = "Epic sadface: Password is required";
//        assertEquals(messageExpected, messageError);
//    }
//
//    @Test
//    public void TC03_shouldReturnErrorMessageWithEmptyUsernameField(){
//        WebElement inputUsername = driver.findElement(By.id("user-name"));
//        inputUsername.sendKeys("");
//
//        WebElement inputPassword = driver.findElement(By.id("password"));
//        inputPassword.sendKeys("secret_sauce");
//
//        WebElement buttonLogin = driver.findElement(By.id("login-button"));
//        buttonLogin.click();
//
//        String messageError = driver.findElement(By.cssSelector("div.error-message-container>h3")).getText();
//        String messageExpected = "Epic sadface: Username is required";
//        assertEquals(messageExpected, messageError);
//    }
//
//    @Test
//    public void  TC04_mustLoginSuccessfully(){
//
//
//        WebElement inputUsername = driver.findElement(By.id("user-name"));
//        inputUsername.sendKeys("standard_user");
//
//        WebElement inputPassword = driver.findElement(By.id("password"));
//        inputPassword.sendKeys("secret_sauce");
//
//        WebElement buttonLogin = driver.findElement(By.id("login-button"));
//        buttonLogin.click();
//
//        String titleLogoPage = driver.findElement(By.className("app_logo")).getText();
//        assertTrue(titleLogoPage.equals("Swag Labs"));
//    }
//
    //    @Test
//    public void TC05_shouldReturnErrormessageWhenLoggingInWithIncorrectPassword(){
//        WebElement inputUsername = driver.findElement(By.id("user-name"));
//        inputUsername.sendKeys("standard_user");
//
//        WebElement inputPassword = driver.findElement(By.id("password"));
//        inputPassword.sendKeys("teste_sauce");
//
//        WebElement buttonLogin = driver.findElement(By.id("login-button"));
//        buttonLogin.click();
//
//        String messageError = driver.findElement(By.cssSelector("div.error-message-container>h3")).getText();
//        String messageExpected = "Epic sadface: Username and password do not match any user in this service";
//
//        assertEquals(messageExpected, messageError);
//    }
//
//    @Test
//    public void TC06_shouldReturnErrormessageWhenLoggingInWithIncorrectUsername(){
//        WebElement inputUsername = driver.findElement(By.id("user-name"));
//        inputUsername.sendKeys("secret_error");
//
//        WebElement inputPassword = driver.findElement(By.id("password"));
//        inputPassword.sendKeys("teste_sauce");
//
//        WebElement buttonLogin = driver.findElement(By.id("login-button"));
//        buttonLogin.click();
//
//        String messageError = driver.findElement(By.cssSelector("div.error-message-container>h3")).getText();
//        String messageExpected = "Epic sadface: Username and password do not match any user in this service";
//
//        assertEquals(messageExpected, messageError);
//    }
//}

}
