package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class AddProductsTest extends BaseTests {

    @Test
    public void addAllProductsToCartTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductPage productPage = inventoryPage.clickProductByName("Sauce Labs Backpack");
        productPage.clickAddToCart();
        navigator.returnToInventoryPage();

        productPage = inventoryPage.clickProductByName("Sauce Labs Bolt T-Shirt");
        productPage.clickAddToCart();
        navigator.returnToInventoryPage();

        productPage = inventoryPage.clickProductByName("Sauce Labs Onesie");
        productPage.clickAddToCart();
        navigator.returnToInventoryPage();

        productPage = inventoryPage.clickProductByName("Sauce Labs Bike Light");
        productPage.clickAddToCart();
        navigator.returnToInventoryPage();

        productPage = inventoryPage.clickProductByName("Sauce Labs Fleece Jacket");
        productPage.clickAddToCart();
        navigator.returnToInventoryPage();

        productPage = inventoryPage.clickProductByName("Test.allTheThings() T-Shirt (Red)");
        productPage.clickAddToCart();

        CartPage cartPage = navigator.clickCart();
        cartPage.clickCheckout();

        Assert.assertTrue(stepOnePage.isCheckoutSuccessful(),"Checkout was not completed successfully.");
    }
}
