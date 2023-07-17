package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigator {
    private WebDriver driver;
    private By backToProducts = By.id("back-to-products");
    private By cartLink = By.className("shopping_cart_link");

    public Navigator(WebDriver driver) {
        this.driver = driver;
    }

    public InventoryPage returnToInventoryPage() {
        driver.findElement(backToProducts).click();
        return new InventoryPage(driver);
    }
    public CartPage clickCart() {
        driver.findElement(cartLink).click();
        return new CartPage(driver);
    }
}
