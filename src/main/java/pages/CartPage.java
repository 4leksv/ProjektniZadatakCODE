package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage {
    private WebDriver driver;
    private By checkoutButton = By.id("checkout");
    private By removeButton = By.cssSelector("[class='btn btn_secondary btn_small cart_button']");
    private By productCard = By.cssSelector("[class='cart_item_label']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage clickCheckout() {
        driver.findElement(checkoutButton).click();
        return new ProductPage(driver);
    }
    public WebElement getCardItemByName(String productName) {
        List<WebElement> productCardList = driver.findElements(productCard);
        for (WebElement element : productCardList) {
            String cardProductName = element.findElement(By.className("inventory_item_name")).getText();
            if (cardProductName.contains(productName)) {
                return element;
            }
        }
        return null;
    }
    public void removeProduct(String productName) {
        WebElement cardItem = getCardItemByName(productName);
        if (cardItem != null) {
            cardItem.findElement(removeButton).click();
        } else {
            System.out.println("The product '" + productName + "' was not found on the card.");
        }
    }
    public boolean isProductInCart(String productName) {
        WebElement cardItem = getCardItemByName(productName);
        return cardItem != null;
    }
}
