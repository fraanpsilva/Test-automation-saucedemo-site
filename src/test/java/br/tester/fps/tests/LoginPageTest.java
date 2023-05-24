package br.tester.fps.tests;

import br.tester.fps.pages.BasePage;
import br.tester.fps.pages.LoginPage;
import org.junit.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginPageTest {

    private LoginPage loginPage;
    public BasePage bp;

    private WebDriver driver;
    private static String BASE_URL = "https://www.saucedemo.com/";


    @Before
    public void initDriver() {
        this.loginPage = new LoginPage();
        this.loginPage.openPage(this.BASE_URL);
    }

    @After
    public void closeDriver() {
        this.loginPage.quitDriver();
    }


    @Test
    public void TC01_shouldReturnErrorMessageWithEmptyUsernameAndPasswordFields(){
        //when
        this.loginPage.loginWithEmptyUsernameAndPasswordFields();
        //when
        assertTrue(loginPage.getMessageError().equals("Epic sadface: Username is required"));
    }

    @Test
    public void TC02_shouldReturnErrorMessageWithEmptyPasswordField(){
        //when
        this.loginPage.loginWithEmptyPasswordField();
        //when
        assertTrue(loginPage.getMessageError().equals("Epic sadface: Password is required"));
    }

    @Test
    public void TC03_shouldReturnErrorMessageWithEmptyUsernameField(){
        this.loginPage.loginWithEmptyUsernameField();
        assertTrue(loginPage.getMessageError().equals("Epic sadface: Username is required"));
    }

    @Test
    public void TC04_shouldReturnErrormessageWhenLoggingInWithIncorrectPassword(){
        this.loginPage.loginWithIncorrectPassword();
        assertTrue(loginPage.getMessageError().equals("Epic sadface: Username and password do not match any user in this service"));

    }

    @Test
    public void TC05_shouldReturnErrormessageWhenLoggingInWithIncorrectPassword(){
        this.loginPage.loginWithIncorrectPassword();
        assertTrue(loginPage.getMessageError().equals("Epic sadface: Username and password do not match any user in this service"));

    }

    @Test
    public void TC06_loginWithSuccesfully() {
        //when
        this.loginPage.signInWithSuccesfully();
        //then
        assertTrue(loginPage.getTitleLogo().equals("Swag Labs"));
    }


}

