package br.tester.fps.tests;

import br.tester.fps.pages.BasePage;
import br.tester.fps.pages.LoginPage;
import br.tester.fps.pages.ProductsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductsPageTest {

    private ProductsPage productsPage;
    public BasePage basePage;

    private WebDriver driver;
    private static String BASE_URL = "https://www.saucedemo.com/";


    @Before
    public void initDriver() {
        this.productsPage = new ProductsPage();
        this.productsPage.openPage(this.BASE_URL);
        this.productsPage.signInWithSuccesfully();

    }

    @After
    public void closeDriver() {
        this.productsPage.quitDriver();
    }


    @Test
    public void TC01_mustOpenAproduct(){
        this.productsPage.openTheProduct();
        String urlCurrent = this.productsPage.getCurrentUrl();
        String urlExpected = "https://www.saucedemo.com/inventory-item.html?id=4";
        assertEquals(urlExpected, urlCurrent);
    }

    @Test
    public void TC02_mustAddProductToCart(){
        this.productsPage.addingAproductToCart();
        Boolean buttonRemoveIsPresent = this.productsPage.buttonBackProductsIsPresent();
        assertTrue(buttonRemoveIsPresent);
    }

    @Test
    public void TC03_mustCheckout(){
        this.productsPage.finalizingApurchase();
        String messageActual = this.productsPage.getMessageSuccecfuly();
        String messageExpected = "Thank you for your order!";
        assertEquals(messageExpected, messageActual);
    }

    @Test
    public void TC04_mustGoBackToHomePageAfterCheckout(){
        this.productsPage.backToProducts();
        String titlePageActual = this.productsPage.getTitleHomePage();
        String titlePageExpected = "Products";
        assertEquals(titlePageExpected, titlePageActual);
    }
}
