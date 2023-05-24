package br.tester.fps.pages;

import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class ProductsPage extends BasePage{

    // locators de login
    private By usernameLocator = By.id("user-name");
    private By passwordLocator = By.id("password");
    private By buttonLoggin = By.id("login-button");
    // locators
    private By titlePage = By.cssSelector("div.header_secondary_container>span.title");
    private By productBackPack = By.cssSelector("div.inventory_item_name");
    private By buttonBackProducts = By.name("back-to-products");
    private By buttonAddBackpackToCart = By.id("add-to-cart-sauce-labs-backpack");
    private By buttonRemoveBackpackToCart = By.id("remove-sauce-labs-backpack");
    private By linkOpenCart = By.className("shopping_cart_link");
    private By buttonCheckout = By.id("checkout");

    private By inputFirstName = By.id("first-name");
    private By inputLastName = By.id("last-name");
    private By inputPostalCode = By.id("postal-code");

    private By titlePageCheckouOverview = By.cssSelector("div.header_secondary_container>span.title");

    private By buttonContinueCheckout = By.name("continue");

    private By buttonFinishCheckout = By.name("finish");
    private By messageThanksforOrder = By.className("complete-header");
    private By buttonBackHomeAfterCheckout = By.name("back-to-products");







    // método que vai visualizar a página de produtos
    public void viewProductsPage(){
        if(super.isDisplayed(titlePage)){
            System.out.println("Elemento presente");

        }else {
            System.out.println("Title was not found");
        }
    }

    public void signInWithSuccesfully(){

        if(super.isDisplayed(usernameLocator)){ // verificando se o campo de email aparece na página que entramos
            super.write("standard_user", usernameLocator);
            super.write("secret_sauce", passwordLocator);
            super.click(buttonLoggin);
        } else {
            System.out.println("username textbox was not present ");
        }
    }


    public void openTheProduct(){
        if(super.isDisplayed(titlePage)){
            super.click(productBackPack);
        }else {
            System.out.println("Product was not found");
        }
    }


    public void addingAproductToCart(){
        if(super.isDisplayed(titlePage)){

            super.click(buttonAddBackpackToCart);
        }else {
            System.out.println("Title was not found");
        }
    }

    public void finalizingApurchase(){
        if(super.isDisplayed(titlePage)){
            super.click(buttonAddBackpackToCart);
            super.click(linkOpenCart);
            super.click(buttonCheckout);

            super.write("Name", inputFirstName);
            super.write("Teste", inputLastName);
            super.write("123456", inputPostalCode);
            super.click(buttonContinueCheckout);

            if (super.isDisplayed(titlePage)) {
                super.click(buttonFinishCheckout);
            } else {
                System.out.println("Title page not found");
            }


        }else {
            System.out.println("Title not found");
        }
    }


    public void backToProducts(){
        if(super.isDisplayed(titlePage)){
            finalizingApurchase();

            // utilizando o método com wait
            super.waitVisibilityOfElementLocated(buttonBackProducts);

            super.click(buttonBackProducts);
        }else {
            System.out.println("Button 'Back Home' not found");
        }
    }

    public boolean buttonBackProductsIsPresent(){
        super.isDisplayed(buttonBackProducts);
        return true;
    }

    public void buttonRemoveItemToCart(){
        super.isDisplayed(buttonRemoveBackpackToCart);
    }

    public String getMessageSuccecfuly(){
        return super.getText(messageThanksforOrder);
    }

    public String getTitleHomePage(){
        return super.getText(titlePage);
    }



}
