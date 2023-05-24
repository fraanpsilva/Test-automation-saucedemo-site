package br.tester.fps.pages;

import org.junit.Test;
import org.openqa.selenium.By;

import javax.swing.*;

public class LoginPage extends BasePage{

    // locators
    private By usernameLocator = By.id("user-name");
    private By passwordLocator = By.id("password");
    private By buttonLoggin = By.id("login-button");
    private By titleLogoPage = By.className("app_logo");
    private By messageError = By.cssSelector("div.error-message-container>h3");

    public void signInWithSuccesfully(){

        if(super.isDisplayed(usernameLocator)){ // verificando se o campo de email aparece na página que entramos
            super.write("standard_user", usernameLocator);
            super.write("secret_sauce", passwordLocator);
            super.click(buttonLoggin);
        } else {
            System.out.println("username textbox was not present ");
        }
    }

    public void loginWithEmptyUsernameAndPasswordFields(){
        if(super.isDisplayed(usernameLocator)){ // verificando se o campo de email aparece na página que entramos
            super.write("", usernameLocator);
            super.write("", passwordLocator);
            super.click(buttonLoggin);
        } else {
            System.out.println("username textbox was not present ");
        }
    }

    public void loginWithEmptyPasswordField(){
        if(super.isDisplayed(usernameLocator)){ // verificando se o campo de email aparece na página que entramos
            super.write("standard-user", usernameLocator);
            super.write("", passwordLocator);
            super.click(buttonLoggin);
        } else {
            System.out.println("username textbox was not present ");
        }
    }

    public void loginWithEmptyUsernameField(){
        if(super.isDisplayed(usernameLocator)){ // verificando se o campo de email aparece na página que entramos
            super.write("", usernameLocator);
            super.write("secret-sauce", passwordLocator);
            super.click(buttonLoggin);
        } else {
            System.out.println("username textbox was not present ");
        }
    }

    public void loginWithIncorrectPassword(){
        if(super.isDisplayed(usernameLocator)){ // verificando se o campo de email aparece na página que entramos
            super.write("locked_out_user", usernameLocator);
            super.write("password-error", passwordLocator);
            super.click(buttonLoggin);
        } else {
            System.out.println("username textbox was not present ");
        }
    }

    public void loginWithIncorrectUsername(){
        if(super.isDisplayed(usernameLocator)){ // verificando se o campo de email aparece na página que entramos
            super.write("user_error", usernameLocator);
            super.write("secret-sauce", passwordLocator);
            super.click(buttonLoggin);
        } else {
            System.out.println("username textbox was not present ");
        }
    }

    public String getTitleLogo(){
        return super.getText(titleLogoPage);
    }

    @Test
    public String getMessageError(){
        return super.getText(messageError);

    }
}
