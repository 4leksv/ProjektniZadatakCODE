package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class FinalBuyTest extends BaseTests {

    @Test
    public void CheckoutCompleteTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductPage productPage = inventoryPage.clickProductByName("Test.allTheThings() T-Shirt (Red)");
        productPage.clickAddToCart();

        CartPage cartPage = navigator.clickCart();
        cartPage.clickCheckout();

        stepOnePage.setFirstName("Aleksa");
        stepOnePage.setLastName("Vukosavljevic");
        stepOnePage.setPostalCode("15300");
        stepOnePage.clickContinue();

        stepTwoPage.clickFinish();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Pokušao sam da napravim wait, ali nažalost, nisam uspeo.
        // Pa sam iskoristio Thread.sleep(), za koji znam da nije dobra praksa koristiti, ali čisto zbog preglednosti ovom prilikom.

        /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.urlContains("checkout-complete.html"));
        */

        Assert.assertTrue(checkoutCompletePage.isTransactionComplete(),"The transaction was not completed successfully.");

        checkoutCompletePage.clickBackHome();
    }
}
