package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

import static org.testng.AssertJUnit.assertFalse;

public class RemoveProductsTest extends BaseTests {

    @Test
    public void removeSomeProductsFromCartTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductPage productPage = inventoryPage.clickProductByName("Sauce Labs Bolt T-Shirt");
        productPage.clickAddToCart();
        navigator.returnToInventoryPage();

        productPage = inventoryPage.clickProductByName("Test.allTheThings() T-Shirt (Red)");
        productPage.clickAddToCart();

        CartPage cartPage = navigator.clickCart();
        cartPage.removeProduct("Test.allTheThings() T-Shirt (Red)");

        cartPage.clickCheckout();

        assertFalse(cartPage.isProductInCart("Test.allTheThings() T-Shirt (Red)"));
    }
}
