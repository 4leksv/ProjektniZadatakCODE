package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class ItemTotalTest extends BaseTests {

    @Test
    public void TotalPriceTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductPage productPage = inventoryPage.clickProductByName("Sauce Labs Backpack");
        productPage.clickAddToCart();
        navigator.returnToInventoryPage();

        productPage = inventoryPage.clickProductByName("Sauce Labs Bolt T-Shirt");
        productPage.clickAddToCart();
        navigator.returnToInventoryPage();

        productPage = inventoryPage.clickProductByName("Sauce Labs Fleece Jacket");
        productPage.clickAddToCart();
        navigator.returnToInventoryPage();

        CartPage cartPage = navigator.clickCart();
        cartPage.clickCheckout();

        stepOnePage.setFirstName("Aleksa");
        stepOnePage.setLastName("Vukosavljevic");
        stepOnePage.setPostalCode("15300");
        stepOnePage.clickContinue();

        Assert.assertEquals(stepTwoPage.getTotalPrice(),"Total: $103.65", "The price is wrong.");
    }
}
